package com.example.zack.pokepvp;

import java.util.ArrayList;

public class Player {
    private String name;
    private Integer wins;
    private Integer losses;
    private ArrayList<Pokemon> pokemonTeam;


    Player(String n){
        name = n;
        wins = 0;
        losses = 0;
        pokemonTeam = null;
    }
}
