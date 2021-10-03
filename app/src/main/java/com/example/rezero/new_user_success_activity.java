package com.example.rezero;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class new_user_success_activity extends AppCompatActivity {
    private View login_view_now;
    private ImageView back;

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_user_success); //레이아웃에서 띄울 xml 화면 선택


        //0. 뒤로가기
        back = (ImageView) findViewById(R.id.login_find_image_back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        //1. XML과 자바 연결
        login_view_now = (View) findViewById(R.id.login_view_now);

        //2. 로그인 버튼 누르면 로그인 화면으로 이동!
        login_view_now.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(new_user_success_activity.this, login_1_activity.class);
                startActivity(intent);
            }
        });
    }
}
