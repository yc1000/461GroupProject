package com.example.zack.pokepvp;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by dalesong on 4/29/16.
 */
public class PlayerTest {
    Player testPlayer;
    Charizard charizard;
    Blastoise blastoise;
    Venusaur venusaur;


    @Before
    public void setup(){
        testPlayer = new Player("test");
        charizard = new Charizard();
        blastoise = new Blastoise();
        venusaur = new Venusaur();
        testPlayer.addPokemon(charizard);
        testPlayer.addPokemon(blastoise);
        testPlayer.addPokemon(venusaur);

    }

    //This test tests both setInUse and getInUse
    @Test
    public void testSetGetInUse() throws Exception {
        testPlayer.setInUse(testPlayer.getPokemonTeam().get(0));
        assertEquals(charizard, testPlayer.getInUse());

        testPlayer.setInUse(testPlayer.getPokemonTeam().get(1));
        assertEquals(blastoise, testPlayer.getInUse());

        testPlayer.setInUse(testPlayer.getPokemonTeam().get(2));
        assertEquals(venusaur, testPlayer.getInUse());
    }


    @Test
    public void testGetPokemonTeam() throws Exception {
        ArrayList<Pokemon> testPkmTeam = new ArrayList<Pokemon>(3);
        testPkmTeam.add(charizard);
        testPkmTeam.add(blastoise);
        testPkmTeam.add(venusaur);
        testPlayer.getPokemonTeam().equals(testPkmTeam);
    }
}