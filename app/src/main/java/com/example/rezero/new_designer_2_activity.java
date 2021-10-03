package com.example.rezero;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class new_designer_2_activity extends AppCompatActivity {
    private View new_designer_2_view_success;
    private ImageView back;

    public void onCreate(Bundle savedInstance)
    {
        //0. 화면 띄우기
        super.onCreate(savedInstance);
        setContentView(R.layout.new_designer_2);

        //1. 자바 - XML 연동
        new_designer_2_view_success = (View) findViewById(R.id.new_designer_2_view_success);

        //2. 뒤로가기 구현
        back = (ImageView) findViewById(R.id.login_find_image_back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                onBackPressed();
            }
        });

        //3. 키보드 다른 곳 누르면 내려가게

        //4. 완료 버튼 누르면 성공 화면 띄우기
        new_designer_2_view_success.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(new_designer_2_activity.this, new_user_success_activity.class);
                startActivity(intent);
            }
        });

    }
}
