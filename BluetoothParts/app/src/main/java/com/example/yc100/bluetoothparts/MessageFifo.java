package com.example.yc100.bluetoothparts;

import java.util.ArrayList;
import java.util.concurrent.Semaphore;

/**
 * Created by yc100 on 4/30/2016.
 */
public class MessageFifo extends ArrayList<String> {
    public synchronized void clear() {
        try {
            super.removeRange(0, super.size() - 1);
            super.remove(0);
        } catch (Exception e) {

        }
    }

    public synchronized boolean add(String s) {
        notify();
        return super.add(s);
    }

    public synchronized String read() {
        if(super.size() != 0) {
            return null;
        }
        return super.remove(0);
    }

}
