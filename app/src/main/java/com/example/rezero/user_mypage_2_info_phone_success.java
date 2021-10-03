package com.example.rezero;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class user_mypage_2_info_phone_success extends AppCompatActivity {
    private View login_view_now;
    private ImageView back;

    @Override
    public void onCreate(Bundle savedInstanceState) {

        /* 1. 레이아웃에서 띄울 XML 화면 표시 */
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_mypage_2_info_phone_success);
        
        /* 2. 로그인하러 가기 연결 */
        login_view_now = (View) findViewById(R.id.login_view_now);
        login_view_now.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                //로그인 화면으로 이동
                Intent intent = new Intent(user_mypage_2_info_phone_success.this, login_1_activity.class);
                startActivity(intent);
            }
            });

        //3. 뒤로가기
        back = (ImageView) findViewById(R.id.login_find_image_back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                onBackPressed();
            }
        });
        
        
    }
}
