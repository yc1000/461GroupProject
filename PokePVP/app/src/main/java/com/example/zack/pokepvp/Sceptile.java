package com.example.zack.pokepvp;

import java.util.ArrayList;

/**
 * Created by Zack on 4/29/2016.
 */
public class Sceptile extends Pokemon {
    Sceptile(){
        frontPicture = R.mipmap.sceptilefront;
        backPicture = R.mipmap.sceptileback;
        stats.setAtk(250);
        stats.setDef(200);
        health = 320;
        stats.setMaxHP(320);
        attacks = new ArrayList<Attack>();
        attacks.add(new Attack());
        attacks.add(new Attack("Leaf Blade",90, 15));
        attacks.add(new Attack("Leaf Storm",130, 5));
        number = 8;
        stats.setSpeed(275);
        name = "Sceptile";

    }
}
