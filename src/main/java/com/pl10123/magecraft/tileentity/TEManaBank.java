package com.pl10123.magecraft.tileentity;


import com.pl10123.magecraft.mana.ManaTank;


public class TEManaBank extends ManaTank{


    public TEManaBank(){
      //  this.tier = 0;
       this.currentAmount = 0;
        this.maxAmount =  8000; //TODO put these in another file
    }
}

