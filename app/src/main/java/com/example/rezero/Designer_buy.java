package com.example.rezero;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.LinearLayout;

public class Designer_buy extends AppCompatActivity {

    LinearLayout main_layout;
    ImageButton clear_choice2;

    int cartsNum=4;
    View[] profiles = new View[cartsNum];
    CheckBox[] checkBoxes = new CheckBox[cartsNum];
    Button[] detail_button = new Button[cartsNum];

    CheckBox allCheck_detail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_designer_buy);


        //스크롤뷰 제일 아래에 깔리는 배경 레이아웃
        main_layout = (LinearLayout) findViewById(R.id.main_layout);
        LayoutInflater mInflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        for (int i=0;i<cartsNum;i++){
            profiles[i] = mInflater.inflate(R.layout.designer_buy_profile_dyes, null);//프로파일레이아웃을 인플레이트
            checkBoxes[i] = (CheckBox) profiles[i].findViewById(R.id.check);
            detail_button[i] = (Button) profiles[i].findViewById(R.id.detail_button);
        }

        //프로파일레이어붙히기
        for (int i=0;i<cartsNum;i++){
            main_layout.addView(profiles[i]);//프로파일레이아웃 붙힘
        }

        for (int i=0;i<cartsNum;i++){
            profiles[i] = mInflater.inflate(R.layout.designer_buy_profile_dno, null);//프로파일레이아웃을 인플레이트
            checkBoxes[i] = (CheckBox) profiles[i].findViewById(R.id.check);
            detail_button[i] = (Button) profiles[i].findViewById(R.id.detail_button);
        }

        //프로파일레이어붙히기
        for (int i=0;i<cartsNum;i++){
            main_layout.addView(profiles[i]);//프로파일레이아웃 붙힘
        }

        //전체선택
        allCheck_detail = (CheckBox) findViewById(R.id.allCheck_detail);
        allCheck_detail.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b==true){
                    for (int i=0;i<cartsNum;i++){
                        checkBoxes[i].setChecked(true);
                    }
                }else {
                    for (int i=0;i<cartsNum;i++){
                        checkBoxes[i].setChecked(false);
                    }
                }
            }
        });

        //선택삭제
        clear_choice2 = (ImageButton) findViewById(R.id.clear_choice2);
        clear_choice2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for (int i=0;i<cartsNum;i++){
                    if (checkBoxes[i].isChecked()==true){
                        main_layout.removeView(profiles[i]);
                    }
                }
            }
        });

    }
}