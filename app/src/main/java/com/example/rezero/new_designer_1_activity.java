package com.example.rezero;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class new_designer_1_activity extends AppCompatActivity {

    private View new_designer_1_view_next;
    private ImageView back;

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        //1. 화면 띄우기
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_designer_1);

        //2. 뒤로가기 구현
        back = (ImageView) findViewById(R.id.login_find_image_back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                onBackPressed();
            }
        });
        
        //3. 키보드 다른 곳 누르면 내려가게

        //4. XML - 자바 연결
        new_designer_1_view_next = (View) findViewById(R.id.new_designer_1_view_next);

        //5. 다음 클릭 시 디자이너 회원가입 2 화면 띄우기
        new_designer_1_view_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(new_designer_1_activity.this, new_designer_2_activity.class);
                startActivity(intent);
            }
        });
    }
}
