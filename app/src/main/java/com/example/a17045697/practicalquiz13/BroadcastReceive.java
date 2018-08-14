package com.example.a17045697.practicalquiz13;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.widget.Toast;

public class BroadcastReceive extends android.content.BroadcastReceiver {

    @Override
    public void onReceive(Context context,Intent intent){
        SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor preEdit = sharedPref.edit();
        int pos = sharedPref.getInt("radioSelection", 0);
        if(pos == 1){
           Toast my_toast =  Toast.makeText(context,"You have a good taste", Toast.LENGTH_LONG);
           my_toast.show();
        }else{
            Toast my_toast =  Toast.makeText(context,"Bro, think twice about it.", Toast.LENGTH_LONG);
            my_toast.show();
        }
    }




}
