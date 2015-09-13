package com.pl10123.magecraft.block;


import com.pl10123.magecraft.tileentity.TEManaBank;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockManaBank extends BlockTEMageCraft {

    public BlockManaBank(){
        super(Material.glass);
        this.setBlockName("manaBank");
        this.setHarvestLevel("pickaxe", 1);
        this.setHardness(0.7F);

       // this.setBlockBounds();
    }



    @Override
    public boolean isOpaqueCube() {
        return false;
    }

    @Override
    public int getRenderType() {
        return -1;
    }

    @Override
    public boolean renderAsNormalBlock() {
        return false;
    }

    @Override
    public TileEntity createNewTileEntity(World world, int meta) {
        return new TEManaBank();
    }
}
