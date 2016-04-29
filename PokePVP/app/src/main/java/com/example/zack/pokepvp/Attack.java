package com.example.zack.pokepvp;

/**
 * Created by Zack on 4/29/2016.
 */
public class Attack {
    private String name;
    private int value;

    public String getName() {
        return name;
    }

    public int getValue() {
        return value;
    }

    Attack(){

        name = "tackle";
        value = 10;
    }
    Attack(String nam, int val){
        name = nam;
        value = val;
    }
}
