package com.example.zack.pokepvp;

import java.util.ArrayList;

/**
 * Created by yc100 on 5/5/2016.
 */
public class Rayquaza extends Pokemon{

    public Rayquaza() {
        frontPicture = R.mipmap.rayquazafront;
        backPicture = R.mipmap.rayquazaback;
        stats.setAtk(399);
        stats.setDef(279);
        health = 414;
        stats.setMaxHP(334);
        attacks = new ArrayList<Attack>();
        attacks.add(new Attack("Dragon Pulse", 85, 10));
        attacks.add(new Attack("Fly", 90, 15));
        attacks.add(new Attack("Outrage", 120, 10));
        number = 14;
        stats.setSpeed(289);
        name = "Rayquaza";
    }
}
