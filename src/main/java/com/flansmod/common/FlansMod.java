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

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

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
import com.flansmod.common.network.PacketHandler;
import com.flansmod.common.paintjob.BlockPaintjobTable;
import com.flansmod.common.paintjob.TileEntityPaintjobTable;
import com.flansmod.common.parts.ItemPart;
import com.flansmod.common.parts.PartType;
import com.flansmod.common.teams.ArmourBoxType;
import com.flansmod.common.teams.ArmourType;
import com.flansmod.common.teams.BlockArmourBox;
import com.flansmod.common.teams.BlockSpawner;
import com.flansmod.common.teams.ChunkLoadingHandler;
import com.flansmod.common.teams.CommandTeams;
import com.flansmod.common.teams.EntityFlag;
import com.flansmod.common.teams.EntityFlagpole;
import com.flansmod.common.teams.EntityGunItem;
import com.flansmod.common.teams.EntityTeamItem;
import com.flansmod.common.teams.ItemFlagpole;
import com.flansmod.common.teams.ItemOpStick;
import com.flansmod.common.teams.ItemTeamArmour;
import com.flansmod.common.teams.PlayerClass;
import com.flansmod.common.teams.Team;
import com.flansmod.common.teams.TeamsManager;
import com.flansmod.common.teams.TileEntitySpawner;
import com.flansmod.common.tools.EntityParachute;
import com.flansmod.common.tools.ItemTool;
import com.flansmod.common.tools.ToolType;
import com.flansmod.common.types.EnumType;
import com.flansmod.common.types.InfoType;
import com.flansmod.common.types.TypeFile;

import net.fexcraft.mod.lib.util.block.BlockUtil;
import net.fexcraft.mod.lib.util.entity.EntUtil;
import net.fexcraft.mod.lib.util.item.ItemUtil;
import net.minecraft.block.material.Material;
import net.minecraft.command.CommandHandler;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.ForgeChunkManager;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.item.ItemTossEvent;
import net.minecraftforge.event.entity.player.PlayerDropsEvent;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartedEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;

//@Mod(modid = FlansMod.MODID, name = FlansMod.NAME, version = FlansMod.VERSION, acceptableRemoteVersions = "@ALLOWEDVERSIONS@", guiFactory = "com.flansmod.client.gui.config.ModGuiFactory")
public class FlansMod
{
	//Core mod stuff
	private static Logger logger;
	public static boolean DEBUG = false;
	public static Configuration configFile;
	public static final String MODID = "flansmod";
	public static final String VERSION = "@VERSION@";
	public static final String NAME = "Flan's Mod";
	//@Mod.Instance(MODID)
	public static FlansMod INSTANCE;
	public static int generalConfigInteger = 32;
	public static String generalConfigString = "Hello!";
	public static boolean addGunpowderRecipe = true;
	public static int teamsConfigInteger = 32;
	public static String teamsConfigString = "Hello!";
	public static boolean teamsConfigBoolean = false;
	@SidedProxy(clientSide = "com.flansmod.client.ClientProxy", serverSide = "com.flansmod.common.CommonProxy")
	public static CommonProxy proxy;
	//A standardised ticker for all bits of the mod to call upon if they need one
	public static int ticker = 0;
	public static long lastTime;
	public static File flanDir;
	public static final float soundRange = 50F;
	public static final float driveableUpdateRange = 200F;
	public static final int numPlayerSnapshots = 20;
	public static boolean isApocalypseLoaded = false;
	public static boolean addAllPaintjobsToCreative = false;
	
	public static float armourSpawnRate = 0.25F;
	
	public static int dungeonLootChance = 500;
	
	/** The spectator team. Moved here to avoid a concurrent modification error */
	public static Team spectators = new Team("spectators", "Spectators", 0x404040, '7');

	//Handlers
	public static final PacketHandler packetHandler = new PacketHandler();
	public static final FPacketHandler packet_handler = new FPacketHandler();
	public static final PlayerHandler playerHandler = new PlayerHandler();
	//public static final TeamsManager teamsManager = new TeamsManager();
	//public static final CommonTickHandler tickHandler = new CommonTickHandler();//TODO
	public static FlansHooks hooks = new FlansHooks();
	
	//Items and creative tabs
	public static BlockFlansWorkbench workbench;
	public static BlockSpawner spawner;
	public static ItemOpStick opStick;
	public static ItemFlagpole flag;
	public static ArrayList<ItemPart> partItems = new ArrayList<ItemPart>();
	public static ArrayList<ItemMecha> mechaItems = new ArrayList<ItemMecha>();
	public static ArrayList<ItemTool> toolItems = new ArrayList<ItemTool>();
	public static ArrayList<ItemTeamArmour> armourItems = new ArrayList<ItemTeamArmour>();
	public static CreativeTabFlan tabFlanGuns = new CreativeTabFlan(0), tabFlanDriveables = new CreativeTabFlan(1),
			tabFlanParts = new CreativeTabFlan(2), tabFlanTeams = new CreativeTabFlan(3), tabFlanMechas = new CreativeTabFlan(4);
	
