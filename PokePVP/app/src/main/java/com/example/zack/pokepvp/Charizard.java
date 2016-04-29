package com.example.zack.pokepvp;

import java.util.ArrayList;

/**
 * Created by Zack on 4/29/2016.
 */
public class Charizard extends Pokemon {
    Charizard(){
        frontPicture = R.mipmap.charizard;
        backPicture = R.mipmap.charizardback;
        stats.setAtk(7);
        stats.setDef(3);
        health = 0;
        attacks = new ArrayList<Attack>();
        attacks.add(new Attack());
        attacks.add(new Attack("Fly",30));
        attacks.add(new Attack("Ember",50));
        name = "Charizard";

    }
}
