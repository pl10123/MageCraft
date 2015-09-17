package com.pl10123.magecraft.block;


import com.pl10123.magecraft.init.ModFluids;
import com.pl10123.magecraft.init.ModItems;
import com.pl10123.magecraft.tileentity.TEManaBank;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraftforge.fluids.FluidStack;

public class BlockManaBank extends BlockTEMageCraft {

    public BlockManaBank(){
        super(Material.glass);
        this.setBlockName("manaBank");
        this.setHarvestLevel("pickaxe", 1);
        this.setHardness(0.7F);

       // this.setBlockBounds();
    }

    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float f, float f2, float f3) {
        if(player.getCurrentEquippedItem().isItemEqual(new ItemStack(Items.bucket))){
            TileEntity te = world.getTileEntity(x, y, z);
            if (te instanceof TEManaBank){
                TEManaBank manaBank = (TEManaBank) te;
                FluidStack test = manaBank.drain(1000, false);
                if(test.amount < 1000){
                    return false;
                }else if(test.amount == 1000){
                    manaBank.drain(1000, true);
                    player.destroyCurrentEquippedItem();
                    player.setCurrentItemOrArmor(0, new ItemStack(ModItems.manaBucket));
                    world.markBlockForUpdate(x, y, z);
                    return true;
                }
            }

            return true;
        }
        if(player.getCurrentEquippedItem().isItemEqual(new ItemStack(ModItems.manaBucket))){
            TileEntity te = world.getTileEntity(x, y, z);
            if(te instanceof TEManaBank){
                TEManaBank manaBank = (TEManaBank) te;
                int test = manaBank.fill(new FluidStack(ModFluids.mana, 1000), false);
                if(test != 1000){
                    return false;
                } else{
                    manaBank.fill(new FluidStack(ModFluids.mana, 1000), true);
                    player.destroyCurrentEquippedItem();
                    player.setCurrentItemOrArmor(0, new ItemStack(Items.bucket));
                    world.markBlockForUpdate(x, y, z);
                    return true;
                }
            }
        }

        return false;
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
