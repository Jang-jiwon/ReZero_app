package com.example.rezero;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class product_like extends AppCompatActivity {

    ImageButton homeBtn, boxBtn, likeBtn, myBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_like);

        //하단 버튼객체생성
        homeBtn = (ImageButton) findViewById(R.id.homeBtn);
        boxBtn = (ImageButton) findViewById(R.id.boxBtn);
        likeBtn = (ImageButton) findViewById(R.id.likeBtn);
        myBtn = (ImageButton) findViewById(R.id.myBtn);

        //하단바 버튼 누름효과지정
        {
            homeBtn.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View view, MotionEvent event) {
                    if (event.getAction() == MotionEvent.ACTION_DOWN) {

                        homeBtn.setBackgroundColor(Color.parseColor("#F5F5F5"));

                    } else if (event.getAction() == MotionEvent.ACTION_UP) {

                        homeBtn.setBackgroundColor(Color.WHITE);

                    }
                    return false;
                }
            });
            boxBtn.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View view, MotionEvent event) {
                    if (event.getAction() == MotionEvent.ACTION_DOWN) {

                        boxBtn.setBackgroundColor(Color.parseColor("#F5F5F5"));

                    } else if (event.getAction() == MotionEvent.ACTION_UP) {

                        boxBtn.setBackgroundColor(Color.WHITE);

                    }
                    return false;
                }
            });
            likeBtn.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View view, MotionEvent event) {
                    //찜 화면으로 이동
                    Intent intent = new Intent(product_like.this, product_like.class);
                    startActivity(intent);
                    if (event.getAction() == MotionEvent.ACTION_DOWN) {

                        likeBtn.setBackgroundColor(Color.parseColor("#F5F5F5"));

                    } else if (event.getAction() == MotionEvent.ACTION_UP) {

                        likeBtn.setBackgroundColor(Color.WHITE);

                    }
                    return false;
                }
            });
            myBtn.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View view, MotionEvent event) {
                    //로그인 화면으로 이동
                    Intent intent = new Intent(product_like.this, login_1_activity.class);
                    startActivity(intent);
                    if (event.getAction() == MotionEvent.ACTION_DOWN) {

                        myBtn.setBackgroundColor(Color.parseColor("#F5F5F5"));

                    } else if (event.getAction() == MotionEvent.ACTION_UP) {

                        myBtn.setBackgroundColor(Color.WHITE);

                    }


                    return false;
                }
            });
        }
    }
}