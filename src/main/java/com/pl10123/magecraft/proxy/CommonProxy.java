package com.pl10123.magecraft.proxy;


public abstract class CommonProxy implements IProxy {

    public abstract void doSomething();

    @Override
    public abstract void registerRenderStuff();
}
