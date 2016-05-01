package com.example.zack.pokepvp;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by dalesong on 4/29/16.
 */
public class AttackTest {
    Attack atk;
    Attack atk2;

    @Before
    public void setUp(){
        atk = new Attack();
        atk2 = new Attack("splash", 0, 100);
    }

    @Test
    public void testGetName() throws Exception {
        assertEquals("tackle", atk.getName());
        assertEquals("splash", atk2.getName());
    }

    @Test
    public void testGetValue() throws Exception {
        assertEquals(10, atk.getValue());
        assertEquals(0, atk2.getValue());
    }
}