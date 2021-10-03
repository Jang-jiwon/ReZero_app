package com.example.rezero;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class user_mypage_notice_2_activity extends AppCompatActivity {

    private ImageView back;
    String title;
    String day;


    public void onCreate(Bundle savedInstance)
    {
        Intent intent = new Intent(this.getIntent());

        title = intent.getStringExtra("title");
        day = intent.getStringExtra("day");

        super.onCreate(savedInstance);
        setContentView(R.layout.user_mypage_notice_2);

        //1. 뒤로 가기
        back = (ImageView) findViewById(R.id.login_find_image_back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                onBackPressed();
            }
        });

    }
}