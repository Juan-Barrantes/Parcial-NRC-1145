package com.example.parcial1145_barrantes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        new Handler(Looper.getMainLooper()).postDelayed(()->{
            mostrarLogin();
        }, 3000);
    }

    private void mostrarLogin() {
        startActivity(new Intent(this, LoginActivity.class));
        finish();
    }
}