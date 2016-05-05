package com.example.zack.pokepvp;

import java.util.ArrayList;

/**
 * Created by yc100 on 5/5/2016.
 */
public class Leafeon extends Pokemon{

    public Leafeon() {
        frontPicture = R.mipmap.leafeonfront;
        backPicture = R.mipmap.leafeonback;
        stats.setAtk(319);
        stats.setDef(359);
        health = 334;
        stats.setMaxHP(334);
        attacks = new ArrayList<Attack>();
        attacks.add(new Attack("Magic Leaf", 60, 20));
        attacks.add(new Attack("Leaf Blade", 90, 15));
        attacks.add(new Attack("Last Resort", 140, 5));
        number = 12;
        stats.setSpeed(289);
        name = "Leafeon";
    }
}
