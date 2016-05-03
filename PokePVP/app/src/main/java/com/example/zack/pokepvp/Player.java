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
        //pokemonTeam.add(new Blastoise());
        pokemonTeam.add(new Hitmonchan());
        pokemonTeam.add(new Charizard());
        pokemonTeam.add(new Venusaur());
    }
    Player(int first, int second, int third) {
        pokemonTeam = new ArrayList<Pokemon>();
        pokemonTeam.add(getPokemon(first));
        pokemonTeam.add(getPokemon(second));
        pokemonTeam.add(getPokemon(third));
    }

    public String getPokemonNums() {
        String result = "";
        for(int i = 0; i < pokemonTeam.size(); i++) {
            result += pokemonTeam.get(i).getNumberString();
        }
        return "030102";
    }

    public Pokemon getPokemon(int index) {
        switch (index) {
            case 0:
                return new Blastoise();
            case 1:
                return new Charizard();
            case 2:
                return new Venusaur();
            case 3:
                return new Hitmonchan();
            case 4:
                return new Absol();
            case 5:
                return new Jirachi();
            case 6:
                return new Mewtwo();
            case 7:
                return new Ninetales();
            default:
                return new Sceptile();
        }
    }

    boolean isDead(){
        int count =0;
        for (int i = 0; i < 3; i++){
            if(pokemonTeam.get(i).getHealth() <= 0){
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
