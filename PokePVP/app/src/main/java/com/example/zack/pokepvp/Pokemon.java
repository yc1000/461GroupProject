package com.example.zack.pokepvp;

import java.util.ArrayList;

public class Pokemon {
    protected String name;



    protected Statistics stats;
    protected int health;
    protected int backPicture;
    protected int frontPicture;
    protected ArrayList<Attack> attacks;

    public Pokemon() {
        this.stats = new Statistics();
        health = 100;
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
}

