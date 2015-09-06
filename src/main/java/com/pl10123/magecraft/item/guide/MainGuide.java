package com.pl10123.magecraft.item.guide;


import amerifrance.guideapi.api.GuideRegistry;
import amerifrance.guideapi.api.abstraction.CategoryAbstract;
import amerifrance.guideapi.api.abstraction.EntryAbstract;
import amerifrance.guideapi.api.abstraction.IPage;
import amerifrance.guideapi.api.base.Book;
import amerifrance.guideapi.api.util.BookBuilder;
import amerifrance.guideapi.api.util.PageHelper;
import amerifrance.guideapi.categories.CategoryItemStack;
import amerifrance.guideapi.entries.EntryUniText;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.StatCollector;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class MainGuide
{

    //Use StatCollector.translateToLocal
    public static Book mainGuide;
    private static List<EntryAbstract> entriesIntro;

    public static void initMainGuide()
    {
        BookBuilder bookBuilder = new BookBuilder();
        initIntro();




        ArrayList<CategoryAbstract> categories = new ArrayList<CategoryAbstract>();
        categories.add(new CategoryItemStack(entriesIntro, StatCollector.translateToLocal("magecraft.guide.cat.intro"), new ItemStack(Items.stick)));
        //End category one

        bookBuilder.setCategories(categories);
        bookBuilder.setUnlocWelcomeMessage(StatCollector.translateToLocal("magecraft.guide.welcome"));
        bookBuilder.setBookColor(Color.CYAN);
        bookBuilder.setSpawnWithBook(false);
        bookBuilder.setUnlocBookTitle(StatCollector.translateToLocal("magecraft.guide.title"));
        mainGuide = bookBuilder.build();
        
        GuideRegistry.registerBook(mainGuide);
    }

    private static void initIntro() {
        entriesIntro = new ArrayList<EntryAbstract>();

        //entry one pages
        ArrayList<IPage> pagesEntryIntro = new ArrayList();
        pagesEntryIntro.addAll(PageHelper.pagesForLongText(StatCollector.translateToLocal("magecraft.guide.intro.entry1.page1")));
        entriesIntro.add(new EntryUniText(pagesEntryIntro, "magecraft.guide.intro.entry1.name"));

        //Start entry two
        //Entry two pages
        ArrayList<IPage> pagesEntry2Intro = new ArrayList<IPage>();
        pagesEntry2Intro.addAll(PageHelper.pagesForLongText(StatCollector.translateToLocal("magecraft.guide.intro.entry2.page1")));
        pagesEntry2Intro.addAll(PageHelper.pagesForLongText(StatCollector.translateToLocal("magecraft.guide.intro.entry2.page2")));
        entriesIntro.add(new EntryUniText(pagesEntry2Intro,"magecraft.guide.intro.entry2.name"));

        //Start entry threee
        ArrayList<IPage> pagesEntry3Intro = new ArrayList();
        pagesEntry3Intro.addAll(PageHelper.pagesForLongText(StatCollector.translateToLocal("magecraft.guide.intro.entry3.page1")));
        //pagesEntry3Intro.add(new PageIRecipe()); //TODO finish this guide
    }
}