	/** Custom paintjob item */
	public static Item rainbowPaintcan;
	public static BlockPaintjobTable paintjobTable;

	/** The mod pre-initialiser method */
	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		//Register a logger
		logger = LogManager.getLogger(NAME);

		log("Preinitialising Flan's mod.");
		configFile = new Configuration(event.getSuggestedConfigurationFile());
		syncConfig();

		//TODO : Load properties
		//configuration = new Configuration(event.getSuggestedConfigurationFile());
		//loadProperties();
		
		try
		{
			isApocalypseLoaded = true;
			Class.forName("com.flansmod.apocalypse.common.FlansModApocalypse");
		}
		catch(Exception e)
		{
			isApocalypseLoaded = false;
		}
		
		flanDir = new File(event.getModConfigurationDirectory().getParentFile(), "/Flan/");
	
		if (!flanDir.exists())
		{
			log("Flan folder not found. Creating empty folder.");
			log("You should get some content packs and put them in the Flan folder.");
			flanDir.mkdirs();
		}
		
		//Set up mod blocks and items
		workbench = (BlockFlansWorkbench)(new BlockFlansWorkbench());
		workbench.setRegistryName(MODID, "flansWorkbench");
		workbench.setUnlocalizedName(workbench.getRegistryName().toString());
		GameRegistry.register(workbench);
		GameRegistry.register(new ItemBlockManyNames(workbench));
		GameRegistry.addRecipe(new ItemStack(workbench, 1, 0), "BBB", "III", "III", 'B', Items.BOWL, 'I', Items.IRON_INGOT );
		GameRegistry.addRecipe(new ItemStack(workbench, 1, 1), "ICI", "III", 'C', Items.CAULDRON, 'I', Items.IRON_INGOT );
		opStick = new ItemOpStick();
		ItemUtil.register(MODID, opStick);
		ItemUtil.registerRender(opStick);
		flag = (ItemFlagpole)(new ItemFlagpole());
		ItemUtil.register(MODID, flag);
		ItemUtil.registerRender(flag);
		spawner = (BlockSpawner)(new BlockSpawner(Material.IRON).setBlockUnbreakable().setResistance(1000000F));
		GameRegistry.register(spawner);
		GameRegistry.register(new ItemBlockManyNames(spawner));
		GameRegistry.registerTileEntity(TileEntitySpawner.class, "teamsSpawner");
		
		rainbowPaintcan = new Item().setCreativeTab(tabFlanGuns);
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

