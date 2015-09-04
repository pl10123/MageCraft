package com.pl10123.magecraft.init;

import com.pl10123.magecraft.block.BlockMageCraft;
import com.pl10123.magecraft.block.BlockManaGenerator;
import cpw.mods.fml.common.registry.GameRegistry;

public class ModBlocks
{

    public static BlockMageCraft manaGenerator = new BlockManaGenerator();

    public static void init()
    {
        GameRegistry.registerBlock(manaGenerator, "manaGenerator");
    }
}
