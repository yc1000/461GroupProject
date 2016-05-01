package com.example.zack.pokepvp;

import java.util.ArrayList;

/**
 * Created by dalesong on 5/1/16.
 */
public class Hitmonchan extends Pokemon{
    Hitmonchan(){
        frontPicture = R.mipmap.venusaurfront;
        backPicture = R.mipmap.venusaurback;
        stats.setAtk(215);
        stats.setDef(163);
        health = 210;
        stats.setMaxHP(270);
        attacks = new ArrayList<Attack>();
        //attacks.add(new Attack());
        attacks.add(new Attack("Close Combat",50, 5));
        attacks.add(new Attack("Focus Punch",40, 10));
        name = "Venusaur";

    }
}
