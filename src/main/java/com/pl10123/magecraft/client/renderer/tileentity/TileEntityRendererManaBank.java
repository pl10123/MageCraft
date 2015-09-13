package com.pl10123.magecraft.client.renderer.tileentity;


import com.pl10123.magecraft.client.renderer.model.ModelManaBank;
import com.pl10123.magecraft.reference.Reference;
import com.pl10123.magecraft.tileentity.TEManaBank;
import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public class TileEntityRendererManaBank extends TileEntitySpecialRenderer{

    ModelManaBank modelManaBank = new ModelManaBank();
    @Override
    public void renderTileEntityAt(TileEntity te, double x, double y, double z, float p_147500_8_) {
        if(te instanceof TEManaBank){
            TEManaBank teManaBank = (TEManaBank) te;

            GL11.glPushMatrix();
            GL11.glTranslatef(((float) x) + 0.5F  , ((float) y) - 0.5F, ((float) z) + 0.5F);
            ResourceLocation resourceLocation = new ResourceLocation(Reference.MOD_ID + ":" + "models/ManaBankTexture.png");
            FMLClientHandler.instance().getClient().getTextureManager().bindTexture(resourceLocation);

            GL11.glPushMatrix();
            this.modelManaBank.render(null, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
            GL11.glPopMatrix();
            //render tank thing.
            GL11.glPopMatrix();

        }
    }
}
