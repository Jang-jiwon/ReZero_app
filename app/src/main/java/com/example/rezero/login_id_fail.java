package com.example.rezero;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class login_id_fail extends AppCompatActivity {
    private View back_view;
    private View new_view;
    private ImageView back;


    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_id_fail); //레이아웃에서 띄울 xml 화면 선택

        back_view = (View) findViewById(R.id.login_id_fail_view_back);
        new_view = (View) findViewById(R.id.login_id_fail_view_new);

        //0. 뒤로가기
        back = (ImageView) findViewById(R.id.login_find_image_back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                onBackPressed();
            }
        });

        //1. 이전 버튼 눌렀을 때
        back_view.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                onBackPressed();
            }
        });

        //2. 회원가입 뷰 눌렀을 때
        new_view.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                //회원가입 화면으로 이동
                Intent intent = new Intent(login_id_fail.this, login_new_activity.class);
                startActivity(intent);
            }
        });
    }

}
