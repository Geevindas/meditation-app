package com.malith.medapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Handler;

public class MainActivity extends AppCompatActivity {

    private static final int DELAY_TIME = 1500; // Delay time in milliseconds

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_institute);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity.this, loginScreen.class);
                startActivity(intent);
                finish();
            }
        }, DELAY_TIME);
    }
}