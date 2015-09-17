package com.pl10123.magecraft.mana;


import com.pl10123.magecraft.init.ModFluids;
import com.pl10123.magecraft.tileentity.TileEntityMageCraft;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.FluidTankInfo;
import net.minecraftforge.fluids.IFluidTank;

public class ManaTank extends TileEntityMageCraft implements IFluidTank {

    public int currentAmount = 0;
    public int maxAmount;

    @Override
    public FluidStack getFluid() {
        if(currentAmount > 0) return new FluidStack(ModFluids.mana, currentAmount);
        return null;
    }

    @Override
    public int getFluidAmount() {
        return currentAmount;
    }

    @Override
    public int getCapacity() {
        return maxAmount;
    }

    @Override
    public FluidTankInfo getInfo() {
        return new FluidTankInfo(new FluidStack(ModFluids.mana, currentAmount), currentAmount);
    }

    @Override
    public int fill(FluidStack resource, boolean doFill) {
         if(resource.getFluid().equals(ModFluids.mana)){
            int newAmount = currentAmount + resource.amount;
            int maxAcceptable = maxAmount - currentAmount;
            if(newAmount > maxAcceptable){
                if(doFill)currentAmount = maxAmount;
                return maxAcceptable;
            }
            if(newAmount == maxAcceptable){
                if(doFill)currentAmount = maxAmount;
                return resource.amount;
            }
            if(newAmount < maxAcceptable){
                if(doFill)currentAmount = newAmount;
                return resource.amount;
            }
         }
        return 0;
    }

    @Override
    public FluidStack drain(int maxDrain, boolean doDrain) {
            int newAmount = maxDrain - currentAmount;
            if(newAmount == 0){
                if(doDrain)currentAmount = newAmount;
                return new FluidStack(ModFluids.mana, newAmount);
            }
            if(newAmount > 0){
                if(doDrain)currentAmount = newAmount;
                return new FluidStack(ModFluids.mana, newAmount);
            }
            if(newAmount < 0){
                int shouldBeDrained = currentAmount;
                if(doDrain)currentAmount = 0;
                return new FluidStack(ModFluids.mana, shouldBeDrained);
            }
        return null;
    }


}
