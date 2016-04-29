package com.example.zack.pokepvp;

import java.util.ArrayList;

/**
 * Created by Zack on 4/29/2016.
 */
public class Venusaur extends Pokemon {
    Venusaur(){
        frontPicture = R.mipmap.venusaurfront;
        backPicture = R.mipmap.venusaurback;
        stats.setAtk(3);
        stats.setDef(7);
        health = 100;
        attacks = new ArrayList<Attack>();
        attacks.add(new Attack());
        attacks.add(new Attack("cut",30));
        attacks.add(new Attack("Solar Beam",50));
        name = "Venusaur";

    }
}
