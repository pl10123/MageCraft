package com.pl10123.magecraft.handler;


import com.pl10123.magecraft.reference.Reference;
import cpw.mods.fml.client.event.ConfigChangedEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.common.config.Configuration;

import java.io.File;

public class ConfigHandler {

    public static Configuration configuration;


    //Config Values
    public static boolean testValue = false;

    public static void init(File configFile){
        //Create config file from specified filename.
        if(configuration ==null) {
            configuration = new Configuration(configFile);
            loadConfig();
        }
    }

    @SubscribeEvent
    public void onConfigurationChangedEvent(ConfigChangedEvent.OnConfigChangedEvent e)
    {

        if(e.modID.equalsIgnoreCase(Reference.MOD_ID)){

            //Resync configs
            loadConfig();
        }

    }

    private static void loadConfig()
    {
        configuration.getBoolean("testValue", Configuration.CATEGORY_GENERAL, true, "This is a test value");

        if(configuration.hasChanged()){
            configuration.save();
        }
    }
}
