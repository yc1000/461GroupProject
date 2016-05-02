package com.example.zack.pokepvp;

import java.util.ArrayList;

/**
 * Created by Zack on 4/29/2016.
 */
public class Absol extends Pokemon {
    Absol(){
        frontPicture = R.mipmap.absolfront;
        backPicture = R.mipmap.absolback;
        stats.setAtk(350);
        stats.setDef(260);
        health = 280;
        stats.setMaxHP(280);
        attacks = new ArrayList<Attack>();
        attacks.add(new Attack());
        attacks.add(new Attack("Night Slash",70, 15));
        attacks.add(new Attack("Psycho Cut",70, 20));
        name = "Absol";

    }
}