		log("Preinitializing complete.");
	}
	
	/** The mod initialiser method */
	@Mod.EventHandler
	public void init(FMLInitializationEvent event)
	{
		log("Initialising Flan's Mod.");

		//Do proxy loading
		proxy.load();
		//proxy.registerRenderers();

		//Initialising handlers
		packetHandler.initialise();
		NetworkRegistry.INSTANCE.registerGuiHandler(this, new CommonGuiHandler());		
		
		// Recipes
		for (InfoType type : InfoType.infoTypes.values())
		{
			type.addRecipe();
			type.addDungeonLoot();
		}
		if(addGunpowderRecipe)
		{
			ItemStack charcoal = new ItemStack(Items.COAL, 1, 1);
			GameRegistry.addShapelessRecipe(new ItemStack(Items.GUNPOWDER), charcoal, charcoal, charcoal, new ItemStack(Items.GLOWSTONE_DUST));
		}
		log("Loaded recipes.");
		
		//Register teams mod entities
		//EntityRegistry.registerGlobalEntityID(EntityFlagpole.class, "Flagpole", EntityRegistry.findGlobalUniqueEntityId());
		EntityRegistry.registerModEntity(EntityFlagpole.class, "Flagpole", 93, this, 40, 5, true);
		//EntityRegistry.registerGlobalEntityID(EntityFlag.class, "Flag", EntityRegistry.findGlobalUniqueEntityId());
		EntityRegistry.registerModEntity(EntityFlag.class, "Flag", 94, this, 40, 5, true);
		//EntityRegistry.registerGlobalEntityID(EntityTeamItem.class, "TeamsItem", EntityRegistry.findGlobalUniqueEntityId());
		EntityRegistry.registerModEntity(EntityTeamItem.class, "TeamsItem", 97, this, 100, 10000, true);
		//EntityRegistry.registerGlobalEntityID(EntityGunItem.class, "GunItem", EntityRegistry.findGlobalUniqueEntityId());
		EntityRegistry.registerModEntity(EntityGunItem.class, "GunItem", 98, this, 100, 20, true);
		//EntityRegistry.registerGlobalEntityID(EntityItemCustomRender.class, "CustomItem", EntityRegistry.findGlobalUniqueEntityId());
		EntityRegistry.registerModEntity(EntityCustomItem.class, "CustomItem", 89, this, 100, 20, true);
		
		//Register driveables
		//EntityRegistry.registerGlobalEntityID(EntityPlane.class, "Plane", EntityRegistry.findGlobalUniqueEntityId());
		EntityRegistry.registerModEntity(EntityPlane.class, "Plane", 90, this, 250, 3, false);
		//EntityRegistry.registerGlobalEntityID(EntityVehicle.class, "Vehicle", EntityRegistry.findGlobalUniqueEntityId());
		EntityRegistry.registerModEntity(EntityVehicle.class, "Vehicle", 95, this, 250, 10, false);
		//EntityRegistry.registerGlobalEntityID(EntitySeat.class, "Seat", EntityRegistry.findGlobalUniqueEntityId());
		EntityRegistry.registerModEntity(EntitySeat.class, "Seat", 99, this, 250, 1000, false);
		//EntityRegistry.registerGlobalEntityID(EntityWheel.class, "Wheel", EntityRegistry.findGlobalUniqueEntityId());
		EntityRegistry.registerModEntity(EntityWheel.class, "Wheel", 103, this, 250, 20, false);
		//EntityRegistry.registerGlobalEntityID(EntityParachute.class, "Parachute", EntityRegistry.findGlobalUniqueEntityId());
		EntityRegistry.registerModEntity(EntityParachute.class, "Parachute", 101, this, 40, 20, false);
		//EntityRegistry.registerGlobalEntityID(EntityMecha.class, "Mecha", EntityRegistry.findGlobalUniqueEntityId());
		EntityRegistry.registerModEntity(EntityMecha.class, "Mecha", 102, this, 250, 20, false);
		
		//Register bullets and grenades
		//EntityRegistry.registerGlobalEntityID(EntityBullet.class, "Bullet", EntityRegistry.findGlobalUniqueEntityId());
		EntityRegistry.registerModEntity(EntityBullet.class, "Bullet", 96, this, 40, 100, false);
		//EntityRegistry.registerGlobalEntityID(EntityGrenade.class, "Grenade", EntityRegistry.findGlobalUniqueEntityId());
		EntityRegistry.registerModEntity(EntityGrenade.class, "Grenade", 100, this, 40, 100, true);

		//Register MGs and AA guns
		//EntityRegistry.registerGlobalEntityID(EntityMG.class, "MG", EntityRegistry.findGlobalUniqueEntityId());
		EntityRegistry.registerModEntity(EntityMG.class, "MG", 91, this, 40, 5, true);
		//EntityRegistry.registerGlobalEntityID(EntityAAGun.class, "AAGun", EntityRegistry.findGlobalUniqueEntityId());
		EntityRegistry.registerModEntity(EntityAAGun.class, "AAGun", 92, this, 40, 500, false);
		
		//Register the chunk loader 
		//TODO : Re-do chunk loading
		ForgeChunkManager.setForcedChunkLoadingCallback(this, new ChunkLoadingHandler());

		//Config
		MinecraftForge.EVENT_BUS.register(INSTANCE);
		//Starting the EventListener
		new PlayerDeathEventListener();
		log("Loading complete.");
	}
	
	/** The mod post-initialisation method */
	@Mod.EventHandler
	public void postInit(FMLPostInitializationEvent event)
	{
		packetHandler.postInitialise();
		packet_handler.initialise();
		
		hooks.hook();
	}
	
	@SubscribeEvent
	public void playerDrops(PlayerDropsEvent event)
	{
		for(int i = event.getDrops().size() - 1; i >= 0; i--)
		{
			EntityItem ent = event.getDrops().get(i);
			InfoType type = InfoType.getType(ent.getEntityItem());
			if(type != null && !type.canDrop)
				event.getDrops().remove(i);
		}
	}
	
	@SubscribeEvent
	public void playerDrops(ItemTossEvent event)
	{
		InfoType type = InfoType.getType(event.getEntityItem().getEntityItem());
		if(type != null && !type.canDrop)
			event.setCanceled(true);
	}
	
	/** Teams command register method */
	@Mod.EventHandler
	public void registerCommand(FMLServerStartedEvent e)
	{
		CommandHandler handler = ((CommandHandler)FMLCommonHandler.instance().getSidedDelegate().getServer().getCommandManager());
		handler.registerCommand(new CommandTeams());
	}

	@SubscribeEvent
	public void onConfigChanged(ConfigChangedEvent.OnConfigChangedEvent eventArgs) {
		if(eventArgs.getModID().equals(MODID))
			syncConfig();
	}
	
	@SubscribeEvent
	public void onBlockBreak(BlockEvent.BreakEvent event)
	{
		if(event.getPlayer() != null
				&& event.getPlayer().getHeldItemMainhand() != null
				&& event.getPlayer().getHeldItemMainhand().getItem() instanceof ItemGun)
		{
			event.setCanceled(true);
		}
	}

	//TODO temporary off //@SubscribeEvent
	public void onLivingSpecialSpawn(EntityJoinWorldEvent event)
	{
		double chance = event.getWorld().rand.nextDouble();

		if(chance < armourSpawnRate && event.getEntity() instanceof EntityZombie || event.getEntity() instanceof EntitySkeleton)
		{
			if(event.getWorld().rand.nextBoolean() && ArmourType.armours.size() > 0)
			{
				//Give a completely random piece of armour
				ArmourType armour = ArmourType.armours.get(event.getWorld().rand.nextInt(ArmourType.armours.size()));
				if(armour != null && armour.type != 2)
					//event.getEntity().setCurrentItemOrArmor(armour.type + 1, new ItemStack(armour.item));
					event.getEntity().setItemStackToSlot(EntUtil.getEquipmentSlot(armour.type + 1), new ItemStack(armour.item));
			}
			else if(Team.teams.size() > 0)
			{
				//Give a random set of armour
				Team team = Team.teams.get(event.getWorld().rand.nextInt(Team.teams.size()));
				if(team.hat != null)
					event.getEntity().setItemStackToSlot(EntUtil.getEquipmentSlot(1), team.hat.copy());
				if(team.chest != null)
					event.getEntity().setItemStackToSlot(EntUtil.getEquipmentSlot(2), team.chest.copy());
				if(team.legs != null)
					event.getEntity().setItemStackToSlot(EntUtil.getEquipmentSlot(3), team.legs.copy());
				if(team.shoes != null)
					event.getEntity().setItemStackToSlot(EntUtil.getEquipmentSlot(4), team.shoes.copy());
				
				if(team.classes.size() > 0)
				{
					PlayerClass playerClass = team.classes.get(event.getWorld().rand.nextInt(team.classes.size()));
					if(playerClass.hat != null)
						event.getEntity().setItemStackToSlot(EntUtil.getEquipmentSlot(1), team.hat.copy());
					if(playerClass.chest != null)
						event.getEntity().setItemStackToSlot(EntUtil.getEquipmentSlot(2), team.chest.copy());
					if(playerClass.legs != null)
						event.getEntity().setItemStackToSlot(EntUtil.getEquipmentSlot(3), team.legs.copy());
					if(playerClass.shoes != null)
						event.getEntity().setItemStackToSlot(EntUtil.getEquipmentSlot(4), team.shoes.copy());
				}
			}
		}
		//tickHandler.onEntitySpawn(event);
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
			log("Failed to get class loader. All content loading will now fail.");
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
					default : log("Unrecognised type for " + infoType.shortName); break;
					}
				}
				catch(Exception e)
				{
					log("Failed to add " + type.name() + " : " + typeFile.name);
					e.printStackTrace();
				}
			}
			log("Loaded " + type.name() + ".");
		}		
		Team.spectators = spectators;
		
		//Automates JSON adding for old content packs
		//No longer needed. We use a CustomModelLoader
		//proxy.addMissingJSONs(InfoType.infoTypes);
	}
	
	public static PacketHandler getPacketHandler()
	{
		return INSTANCE.packetHandler;
	}
	
	public static SimpleNetworkWrapper getNewPacketHandler(){
		return packet_handler.getInstance();
	}

	public static void syncConfig() {
		//generalConfigInteger = configFile.getInt("Config Integer", Configuration.CATEGORY_GENERAL, generalConfigInteger, 0, Integer.MAX_VALUE, "An Integer!");
		//generalConfigString = configFile.getString("Config String", Configuration.CATEGORY_GENERAL, generalConfigString, "A String!");
		addGunpowderRecipe = configFile.getBoolean("Gunpowder Recipe", Configuration.CATEGORY_GENERAL, addGunpowderRecipe, "Whether or not to add the extra gunpowder recipe (3 charcoal + 1 lightstone)");

		addAllPaintjobsToCreative = configFile.getBoolean("Add All Paintjobs to Creative", Configuration.CATEGORY_GENERAL, addAllPaintjobsToCreative, "Whether all paintjobs should appear in creative");

		if(configFile.hasChanged())
			configFile.save();
	}

	public static Logger getLogger()
	{
		return logger;
	}

	public static void log(Object log)
	{
		getLogger().info(String.valueOf(log));
	}

	public static void logError(String message, Throwable e)
	{
		getLogger().error(message, e);
	}

	public static void Assert(boolean b, String string)
	{
		if(!b)
		{
			log(string);
		}
	}
}
