package com.example.myclothingshop.activities;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myclothingshop.MainActivity;
import com.example.myclothingshop.R;
import com.google.firebase.auth.FirebaseAuth;

public class splashActivity extends AppCompatActivity {

    ProgressBar progressBar;
    FirebaseAuth auth;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        auth = FirebaseAuth.getInstance();
        progressBar = findViewById(R.id.progressbar2);
        progressBar.setVisibility(View.GONE);
        if(auth.getCurrentUser() != null){
            progressBar.setVisibility(View.VISIBLE);
            startActivity(new Intent(splashActivity.this, MainActivity.class));
            Toast.makeText(this,"Please wait you are already logged in!!",Toast.LENGTH_SHORT).show();
            finish();
        }

        };

    public void login(View view) {

        startActivity(new Intent(splashActivity.this, Login.class));
    }

    public void registration(View view) {

        startActivity(new Intent(splashActivity.this, Registaration.class));
    }
}
