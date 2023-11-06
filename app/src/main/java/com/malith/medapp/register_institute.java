package com.malith.medapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;

public class register_institute extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_institute);

        Fragment fragment = new mapFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout,fragment).commit();
    }
}