package com.example.immad.androidstatesandlog;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    private final static String TAG = "State_Change";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.v(TAG, "OnCreate()");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.v(TAG, "OnStart()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.v(TAG, "OnResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.v(TAG, "OnPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.v(TAG, "OnStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.v(TAG, "OnDestroy()");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.v(TAG, "onSaveInstanceState()");
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.v(TAG, "onRestoreInstanceState()");
    }
}
