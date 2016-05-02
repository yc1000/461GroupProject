package com.example.yc100.bluetoothparts;

import android.content.Intent;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class GameStarterActivity extends AppCompatActivity {
    public static BluetoothChatFragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_starter);

        fragment = new BluetoothChatFragment();
        fragment.copy(MainActivity.fragment, 1);
        if (savedInstanceState == null) {
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.game_content_fragment, fragment);
            transaction.commit();
        }
        /*Intent intent = getIntent();
        String msg = intent.getStringExtra(MainActivity.GAME_START);

        TextView tv = new TextView(this);
        tv.setTextSize(40);
        tv.setText(msg);
        RelativeLayout layout = (RelativeLayout) findViewById(R.id.Game);
        layout.addView(tv);*/
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

    public void testSendMessageInOtherActivity(View v) {
        fragment.sendMessage("TestingFromAnotherActivity");
    }

    public void parse(String data) {
        Button b = (Button) findViewById(R.id.button4);
        b.setText(data);
    }


}
