package com.example.zack.pokepvp;

import android.content.Context;
import android.content.pm.ActivityInfo;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.view.View;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;


import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Random;

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
    Random rn;
    Handler mHandler;
    TextView PopUp,PopUp2,PopUp3;
    Boolean CloseWindow;


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
        rn = new Random();
        PopUp = (TextView) findViewById(R.id.PopUp);
        PopUp2 = (TextView) findViewById(R.id.PopUp2);
        PopUp3 = (TextView) findViewById(R.id.PopUp3);
        CloseWindow = true;


        user = new Player();
        userPokemon = user.getPokemonTeam().get(0);
        enemy = new Player();
        enemyPokemon = enemy.getPokemonTeam().get(0);


        SwitchButton.setVisibility(View.INVISIBLE);
        SurrenderButton.setVisibility(View.INVISIBLE);
        FightButton.setVisibility(View.INVISIBLE);
        UserHealth.setMax(userPokemon.getStats().getMaxHP());
        UserHealth.setProgress(userPokemon.getHealth());
        UserImage.setImageResource(userPokemon.backPicture);
        UserName.setText(userPokemon.getName());
        EnemyHealth.setMax(enemyPokemon.getStats().getMaxHP());
        EnemyHealth.setProgress(enemyPokemon.getHealth());
        EnemyImage.setImageResource(enemyPokemon.frontPicture);
        EnemyName.setText(enemyPokemon.getName());



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
        if(user.getPokemonTeam().get(0) == userPokemon){Pokemon1.setVisibility(View.INVISIBLE);}
        if(user.getPokemonTeam().get(1) == userPokemon){Pokemon2.setVisibility(View.INVISIBLE);}
        if(user.getPokemonTeam().get(2) == userPokemon){Pokemon3.setVisibility(View.INVISIBLE);}


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
        Attack1.setVisibility(View.INVISIBLE);
        Attack2.setVisibility(View.INVISIBLE);
        Attack3.setVisibility(View.INVISIBLE);
        cancelAttack.setVisibility(View.INVISIBLE);
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
        if(userPokemon.attacks.get(0).getCurrentPP() > 0)Attack1.setVisibility(View.VISIBLE);
        if(userPokemon.attacks.get(1).getCurrentPP() > 0)Attack2.setVisibility(View.VISIBLE);
        if(userPokemon.attacks.get(2).getCurrentPP() > 0)Attack3.setVisibility(View.VISIBLE);
        cancelAttack.setVisibility(View.VISIBLE);
    }

    public void pokemon1(View view){
        readyUp();
        int health = userPokemon.getHealth();
        userPokemon = user.getPokemonTeam().get(0);
        if(health == 0){readyUp(); SetUser(); ScalePic(false); return;}
        SetUser();
        ScalePic(false);
        launchText3("You chose " + userPokemon.getName() + "!");

    }
    public void pokemon2(View view){
        readyUp();
        int health = userPokemon.getHealth();
        userPokemon = user.getPokemonTeam().get(1);
        if(health == 0){readyUp(); SetUser();ScalePic(false); return;}
        SetUser();
        ScalePic(false);
        launchText3("You chose " + userPokemon.getName() + "!");
    }
    public void pokemon3(View view){
        readyUp();
        int health = userPokemon.getHealth();
        userPokemon = user.getPokemonTeam().get(2);
        if(health == 0){readyUp(); SetUser(); ScalePic(false); return;}
        SetUser();
        ScalePic(false);
        launchText3("You chose " + userPokemon.getName() + "!");
    }

    public void attack1(View view) {
        userMove(userPokemon.attacks.get(0));
        if(enemy.isDead()){
            clearBottom();
            MainText.setText("Nice work, You Won");
            MainText.setVisibility(View.VISIBLE);
            return;
        }
        launchText("You used " + userPokemon.attacks.get(0).getName() + "!");
        userPokemon.attacks.get(0).reducePP();
    }
    public void attack2(View view) {
        userMove(userPokemon.attacks.get(1));
        if(enemy.isDead()){
            clearBottom();
            MainText.setText("Nice work, You Won");
            MainText.setVisibility(View.VISIBLE);
            return;
        }
        launchText("You used " + userPokemon.attacks.get(1).getName() + "!");
        userPokemon.attacks.get(1).reducePP();
    }
    public void attack3(View view) {
        userMove(userPokemon.attacks.get(2));
        if(enemy.isDead()){
            clearBottom();
            MainText.setText("Nice work, You Won");
            MainText.setVisibility(View.VISIBLE);
            return;
        }
        launchText("You used " + userPokemon.attacks.get(2).getName() + "!");
        userPokemon.attacks.get(2).reducePP();
    }

    public void SetUser(){
        UserHealth.setMax(userPokemon.getStats().getMaxHP());
        UserHealth.setProgress(userPokemon.getHealth());
        UserName.setText(userPokemon.getName());
        UserImage.setImageResource(userPokemon.backPicture);
    }

    public void SetEnemy(){
        EnemyHealth.setMax(enemyPokemon.getStats().getMaxHP());
        EnemyHealth.setProgress(enemyPokemon.getHealth());
        EnemyName.setText(enemyPokemon.getName());
        EnemyImage.setImageResource(enemyPokemon.frontPicture);
    }

    public int CalculateAttack(Attack atk, Boolean isUser){
        Pokemon mon;
        Pokemon other;
        if(isUser){mon = userPokemon;other = enemyPokemon;}else{mon = enemyPokemon; other = userPokemon;}
        double attack = mon.getStats().getAtk();
        double defense = other.getStats().getDef();
        double damage = .84;
        damage *= (attack/defense);
        damage *= atk.getValue();
        return (int)damage + 2;
    }

    public void EnemyMove(Attack atk){
        int Power = CalculateAttack(atk,false);
        clearBottom();
        MainText.setText("Enemy used " + atk.getName() + "!");

        MainText.setVisibility(View.VISIBLE);
        RotatePic(false);
        SlidePic(true);
        launchText2("Enemy used " + atk.getName() + "!");
        if(userPokemon.getHealth() <= Power){
            userPokemon.setHealth(0);
        }else{
            userPokemon.setHealth(userPokemon.getHealth() - Power);
        }
        SetUser();
        if(userPokemon.getHealth() == 0){
            PopUp2.setText("Enemy used " + atk.getName() + " and you died!");
        }
        if(user.isDead()){
            MainText.setText("You Lose");
            MainText.setVisibility(View.VISIBLE);
            PopUp3.setVisibility(View.INVISIBLE);
            PopUp2.setVisibility(View.INVISIBLE);
            PopUp.setVisibility(View.INVISIBLE);
        }

    }

    public void userMove(Attack atk){
        clearBottom();
        MainText.setText("You used " + atk.getName() + "!");


        int power = CalculateAttack(atk,true);
        MainText.setVisibility(View.VISIBLE);
        RotatePic(true);
        SlidePic(false);
        if(enemyPokemon.getHealth() <= power){
            enemyPokemon.setHealth(0);
        }else{
            enemyPokemon.setHealth(enemyPokemon.getHealth() - power);
        }
        SetEnemy();
       if(enemyPokemon.getHealth() == 0){
            MainText.setText(enemyPokemon.getName() + " fainted!");

            int next = enemy.getPokemonTeam().indexOf(enemyPokemon)+1;
            if(next==3){return;}
            enemyPokemon = enemy.getPokemonTeam().get(next);
            SetEnemy();
        }
        if(enemy.isDead()){
            MainText.setText("You Win");
            MainText.setVisibility(View.VISIBLE);
            PopUp3.setVisibility(View.INVISIBLE);
            PopUp2.setVisibility(View.INVISIBLE);
            PopUp.setVisibility(View.INVISIBLE);
        }
    }

    public void launchText(String text){
        PopUp.setText(text);
        PopUp.setVisibility(View.VISIBLE);

    }

    public void launchText2(String text){
        PopUp2.setText(text);
        PopUp2.setVisibility(View.VISIBLE);

    }

    public void launchText3(String text){
        PopUp3.setText(text);
        PopUp3.setVisibility(View.VISIBLE);
        clearBottom();

    }

    public void launchText4(String text){
        PopUp3.setText(text);
        PopUp3.setVisibility(View.VISIBLE);
        clearBottom();

    }

    public void hideText(View view){
        PopUp.setVisibility(View.INVISIBLE);
        EnemyMove(enemyPokemon.attacks.get(rn.nextInt(3)));
        if(user.isDead()){
            clearBottom();
            MainText.setText("Its Over...you lose");
            MainText.setVisibility(View.VISIBLE);
        }
    }

    public void hideText2(View view) {
        PopUp2.setVisibility(View.INVISIBLE);

        if(userPokemon.getHealth() <= 0){
            MainText.setText("He dead... ");
            switchPokemonUp();

        }else{
            readyUp();
        }
    }

    public void hideText3(View view){
        PopUp3.setVisibility(View.INVISIBLE);

        EnemyMove(enemyPokemon.attacks.get(rn.nextInt(3)));
        if(user.isDead()){
            clearBottom();
            MainText.setText("Its Over...you lose");
            MainText.setVisibility(View.VISIBLE);
        }
    }

    public void ResetIt(View view){
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


        SetEnemy();
        SetUser();
        readyUp();
    }

    public void RotatePic(Boolean isEnemy){
        RotateAnimation anim = new RotateAnimation(0.0f, 360.0f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        anim.setInterpolator(new LinearInterpolator());
        anim.setRepeatCount(Animation.ABSOLUTE);
        anim.setDuration(400);
        if(isEnemy){EnemyImage.startAnimation(anim);}else{UserImage.startAnimation(anim);}
    }

    public void ScalePic(Boolean isEnemy){
        ScaleAnimation anim = new ScaleAnimation(0,1,0,1);
        anim.setDuration(400);
        if(isEnemy){EnemyImage.startAnimation(anim);}else{UserImage.startAnimation(anim);}
    }

    public void SlidePic(Boolean isEnemy){
        Animation animation;
        if(isEnemy){
            animation = new TranslateAnimation(0, -75, 0, 50);
        }else{
            animation = new TranslateAnimation(0, 75, 0, -50);
        }
        animation.setDuration(100);
        animation.setFillAfter(false);
        if(isEnemy){
            EnemyImage.startAnimation(animation);
        }else{
            UserImage.startAnimation(animation);
        }
    }

    public void GiveUp(View view){
        MainText.setText("What a cop out");
        clearBottom();
        MainText.setVisibility(View.VISIBLE);
        PopUp3.setVisibility(View.INVISIBLE);
        PopUp2.setVisibility(View.INVISIBLE);
        PopUp.setVisibility(View.INVISIBLE);
    }

}
