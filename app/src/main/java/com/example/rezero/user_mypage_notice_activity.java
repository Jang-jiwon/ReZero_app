package com.example.rezero;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

public class user_mypage_notice_activity extends AppCompatActivity {

    private ImageView back;

    private LinearLayout user_mypage_notice_layout_2;
    private LinearLayout user_mypage_notice_layout_1;

    public void onCreate(Bundle savedInstance)
    {
        super.onCreate(savedInstance);
        setContentView(R.layout.user_mypage_notice);

        //1. 뒤로 가기
        back = (ImageView) findViewById(R.id.login_find_image_back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                onBackPressed();
            }
        });

        //2. 첫번째 공지사항 누르면
        user_mypage_notice_layout_2 = (LinearLayout) findViewById(R.id.user_mypage_notice_layout_2);
        user_mypage_notice_layout_1 = (LinearLayout) findViewById(R.id.user_mypage_notice_layout_1);

        user_mypage_notice_layout_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    Intent intent = new Intent(user_mypage_notice_activity.this, user_mypage_notice_2_activity.class);

                    intent.putExtra("title", "첫번째 공지사항");
                    intent.putExtra("day", "2021.08.23");

                    startActivity(intent);
            }
        });

        //3. 두번째 공지사항 누르면
        user_mypage_notice_layout_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(user_mypage_notice_activity.this, user_mypage_notice_2_activity.class);

                intent.putExtra("title", "두번째 공지사항");
                intent.putExtra("day", "2021.09.08");

                startActivity(intent);

            }
        });
    }
}