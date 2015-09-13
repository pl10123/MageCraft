package com.pl10123.magecraft.client.renderer.item;


import com.pl10123.magecraft.client.renderer.model.ModelManaBank;
import com.pl10123.magecraft.reference.Reference;
import cpw.mods.fml.client.FMLClientHandler;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;
import org.lwjgl.opengl.GL11;

public class ItemRendererManaBank implements IItemRenderer{

    private final ModelManaBank modelManaBank = new ModelManaBank();

    @Override
    public boolean handleRenderType(ItemStack item, ItemRenderType type) {
        return true;
    }

    @Override
    public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item, ItemRendererHelper helper) {
        return true;
    }

    @Override
    public void renderItem(ItemRenderType type, ItemStack item, Object... data) {
        switch (type)
        {
            case ENTITY:
            {
                renderManaBank(-0.5F, -0.38F, 0.5F);
                return;
            }
            case EQUIPPED:
            {
                renderManaBank(0.0F, 0.0F, 1.0F);
                return;
            }
            case EQUIPPED_FIRST_PERSON:
            {
                renderManaBank(0.0F, 0.0F, 1.0F);
                return;
            }
            case INVENTORY:
            {
                renderManaBank(-1.0F, -0.9F, 0.0F);
                return;
            }
            default:
        }
    }

    private void renderManaBank(float x, float y, float z){
        GL11.glPushMatrix();

        float translateX =  x + 1.0F;
        float translateY =  y - 0.1F;
        float translateZ =  z ;

        GL11.glScalef(1F, 1F, 1F);
        GL11.glTranslatef(translateX, translateY, translateZ);
        FMLClientHandler.instance().getClient().getTextureManager().bindTexture(new ResourceLocation(Reference.MOD_ID + ":" + "models/ManaBankTexture.png"));

        modelManaBank.render(null, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);

        GL11.glPopMatrix();

    }
}
