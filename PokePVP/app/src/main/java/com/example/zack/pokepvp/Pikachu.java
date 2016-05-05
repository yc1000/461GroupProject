package com.example.zack.pokepvp;

import java.util.ArrayList;

/**
 * Created by yc100 on 5/5/2016.
 */
public class Pikachu extends Pokemon{

    public Pikachu() {
        frontPicture = R.mipmap.pikachufront;
        backPicture = R.mipmap.pikachuback;
        stats.setAtk(209);
        stats.setDef(179);
        health = 274;
        stats.setMaxHP(274);
        attacks = new ArrayList<Attack>();
        attacks.add(new Attack("Thunder Shock", 40, 30));
        attacks.add(new Attack("Spark", 65, 20));
        attacks.add(new Attack("Thunder", 110, 10));
        number = 11;
        stats.setSpeed(279);
        name = "Pikachu";
    }
}
