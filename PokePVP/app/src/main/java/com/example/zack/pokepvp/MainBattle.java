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


        UserHealth.setMax(100);
        UserHealth.setProgress(50);


        EnemyHealth.setMax(100);
        EnemyHealth.setProgress(25);
        UserImage.setImageResource(R.mipmap.blastoise);
        EnemyImage.setImageResource(R.mipmap.charizard);
        try {
            wait(3000);
        }
        catch(Exception e){

        }
        UserName.setVisibility(View.INVISIBLE);

    }

    public void thisFunction(View view){
        int x = 1;
        return;
    }




}
