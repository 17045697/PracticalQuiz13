package com.example.a17045697.practicalquiz13;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {



    BroadcastReceiver br = new BroadcastReceive();
    RadioGroup RG1;
    RadioButton rbGood;
    RadioButton rbBad;


    @Override
    protected void onPause() {
        super.onPause();
        SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor preEdit = sharedPref.edit();
        int pos = RG1.getCheckedRadioButtonId();
        preEdit.putInt("radioSelection", pos);
        preEdit.commit();
    }

    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor preEdit = sharedPref.edit();
        int pos = sharedPref.getInt("radioSelection", 0);
        RG1.check(pos);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RG1 = findViewById(R.id.Radio);
        rbGood = findViewById(R.id.radioButtonGood);
        rbBad = findViewById(R.id.radioButtonBad);


        IntentFilter filter = new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION);
        filter.addAction("android.intent.action.WALLPAPER_CHANGED");
        this.registerReceiver(br, filter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        this.unregisterReceiver(br);
    }

}

