package com.example.zack.pokepvp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    static BluetoothChatFragment fragment;
    static AppBarLayout app;
    public final static String GAME_START = "com.example.yc100.bluetoothparts.GAMESTART";
    private String OtherPokemon = "NOTSELECTED";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if (savedInstanceState == null) {
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            fragment = new BluetoothChatFragment();
            transaction.replace(R.id.sample_content_fragment, fragment);
            transaction.commit();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        OtherPokemon = "NOTSELECTED";
    }

    public void connectBlueTooth(View v) {
        fragment.connectSecure();
    }

    public void enableDiscovery(View v) {
        fragment.ensureDiscoverable();
    }

    public void startGame(View v) {
        if(fragment.getBluetoothChatService().getState() != BluetoothChatService.STATE_CONNECTED) {
            Toast.makeText(this, "Please connect a device through Bluetooth", Toast.LENGTH_SHORT).show();
            return;
        }
        Intent intent = new Intent(this, MainBattle.class);
        intent.putExtra(GAME_START, OtherPokemon);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    public void toggleActionBar() {
        if(findViewById(R.id.appbar).getVisibility() == View.GONE) {
            findViewById(R.id.appbar).setVisibility(View.VISIBLE);
        } else {
            findViewById(R.id.appbar).setVisibility(View.GONE);
        }
        app = (AppBarLayout) findViewById(R.id.appbar);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_setting) {
            toggleActionBar();
        }

        return super.onOptionsItemSelected(item);
    }

    public void set(String data) {
        OtherPokemon = data;
    }
}
