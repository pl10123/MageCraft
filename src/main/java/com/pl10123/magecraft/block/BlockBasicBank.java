package com.pl10123.magecraft.block;


import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import java.util.List;

public class BlockBasicBank extends BlockTEMageCraft {

    public BlockBasicBank(){
        super(Material.glass);
        this.setBlockName("manaBank");
    }

    @Override
    public void getSubBlocks(Item item, CreativeTabs tabs, List list) {
        for(int meta = 0; meta < 5; meta ++){
            list.add(new ItemStack(item, 1, meta));
        }
    }

    @Override
    public TileEntity createNewTileEntity(World world, int meta) {
        return null;
    }
}
