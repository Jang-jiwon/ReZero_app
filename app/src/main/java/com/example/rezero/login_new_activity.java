package com.example.rezero;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class login_new_activity extends Activity
{
    private TextView login_new_textview_user;
    private TextView login_new_textview_designer;
    private TextView login_new_textview_login;

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_new); //레이아웃에서 띄울 xml 화면 선택

        //1. 자바 변수와 XML 연결
        login_new_textview_user = (TextView) findViewById(R.id.login_new_textview_user);
        login_new_textview_designer = (TextView) findViewById(R.id.login_new_textview_designer);
        login_new_textview_login = (TextView) findViewById(R.id.login_new_textview_login);

        //2. 일반 회원으로 가입 클릭 시
        login_new_textview_user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //2-(1) 사용자 회원가입 페이지로 이동
                Intent intent = new Intent(login_new_activity.this, new_user_1_activity.class);
                startActivity(intent);
            }
        });

        //3. 디자이너로 회원가입 클릭 시
        login_new_textview_designer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //3-(1) 사용자 회원가입 페이지로 이동
                Intent intent = new Intent(login_new_activity.this, new_designer_1_activity.class);
                startActivity(intent);
            }
        });

        //4. 로그인하기 클릭 시
        login_new_textview_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //4-(1) 로그인 페이지로 이동
                Intent intent = new Intent(login_new_activity.this, login_1_activity.class);
                startActivity(intent);
            }
        });

    }
}
