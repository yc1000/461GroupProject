package com.example.zack.pokepvp;

import java.util.ArrayList;

public class Pokemon {
    private final int max_places = 10;
    protected String name;

    protected int number;

    protected Statistics stats;
    protected int health;
    protected int backPicture;
    protected int frontPicture;
    protected ArrayList<Attack> attacks;

    public Pokemon() {
        this.stats = new Statistics();
        health = 100;
    }

    public int getNumber() {
        return number;
    }

    public int getSpeed() {
        return stats.getSpeed();
    }

    public String getNumberString() {
        String result = "";
        int p = getNumber();
        if(p < 10) {
            result += "0";
        }
        result += (new Integer(p)).toString();
        return result;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Statistics getStats() {
        return stats;
    }

    public int getHealth() {
        return health;
    }

    public int getBackPicture() {
        return backPicture;
    }

    public int getFrontPicture() {
        return frontPicture;
    }

    //this method is for testing purposes only.
    public void setStats(int maxHP, int speed, int atk, int def, int spatk, int spdef){
        this.stats.setAtk(atk);
        this.stats.setDef(def);
        this.stats.setSpeed(speed);
        this.health = maxHP;
        this.stats.setSpatk(spatk);
        this.stats.setSpdef(spdef);
    }

}

