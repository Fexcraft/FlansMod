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

import com.flansmod.common.cmds.KeyCommand;
import com.flansmod.common.cmds.TextureCommand;
import com.flansmod.common.driveables.EntityPlane;
import com.flansmod.common.driveables.EntitySeat;
import com.flansmod.common.driveables.EntityVehicle;
import com.flansmod.common.driveables.EntityWheel;
import com.flansmod.common.driveables.ItemPlane;
import com.flansmod.common.driveables.ItemVehicle;
import com.flansmod.common.driveables.PlaneType;
import com.flansmod.common.driveables.VehicleType;
import com.flansmod.common.driveables.mechas.EntityMecha;
import com.flansmod.common.driveables.mechas.ItemMecha;
import com.flansmod.common.driveables.mechas.ItemMechaAddon;
import com.flansmod.common.driveables.mechas.MechaItemType;
import com.flansmod.common.driveables.mechas.MechaType;
import com.flansmod.common.eventhandlers.PlayerDeathEventListener;
import com.flansmod.common.guns.AAGunType;
import com.flansmod.common.guns.AttachmentType;
import com.flansmod.common.guns.BulletType;
import com.flansmod.common.guns.EntityAAGun;
import com.flansmod.common.guns.EntityBullet;
import com.flansmod.common.guns.EntityGrenade;
import com.flansmod.common.guns.EntityMG;
import com.flansmod.common.guns.GrenadeType;
import com.flansmod.common.guns.GunType;
import com.flansmod.common.guns.ItemAAGun;
import com.flansmod.common.guns.ItemAttachment;
import com.flansmod.common.guns.ItemBullet;
import com.flansmod.common.guns.ItemGrenade;
import com.flansmod.common.guns.ItemGun;
import com.flansmod.common.guns.boxes.BlockGunBox;
import com.flansmod.common.guns.boxes.GunBoxType;
import com.flansmod.common.network.FPacketHandler;
import com.flansmod.common.paintjob.BlockPaintjobTable;
import com.flansmod.common.paintjob.TileEntityPaintjobTable;
import com.flansmod.common.parts.ItemKey;
import com.flansmod.common.parts.ItemPart;
import com.flansmod.common.parts.PartType;
import com.flansmod.common.teams.ArmourBoxType;
import com.flansmod.common.teams.ArmourType;
import com.flansmod.common.teams.BlockArmourBox;
import com.flansmod.common.teams.BlockSpawner;
import com.flansmod.common.teams.ChunkLoadingHandler;
import com.flansmod.common.teams.EntityGunItem;
import com.flansmod.common.teams.ItemTeamArmour;
import com.flansmod.common.teams.TileEntitySpawner;
import com.flansmod.common.tools.EntityParachute;
import com.flansmod.common.tools.ItemTool;
import com.flansmod.common.tools.ToolType;
import com.flansmod.common.types.EnumType;
import com.flansmod.common.types.InfoType;
import com.flansmod.common.types.TypeFile;
import com.flansmod.common.util.CTabs;
import com.flansmod.common.util.Config;
import com.flansmod.common.util.Ticker;
import com.flansmod.common.util.Util;

import net.fexcraft.mod.lib.util.block.BlockUtil;
import net.minecraft.block.material.Material;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.ForgeChunkManager;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.event.entity.item.ItemTossEvent;
import net.minecraftforge.event.entity.player.PlayerDropsEvent;
import net.minecraftforge.event.world.BlockEvent;
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

@Mod(modid = "ffmm", name = FlansMod.NAME, version = FlansMod.VERSION, dependencies = "required-after:fcl", acceptableRemoteVersions = "*", guiFactory = "com.flansmod.client.gui.config.ModGuiFactory")
public class FlansMod
{
	//Core mod stuff
	public static boolean DEBUG = false;
	public static final String MODID = "flansmod";
	public static final String VERSION = "5.F0.3";
	public static final String NAME = "Flan's Mod Minus";
	@Mod.Instance("ffmm")
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
	public static BlockFlansWorkbench workbench;
	public static BlockSpawner spawner;
	public static ArrayList<ItemPart> partItems = new ArrayList<ItemPart>();
	public static ArrayList<ItemMecha> mechaItems = new ArrayList<ItemMecha>();
	public static ArrayList<ItemTool> toolItems = new ArrayList<ItemTool>();
	public static ArrayList<ItemTeamArmour> armourItems = new ArrayList<ItemTeamArmour>();
	
	/** Custom paintjob item */
	public static Item rainbowPaintcan;
	public static BlockPaintjobTable paintjobTable;
	
	public static ItemKey key;

