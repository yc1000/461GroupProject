package com.example.zack.pokepvp;

/**
 * Created by Zack on 4/29/2016.
 */
public class Attack {
    private String name;
    private int value;
    private int currentPP;
    private int totalPP;


    public String getName() {
        return name;
    }

    public int getValue() {
        return value;
    }

    Attack(){

        name = "tackle";
        value = 10;
        currentPP = 20;
        totalPP = 20;
    }
    Attack(String nam, int val, int pp){
        name = nam;
        value = val;
        totalPP = pp;
        currentPP = pp;
    }

    public int getCurrentPP() {
        return currentPP;
    }

    public int getTotalPP() {
        return totalPP;
    }
    public void reducePP(){
        currentPP--;
    }
}
