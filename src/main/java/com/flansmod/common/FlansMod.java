package com.flansmod.common;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;

import com.flansmod.client.debug.UtilGui;
import com.flansmod.common.blocks.CrateBlock;
import com.flansmod.common.cmds.KeyCommand;
import com.flansmod.common.cmds.QuickFix;
import com.flansmod.common.cmds.TextureCommand;
import com.flansmod.common.data.DriveableType;
import com.flansmod.common.data.VehicleType;
import com.flansmod.common.driveables.EntityPlane;
import com.flansmod.common.driveables.EntitySeat;
import com.flansmod.common.driveables.EntityVehicle;
import com.flansmod.common.driveables.EntityWheel;
import com.flansmod.common.driveables.ItemVehicle;
import com.flansmod.common.driveables.mechas.EntityMecha;
import com.flansmod.common.driveables.mechas.ItemMecha;
import com.flansmod.common.driveables.mechas.ItemMechaAddon;
import com.flansmod.common.driveables.mechas.MechaItemType;
import com.flansmod.common.guns.AAGunType;
import com.flansmod.common.guns.BulletType;
import com.flansmod.common.guns.EntityAAGun;
import com.flansmod.common.guns.EntityBullet;
import com.flansmod.common.guns.ItemAAGun;
import com.flansmod.common.guns.ItemBullet;
import com.flansmod.common.network.FPacketHandler;
import com.flansmod.common.parts.ItemKey;
import com.flansmod.common.parts.ItemPart;
import com.flansmod.common.parts.PartType;
import com.flansmod.common.tools.EntityParachute;
import com.flansmod.common.tools.ItemTool;
import com.flansmod.common.tools.ToolType;
import com.flansmod.common.types.EnumType;
import com.flansmod.common.types.InfoType;
import com.flansmod.common.types.TypeFile;
import com.flansmod.common.util.CTabs;
import com.flansmod.common.util.ChunkLoadingHandler;
import com.flansmod.common.util.Config;
import com.flansmod.common.util.Ticker;
import com.flansmod.common.util.Util;

import net.fexcraft.mod.lib.network.SimpleUpdateHandler;
import net.fexcraft.mod.lib.util.common.Static;
import net.fexcraft.mod.lib.util.registry.Registry;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.common.ForgeChunkManager;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.event.entity.item.ItemTossEvent;
import net.minecraftforge.event.entity.player.PlayerDropsEvent;
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

@Mod(modid = "flansmod", name = FlansMod.NAME, version = FlansMod.VERSION, dependencies = "required-after:fcl", acceptableRemoteVersions = "*", guiFactory = "com.flansmod.client.gui.config.ModGuiFactory")
public class FlansMod {
	
	//Core mod stuff
	public static boolean DEBUG = false;
	public static final String MODID = "flansmod";
	public static final String VERSION = "5.F1.7-EX";
	public static final String NAME = "Flan's Mod Minus";
	@Mod.Instance("flansmod")
	public static FlansMod INSTANCE;
	@SidedProxy(clientSide = "com.flansmod.client.ClientProxy", serverSide = "com.flansmod.common.CommonProxy")
	public static CommonProxy proxy;
	public static File flanDir;

	//Handlers
	//public static final PacketHandler packetHandler = new PacketHandler();
	public static final FPacketHandler packet_handler = new FPacketHandler();
	public static final PlayerHandler playerHandler = new PlayerHandler();
	public static final Ticker tick_handler = new Ticker();
	public static FlansHooks hooks = new FlansHooks();
	
	//Items and creative tabs
	public static ArrayList<ItemPart> partItems = new ArrayList<ItemPart>();
	public static ArrayList<ItemMecha> mechaItems = new ArrayList<ItemMecha>();
	public static ArrayList<ItemTool> toolItems = new ArrayList<ItemTool>();
	
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
		GameRegistry.registerTileEntity(TileEntityItemHolder.class, "itemHolder");
		
		//Read content packs
		readContentPacks(event);

		proxy.registerRenderers();

		//Force Minecraft to reload all resources in order to load content pack resources.
		proxy.forceReload();

		proxy.registerRenderers();

