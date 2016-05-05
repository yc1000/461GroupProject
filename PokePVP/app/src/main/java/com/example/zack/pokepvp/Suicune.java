package com.example.zack.pokepvp;

import java.util.ArrayList;

/**
 * Created by yc100 on 5/5/2016.
 */
public class Suicune extends Pokemon{

    public Suicune() {
        frontPicture = R.mipmap.suicunefront;
        backPicture = R.mipmap.suicuneback;
        stats.setAtk(249);
        stats.setDef(329);
        health = 404;
        stats.setMaxHP(404);
        attacks = new ArrayList<Attack>();
        attacks.add(new Attack("Bubble Beam", 65, 20));
        attacks.add(new Attack("Ice Fang", 65, 15));
        attacks.add(new Attack("Hydro Pump", 110, 5));
        number = 10;
        stats.setSpeed(269);
        name = "Suicune";
    }
}
