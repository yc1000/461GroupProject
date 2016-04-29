package com.example.zack.pokepvp;

import android.widget.ProgressBar;

public class Statistics {
    private ProgressBar HP;
    //need to add SPEED, SP. DEFENSE, SP. ATTACK, DEFENSE, ATTACK

    Statistics(Integer maxHP){
        HP.setMax(maxHP);
        HP.setProgress(maxHP);
    }
}
