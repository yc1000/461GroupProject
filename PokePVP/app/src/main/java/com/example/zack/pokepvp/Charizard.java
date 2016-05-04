package com.example.zack.pokepvp;

import java.util.ArrayList;

/**
 * Created by Zack on 4/29/2016.
 */
public class Charizard extends Pokemon {
    Charizard(){
        frontPicture = R.mipmap.charizard;
        backPicture = R.mipmap.charizardback;
        stats.setAtk(173);
        stats.setDef(161);
        health = 266;
        stats.setMaxHP(266);
        attacks = new ArrayList<Attack>();
        attacks.add(new Attack());
        attacks.add(new Attack("Fly",90, 15));
        attacks.add(new Attack("Flamethrower",90, 15));
        number = 1;
        stats.setSpeed(235);
        name = "Charizard";

    }
}