	/** The mod pre-initialiser method */
	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent event){
		Util.log("Preinitialising Flan's mod.");
		Config.initalize(new Configuration(event.getSuggestedConfigurationFile()), event.getSuggestedConfigurationFile().getParentFile());
		com.flansmod.common.data.player.PlayerHandler.initialize();
		
		flanDir = new File(event.getModConfigurationDirectory().getParentFile(), "/Flan/");
		if(!flanDir.exists()){
			Util.log("Flan folder not found. Creating empty folder.");
			Util.log("You should get some content packs and put them in the Flan folder.");
			flanDir.mkdirs();
		}
		
		//Set up mod blocks and items
		key = new ItemKey();
		workbench = (BlockFlansWorkbench)(new BlockFlansWorkbench());
		workbench.setRegistryName(MODID, "flansWorkbench");
		workbench.setUnlocalizedName(workbench.getRegistryName().toString());
		GameRegistry.register(workbench);
		GameRegistry.register(new ItemBlockManyNames(workbench));
		GameRegistry.addRecipe(new ItemStack(workbench, 1, 0), "BBB", "III", "III", 'B', Items.BOWL, 'I', Items.IRON_INGOT );
		GameRegistry.addRecipe(new ItemStack(workbench, 1, 1), "ICI", "III", 'C', Items.CAULDRON, 'I', Items.IRON_INGOT );
		spawner = (BlockSpawner)(new BlockSpawner(Material.IRON).setBlockUnbreakable().setResistance(1000000F));
		GameRegistry.register(spawner);
		GameRegistry.register(new ItemBlockManyNames(spawner));
		GameRegistry.registerTileEntity(TileEntitySpawner.class, "teamsSpawner");
		
		rainbowPaintcan = new Item().setCreativeTab(CTabs.parts);
		rainbowPaintcan.setRegistryName(MODID, "rainbowPaintcan");
		rainbowPaintcan.setUnlocalizedName(rainbowPaintcan.getRegistryName().toString());
		GameRegistry.register(rainbowPaintcan);
		paintjobTable = new BlockPaintjobTable();
		BlockUtil.register(MODID, paintjobTable);
		BlockUtil.registerFIB(paintjobTable);
		GameRegistry.registerTileEntity(TileEntityPaintjobTable.class, MODID);
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
		for(InfoType type : InfoType.infoTypes.values()){
			type.addRecipe();
		}
		if(Config.addGunpowderRecipe){
			ItemStack charcoal = new ItemStack(Items.COAL, 1, 1);
			GameRegistry.addShapelessRecipe(new ItemStack(Items.GUNPOWDER), charcoal, charcoal, charcoal, new ItemStack(Items.GLOWSTONE_DUST));
		}
		Util.log("Loaded recipes.");
		
		//EntityRegistry.registerGlobalEntityID(EntityGunItem.class, "GunItem", EntityRegistry.findGlobalUniqueEntityId());
		EntityRegistry.registerModEntity(new ResourceLocation(MODID, "GunItem"), EntityGunItem.class, "GunItem", 98, this, 100, 20, true);
		//EntityRegistry.registerGlobalEntityID(EntityItemCustomRender.class, "CustomItem", EntityRegistry.findGlobalUniqueEntityId());
		EntityRegistry.registerModEntity(new ResourceLocation(MODID, "CustomItem"), EntityCustomItem.class, "CustomItem", 89, this, 100, 20, true);
		
		//Register driveables
		//EntityRegistry.registerGlobalEntityID(EntityPlane.class, "Plane", EntityRegistry.findGlobalUniqueEntityId());
		EntityRegistry.registerModEntity(new ResourceLocation(MODID, "Plane"), EntityPlane.class, "Plane", 90, this, 250, 3, false);
		//EntityRegistry.registerGlobalEntityID(EntityVehicle.class, "Vehicle", EntityRegistry.findGlobalUniqueEntityId());
		EntityRegistry.registerModEntity(new ResourceLocation(MODID, "Vehicle"), EntityVehicle.class, "Vehicle", 95, this, 250, 10, false);
		//EntityRegistry.registerGlobalEntityID(EntitySeat.class, "Seat", EntityRegistry.findGlobalUniqueEntityId());
		EntityRegistry.registerModEntity(new ResourceLocation(MODID, "Seat"), EntitySeat.class, "Seat", 99, this, 250, 1000, false);
		//EntityRegistry.registerGlobalEntityID(EntityWheel.class, "Wheel", EntityRegistry.findGlobalUniqueEntityId());
		EntityRegistry.registerModEntity(new ResourceLocation(MODID, "Wheel"), EntityWheel.class, "Wheel", 103, this, 250, 20, false);
		//EntityRegistry.registerGlobalEntityID(EntityParachute.class, "Parachute", EntityRegistry.findGlobalUniqueEntityId());
		EntityRegistry.registerModEntity(new ResourceLocation(MODID, "Parachute"), EntityParachute.class, "Parachute", 101, this, 40, 20, false);
		//EntityRegistry.registerGlobalEntityID(EntityMecha.class, "Mecha", EntityRegistry.findGlobalUniqueEntityId());
		EntityRegistry.registerModEntity(new ResourceLocation(MODID, "Mecha"), EntityMecha.class, "Mecha", 102, this, 250, 20, false);
		
		//Register bullets and grenades
		//EntityRegistry.registerGlobalEntityID(EntityBullet.class, "Bullet", EntityRegistry.findGlobalUniqueEntityId());
		EntityRegistry.registerModEntity(new ResourceLocation(MODID, "Bullet"), EntityBullet.class, "Bullet", 96, this, 40, 100, false);
		//EntityRegistry.registerGlobalEntityID(EntityGrenade.class, "Grenade", EntityRegistry.findGlobalUniqueEntityId());
		EntityRegistry.registerModEntity(new ResourceLocation(MODID, "Grenade"), EntityGrenade.class, "Grenade", 100, this, 40, 100, true);

		//Register MGs and AA guns
		//EntityRegistry.registerGlobalEntityID(EntityMG.class, "MG", EntityRegistry.findGlobalUniqueEntityId());
		EntityRegistry.registerModEntity(new ResourceLocation(MODID, "MG"), EntityMG.class, "MG", 91, this, 40, 5, true);
		//EntityRegistry.registerGlobalEntityID(EntityAAGun.class, "AAGun", EntityRegistry.findGlobalUniqueEntityId());
		EntityRegistry.registerModEntity(new ResourceLocation(MODID, "AAGun"), EntityAAGun.class, "AAGun", 92, this, 40, 500, false);
		
		//Register the chunk loader 
		//TODO : Re-do chunk loading
		ForgeChunkManager.setForcedChunkLoadingCallback(this, new ChunkLoadingHandler());

		//Config
		MinecraftForge.EVENT_BUS.register(INSTANCE);
		//Starting the EventListener
		new PlayerDeathEventListener();
		Util.log("Loading complete.");
	}
	
	/** The mod post-initialisation method */
	@Mod.EventHandler
	public void postInit(FMLPostInitializationEvent event){
		//packetHandler.postInitialise();
		packet_handler.initialise();
		
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
	}
	
	@SubscribeEvent
	public void onBlockBreak(BlockEvent.BreakEvent event){
		if(event.getPlayer() != null && event.getPlayer().getHeldItemMainhand() != null && event.getPlayer().getHeldItemMainhand().getItem() instanceof ItemGun){
			event.setCanceled(true);
		}
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
	private void readContentPacks(FMLPreInitializationEvent event)
	{
		// Icons, Skins, Models
		// Get the classloader in order to load the images
		ClassLoader classloader = (net.minecraft.server.MinecraftServer.class).getClassLoader();
		Method method = null;
		try
		{
			method = (java.net.URLClassLoader.class).getDeclaredMethod("addURL", java.net.URL.class);
			method.setAccessible(true);
		} catch (Exception e)
		{
			Util.log("Failed to get class loader. All content loading will now fail.");
			e.printStackTrace();
		}

		List<File> contentPacks = proxy.getContentList(method, classloader);

		//TODO : Add gametype loader
		getTypeFiles(contentPacks);
		
		for(EnumType type : EnumType.values())
		{
			Class<? extends InfoType> typeClass = type.getTypeClass();
			for(TypeFile typeFile : TypeFile.files.get(type))
			{
				try
				{
					InfoType infoType = (typeClass.getConstructor(TypeFile.class).newInstance(typeFile));
					infoType.read(typeFile);
					switch(type)
					{
					case bullet : 		new ItemBullet((BulletType)infoType); break;
					case attachment : 	new ItemAttachment((AttachmentType)infoType); break;
					case gun : 			new ItemGun((GunType)infoType); break;
					case grenade : 		new ItemGrenade((GrenadeType)infoType); break;
					case part : 		partItems.add((ItemPart)new ItemPart((PartType)infoType)); break;
					case plane : 		new ItemPlane((PlaneType)infoType); break;
					case vehicle : 		new ItemVehicle((VehicleType)infoType); break;
					case aa : 			new ItemAAGun((AAGunType)infoType); break;
					case mechaItem : 	new ItemMechaAddon((MechaItemType)infoType); break;
					case mecha : 		mechaItems.add((ItemMecha)new ItemMecha((MechaType)infoType)); break;
					case tool : 		toolItems.add((ItemTool)new ItemTool((ToolType)infoType)); break;
					case box : 			new BlockGunBox((GunBoxType)infoType); break;
					case armour : 		armourItems.add((ItemTeamArmour)new ItemTeamArmour((ArmourType)infoType)); break;
					case armourBox : 	new BlockArmourBox((ArmourBoxType)infoType); break; 
					case playerClass : 	break;
					case team : 		break;
					case itemHolder:	new BlockItemHolder((ItemHolderType)infoType); break;
					default: Util.log("Unrecognised type for " + infoType.shortName); break;
					}
				}
				catch(Exception e)
				{
					Util.log("Failed to add " + type.name() + " : " + typeFile.name);
					e.printStackTrace();
				}
			}
			Util.log("Loaded " + type.name() + ".");
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
