package com.example.zack.pokepvp;

public class Pokemon {
    private String name;
    //private Integer level; //not implemented at this point
    private Statistics stats;

    Pokemon(String n){

    }

    public int getHP(){
        return stats.getHP().getProgress();
    }
}
