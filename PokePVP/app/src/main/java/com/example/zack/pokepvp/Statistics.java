package com.example.zack.pokepvp;

import android.widget.ProgressBar;

public class Statistics {
    private ProgressBar HP;
    //need to add SPEED, SP. DEFENSE, SP. ATTACK, DEFENSE, ATTACK
    private int speed;
    private int atk;
    private int def;
    private int spdef;

    public Statistics() {

    }

    private int spatk;
    private int[] atklevel;
    private int[] deflevel;

    public Statistics(int maxHP, int speed, int atk, int def, int spatk, int spdef){
        HP.setMax(maxHP);
        HP.setProgress(maxHP);
        this.speed = speed;
        this.atk = atk;
        this.def = def;
        this.spatk = spatk;
        this.spdef = spdef;
        atklevel = new int[2];
        deflevel = new int[2];
        intiailizeLevel(atklevel);
        intiailizeLevel(deflevel);
    }

    private void intiailizeLevel(int[] array){
        array[0] = 2;
        array[1] = 2;
    }


    public void setHP(int damage){
        HP.setProgress(HP.getProgress() - damage);
    }

    public ProgressBar getHP(){
        return HP;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void setAtk(int atk) {
        this.atk = atk;
    }

    public void setDef(int def) {
        this.def = def;
    }

    public void setSpdef(int spdef) {
        this.spdef = spdef;
    }

    public void setSpatk(int spatk) {
        this.spatk = spatk;
    }

    public void setAtklevel(int[] atklevel) {
        this.atklevel = atklevel;
    }

    public void setDeflevel(int[] deflevel) {
        this.deflevel = deflevel;
    }



    public int getDef() {
        return def;
    }

    public int getAtk() {
        return atk;
    }

    public int getSpdef() {
        return spdef;
    }

    public int getSpatk() {
        return spatk;
    }

    public int[] getAtklevel() {
        return atklevel;
    }

    public int[] getDeflevel() {
        return deflevel;
    }

    public int getSpeed() {
        return speed;
    }


}
