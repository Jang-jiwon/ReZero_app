package com.example.rezero;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class user_mypage_2_info_bank_activity extends AppCompatActivity {

    private ImageView back;

    //로그인 변수
    String login;
    String login_user_email;
    String login_user_pwd;
    String login_user_name;
    String login_user_order;
    String login_user_point;
    String login_user_coupon;
    String login_user_birth;
    String login_user_phone_num;
    String login_user_bank;
    String login_user_account;
    String login_user_address;
    String login_user_like_pro;
    String login_user_mission;
    String login_user_like_designer;
    String login_user_cart;
    String login_user_chat;
    String login_user_review;

    //이 화면에서 사용할 변수
    View new_designer_2_view_success;

    public void onCreate(Bundle savedInstance)
    {
        //0. 로그인했을 때 조회한 db 값 가져오기
        Intent intent = new Intent(this.getIntent());

        login = intent.getStringExtra("login");
        Log.i("로그인함?",login+" ");

        login_user_email  = intent.getStringExtra("login_user_email");
        login_user_pwd  = intent.getStringExtra("login_user_pwd");
        Log.i("가져온 로그인 값?", login+"했으면? "+login_user_email+" "+login_user_pwd);

        login_user_name = intent.getStringExtra("login_user_name");
        login_user_order = intent.getStringExtra("login_user_order");
        login_user_point = intent.getStringExtra("login_user_point");
        login_user_coupon = intent.getStringExtra("login_user_coupon");
        login_user_birth = intent.getStringExtra("login_user_birth");
        login_user_phone_num = intent.getStringExtra("login_user_phone_num");
        login_user_bank = intent.getStringExtra("login_user_bank");
        login_user_account = intent.getStringExtra("login_user_account");
        login_user_address = intent.getStringExtra("login_user_address");
        login_user_like_pro = intent.getStringExtra("login_user_like_pro");
        login_user_mission = intent.getStringExtra("login_user_mission");
        login_user_like_designer = intent.getStringExtra("login_user_like_designer");
        login_user_cart = intent.getStringExtra("login_user_cart");
        login_user_chat = intent.getStringExtra("login_user_chat");
        login_user_review = intent.getStringExtra("login_user_review");

        //1. 화면 띄우기
        super.onCreate(savedInstance);
        setContentView(R.layout.user_mypage_2_info_bank);

        //2. 뒤로가기 버튼
        back = (ImageView) findViewById(R.id.login_find_image_back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                onBackPressed();
            }
        });

        //3. 완료 버튼 클릭 시
        new_designer_2_view_success = (View) findViewById(R.id.new_designer_2_view_success);
        new_designer_2_view_success.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(user_mypage_2_info_bank_activity.this, user_mypage_2_info_bank_success.class);
                startActivity(intent);
            }
        });
    }
}
