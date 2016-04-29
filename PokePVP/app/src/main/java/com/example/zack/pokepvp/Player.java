package com.example.zack.pokepvp;

import java.util.ArrayList;

public class Player {
    private String name;
    private Integer wins;
    private Integer losses;
    private ArrayList<Pokemon> pokemonTeam;
    private Pokemon inUse;


    Player(String n){
        name = n;
        wins = 0;
        losses = 0;
        pokemonTeam = null;
    }

    public void setInUse(Pokemon pm){
        inUse = pm;
    }

    public Pokemon getInUse(){
        return inUse;
    }

    public ArrayList<Pokemon> getPokemonTeam(){
        return pokemonTeam;
    }
}