		Util.log("Preinitializing complete.");
	}
	
	/** The mod initialiser method */
	@Mod.EventHandler
	public void init(FMLInitializationEvent event){
		Util.log("Initialising Flan's Mod.");

		//Do proxy loading
		proxy.load();
		//proxy.registerRenderers();

		//Initialising handlers
		//packetHandler.initialise();
		NetworkRegistry.INSTANCE.registerGuiHandler(this, new CommonGuiHandler());		
		
		// Recipes
		for(InfoType type : InfoType.types.values()){
			type.addRecipe();
		}
		if(Config.addGunpowderRecipe){
			ItemStack charcoal = new ItemStack(Items.COAL, 1, 1);
			GameRegistry.addShapelessRecipe(new ItemStack(Items.GUNPOWDER), charcoal, charcoal, charcoal, new ItemStack(Items.GLOWSTONE_DUST));
		}
		Util.log("Loaded recipes.");
		
		//EntityRegistry.registerGlobalEntityID(EntityItemCustomRender.class, "CustomItem", EntityRegistry.findGlobalUniqueEntityId());
		EntityRegistry.registerModEntity(new ResourceLocation(MODID, "CustomItem"), EntityCustomItem.class, "CustomItem", 89, this, 100, 20, true);
		
		//Register driveables
		//EntityRegistry.registerGlobalEntityID(EntityPlane.class, "Plane", EntityRegistry.findGlobalUniqueEntityId());
		EntityRegistry.registerModEntity(new ResourceLocation(MODID, "Plane"), EntityPlane.class, "Plane", 90, this, 250, 3, false);
		//EntityRegistry.registerGlobalEntityID(EntityVehicle.class, "Vehicle", EntityRegistry.findGlobalUniqueEntityId());
		EntityRegistry.registerModEntity(new ResourceLocation(MODID, "Vehicle"), EntityVehicle.class, "Vehicle", 95, this, 250, 10, false);
		//EntityRegistry.registerGlobalEntityID(EntitySeat.class, "Seat", EntityRegistry.findGlobalUniqueEntityId());
		EntityRegistry.registerModEntity(new ResourceLocation(MODID, "Seat"), EntitySeat.class, "Seat", 99, this, 250, 10, false);
		//EntityRegistry.registerGlobalEntityID(EntityWheel.class, "Wheel", EntityRegistry.findGlobalUniqueEntityId());
		EntityRegistry.registerModEntity(new ResourceLocation(MODID, "Wheel"), EntityWheel.class, "Wheel", 103, this, 250, 20, false);
		//EntityRegistry.registerGlobalEntityID(EntityParachute.class, "Parachute", EntityRegistry.findGlobalUniqueEntityId());
		EntityRegistry.registerModEntity(new ResourceLocation(MODID, "Parachute"), EntityParachute.class, "Parachute", 101, this, 40, 20, false);
		//EntityRegistry.registerGlobalEntityID(EntityMecha.class, "Mecha", EntityRegistry.findGlobalUniqueEntityId());
		EntityRegistry.registerModEntity(new ResourceLocation(MODID, "Mecha"), EntityMecha.class, "Mecha", 102, this, 250, 20, false);
		
		//Register bullets and grenades
		//EntityRegistry.registerGlobalEntityID(EntityBullet.class, "Bullet", EntityRegistry.findGlobalUniqueEntityId());
		EntityRegistry.registerModEntity(new ResourceLocation(MODID, "Bullet"), EntityBullet.class, "Bullet", 96, this, 40, 100, false);
		
		//EntityRegistry.registerGlobalEntityID(EntityAAGun.class, "AAGun", EntityRegistry.findGlobalUniqueEntityId());
		EntityRegistry.registerModEntity(new ResourceLocation(MODID, "AAGun"), EntityAAGun.class, "AAGun", 92, this, 40, 500, false);
		
		//Register the chunk loader 
		//TODO : Re-do chunk loading
		ForgeChunkManager.setForcedChunkLoadingCallback(this, new ChunkLoadingHandler());

		//Config
		MinecraftForge.EVENT_BUS.register(INSTANCE);
		//Starting the EventListener
		Util.log("Loading complete.");
	}
	
	/** The mod post-initialisation method */
	@Mod.EventHandler
	public void postInit(FMLPostInitializationEvent event){
		//packetHandler.postInitialise();
		packet_handler.initialise();
		MinecraftForge.EVENT_BUS.register(new UtilGui());
		hooks.hook();
	}
	
	@SubscribeEvent
	public void playerDrops(PlayerDropsEvent event){
		for(int i = event.getDrops().size() - 1; i >= 0; i--){
			EntityItem ent = event.getDrops().get(i);
			InfoType type = InfoType.getType(ent.getEntityItem());
			if(type != null && !type.canDrop)
				event.getDrops().remove(i);
		}
	}
	
	@SubscribeEvent
	public void playerDrops(ItemTossEvent event){
		InfoType type = InfoType.getType(event.getEntityItem().getEntityItem());
		if(type != null && !type.canDrop)
			event.setCanceled(true);
	}
	
	@Mod.EventHandler
	public void registerCommand(FMLServerStartingEvent event){
		//CommandHandler handler = ((CommandHandler)FMLCommonHandler.instance().getSidedDelegate().getServer().getCommandManager());
		//handler.registerCommand(new CommandTeams());
		event.registerServerCommand(new TextureCommand());
		event.registerServerCommand(new KeyCommand());
		event.registerServerCommand(new QuickFix());
	}
	
	/** Reads type files from all content packs */
	private void getTypeFiles(List<File> contentPacks)
	{
		for (File contentPack : contentPacks)
		{
			if(contentPack.isDirectory())
			{				
				for(EnumType typeToCheckFor : EnumType.values())
				{
					File typesDir = new File(contentPack, "/" + typeToCheckFor.folderName + "/");
					if(!typesDir.exists())
						continue;
					for(File file : typesDir.listFiles())
					{
						try
						{
							BufferedReader reader = new BufferedReader(new FileReader(file));
							String[] splitName = file.getName().split("/");
							TypeFile typeFile = new TypeFile(contentPack.getName(), typeToCheckFor, splitName[splitName.length - 1].split("\\.")[0]);
							for(;;)
							{
								String line = null;
								try
								{
									line = reader.readLine();
								} 
								catch (Exception e)
								{
									break;
								}
								if (line == null)
									break;
								typeFile.lines.add(line);
							}
							reader.close();
						}
						catch(FileNotFoundException e)
						{
							e.printStackTrace();
						}
						catch(IOException e)
						{
							e.printStackTrace();
						}
					}		
				}
				File dir = new File(contentPack, "/vehicles/");
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
							VehicleType type = new VehicleType(contentPack.getName(), filename[filename.length - 1].split("\\.")[0], arr);
							VehicleType.addType(type);
						}
						catch(Exception e){
							e.printStackTrace();
						}
					}
				}
			}
			else
			{
				try
				{
					ZipFile zip = new ZipFile(contentPack);
					ZipInputStream zipStream = new ZipInputStream(new FileInputStream(contentPack));
					BufferedReader reader = new BufferedReader(new InputStreamReader(zipStream));
					ZipEntry zipEntry = zipStream.getNextEntry();
					do
					{
						zipEntry = zipStream.getNextEntry();
						if(zipEntry == null)
							continue;
						TypeFile typeFile = null;
						for(EnumType type : EnumType.values())
						{
							if(zipEntry.getName().startsWith(type.folderName + "/") && zipEntry.getName().split(type.folderName + "/").length > 1 && zipEntry.getName().split(type.folderName + "/")[1].length() > 0)
							{
								String[] splitName = zipEntry.getName().split("/");
								typeFile = new TypeFile(zip.getName(), type, splitName[splitName.length - 1].split("\\.")[0]);
							}
						}
						if(typeFile == null)
						{
							continue;
						}
						for(;;)
						{
							String line = null;
							try
							{
								line = reader.readLine();
							} 
							catch (Exception e)
							{
								break;
							}
							if (line == null)
								break;
							typeFile.lines.add(line);
						}
					}
					while(zipEntry != null);
					reader.close();
					zip.close();
					zipStream.close();
				}
				catch(IOException e)
				{
					e.printStackTrace();
				}
			}
		}
	}
	
	/** Content pack reader method */
	private void readContentPacks(FMLPreInitializationEvent event){
		// Icons, Skins, Models
		// Get the classloader in order to load the images
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

		List<File> contentPacks = proxy.getContentList(method, classloader);

		//TODO : Add gametype loader
		getTypeFiles(contentPacks);
		
		for(EnumType type : EnumType.values()){
			Class<? extends InfoType> typeClass = type.getTypeClass();
			for(TypeFile typeFile : TypeFile.files.get(type)){
				try{
					InfoType infoType = (typeClass.getConstructor(TypeFile.class).newInstance(typeFile));
					infoType.read(typeFile);
					switch(type){
						case bullet : 		new ItemBullet((BulletType)infoType); break;
						case part : 		partItems.add((ItemPart)new ItemPart((PartType)infoType)); break;
						//case plane : 		new ItemPlane((PlaneType)infoType); break;
						//case vehicle : 		new ItemVehicle((VehicleType)infoType); break;
						case aa : 			new ItemAAGun((AAGunType)infoType); break;
						case mechaItem : 	new ItemMechaAddon((MechaItemType)infoType); break;
						//case mecha : 		mechaItems.add((ItemMecha)new ItemMecha((MechaType)infoType)); break;
						case tool : 		toolItems.add((ItemTool)new ItemTool((ToolType)infoType)); break;
						case team : 		break;
						case itemHolder:	new BlockItemHolder((ItemHolderType)infoType); break;
						default: Util.log("Unrecognised type for " + infoType.shortName); break;
					}
				}
				catch(Exception e){
					Util.log("Failed to add " + type.name() + " : " + typeFile.name);
					e.printStackTrace();
				}
			}
			Util.log("Loaded " + type.name() + ".");
		}
		for(DriveableType type : DriveableType.getTypes()){
			if(type instanceof VehicleType){
				type.read();
				type.item = ItemVehicle.getNew((VehicleType)type);
			}
			else{
				Static.exception(3);
			}
		}
		
		//Automates JSON adding for old content packs
		//No longer needed. We use a CustomModelLoader
		//proxy.addMissingJSONs(InfoType.infoTypes);
	}
	
	/*public static PacketHandler getPacketHandler()
	{
		return INSTANCE.packetHandler;
	}*/
	
	public static SimpleNetworkWrapper getNewPacketHandler(){
		return packet_handler.getInstance();
	}

	public static void Assert(boolean b, String string)
	{
		if(!b)
		{
			Util.log(string);
		}
	}
}
