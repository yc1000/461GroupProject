package com.example.zack.pokepvp;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by dalesong on 4/29/16.
 */
public class PokemonTest {
    Pokemon testPkm;
    @Before
    public void setUp(){
        testPkm = new Pokemon();
    }
    @Test
    public void testSetHealth() throws Exception {
        testPkm.setHealth(69);
        assertEquals(69, testPkm.getHealth());
    }

    @Test
    public void testSetGetName() throws Exception {
        testPkm.setName("Dale");
        assertEquals("Dale", testPkm.getName());
    }

    //tests both get and set stats methods and getHealth method
    @Test
    public void testGetSetStats() throws Exception {
        testPkm.setStats(1, 2, 3, 4, 5, 6);
        assertEquals(1, testPkm.getHealth());   //tests getHealth method
        assertEquals(2, testPkm.getStats().getSpeed()); //tests getSpeed
        assertEquals(3, testPkm.getStats().getAtk()); //tests getAtk;
        assertEquals(4, testPkm.getStats().getDef());
        assertEquals(5, testPkm.getStats().getSpatk());
        assertEquals(6, testPkm.getStats().getSpdef());
    }

}