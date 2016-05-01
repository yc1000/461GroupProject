package com.example.zack.pokepvp;

import java.util.ArrayList;

/**
 * Created by dalesong on 5/1/16.
 */
public class Hitmonchan extends Pokemon{
    Hitmonchan(){
        frontPicture = R.mipmap.hitmonchanfront;
        backPicture = R.mipmap.hitmonchanback;
        stats.setAtk(215);
        stats.setDef(163);
        health = 210;
        stats.setMaxHP(210);
        attacks = new ArrayList<Attack>();
        //attacks.add(new Attack());
        attacks.add(new Attack("Close Combat", 120, 15));
        attacks.add(new Attack("Focus Punch", 150, 10));
        attacks.add(new Attack("Mega Punch", 80, 20));
        name = "Hitmonchan";
    }
}
