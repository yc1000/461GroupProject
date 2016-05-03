package com.example.zack.pokepvp;

import android.test.ActivityInstrumentationTestCase2;

//import org.junit.Before;
//import org.junit.Test;

//import static org.junit.Assert.*;

/**
 * Created by dalesong on 4/29/16.
 */
public class MainBattleTest extends ActivityInstrumentationTestCase2<MainBattle> {
    public MainBattleTest() {
        super(MainBattle.class);
    }

    public void setUp(){}


    public void testActivityExists() {
        MainBattle activity = getActivity();
        assertNotNull(activity);
    }

}