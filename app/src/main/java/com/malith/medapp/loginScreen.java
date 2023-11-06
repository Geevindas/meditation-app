package com.malith.medapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class loginScreen extends AppCompatActivity {

    private AppCompatButton mLog_btn;
    private AppCompatButton mSign_btn;
    private AppCompatButton slog_btn;
    private AppCompatButton sSign_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_screen);

        // mentor login, signup buttons get attribute using button id
        mLog_btn = (AppCompatButton) findViewById(R.id.mLogin_btn);
        mSign_btn = (AppCompatButton) findViewById(R.id.mSignup_btn);

        //student login, signup buttons get attributes using button id
        slog_btn = (AppCompatButton) findViewById(R.id.sLogin_btn);
        sSign_btn = (AppCompatButton) findViewById(R.id.sSignup_btn);


        //onclick method for navigate mentor login page
        mLog_btn.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openMentorLogin();
            }
        });

        //onclick method for navigate menter sign up
        mSign_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openMentorSignup();
            }
        });


    }
    public void openMentorLogin(){
        Intent intent = new Intent( this, mentor_login_two.class );
        startActivity(intent);
    }

    public  void openMentorSignup(){
        Intent intent = new Intent( this, mentorLogin.class );
        startActivity(intent);
    }

}