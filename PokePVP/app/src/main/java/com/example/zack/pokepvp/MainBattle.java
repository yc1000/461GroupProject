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
        user = new Player();
        userPokemon = user.getPokemonTeam().get(0);
        enemy = new Player();
        enemyPokemon = enemy.getPokemonTeam().get(0);


        SwitchButton.setVisibility(View.INVISIBLE);
        SurrenderButton.setVisibility(View.INVISIBLE);
        FightButton.setVisibility(View.INVISIBLE);
        UserHealth.setMax(100);
        UserHealth.setProgress(userPokemon.getHealth());
        UserImage.setImageResource(userPokemon.backPicture);
        UserName.setText(userPokemon.getName());
        EnemyHealth.setMax(100);
        EnemyHealth.setProgress(enemyPokemon.getHealth());
        EnemyImage.setImageResource(enemyPokemon.frontPicture);
        EnemyName.setText(enemyPokemon.getName());

        EnemyImage.setImageResource(R.mipmap.charizard);

       try {
            Thread.sleep(5000);
        }
        catch(Exception e){
            System.out.println("fuck");
        }


        readyUp();

    }

    public void switchPokemon(View view){
        clearBottom();
        cancelAttack.setVisibility(View.VISIBLE);
        Pokemon1.setText(user.getPokemonTeam().get(0).getName());
        Pokemon2.setText(user.getPokemonTeam().get(1).getName());
        Pokemon3.setText(user.getPokemonTeam().get(2).getName());
        if(user.getPokemonTeam().get(0).getHealth() > 0){Pokemon1.setVisibility(View.VISIBLE);}
        if(user.getPokemonTeam().get(1).getHealth() > 0){Pokemon2.setVisibility(View.VISIBLE);}
        if(user.getPokemonTeam().get(2).getHealth() > 0){Pokemon3.setVisibility(View.VISIBLE);}


        return;
    }

    public void switchPokemonUp(){
        clearBottom();
        cancelAttack.setVisibility(View.VISIBLE);
        Pokemon1.setText(user.getPokemonTeam().get(0).getName());
        Pokemon2.setText(user.getPokemonTeam().get(1).getName());
        Pokemon3.setText(user.getPokemonTeam().get(2).getName());
        if(user.getPokemonTeam().get(0).getHealth() > 0){Pokemon1.setVisibility(View.VISIBLE);}
        if(user.getPokemonTeam().get(1).getHealth() > 0){Pokemon2.setVisibility(View.VISIBLE);}
        if(user.getPokemonTeam().get(2).getHealth() > 0){Pokemon3.setVisibility(View.VISIBLE);}


        return;
    }

    public void clearBottom(){
        SwitchButton.setVisibility(View.INVISIBLE);
        SurrenderButton.setVisibility(View.INVISIBLE);
        FightButton.setVisibility(View.INVISIBLE);
        Pokemon1.setVisibility(View.INVISIBLE);
        Pokemon2.setVisibility(View.INVISIBLE);
        Pokemon3.setVisibility(View.INVISIBLE);
        SwitchButton.setVisibility(View.INVISIBLE);
        SurrenderButton.setVisibility(View.INVISIBLE);
        FightButton.setVisibility(View.INVISIBLE);
        MainText.setVisibility(View.INVISIBLE);
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
        clearBottom();
        SwitchButton.setVisibility(View.VISIBLE);
        SurrenderButton.setVisibility(View.VISIBLE);
        FightButton.setVisibility(View.VISIBLE);
    }

    public void readyUp(){
        clearBottom();
        SwitchButton.setVisibility(View.VISIBLE);
        SurrenderButton.setVisibility(View.VISIBLE);
        FightButton.setVisibility(View.VISIBLE);
    }

    //checkSync if connection still exist, if a player's connection is lost, he/she loses.
    public Boolean checkSync(){
        return Boolean.TRUE;
    }

    public void showAttacks(View view){
        clearBottom();
        Attack1.setText(userPokemon.attacks.get(0).getName());
        Attack2.setText(userPokemon.attacks.get(1).getName());
        Attack3.setText(userPokemon.attacks.get(2).getName());
        Attack1.setVisibility(View.VISIBLE);
        Attack2.setVisibility(View.VISIBLE);
        Attack3.setVisibility(View.VISIBLE);
        cancelAttack.setVisibility(View.VISIBLE);
    }

    public void pokemon1(View view){
        readyUp();
        userPokemon = user.getPokemonTeam().get(0);
        SetUser();
    }
    public void pokemon2(View view){
        readyUp();
        userPokemon = user.getPokemonTeam().get(1);
        SetUser();
    }
    public void pokemon3(View view){
        readyUp();
        userPokemon = user.getPokemonTeam().get(2);
        SetUser();
    }

    public void attack1(View view) {
        userMove(userPokemon.attacks.get(0));
        EnemyMove(enemyPokemon.attacks.get(0));
        clearBottom();
        readyUp();
    }
    public void attack2(View view) {
        userMove(userPokemon.attacks.get(1));
        EnemyMove(enemyPokemon.attacks.get(1));
        clearBottom();
        readyUp();
    }
    public void attack3(View view) {
        userMove(userPokemon.attacks.get(2));
        EnemyMove(enemyPokemon.attacks.get(2));
        clearBottom();
        readyUp();
    }

    public void SetUser(){
        UserHealth.setProgress(userPokemon.getHealth());
        UserName.setText(userPokemon.getName());
        UserImage.setImageResource(userPokemon.backPicture);
    }

    public void SetEnemy(){
        EnemyHealth.setProgress(userPokemon.getHealth());
        EnemyName.setText(userPokemon.getName());
        EnemyImage.setImageResource(userPokemon.backPicture);
    }

    public int CalculateAttack(Attack atk){
        return 30;
    }

    public void EnemyMove(Attack atk){
        int Power = CalculateAttack(atk);
        clearBottom();
        MainText.setText("Enemy used " + atk.getName() + "!");
        MainText.setVisibility(View.INVISIBLE);
        if(userPokemon.getHealth() <= Power){
            userPokemon.setHealth(0);
        }else{
            UserHealth.setProgress(userPokemon.getHealth() - Power);
        }
        SetUser();
        try {
            Thread.sleep(2000);
        }
        catch(Exception e){
            System.out.println("fuck");
        }
        if(userPokemon.getHealth() <= 0){
            MainText.setText("He dead... ");
            try {
                Thread.sleep(2000);
            }
            catch(Exception e){
                System.out.println("fuck");
            }
            clearBottom();
            switchPokemonUp();

        }

    }

    public void userMove(Attack atk){
        clearBottom();
        MainText.setText("You used " + atk.getName() + "!");
        int power = CalculateAttack(atk);
        MainText.setVisibility(View.INVISIBLE);
        if(enemyPokemon.getHealth() <= power){
            userPokemon.setHealth(0);
        }else{
            UserHealth.setProgress(userPokemon.getHealth() - power);
        }
        SetEnemy();
        try {
            Thread.sleep(2000);
        }
        catch(Exception e){
            System.out.println("fuck");
        }
        if(enemyPokemon.getHealth() == 0){
            MainText.setText(enemyPokemon.getName() + " fainted!");
            try {
                Thread.sleep(2000);
            }
            catch(Exception e){
                System.out.println("fuck");
            }
            enemyPokemon = enemy.getPokemonTeam().get(1);
            SetEnemy();
        }
    }
}
