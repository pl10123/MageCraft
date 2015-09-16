package com.pl10123.magecraft.tileentity;


import cofh.api.fluid.ITankContainerBucketable;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.util.ForgeDirection;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.FluidTankInfo;
import net.minecraftforge.fluids.IFluidTank;

public class TEManaBank extends TileEntityMageCraft implements ITankContainerBucketable, IFluidTank{

    private static int Storage = 0;
    //private static int tier;
    private int currentFluidAmount;
    private final int maxCapacity = 8000;

    public TEManaBank(){
      //  this.tier = 0;
        currentFluidAmount = 0;
    }

    @Override
    public int fill(ForgeDirection from, FluidStack resource, boolean doFill) {
        return 0;
    }

    @Override
    public FluidStack drain(ForgeDirection from, FluidStack resource, boolean doDrain) {
        return null;
    }

    @Override
    public FluidStack drain(ForgeDirection from, int maxDrain, boolean doDrain) {
        return null;
    }

    @Override
    public boolean canFill(ForgeDirection from, Fluid fluid) {
        if(from == ForgeDirection.UP){
            return true;
        }
        return false;
    }

    @Override
    public boolean canDrain(ForgeDirection from, Fluid fluid) {
        if(from == ForgeDirection.DOWN){
            return true;
        }
        return false;
    }

    @Override
    public FluidTankInfo[] getTankInfo(ForgeDirection from) {
        return new FluidTankInfo[0];
    }

    @Override
    public FluidStack getFluid() {
        return null;
    }

    @Override
    public int getFluidAmount() {
        return currentFluidAmount;
    }

    @Override
    public int getCapacity() {
        return maxCapacity;
    }

    @Override
    public FluidTankInfo getInfo() {
        return null;
    }

    @Override
    public int fill(FluidStack resource, boolean doFill) {
        return 0;
    }

    @Override
    public FluidStack drain(int maxDrain, boolean doDrain) {
        return null;
    }

    @Override
    public boolean allowBucketFill(ItemStack stack) {
        return false;
    }

    @Override
    public boolean allowBucketDrain(ItemStack stack) {
        return false;
    }
}
