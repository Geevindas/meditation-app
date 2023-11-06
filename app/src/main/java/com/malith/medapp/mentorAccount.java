package com.malith.medapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class mentorAccount extends AppCompatActivity {

    AppCompatButton button_regins;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mentor_account);
        button_regins = (AppCompatButton) findViewById(R.id.btnRegIns);

        button_regins.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), register_institute.class);
                startActivity(intent);
            }
        });
    }
}