package com.example.zack.pokepvp;

import java.util.ArrayList;

/**
 * Created by Zack on 4/29/2016.
 */
public class Blastoise extends Pokemon {
    Blastoise(){
        frontPicture = R.mipmap.blastoisefront;
        backPicture = R.mipmap.blastoise;
        stats.setAtk(171);
        stats.setDef(205);
        health = 268;
        stats.setMaxHP(268);
        attacks = new ArrayList<Attack>();
        attacks.add(new Attack());
        attacks.add(new Attack("bite",30));
        attacks.add(new Attack("surf",50));
        name = "Blastoise";

    }
}
