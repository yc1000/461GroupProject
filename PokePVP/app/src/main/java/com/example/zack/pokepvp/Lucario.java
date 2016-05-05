package com.example.zack.pokepvp;

import java.util.ArrayList;

/**
 * Created by yc100 on 5/5/2016.
 */
public class Lucario extends Pokemon{

    public Lucario() {
        frontPicture = R.mipmap.lucariofront;
        backPicture = R.mipmap.lucarioback;
        stats.setAtk(319);
        stats.setDef(239);
        health = 344;
        stats.setMaxHP(344);
        attacks = new ArrayList<Attack>();
        attacks.add(new Attack("Metal Claw", 50, 35));
        attacks.add(new Attack("Aura Sphere", 80, 20));
        attacks.add(new Attack("Close Combat", 120, 5));
        number = 13;
        stats.setSpeed(279);
        name = "Lucario";
    }
}
