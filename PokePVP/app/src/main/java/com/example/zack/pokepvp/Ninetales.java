package com.example.zack.pokepvp;

import java.util.ArrayList;

/**
 * Created by Zack on 4/29/2016.
 */
public class Ninetales extends Pokemon {
    Ninetales(){
        frontPicture = R.mipmap.ninetalesfront;
        backPicture = R.mipmap.ninetalesback;
        stats.setAtk(175);
        stats.setDef(200);
        health = 300;
        stats.setMaxHP(300);
        attacks = new ArrayList<Attack>();
        attacks.add(new Attack());
        attacks.add(new Attack("Heat Wave",95, 10));
        attacks.add(new Attack("Extrasensory",80, 20));
        number = 7;
        stats.setSpeed(235);
        name = "Ninetales";

    }
}
