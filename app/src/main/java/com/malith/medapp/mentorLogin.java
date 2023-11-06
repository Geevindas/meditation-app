package com.malith.medapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class mentorLogin extends AppCompatActivity {

    EditText username, email, mobile, password, rePassword;
    AppCompatButton signup;

    DBHelper db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mentor_login);

        username = (EditText) findViewById(R.id.msUsername);
        email = (EditText) findViewById(R.id.msEmail);
        mobile =  (EditText) findViewById(R.id.msMobile);
        password = (EditText) findViewById(R.id.msPassword);
        rePassword = (EditText) findViewById(R.id.msRepassword);
        signup = (AppCompatButton) findViewById(R.id.msSignup);

        //initialize database
        db = new DBHelper(this);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = username.getText().toString();
                String pass = password.getText().toString();
                String e_mail = email.getText().toString();
                String mob = mobile.getText().toString();
                String rePass = rePassword.getText().toString();

                if (user.equals("") || pass.equals("") || e_mail.equals("") || mob.equals("") || rePass.equals("")){
                    Toast.makeText(mentorLogin.this, "Please enter all fields", Toast.LENGTH_SHORT).show();
                } else{
                    if (pass.equals(rePass)){
                        boolean checkuser = db.checkUsername(user);
                        if (checkuser == false){
                            boolean insert = db.insertData(user, pass, e_mail, mob);
                            if (insert == true) {
                                Toast.makeText(mentorLogin.this, "Sign up successfull.!", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(getApplicationContext(), mentor_login_two.class);
                                startActivity(intent);
                            } else {
                                Toast.makeText(mentorLogin.this, "Sign up Failed.", Toast.LENGTH_SHORT).show();
                            }
                        } else {
                            Toast.makeText(mentorLogin.this, "User already exists Please sign in.!", Toast.LENGTH_SHORT).show();
                        }
                    } else{
                        Toast.makeText(mentorLogin.this, "Password not matching.", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });
    }
}