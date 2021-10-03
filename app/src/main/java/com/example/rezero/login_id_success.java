package com.example.rezero;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class login_id_success extends AppCompatActivity {

    private String email;
    private int email_index;
    private TextView email_textview;
    private View login_view;
    private View pwd_view;
    private ImageView back;


    @Override
    public void onCreate(Bundle savedInstanceState) {


        /* 0. PutExtra 값 가져오기 */
        //: login_find_id.java에서 putExtra한 user_email 값 (아이디 찾기에서 DB 조회한 결과) 넘겨 받아오기!!

        Intent intent = new Intent(this.getIntent());
        email  = intent.getStringExtra("user_email");
        email_index = email.indexOf("@");
        StringBuilder builder = new StringBuilder(email);
        builder.setCharAt(email_index-3, '*');
        builder.setCharAt(email_index-2, '*');
        builder.setCharAt(email_index-1, '*');

        /* 1. 레이아웃에서 띄울 xml 화면 선택 */
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_id_success);

        /* 2. 뒤로 가기 구현 */
        back = (ImageView) findViewById(R.id.login_find_image_back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        //이메일 받아온 값으로 채우기
        email_textview = (TextView) findViewById(R.id.login_id_success_textview_email);
        email_textview.setText(builder.toString());

        /* 3. 로그인 버튼 누르면 로그인 화면으로 넘어가기 */
        login_view = (View) findViewById(R.id.login_id_success_view_login);
        login_view.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {

                //로그인 뷰 클릭시 로그인 화면으로 이동
                Intent intent = new Intent(login_id_success.this, login_1_activity.class);
                startActivity(intent);
            }
            });

        /* 4. 비밀번호 버튼 누르면 비밀번호 화면으로 넘어가기 */
        pwd_view = (View) findViewById(R.id.login_id_success_view_pwd);
        pwd_view.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                //비밀번호 뷰 클릭 시 비밀번호 찾기 화면으로 이동
                Intent intent = new Intent(login_id_success.this, login_find_activity.class);
                startActivity(intent);

                //비밀번호 탭으로 전환
                //login_find_activity 클래스의 TabTransition() 메소드 호출! (viewPager에 두번째 인덱스로 전환해줌. 직접 정의함)
                //((login_find_activity)login_find_activity.mContext).TabTransition();

                ((login_find_activity) login_find_activity.mContext).TabTransition();


            }
        });





    }
}
