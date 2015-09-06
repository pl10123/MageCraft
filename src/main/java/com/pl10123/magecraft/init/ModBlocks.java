package com.pl10123.magecraft.init;

import com.pl10123.magecraft.block.fluid.BlockManaFluid;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class ModBlocks
{



    public static Block blockManaFluid  = new BlockManaFluid(ModFluids.mana, Material.water);;


  //  public static BlockMageCraft manaGenerator = new BlockManaGenerator();

    public static void init()
    {
        //GameRegistry.registerBlock(manaGenerator, "manaGenerator");
        GameRegistry.registerBlock(blockManaFluid, "manaFluid");
    }



}
