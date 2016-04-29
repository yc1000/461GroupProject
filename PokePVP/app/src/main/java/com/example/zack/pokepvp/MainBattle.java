package com.example.zack.pokepvp;

import android.content.Context;
import android.content.pm.ActivityInfo;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.view.View;


import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainBattle extends AppCompatActivity {
    ProgressBar UserHealth;
    ImageView UserImage;
    TextView UserName;
    ProgressBar EnemyHealth;
    ImageView EnemyImage;
    TextView EnemyName;
    TextView MainText;
    Button SwitchButton;
    Button FightButton;
    Button SurrenderButton;
    Button ReadyButton;
    Button Attack1,Attack2,Attack3,cancelAttack;
    Button Pokemon1,Pokemon2,Pokemon3;
    Pokemon userPokemon;
    Pokemon enemyPokemon;
    Player user;
    Player enemy;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_battle);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
       // ConnectivityManager connMgr = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
       // NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();

        //Initialize Globals
        MainText = (TextView) findViewById(R.id.MainText);
        UserName = (TextView) findViewById(R.id.UserName);
        UserHealth = (ProgressBar) findViewById(R.id.UserHealth);
        UserImage = (ImageView) findViewById(R.id.UserImage);
        EnemyName = (TextView) findViewById(R.id.EnemyName);
        EnemyHealth = (ProgressBar) findViewById(R.id.EnemyHealth);
        EnemyImage = (ImageView) findViewById(R.id.EnemyImage);
        SwitchButton = (Button) findViewById(R.id.SwitchButton);
        FightButton = (Button) findViewById(R.id.FightButton);
        SurrenderButton = (Button) findViewById(R.id.SurrenderButton);
        ReadyButton = (Button) findViewById(R.id.ReadyButton);
        Attack1 = (Button) findViewById(R.id.Attack1);
        Attack2 = (Button) findViewById(R.id.Attack2);
        Attack3 = (Button) findViewById(R.id.Attack3);
        Pokemon1 = (Button) findViewById(R.id.Pokemon1);
        Pokemon2 = (Button) findViewById(R.id.Pokemon2);
        Pokemon3 = (Button) findViewById(R.id.Pokemon3);
        cancelAttack = (Button) findViewById(R.id.CancelAttack);


        SwitchButton.setVisibility(View.INVISIBLE);
        SurrenderButton.setVisibility(View.INVISIBLE);
        FightButton.setVisibility(View.INVISIBLE);
        userPokemon = new Blastoise();
        UserHealth.setMax(100);
        UserHealth.setProgress(userPokemon.getHealth());

        EnemyHealth.setMax(100);
        EnemyHealth.setProgress(100);
        UserImage.setImageResource(userPokemon.backPicture);
        EnemyImage.setImageResource(R.mipmap.charizard);

        try {
            wait(30000);
        }
        catch(Exception e){
            System.out.println("fuck");
        }


        readyUp();

    }

    public void switchPokemon(View view){
        Attack1.setVisibility(View.INVISIBLE);
        Attack2.setVisibility(View.INVISIBLE);
        Attack3.setVisibility(View.INVISIBLE);
        SwitchButton.setVisibility(View.INVISIBLE);
        SurrenderButton.setVisibility(View.INVISIBLE);
        FightButton.setVisibility(View.INVISIBLE);
        cancelAttack.setVisibility(View.VISIBLE);
        Pokemon1.setVisibility(View.VISIBLE);
        Pokemon2.setVisibility(View.VISIBLE);
        Pokemon3.setVisibility(View.VISIBLE);


        return;
    }

    public void fight(View view){
        int x = 1;
        return;
    }

    public void surrender(View view){
        int x = 1;
        return;
    }

    //this will execute once a player hits ready
    public void ready(View view){
        Pokemon1.setVisibility(View.INVISIBLE);
        Pokemon2.setVisibility(View.INVISIBLE);
        Pokemon3.setVisibility(View.INVISIBLE);
        MainText.setVisibility(View.INVISIBLE);
        ReadyButton.setVisibility(View.INVISIBLE);
        Attack1.setVisibility(View.INVISIBLE);
        Attack2.setVisibility(View.INVISIBLE);
        Attack3.setVisibility(View.INVISIBLE);
        cancelAttack.setVisibility(View.INVISIBLE);
        SwitchButton.setVisibility(View.VISIBLE);
        SurrenderButton.setVisibility(View.VISIBLE);
        FightButton.setVisibility(View.VISIBLE);
    }

    public void readyUp(){
        MainText.setVisibility(View.INVISIBLE);
        ReadyButton.setVisibility(View.INVISIBLE);
        Attack1.setVisibility(View.INVISIBLE);
        Attack2.setVisibility(View.INVISIBLE);
        Attack3.setVisibility(View.INVISIBLE);
        cancelAttack.setVisibility(View.INVISIBLE);
        SwitchButton.setVisibility(View.VISIBLE);
        SurrenderButton.setVisibility(View.VISIBLE);
        FightButton.setVisibility(View.VISIBLE);
    }

    //checkSync if connection still exist, if a player's connection is lost, he/she loses.
    public Boolean checkSync(){
        return Boolean.TRUE;
    }

    public void showAttacks(View view){
        FightButton.setVisibility(View.INVISIBLE);
        SwitchButton.setVisibility(View.INVISIBLE);
        SurrenderButton.setVisibility(View.INVISIBLE);
        Attack1.setText(userPokemon.attacks.get(0).getName());
        Attack2.setText(userPokemon.attacks.get(1).getName());
        Attack3.setText(userPokemon.attacks.get(2).getName());
        Attack1.setVisibility(View.VISIBLE);
        Attack2.setVisibility(View.VISIBLE);
        Attack3.setVisibility(View.VISIBLE);
        cancelAttack.setVisibility(View.VISIBLE);
    }

}
