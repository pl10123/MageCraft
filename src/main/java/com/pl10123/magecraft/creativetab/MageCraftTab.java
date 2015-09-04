package com.pl10123.magecraft.creativetab;


import com.pl10123.magecraft.reference.Reference;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;

public class MageCraftTab
{
    public static final CreativeTabs MageCraftTab = new CreativeTabs(Reference.MOD_NAME) {
        @Override public Item getTabIconItem()
        {
            return Items.diamond;
        }

    };


}
