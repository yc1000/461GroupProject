package com.example.zack.pokepvp;

import android.view.View;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Created by yc100 on 5/2/2016.
 */
public class WaitForMessage {
    public static boolean waitFor(AtomicBoolean messageReceived) {
        long then = System.currentTimeMillis();
        long pauser = then;
        while(!messageReceived.get()) {
            if(then + 10000 < System.currentTimeMillis()) {
                return false;
            }
        }
        messageReceived.getAndSet(false);
        return true;
    }
}
