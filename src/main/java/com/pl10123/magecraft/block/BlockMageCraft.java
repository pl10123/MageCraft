package com.pl10123.magecraft.block;

import com.pl10123.magecraft.creativetab.CreativeTabMageCraft;
import com.pl10123.magecraft.reference.Reference;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;


public class BlockMageCraft extends Block
{

    public BlockMageCraft(Material material)
    {
        super(material);
        this.setCreativeTab(CreativeTabMageCraft.MageCraftTab);
    }

    public BlockMageCraft()
    {
        this(Material.rock);

    }

    @Override
    public String getUnlocalizedName()
    {
        return String.format("tile.%s%s", Reference.MOD_ID + ":", getUnwrappedUnlocalizedName(super.getUnlocalizedName()));
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconRegister)
    {
        blockIcon = iconRegister.registerIcon(String.format("%s", getUnwrappedUnlocalizedName(this.getUnlocalizedName())));
    }

    protected String getUnwrappedUnlocalizedName(String unlocalizedName)
    {
        return unlocalizedName.substring(unlocalizedName.indexOf(".") + 1);
    }


}
