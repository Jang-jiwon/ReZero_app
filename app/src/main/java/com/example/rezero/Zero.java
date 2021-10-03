package com.example.rezero;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class Zero extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zero);

        overridePendingTransition(0, android.R.anim.fade_out);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(Zero.this, login_new_activity.class);
                startActivity(intent);

                finish();
            }
        }, 1200);//0.9초뒤

    }
}