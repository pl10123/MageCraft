package com.pl10123.magecraft.block.fluid;


import com.pl10123.magecraft.creativetab.MageCraftTab;
import net.minecraft.block.material.Material;
import net.minecraftforge.fluids.Fluid;

public class BlockManaFluid extends BlockFluidMageCraft{


    public BlockManaFluid(Fluid fluid, Material material) {
        super(fluid, material);
        this.setBlockName("mana");
        this.setHardness(1.0F);
        this.setCreativeTab(MageCraftTab.MageCraftTab);
    }


}
