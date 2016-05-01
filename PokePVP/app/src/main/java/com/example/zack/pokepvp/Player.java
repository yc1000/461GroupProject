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
    Player(){
        pokemonTeam = new ArrayList<Pokemon>();
        pokemonTeam.add(new Blastoise());
        pokemonTeam.add(new Charizard());
        pokemonTeam.add(new Venusaur());
    }
    boolean isDead(){
        int count =0;
        for (int i = 0; i < 3; i++){
            if(pokemonTeam.get(i).getHealth() == 0){
                count +=1;
            }
        }
        if(count == 3){return true;}else{return false;}
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
