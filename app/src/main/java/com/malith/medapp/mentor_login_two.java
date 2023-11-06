package com.malith.medapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class mentor_login_two extends AppCompatActivity {
    EditText username, password;
    AppCompatButton loginBtn;

    DBHelper db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mentor_login_two);

        username = (EditText) findViewById(R.id.logTwoUsername);
        password = (EditText) findViewById(R.id.logTwoPassword);
        loginBtn = (AppCompatButton) findViewById(R.id.logTwoBtn);

        //initialize database
        db =new DBHelper(this);


        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = username.getText().toString();
                String pass = password.getText().toString();


                if (user.equals("") || pass.equals("")){
                    Toast.makeText(mentor_login_two.this, "Please enter all fields", Toast.LENGTH_SHORT).show();
                } else {
                    boolean checkUsers = db.checkUsernamePassword(user,pass);
                    if (checkUsers == true){
                        Toast.makeText(mentor_login_two.this, "Login successfull..!", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(), mentorAccount.class);
                        startActivity(intent);
                    }else{
                        Toast.makeText(mentor_login_two.this, "Invalid username or password ", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });


    }
}