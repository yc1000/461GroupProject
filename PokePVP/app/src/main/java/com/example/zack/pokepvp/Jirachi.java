package com.example.zack.pokepvp;

import java.util.ArrayList;

/**
 * Created by Zack on 4/29/2016.
 */
public class Jirachi extends Pokemon {
    Jirachi(){
        frontPicture = R.mipmap.jirachifront;
        backPicture = R.mipmap.jirachiback;
        stats.setAtk(260);
        stats.setDef(260);
        health = 350;
        stats.setMaxHP(350);
        attacks = new ArrayList<Attack>();
        attacks.add(new Attack("Zen Headbutt",80, 15));
        attacks.add(new Attack("Flash Cannon",80, 20));
        attacks.add(new Attack("Thunderbolt",95, 10));
        number = 5;
        stats.setSpeed(236);
        name = "Jirachi";

    }
}
