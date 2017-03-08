package com.flansmod.common;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;

import com.flansmod.common.blocks.CrateBlock;
import com.flansmod.common.cmds.KeyCommand;
import com.flansmod.common.cmds.TextureCommand;
import com.flansmod.common.data.DataType;
import com.flansmod.common.data.DriveableType;
import com.flansmod.common.data.EnumType;
import com.flansmod.common.driveables.EntityPlane;
import com.flansmod.common.driveables.EntitySeat;
import com.flansmod.common.driveables.EntityVehicle;
import com.flansmod.common.driveables.EntityWheel;
import com.flansmod.common.items.ItemKey;
import com.flansmod.common.items.ItemPart;
import com.flansmod.common.network.PacketHandler;
import com.flansmod.common.util.CTabs;
import com.flansmod.common.util.Config;
import com.flansmod.common.util.Ticker;
import com.flansmod.common.util.Util;
import com.flansmod.fvm.FvmHook;

import net.fexcraft.mod.lib.network.SimpleUpdateHandler;
import net.fexcraft.mod.lib.util.registry.Registry;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.event.entity.item.ItemTossEvent;
import net.minecraftforge.event.entity.player.PlayerDropsEvent;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;

@Mod(modid = "flansmod", name = FlansMod.NAME, version = FlansMod.VERSION, dependencies = "required-after:fcl;after:fvm", acceptableRemoteVersions = "*", guiFactory = "com.flansmod.client.gui.config.ModGuiFactory")
public class FlansMod {
	
	//Core mod stuff
	public static boolean DEBUG = false;
	public static boolean fvm = false;
	public static final String MODID = "flansmod";
	public static final String VERSION = "5.F1.7-EX";
	public static final String NAME = "Flan's Mod Minus";
	@Mod.Instance("flansmod")
	public static FlansMod INSTANCE;
	@SidedProxy(clientSide = "com.flansmod.client.ClientProxy", serverSide = "com.flansmod.common.CommonProxy")
	public static CommonProxy proxy;
	public static File flanDir;

	//Handlers
	public static final PacketHandler packet_handler = new PacketHandler();
	public static final Ticker tick_handler = new Ticker();
	
	//Items and creative tabs
	public static ArrayList<ItemPart> partItems = new ArrayList<ItemPart>();
	
	/** Custom paintjob item */
	public static Item rainbowPaintcan;
	
	public static ItemKey key;
	private static final String prefix = TextFormatting.BLACK + "[" + TextFormatting.RED + "FM-" + TextFormatting.BLACK + "]" + TextFormatting.GRAY + "";

