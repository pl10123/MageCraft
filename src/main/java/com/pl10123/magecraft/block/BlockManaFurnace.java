package com.pl10123.magecraft.block;


import com.pl10123.magecraft.tileentity.TEManaFurnace;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockManaFurnace extends BlockTEMageCraft {

    public BlockManaFurnace()
    {
        super();
        this.setBlockName("manaFurnace");
    }

    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float placeX, float placeY, float placeZ) {
        return true;
    }

    @Override
    public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_) {
        return new TEManaFurnace();
    }
}
