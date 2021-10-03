package com.example.rezero;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class user_mypage_name_activity extends AppCompatActivity {

    private ImageView back;
    private TextView user_mypage_name_textview_name;
    private TextView user_mypage_name_textview_email;
    private TextView user_mypage_name_textview_info;
    private TextView user_mypage_name_textview_account;
    private TextView user_mypage_name_textview_logout;
    private TextView user_mypage_name_textview_delete;
    private LinearLayout user_mypage_name_layout_name;

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

    public void onCreate(Bundle savedInstance)
    {
        //0. 로그인 값 가져오기
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
        setContentView(R.layout.user_mypage_name);

        //2. 뒤로 가기
        back = (ImageView) findViewById(R.id.login_find_image_back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                onBackPressed();
            }
        });

        //3. 자바 - XML 연결
        user_mypage_name_textview_name = (TextView) findViewById(R.id.user_mypage_name_textview_name);
        user_mypage_name_textview_email = (TextView) findViewById(R.id.user_mypage_name_textview_email);
        user_mypage_name_textview_info = (TextView) findViewById(R.id.user_mypage_name_textview_info);
        user_mypage_name_textview_account = (TextView) findViewById(R.id.user_mypage_name_textview_account);
        user_mypage_name_textview_logout = (TextView) findViewById(R.id.user_mypage_name_textview_logout);
        user_mypage_name_textview_delete = (TextView) findViewById(R.id.user_mypage_name_textview_delete);
        user_mypage_name_layout_name = (LinearLayout) findViewById(R.id.user_mypage_name_layout_name);

        //4. 이름 텍스트뷰에 표시 - 데이터베이스 변수에 가져와서 표시하기!
        user_mypage_name_textview_name.setText(login_user_name);
        user_mypage_name_textview_email.setText(login_user_email);
        if(login.equals("true"))
        {
            user_mypage_name_textview_logout.setText("로그아웃");
        }

        //5. 회원 정보 수정 클릭
        user_mypage_name_textview_info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(user_mypage_name_activity.this, user_mypage_2_info_activity.class);

                intent.putExtra("login", login+"");

                intent.putExtra("login_user_email", login_user_email);
                intent.putExtra("login_user_pwd", login_user_pwd);
                intent.putExtra("login_user_name", login_user_name);
                intent.putExtra("login_user_birth", login_user_birth);
                intent.putExtra("login_user_phone_num", login_user_phone_num);
                intent.putExtra("login_user_bank", login_user_bank);
                intent.putExtra("login_user_account", login_user_account);
                intent.putExtra("login_user_address", login_user_address);
                intent.putExtra("login_user_like_pro", login_user_like_pro);
                intent.putExtra("login_user_order", login_user_order);
                intent.putExtra("login_user_point", login_user_point);
                intent.putExtra("login_user_coupon",login_user_coupon);
                intent.putExtra("login_user_mission", login_user_mission);
                intent.putExtra("login_user_like_designer", login_user_like_designer);
                intent.putExtra("login_user_cart", login_user_cart);
                intent.putExtra("login_user_review", login_user_review);
                intent.putExtra("login_user_chat", login_user_chat);

                Log.i("mypage_name -> 로그인함? ", String.valueOf(login));

                startActivity(intent);
            }
        });

        //6. 환불 계좌 관리 클릭
        user_mypage_name_textview_account.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(user_mypage_name_activity.this, user_mypage_2_info_bank_activity.class);

                intent.putExtra("login", login+"");

                intent.putExtra("login_user_email", login_user_email);
                intent.putExtra("login_user_pwd", login_user_pwd);
                intent.putExtra("login_user_name", login_user_name);
                intent.putExtra("login_user_birth", login_user_birth);
                intent.putExtra("login_user_phone_num", login_user_phone_num);
                intent.putExtra("login_user_bank", login_user_bank);
                intent.putExtra("login_user_account", login_user_account);
                intent.putExtra("login_user_address", login_user_address);
                intent.putExtra("login_user_like_pro", login_user_like_pro);
                intent.putExtra("login_user_order", login_user_order);
                intent.putExtra("login_user_point", login_user_point);
                intent.putExtra("login_user_coupon",login_user_coupon);
                intent.putExtra("login_user_mission", login_user_mission);
                intent.putExtra("login_user_like_designer", login_user_like_designer);
                intent.putExtra("login_user_cart", login_user_cart);
                intent.putExtra("login_user_review", login_user_review);
                intent.putExtra("login_user_chat", login_user_chat);

                Log.i("mypage_name -> 로그인함? ", String.valueOf(login));

                startActivity(intent);
            }
        });

        //7. 로그아웃 클릭
        user_mypage_name_textview_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                login = "false";

                Intent intent = new Intent(user_mypage_name_activity.this, login_1_activity.class);
                startActivity(intent);
            }
        });

        //8. 회원탈퇴 클릭
        user_mypage_name_textview_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(user_mypage_name_activity.this, user_mypage_2_delete_activity.class);
                intent.putExtra("login", login+"");

                intent.putExtra("login_user_email", login_user_email);
                intent.putExtra("login_user_pwd", login_user_pwd);
                Log.i("mypage_name -> 로그인? ", String.valueOf(login));

                startActivity(intent);
            }
        });



    }
}
