package com.example.rezero;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class user_mypage_2_delete_activity extends AppCompatActivity {

    private ImageView back;

    //로그인 변수
    String login;
    String login_user_email;
    String login_user_pwd;

    //이 화면에서 사용할 변수
    View user_mypage_2_delete_view_delete;

    public void onCreate(Bundle savedInstance)
    {
        //0. 로그인했을 때 조회한 db 값 가져오기
        Intent intent = new Intent(this.getIntent());

        login = intent.getStringExtra("login");
        Log.i("로그인함?",login+" ");

        login_user_email  = intent.getStringExtra("login_user_email");
        login_user_pwd  = intent.getStringExtra("login_user_pwd");
        Log.i("가져온 로그인 값?", login+"했으면? "+login_user_email+" "+login_user_pwd);

        //1. 화면 띄우기
        super.onCreate(savedInstance);
        setContentView(R.layout.user_mypage_2_delete);

        //2. 뒤로가기 버튼
        back = (ImageView) findViewById(R.id.login_find_image_back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                onBackPressed();
            }
        });

        //3. 회원탈퇴 클릭 시
        user_mypage_2_delete_view_delete = (View) findViewById(R.id.user_mypage_2_delete_view_delete);
        user_mypage_2_delete_view_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "다음에 다시 만나요 !", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(user_mypage_2_delete_activity.this, login_1_activity.class);
                startActivity(intent);
            }
        });
    }
}
