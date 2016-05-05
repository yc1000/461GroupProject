package com.example.zack.pokepvp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
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
import android.widget.Toast;


import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Time;
import java.util.Random;
import java.util.concurrent.atomic.AtomicBoolean;

public class MainBattle extends AppCompatActivity {
    public static BluetoothChatFragment fragment;
    public static AtomicBoolean messageReceived;
    boolean firstTime;
    int currentAttack;
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
    TextView PopUp,PopUp2,PopUp3,PopUp4,PopUp5;
    Boolean CloseWindow;
    int enemyFirst = -2;
    int enemySecond = -2;
    int enemyThird = -2;
    int newPokemon = -2;
    int newAttack = -2;
    int userMove = 0;
    int yourRandom;
    int theirRandom;
    int doMoveCount = 0;
    int recall = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        messageReceived = new AtomicBoolean(false);
        messageReceived.getAndSet(false);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_battle);
       // ConnectivityManager connMgr = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
       // NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();


        fragment = new BluetoothChatFragment();
        fragment.copy(MainActivity.fragment, 1);
        if (savedInstanceState == null) {
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.game_content_fragment, fragment);
            transaction.commit();
        }

        firstTime = true;
        Intent intent = getIntent();
        String OtherPokemon = intent.getStringExtra(MainActivity.GAME_START);
        String gameType = intent.getStringExtra(MainActivity.GAME_TYPE);

        //Initialize Globals
        currentAttack = -1;
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
        PopUp4 = (TextView) findViewById(R.id.PopUp4);
        PopUp5 = (TextView) findViewById(R.id.PopUp5);
        CloseWindow = true;
        EnemyName.setText("Waiting");

        int pokemonPassedByMain[] = intent.getIntArrayExtra(MainActivity.GAME_POKEMON);

        user = new Player();
        for(int i : pokemonPassedByMain) {
            user.addPokemon(i);
        }

        yourRandom = (int)(Math.random()*50000);
        userPokemon = user.getPokemonTeam().get(0);
        fragment.sendPokeMessage(user.getPokemonNums() + ":set" +  gameType.substring(0, 6) + yourRandom);

        //enemy = new Player();


        SwitchButton.setVisibility(View.INVISIBLE);
        SurrenderButton.setVisibility(View.INVISIBLE);
        FightButton.setVisibility(View.INVISIBLE);
        UserHealth.setMax(userPokemon.getStats().getMaxHP());
        UserHealth.setProgress(userPokemon.getHealth());
        UserImage.setImageResource(userPokemon.backPicture);
        UserName.setText(userPokemon.getName());


        if(OtherPokemon.contains(":set")) {
            firstTime = false;
            //TODO:: Edit this code to be expandable (to be able to change the number of pokemon more easily)
            enemyFirst = (int) Integer.parseInt(OtherPokemon.substring(0,2));
            enemySecond = (int) Integer.parseInt(OtherPokemon.substring(2,4));
            enemyThird = (int) Integer.parseInt(OtherPokemon.substring(4,6));
            theirRandom = (int) Integer.parseInt(OtherPokemon.substring(16));
            enemy = new Player(enemyFirst, enemySecond, enemyThird);
            enemyPokemon = enemy.getPokemonTeam().get(0);
            EnemyHealth.setMax(enemyPokemon.getStats().getMaxHP());
            EnemyHealth.setProgress(enemyPokemon.getHealth());
            EnemyImage.setImageResource(enemyPokemon.frontPicture);
            EnemyName.setText(enemyPokemon.getName());
            readyUp();
        } else {
            launchText4("Waiting for opponent");
        }

    }

    @Override
    public void onPause() {
        super.onPause();
        MainActivity.fragment.copy(fragment, 0);
    }

    @Override
    public void onStop() {
        MainActivity.fragment.copy(fragment, 0);
        super.onStop();
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
        PopUp.setVisibility(View.INVISIBLE);
        PopUp2.setVisibility(View.INVISIBLE);
        PopUp3.setVisibility(View.INVISIBLE);
        PopUp4.setVisibility(View.INVISIBLE);
        PopUp5.setVisibility(View.INVISIBLE);
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
        fragment.sendPokeMessage("0" + "0" + ":action");
        if(userPokemon.getHealth() <= 0) {//Health = zero means you came here after your opponent attacked
            userSwitch(0);
            readyUp();
        } else {// you voluntarily chose to switch pokemon
            userMove = -1;
            launchText("Waiting On Opponent...");
        }
    }
    public void pokemon2(View view){
        fragment.sendPokeMessage("0" + "1" + ":action");
        if(userPokemon.getHealth() <= 0) { //Health = zero means you came here after your opponent attacked
            userSwitch(1);
            readyUp();
        } else { // you voluntarily chose to switch pokemon
            userMove = -2;
            launchText("Waiting On Opponent...");
        }
    }
    public void pokemon3(View view){
        fragment.sendPokeMessage("0" + "2" + ":action");
        if(userPokemon.getHealth() <= 0) {//Health = zero means you came here after your opponent attacked
            userSwitch(2);
            readyUp();
        } else {// you voluntarily chose to switch pokemon
            userMove = -3;
            launchText("Waiting On Opponent...");
        }
    }

    public void attack1(View view) {
        userMove = 0;
        fragment.sendPokeMessage("1" + userMove + ":action");
        launchText("Waiting on Opponent...");
    }
    public void attack2(View view) {
        userMove = 1;
        fragment.sendPokeMessage("1" + userMove + ":action");
        launchText("Waiting on Opponent...");
    }
    public void attack3(View view) {
        userMove = 2;
        fragment.sendPokeMessage("1" + userMove + ":action");
        launchText("Waiting on Opponent...");
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

    public void EnemyAttack(Attack atk){
        int Power = CalculateAttack(atk,false);
        SlidePic(true);
        RotatePic(false);
        if(userPokemon.getHealth() <= Power){
            userPokemon.setHealth(0);
        }else{
            userPokemon.setHealth(userPokemon.getHealth() - Power);
        }
        SetUser();
        if(user.isDead()){
            MainText.setText("You Lose");
            MainText.setVisibility(View.VISIBLE);
            PopUp3.setVisibility(View.INVISIBLE);
            PopUp2.setVisibility(View.INVISIBLE);
            PopUp.setVisibility(View.INVISIBLE);
            recall = 1;
        } else if(userPokemon.getHealth() <= 0){
            if(doMoveCount == 1) {
                doMoveCount = 2;
            }
            launchText2("You fainted!");
            recall = 1;
        }

    }

    public void EnemySwitch(int newPmn) {
        enemyPokemon = enemy.getPokemonTeam().get(newPmn);
        SetEnemy();
        ScalePic(true);
        launchText5("Your Opponent sent out " + enemyPokemon.getName() + "!");
    }

    public void userMove(Attack atk) {
        clearBottom();
        atk.reducePP();

        int power = CalculateAttack(atk,true);
        SlidePic(false);
        RotatePic(true);
        if(enemyPokemon.getHealth() <= power){
            enemyPokemon.setHealth(0);
        }else{
            enemyPokemon.setHealth(enemyPokemon.getHealth() - power);
        }
        SetEnemy();
        if(enemy.isDead()){
            MainText.setText("You Win");
            MainText.setVisibility(View.VISIBLE);
            PopUp3.setVisibility(View.INVISIBLE);
            PopUp2.setVisibility(View.INVISIBLE);
            PopUp.setVisibility(View.INVISIBLE);
            recall = 1;
        } else if(enemyPokemon.getHealth() <= 0){
            launchText3("");
            recall = 1;
        }
    }

    public void userSwitch(int newPmn) {
        userPokemon = user.getPokemonTeam().get(newPmn);
        SetUser();
        ScalePic(false);
        launchText5("You sent out " + userPokemon.getName() + "!");
    }

    public void doMove(int theirSwitch, int theirAttack, int myMove) {
        doMoveCount = 1;
        //Case you switch pokemon
        if(myMove < 0) {
            userSwitch((myMove * -1) - 1);
            return;
        } else { //Case where you attacked
            if(theirAttack >= 0) { //Case they attacked
                if(enemyPokemon.getSpeed() > userPokemon.getSpeed()) { //they are faster
                    EnemyAttack(enemyPokemon.attacks.get(theirAttack));
                    launchText5("They used " + enemyPokemon.attacks.get(theirAttack).getName());
                } else if(enemyPokemon.getSpeed() < userPokemon.getSpeed()) { //you are faster
                    userMove(userPokemon.attacks.get(myMove));
                    launchText5("You used " + userPokemon.attacks.get(myMove).getName());
                } else { //draw do coin toss
                    if(yourRandom < theirRandom) {
                        EnemyAttack(enemyPokemon.attacks.get(theirAttack));
                        launchText5("They used " + enemyPokemon.attacks.get(theirAttack).getName());
                    } else {
                        userMove(userPokemon.attacks.get(myMove));
                        launchText5("You used " + userPokemon.attacks.get(myMove).getName());
                    }
                }
            } else { //Case they switched
                EnemySwitch(theirSwitch);
            }
        }
    }

    public void doMove2(int theirSwitch, int theirAttack, int myMove) {
        //Implements the second half of the attacks
        doMoveCount = 2;
        //your or your opponent's pokemon fainted from the first attack
        if(myMove == 10) {
            switchPokemonUp();
            return;
        }
        //Case you switch pokemon (in doMove)
        if(myMove < 0) {
            if(theirSwitch > -1) {
                EnemySwitch(theirSwitch);
            } else {
                EnemyAttack(enemyPokemon.attacks.get(theirAttack));
                launchText5("They used " + enemyPokemon.attacks.get(theirAttack).getName());
            }
        } else { //Case where you attacked (in doMove)
            if(theirAttack >= 0) { //Case they attacked (in doMove)
                if(enemyPokemon.getSpeed() > userPokemon.getSpeed()) { //they are faster
                    userMove(userPokemon.attacks.get(myMove));
                    launchText5("You used " + userPokemon.attacks.get(myMove).getName());
                } else if(enemyPokemon.getSpeed() < userPokemon.getSpeed()) { //you are faster
                    EnemyAttack(enemyPokemon.attacks.get(theirAttack));
                    launchText5("They used " + enemyPokemon.attacks.get(theirAttack).getName());
                } else { //draw do coin toss
                    if(yourRandom < theirRandom) {
                        userMove(userPokemon.attacks.get(myMove));
                        launchText5("You used " + userPokemon.attacks.get(myMove).getName());
                    } else {
                        EnemyAttack(enemyPokemon.attacks.get(theirAttack));
                        launchText5("They used " + enemyPokemon.attacks.get(theirAttack).getName());
                    }
                }
            } else { //Case they switched
                userMove(userPokemon.attacks.get(myMove));
                launchText5("You used " + userPokemon.attacks.get(myMove).getName());
            }
        }
    }

    public void launchText(String text) {
        clearBottom();
        if(messageReceived.get()) {
            messageReceived.set(false);
            doMove(newPokemon, newAttack, userMove);
        } else {
            PopUp.setText(text);// + " dbg1");
            PopUp.setVisibility(View.VISIBLE);
        }

    }
    public void launchText2(String text) {
        clearBottom();
        PopUp2.setText("You Fainted!");// + " dbg2");
        PopUp2.setVisibility(View.VISIBLE);

    }
    public void launchText3(String text){
        clearBottom();
        if(messageReceived.get() && enemyPokemon.getHealth() <= 0) {
            messageReceived.set(false);
            PopUp3.setVisibility(View.INVISIBLE);
            doMoveCount = 2;
            EnemySwitch(newPokemon);
            readyUp(); // Always ready up because they won't move after switching and if they already moved they can't go again
        } else {
            PopUp3.setText(text + "Your Opponent Fainted! Waiting on Opponent to switch pokemon...");// + " dbg3");
            PopUp3.setVisibility(View.VISIBLE);
        }

    }
    public void launchText4(String text){
        clearBottom();
        if(messageReceived.get()) {
            messageReceived.set(false);
            enemy = new Player(enemyFirst, enemySecond, enemyThird);
            enemyPokemon = enemy.getPokemonTeam().get(0);
            SetEnemy();

            PopUp4.setVisibility(View.INVISIBLE);
            readyUp();
        } else {
            PopUp4.setText("Waiting on Opponent to start...");// + " dbg4");
            PopUp4.setVisibility(View.VISIBLE);
        }

    }
    public void launchText5(String text){
        if(recall == 1) {
            recall = 0;
            return;
        }
        clearBottom();
        PopUp5.setText(text);// + " dbg5");
        PopUp5.setVisibility(View.VISIBLE);
    }

    public void hideText(View view) { //shows right after you select a move
        PopUp.setVisibility(View.INVISIBLE);
        if(messageReceived.get()) {
            messageReceived.set(false);
            doMove(newPokemon, newAttack, userMove);
        } else {
            launchText("Waiting on Opponent...");
        }
    }

    public void hideText2(View view) { //Shows when you faint after they attack
        PopUp2.setVisibility(View.INVISIBLE);

        if(user.isDead()){
            MainText.setText("Its Over...you lose");
            MainText.setVisibility(View.VISIBLE);
        }else{
            switchPokemonUp();
        }
    }

    public void hideText3(View view){ //Shows when opponent pokemon faints after you attack
        PopUp3.setText("Waiting on Opponent...");
        if(messageReceived.get()) {
            messageReceived.set(false);
            PopUp3.setVisibility(View.INVISIBLE);
            doMoveCount = 2;
            EnemySwitch(newPokemon);
            readyUp(); // Always ready up because they won't move after switching and if they already moved they can't go again
        }
    }

    public void hideText4(View view){ // Shows at the start of the game
        if(messageReceived.get()) {
            messageReceived.set(false);
            enemy = new Player(enemyFirst, enemySecond, enemyThird);
            enemyPokemon = enemy.getPokemonTeam().get(0);
            SetEnemy();

            PopUp4.setVisibility(View.INVISIBLE);
            readyUp();
        }
    }

    public void hideText5(View view) { // Shows in between moves
        PopUp5.setVisibility(View.INVISIBLE);
        if(doMoveCount == 1 && userMove != 10) {
            doMove2(newPokemon, newAttack, userMove);
        } else if(userMove == 10) {
            doMoveCount = 2;
            switchPokemonUp();
        } else {
            readyUp();
        }
    }

    public void ResetIt(View view){
        finish();
        /*user = new Player();
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
        readyUp();*/
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

    public void parse(String data) {
        if(data.contains(":set")) {
            enemyFirst = (int) Integer.parseInt(data.substring(0,2));
            enemySecond = (int) Integer.parseInt(data.substring(2,4));
            enemyThird = (int) Integer.parseInt(data.substring(4,6));
            theirRandom = (int) Integer.parseInt(data.substring(16));
            PopUp4.setText("Opponent Ready");
            messageReceived.set(true);
        } else if(data.contains(":action")) {
            int action = (int) Integer.parseInt(data.substring(0,1));
            if(action == 0) {
                newPokemon = Integer.parseInt(data.substring(1,2));
                newAttack = -1;
            } else {
                newPokemon = -1;
                newAttack = Integer.parseInt(data.substring(1,2));
            }
            PopUp3.setText("Opponent Ready");
            PopUp.setText("Opponent Ready");
            messageReceived.set(true);
        } else if(data.contains("SURR3ND3R")) {
            messageReceived.set(true);
        }
    }
}
