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
import android.widget.CheckBox;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    static BluetoothChatFragment fragment;
    static AppBarLayout app;
    public final static String GAME_START = "com.example.yc100.bluetoothparts.GAMESTART";
    public final static String GAME_TYPE = "com.example.yc100.bluetoothparts.GAMETYPE";
    public final static String GAME_POKEMON = "com.example.yc100.bluetoothparts.GAMEPOKEMON";
    private String OtherPokemon = "NOTSELECTED";
    ArrayList<CheckBox> listOfCheckedPokemon = new ArrayList<CheckBox>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        listOfCheckedPokemon = new ArrayList<CheckBox>();
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
        if(OtherPokemon.contains("R@ndom")) {
            Toast.makeText(this, "Your Opponent has already chosen to start a random game", Toast.LENGTH_SHORT).show();
            return;
        }
        int chosenPokemonNumbers[] = findCheckedPokemon();
        if(chosenPokemonNumbers[2] == -1) {
            Toast.makeText(this, "Please select three Pokemon!", Toast.LENGTH_SHORT).show();
            return;
        }


        Intent intent = new Intent(this, MainBattle.class);
        intent.putExtra(GAME_START, OtherPokemon);
        intent.putExtra(GAME_TYPE, "Ch0sen");
        intent.putExtra(GAME_POKEMON, chosenPokemonNumbers);
        startActivity(intent);
    }

    public int[] findCheckedPokemon() {
        int result[] = {-1, -1, -1};
        if(listOfCheckedPokemon.size() == 3) {
            result[0] = Integer.parseInt(listOfCheckedPokemon.get(0).getText().toString());
            result[1] = Integer.parseInt(listOfCheckedPokemon.get(1).getText().toString());
            result[2] = Integer.parseInt(listOfCheckedPokemon.get(2).getText().toString());
        }
        return result;
    }

    public void clickPokemon(View v) {
        if(!listOfCheckedPokemon.contains(v)) {
            if(listOfCheckedPokemon.size() < 3) {
                listOfCheckedPokemon.add((CheckBox) v);
            } else {
                Toast.makeText(this, "You already selected 3 pokemon, please deselect one!", Toast.LENGTH_SHORT).show();
                ((CheckBox)v).setChecked(false);
            }
        } else {
            listOfCheckedPokemon.remove(v);
        }
    }

    public void startRandomGame(View v) {
        if(fragment.getBluetoothChatService().getState() != BluetoothChatService.STATE_CONNECTED) {
            Toast.makeText(this, "Please connect a device through Bluetooth", Toast.LENGTH_SHORT).show();
            return;
        }
        if(OtherPokemon.contains("Ch0sen")) {
            Toast.makeText(this, "Your Opponent has already chosen to start a non-random game", Toast.LENGTH_SHORT).show();
            return;
        }


        int firstPkm = (int)(Math.random() * Pokemon.numDiffPokemon);
        int secondPkm = (int)(Math.random() * Pokemon.numDiffPokemon);
        int thirdPkm = (int)(Math.random() * Pokemon.numDiffPokemon);

        Intent intent = new Intent(this, MainBattle.class);
        intent.putExtra(GAME_START, OtherPokemon);
        intent.putExtra(GAME_TYPE, "R@ndom");
        int rndmPkmList[] = {firstPkm, secondPkm, thirdPkm};
        intent.putExtra(GAME_POKEMON, rndmPkmList);
        startActivity(intent);
    }

    public void set(String data) {
        if(data.contains("EndG@ME")) {
            OtherPokemon = "NOTSELECTED";
        } else {
            OtherPokemon = data;
        }
    }
}
