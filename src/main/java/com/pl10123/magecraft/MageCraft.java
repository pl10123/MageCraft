package com.pl10123.magecraft;

import com.pl10123.magecraft.handler.BucketHandler;
import com.pl10123.magecraft.handler.ConfigHandler;
import com.pl10123.magecraft.init.ModBlocks;
import com.pl10123.magecraft.init.ModFluids;
import com.pl10123.magecraft.init.ModItems;
import com.pl10123.magecraft.item.guide.MainGuide;
import com.pl10123.magecraft.proxy.IProxy;
import com.pl10123.magecraft.reference.Reference;
import com.pl10123.magecraft.utility.LogHelper;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.common.MinecraftForge;


@Mod(modid= Reference.MOD_ID, name=Reference.MOD_NAME, version=Reference.MOD_VERSION, guiFactory = Reference.GUI_FACTORY)
public class MageCraft
{

    @Mod.Instance(Reference.MOD_ID)
    public static MageCraft instance;

    @SidedProxy(clientSide = Reference.CLIENT_PROXY, serverSide = Reference.SERVER_PROXY)
    public static IProxy proxy;


    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent e)
    {

        //Load Configuration Stuff (including some handler thing for config gui screen)
        ConfigHandler.init(e.getSuggestedConfigurationFile());
        FMLCommonHandler.instance().bus().register(new ConfigHandler());

        ModFluids.initFluids();
        ModItems.init();
        ModBlocks.init();
        MainGuide.initMainGuide();

        //Register All Handlers
        BucketHandler.INSTANCE.buckets.put(ModBlocks.blockManaFluid, ModItems.manaBucket);
        MinecraftForge.EVENT_BUS.register(BucketHandler.INSTANCE);

        //Finish pre-init :p
        LogHelper.info("Pre init Complete!");
    }



    @Mod.EventHandler
    public void init(FMLInitializationEvent e)
    {
        LogHelper.info("Init Complete!");
    }



    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent e)
    {
        LogHelper.info("Post init Complete!");
    }

}
