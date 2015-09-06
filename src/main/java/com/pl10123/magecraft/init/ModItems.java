package com.pl10123.magecraft.init;

import com.pl10123.magecraft.item.ItemMageCraft;
import com.pl10123.magecraft.item.ItemTest;
import com.pl10123.magecraft.item.ManaBucket;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidContainerRegistry;


public class ModItems {

    public static final ItemMageCraft itemTest = new ItemTest();
    public static Item manaBucket = new ManaBucket(ModBlocks.blockManaFluid);

    public static void init(){
        GameRegistry.registerItem(itemTest, "testItem");
        GameRegistry.registerItem(manaBucket, "manaBucket");
        FluidContainerRegistry.registerFluidContainer(ModFluids.mana, new ItemStack(manaBucket), new ItemStack(Items.bucket));
    }
}
