package com.pl10123.magecraft.proxy;


import com.pl10123.magecraft.client.renderer.item.ItemRendererManaBank;
import com.pl10123.magecraft.client.renderer.tileentity.TileEntityRendererManaBank;
import com.pl10123.magecraft.init.ModBlocks;
import com.pl10123.magecraft.tileentity.TEManaBank;
import com.pl10123.magecraft.utility.LogHelper;
import cpw.mods.fml.client.registry.ClientRegistry;
import net.minecraft.item.Item;
import net.minecraftforge.client.MinecraftForgeClient;

public class ClientProxy extends CommonProxy {
    @Override
    public void doSomething() {

    }

    @Override
    public void registerRenderStuff() {
        LogHelper.info("Registering renderers");
        ClientRegistry.bindTileEntitySpecialRenderer(TEManaBank.class, new TileEntityRendererManaBank());
        MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ModBlocks.blockManaBank), new ItemRendererManaBank());
    }
}
