package com.pl10123.magecraft.init;


import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;

public class ModFluids
{
    public static Fluid mana;
    public static void initFluids()
    {
        mana = new Fluid("mana").setLuminosity(8).setDensity(3000).setViscosity(4000);
        FluidRegistry.registerFluid(mana);

    }
}
