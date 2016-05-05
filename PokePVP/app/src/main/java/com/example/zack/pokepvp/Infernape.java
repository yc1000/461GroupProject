package com.example.zack.pokepvp;

import java.util.ArrayList;

/**
 * Created by yc100 on 5/5/2016.
 */
public class Infernape extends Pokemon{

    public Infernape() {
        frontPicture = R.mipmap.infernapefront;
        backPicture = R.mipmap.infernapeback;
        stats.setAtk(307);
        stats.setDef(241);
        health = 356;
        stats.setMaxHP(356);
        attacks = new ArrayList<Attack>();
        attacks.add(new Attack("Mach Punch", 40, 30));
        attacks.add(new Attack("Flame Wheel", 60, 25));
        attacks.add(new Attack("Flare Blitz", 120, 15));
        number = 9;
        stats.setSpeed(315);
        name = "Infernape";
    }
}
