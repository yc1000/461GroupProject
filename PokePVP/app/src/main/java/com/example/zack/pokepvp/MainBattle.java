package com.example.zack.pokepvp;

import android.content.Context;
import android.content.pm.ActivityInfo;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
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

        SwitchButton.setVisibility(View.INVISIBLE);
        SurrenderButton.setVisibility(View.INVISIBLE);
        FightButton.setVisibility(View.INVISIBLE);

        UserHealth.setMax(100);
        UserHealth.setProgress(100);

        EnemyHealth.setMax(100);
        EnemyHealth.setProgress(100);

        UserImage.setImageResource(R.mipmap.blastoise);
        EnemyImage.setImageResource(R.mipmap.charizard);
        try {
            wait(30000);
        }
        catch(Exception e){
            System.out.println("fuck");
        }

        //while(true){}

    }

    public void switchPokemon(View view){
        int x = 1;
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
        MainText.setVisibility(View.INVISIBLE);
        ReadyButton.setVisibility(View.INVISIBLE);
        SwitchButton.setVisibility(View.VISIBLE);
        SurrenderButton.setVisibility(View.VISIBLE);
        FightButton.setVisibility(View.VISIBLE);
    }

    //checkSync if connection still exist, if a player's connection is lost, he/she loses.
    public Boolean checkSync(){
        return Boolean.TRUE;
    }


}
