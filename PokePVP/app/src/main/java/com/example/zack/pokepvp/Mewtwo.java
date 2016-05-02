package com.example.zack.pokepvp;

import java.util.ArrayList;

/**
 * Created by Zack on 4/29/2016.
 */
public class Mewtwo extends Pokemon {
    Mewtwo(){
        frontPicture = R.mipmap.mewtwofront;
        backPicture = R.mipmap.mewtwoback;
        stats.setAtk(400);
        stats.setDef(180);
        health = 400;
        stats.setMaxHP(400);
        attacks = new ArrayList<Attack>();
        attacks.add(new Attack("Psychic",90, 10));
        attacks.add(new Attack("Aura Sphere",80, 20));
        attacks.add(new Attack("Psycho Cut",70, 20));
        name = "Mewtwo";

    }
}
