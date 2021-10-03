package com.example.rezero;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class designer_buy_detail extends AppCompatActivity {

    ImageView back;
    LinearLayout main_layout;

    int cartsNum=4;
    View[] profiles = new View[cartsNum];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_designer_buy_detail);

        // 뒤로가기
        back = (ImageView) findViewById(R.id.backBtn);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        //스크롤뷰 제일 아래에 깔리는 배경 레이아웃
        main_layout = (LinearLayout) findViewById(R.id.main_layout);
        LayoutInflater mInflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        for (int i=0;i<cartsNum/2;i++){
            profiles[i] = mInflater.inflate(R.layout.order_detail, null);//프로파일레이아웃을 인플레이트
        }

        //프로파일레이어붙히기
        for (int i=0;i<cartsNum/2;i++){
            main_layout.addView(profiles[i]);//프로파일레이아웃 붙힘
        }
    }
}