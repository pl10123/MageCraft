package com.pl10123.magecraft.init;

import com.pl10123.magecraft.item.ItemMageCraft;
import com.pl10123.magecraft.item.ItemTest;
import cpw.mods.fml.common.registry.GameRegistry;

/**
 * Created by Peter Sakr on 3/9/2015.
 */
public class ModItems {

    public static final ItemMageCraft itemTest = new ItemTest();

    public static void init(){
        GameRegistry.registerItem(itemTest, "testItem");
    }
}
