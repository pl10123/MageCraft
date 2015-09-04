package com.pl10123.magecraft.client.gui;

import com.pl10123.magecraft.handler.ConfigHandler;
import com.pl10123.magecraft.reference.Reference;
import cpw.mods.fml.client.config.GuiConfig;
import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.common.config.ConfigElement;
import net.minecraftforge.common.config.Configuration;

/**
 * Created by Peter Sakr on 1/9/2015.
 */
public class ModGuiConfig extends GuiConfig {

    public ModGuiConfig(GuiScreen guiScreen){
        super(guiScreen,
                new ConfigElement(ConfigHandler.configuration.getCategory(Configuration.CATEGORY_GENERAL)).getChildElements(),
                Reference.MOD_ID,
                false,
                false,
                GuiConfig.getAbridgedConfigPath(ConfigHandler.configuration.toString()));
    }
}
