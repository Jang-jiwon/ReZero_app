package com.example.rezero;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Paid extends AppCompatActivity {

    Button goHomeBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paid);

        goHomeBtn = (Button) findViewById(R.id.goHomeBtn);
        goHomeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gohome = new Intent(Paid.this,MainActivity.class);
                startActivity(gohome);
            }
        });

    }
}