	/** The mod pre-initialiser method */
	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent event){
		Util.log("Preinitialising Flan's mod.");
		Config.initalize(new Configuration(event.getSuggestedConfigurationFile()), event.getSuggestedConfigurationFile().getParentFile());
		com.flansmod.common.data.player.PlayerHandler.initialize();
		
		SimpleUpdateHandler.register("flansmod", 1, VERSION);
		SimpleUpdateHandler.setUpdateMessage("flansmod", prefix + "New Version available! (" + SimpleUpdateHandler.getLatestVersionOf("flansmod") + ")");
		
		flanDir = new File(event.getModConfigurationDirectory().getParentFile(), "/Flan/");
		if(!flanDir.exists()){
			Util.log("Flan folder not found. Creating empty folder.");
			Util.log("You should get some content packs and put them in the Flan folder.");
			flanDir.mkdirs();
		}
		
		//Set up mod blocks and items
		if(event.getSide().isClient()){
			CrateBlock.instance = new CrateBlock();
		}
		
		Registry.registerAllBlocks(MODID);
		Registry.registerAllItems(MODID);
		Registry.registerAllEntities(MODID);
		
		key = new ItemKey();
		
		rainbowPaintcan = new Item().setCreativeTab(CTabs.parts);
		rainbowPaintcan.setRegistryName(MODID, "rainbowPaintcan");
		rainbowPaintcan.setUnlocalizedName(rainbowPaintcan.getRegistryName().toString());
		GameRegistry.register(rainbowPaintcan);
		
		//Read content packs
		readContentPacks(event);

		proxy.registerRenderers();

		//Force Minecraft to reload all resources in order to load content pack resources.
		proxy.forceReload();
		
		fvm = Loader.isModLoaded("fvm");
		proxy.registerRenderers();

		Util.log("Preinitializing complete.");
	}
	
	/** The mod initialiser method */
	@Mod.EventHandler
	public void init(FMLInitializationEvent event){
		Util.log("Initialising Flan's Mod.");
		
		proxy.load();

		//Initialising handlers
		NetworkRegistry.INSTANCE.registerGuiHandler(this, new CommonGuiHandler());		
		
		// Recipes
		/*for(InfoType type : InfoType.types.values()){
			type.addRecipe();
		}*/
		if(Config.addGunpowderRecipe){
			ItemStack charcoal = new ItemStack(Items.COAL, 1, 1);
			GameRegistry.addShapelessRecipe(new ItemStack(Items.GUNPOWDER), charcoal, charcoal, charcoal, new ItemStack(Items.GLOWSTONE_DUST));
		}
		Util.log("Loaded recipes.");
		
		//Register driveables
		EntityRegistry.registerModEntity(new ResourceLocation(MODID, "plane"), EntityPlane.class, "Plane", 90, this, 256, 3, false);
		EntityRegistry.registerModEntity(new ResourceLocation(MODID, "vehicle"), EntityVehicle.class, "Vehicle", 95, this, 256, 10, false);
		EntityRegistry.registerModEntity(new ResourceLocation(MODID, "seat"), EntitySeat.class, "Seat", 99, this, 256, 10, false);
		EntityRegistry.registerModEntity(new ResourceLocation(MODID, "wheel"), EntityWheel.class, "Wheel", 103, this, 256, 20, false);
		if(fvm){
			FvmHook.registerEntities();
		}
		
		//Register the chunk loader 
		//ForgeChunkManager.setForcedChunkLoadingCallback(this, new ChunkLoadingHandler());

		//Config
		MinecraftForge.EVENT_BUS.register(INSTANCE);
		Util.log("Loading complete.");
	}
	
	/** The mod post-initialisation method */
	@Mod.EventHandler
	public void postInit(FMLPostInitializationEvent event){
		packet_handler.initialise();
		if(event.getSide().isClient()){
			MinecraftForge.EVENT_BUS.register(new com.flansmod.client.debug.UtilGui());
		}
	}
	
	@SubscribeEvent
	public void playerDrops(PlayerDropsEvent event){
		for(int i = event.getDrops().size() - 1; i >= 0; i--){
			EntityItem ent = event.getDrops().get(i);
			DriveableType type = DriveableType.getDriveable(ent.getEntityItem());
			if(type != null && !type.canDrop)
				event.getDrops().remove(i);
		}
	}
	
	@SubscribeEvent
	public void playerDrops(ItemTossEvent event){
		DriveableType type = DriveableType.getDriveable(event.getEntityItem().getEntityItem());
		if(type != null && !type.canDrop){
			event.setCanceled(true);
		}
	}
	
	@Mod.EventHandler
	public void registerCommand(FMLServerStartingEvent event){
		event.registerServerCommand(new TextureCommand());
		event.registerServerCommand(new KeyCommand());
	}
	
	/** Reads type files from all content packs */
	private void getTypeFiles(List<File> contentPacks){
		for(File contentPack : contentPacks){
			if(contentPack.isDirectory()){
				for(EnumType et : EnumType.values()){
					File dir = new File(contentPack, "/" + et.folderName + "/");
					if(dir.exists()){
						for(File file : dir.listFiles()){
							try{
								BufferedReader reader = new BufferedReader(new FileReader(file));
								ArrayList<String> lines = new ArrayList<String>();
								for(;;){
									String line = null;
									try{
										line = reader.readLine();
									} 
									catch (Exception e){
										break;
									}
									if(line == null){
										break;
									}
									lines.add(line);
								}
								reader.close();
								String[] arr = new String[lines.size()];
								arr = lines.toArray(arr);
								String[] filename = file.getName().split("/");
								DataType type = et.getDataType(contentPack.getName(), filename[filename.length - 1].split("\\.")[0], arr);
								DataType.addType(type);
							}
							catch(Exception e){
								e.printStackTrace();
							}
						}
					}
				}
			}
			else{
				try{
					ZipFile zip = new ZipFile(contentPack);
					ZipInputStream zipStream = new ZipInputStream(new FileInputStream(contentPack));
					BufferedReader reader = new BufferedReader(new InputStreamReader(zipStream));
					ZipEntry zipEntry = zipStream.getNextEntry();
					do{
						zipEntry = zipStream.getNextEntry();
						if(zipEntry == null){
							continue;
						}
						String[] filename = null;
						EnumType et = null;
						for(EnumType type : EnumType.values()){
							if(zipEntry.getName().startsWith(type.folderName + "/") && zipEntry.getName().split(type.folderName + "/").length > 1 && zipEntry.getName().split(type.folderName + "/")[1].length() > 0){
								filename = zipEntry.getName().split("/");
								et = type;
								break;
							}
						}
						if(filename == null || et == null){
							continue;
						}
						ArrayList<String> lines = new ArrayList<String>();
						for(;;){
							String line = null;
							try{
								line = reader.readLine();
							} 
							catch(Exception e){
								break;
							}
							if(line == null){
								break;
							}
							lines.add(line);
						}
						String[] arr = new String[lines.size()];
						arr = lines.toArray(arr);
						DataType type = et.getDataType(contentPack.getName(), filename[filename.length - 1].split("\\.")[0], arr);
						DataType.addType(type);
					}
					while(zipEntry != null);
					reader.close();
					zip.close();
					zipStream.close();
				}
				catch(IOException e){
					e.printStackTrace();
				}
			}
		}
		
	}
	
	/** Content pack reader method */
	private void readContentPacks(FMLPreInitializationEvent event){
		ClassLoader classloader = (net.minecraft.server.MinecraftServer.class).getClassLoader();
		Method method = null;
		try{
			method = (java.net.URLClassLoader.class).getDeclaredMethod("addURL", java.net.URL.class);
			method.setAccessible(true);
		}
		catch (Exception e){
			Util.log("Failed to get class loader. All content loading will now fail.");
			e.printStackTrace();
		}
		
		getTypeFiles(proxy.getContentList(method, classloader));
		
		for(DataType type : DataType.getTypes()){
			type.read();
			type.registerItem();
		}
		DataType.removeInvalidTypes();
		
	}
	
	public static SimpleNetworkWrapper getNewPacketHandler(){
		return packet_handler.getInstance();
	}
	
}
