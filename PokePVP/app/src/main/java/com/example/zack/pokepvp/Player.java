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
        inUse = null;
        pokemonTeam = new ArrayList<Pokemon>(3);
    }
    Player(){
        pokemonTeam = new ArrayList<Pokemon>();
        pokemonTeam.add(new Blastoise());
        pokemonTeam.add(new Charizard());
        pokemonTeam.add(new Venusaur());
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

    public void addPokemon(Pokemon pm){
        pokemonTeam.add(pm);
    }
}
