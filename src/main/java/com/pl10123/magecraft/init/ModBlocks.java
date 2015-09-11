package com.pl10123.magecraft.init;

import com.pl10123.magecraft.block.BlockManaBank;
import com.pl10123.magecraft.block.BlockTEMageCraft;
import com.pl10123.magecraft.block.fluid.BlockManaFluid;
import com.pl10123.magecraft.tileentity.TEManaBank;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class ModBlocks
{



    public static Block blockManaFluid  = new BlockManaFluid(ModFluids.mana, Material.water);

    public static BlockTEMageCraft blockManaBank = new BlockManaBank();


  //  public static BlockMageCraft manaGenerator = new BlockManaGenerator();

    public static void init()
    {
        //GameRegistry.registerBlock(manaGenerator, "manaGenerator");
        GameRegistry.registerBlock(blockManaFluid, "manaFluid");
        GameRegistry.registerBlock(blockManaBank, "manaBank");


        GameRegistry.registerTileEntity(TEManaBank.class, "manaBankTileEntity");
    }



}
