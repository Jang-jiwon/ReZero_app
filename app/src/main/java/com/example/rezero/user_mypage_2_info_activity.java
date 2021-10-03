package com.example.rezero;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

public class user_mypage_2_info_activity extends AppCompatActivity {

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
    private EditText name_text;
    private EditText email_text;
    private EditText pwd_text;
    private EditText login_find_pwd_edit_phone;
    private View login_find_pwd_view_pwd;
    private View login_find_pwd_view_phone;
    private LinearLayout user_mypage_2_info_layout_all;
    private InputMethodManager imm;
    Boolean check = false;

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
        setContentView(R.layout.user_mypage_2_info);

        //2. 뒤로가기 버튼
        back = (ImageView) findViewById(R.id.login_find_image_back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                onBackPressed();
            }
        });

        //3. XML과 자바 변수 연결
        name_text = (EditText) findViewById(R.id.login_find_pwd_edit_name);
        email_text = (EditText) findViewById(R.id.login_find_pwd_edit_email);
        pwd_text = (EditText) findViewById(R.id.login_find_pwd_edit_pwd);
        login_find_pwd_edit_phone = (EditText) findViewById(R.id.login_find_pwd_edit_phone);
        login_find_pwd_view_pwd = (View) findViewById(R.id.login_find_pwd_view_pwd);
        login_find_pwd_view_phone = (View) findViewById(R.id.login_find_pwd_view_phone);
        user_mypage_2_info_layout_all = (LinearLayout) findViewById(R.id.user_mypage_2_info_layout_all);

        // 3 -(1) Edittext 배경 클릭 시 키보드 내림
        user_mypage_2_info_layout_all = (LinearLayout) findViewById(R.id.login_find_pwd_layout_all);
        imm = (InputMethodManager) this.getSystemService(Context.INPUT_METHOD_SERVICE);

        user_mypage_2_info_layout_all.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                imm.hideSoftInputFromWindow(name_text.getWindowToken(), 0);
                imm.hideSoftInputFromWindow(email_text.getWindowToken(), 0);
                imm.hideSoftInputFromWindow(pwd_text.getWindowToken(), 0);
                imm.hideSoftInputFromWindow(login_find_pwd_edit_phone.getWindowToken(), 0);

            }
        });

        //3-(2). 로그인 한 상태면 화면 세팅
        if(login.equals("true"))
        {
            email_text.setText(login_user_email);
            name_text.setText(login_user_name);
            pwd_text.setText(login_user_pwd);
            login_find_pwd_edit_phone.setText(login_user_phone_num);
        }
        else
        {
            email_text.setText("로그인부터 해주세요!");
            name_text.setText("로그인부터 해주세요!");
            pwd_text.setText("로그인부터 해주세요!");
        }

        //4. 비밀 번호 - 변경 클릭 시
        login_find_pwd_view_pwd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                login_find_pwd_view_pwd.setBackground(ContextCompat.getDrawable(user_mypage_2_info_activity.this, R.drawable.login_rectangle_green_alpha_radius_13));

                Log.i("login_1 -> 로그인함? ", String.valueOf(login));

                Intent intent = new Intent(user_mypage_2_info_activity.this, user_mypage_2_info_pwd_activity.class);


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

                startActivity(intent);
            }
        });

        //5. 핸드폰번호 - 변경 클릭 시
        login_find_pwd_view_phone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                login_find_pwd_view_phone.setBackground(ContextCompat.getDrawable(user_mypage_2_info_activity.this, R.drawable.login_rectangle_green_alpha_radius_13));

                Intent intent = new Intent(user_mypage_2_info_activity.this, user_mypage_2_info_phone_activity.class);

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

                Log.i("login_1 -> 로그인함? ", String.valueOf(login));

                startActivity(intent);
            }
        });
    }
}
