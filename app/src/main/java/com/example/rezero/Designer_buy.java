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
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Designer_buy extends AppCompatActivity {

    LinearLayout main_layout, detail_layout;
    ImageButton clear_choice2, clear_choice;
    ImageView line1, line2;

    int cartsNum=8;
    View[] profiles = new View[cartsNum];
    CheckBox[] checkBoxes = new CheckBox[cartsNum];
    Button[] detail_button = new Button[cartsNum];
    TextView[] textView = new TextView[cartsNum];

    CheckBox allCheck_detail, allCheck_no_delivery, allCheck, allCheck_date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_designer_buy);


        //스크롤뷰 제일 아래에 깔리는 배경 레이아웃
        main_layout = (LinearLayout) findViewById(R.id.main_layout);
        LayoutInflater mInflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        for (int i=0;i<cartsNum/2;i++){
            profiles[i] = mInflater.inflate(R.layout.designer_buy_profile_dyes, null);//프로파일레이아웃을 인플레이트
            checkBoxes[i] = (CheckBox) profiles[i].findViewById(R.id.check);
            detail_button[i] = (Button) profiles[i].findViewById(R.id.detail_button);
            textView[i] = (TextView)profiles[i].findViewById(R.id.d_yes_no);
        }

        //프로파일레이어붙히기
        for (int i=0;i<cartsNum/2;i++){
            main_layout.addView(profiles[i]);//프로파일레이아웃 붙힘
        }

        for (int i=cartsNum/2;i<cartsNum;i++){
            profiles[i] = mInflater.inflate(R.layout.designer_buy_profile_dno, null);//프로파일레이아웃을 인플레이트
            checkBoxes[i] = (CheckBox) profiles[i].findViewById(R.id.check);
            detail_button[i] = (Button) profiles[i].findViewById(R.id.detail_button);
            textView[i] = (TextView)profiles[i].findViewById(R.id.d_yes_no);
        }

        //프로파일레이어붙히기
        for (int i=cartsNum/2;i<cartsNum;i++){
            main_layout.addView(profiles[i]);//프로파일레이아웃 붙힘
        }

        // 날짜 전체 선택
        allCheck = (CheckBox) findViewById(R.id.allCheck);
        allCheck_date = (CheckBox) findViewById(R.id.allCheck_date);
        allCheck.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b==true){
                    allCheck_date.setChecked(true);
                } else {
                    allCheck_date.setChecked(false);
                }
            }
        });

        // 날짜 전체 선택 삭제
        clear_choice = (ImageButton) findViewById(R.id.clear_choice);
        detail_layout = (LinearLayout) findViewById(R.id.detail_layout);
        line1 = (ImageView) findViewById(R.id.line1);
        line2 = (ImageView) findViewById(R.id.line2);
        clear_choice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for (int i=0;i<cartsNum;i++){
                    main_layout.removeView(profiles[i]);
                }
                allCheck_date.setVisibility(View.GONE);
                detail_layout.setVisibility(View.GONE);
                line1.setVisibility(View.GONE);
                line2.setVisibility(View.GONE);
            }
        });


        //전체선택
        allCheck_detail = (CheckBox) findViewById(R.id.allCheck_detail);
        allCheck_detail.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b==true){
                    if(allCheck_no_delivery.isChecked()) {
                        for (int i=0;i<cartsNum;i++){
                            if (textView[i].getText().equals("미발송"))
                                checkBoxes[i].setChecked(true);
                        }
                    }
                    else {
                        for (int i = 0; i < cartsNum; i++) {
                            checkBoxes[i].setChecked(true);
                        }
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
        
        // 발송제외
        allCheck_no_delivery = (CheckBox) findViewById(R.id.allCheck_no_delivery);
        allCheck_no_delivery.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b==true){
                    for (int i=0;i<cartsNum;i++){
                        if(textView[i].getText().equals("발송")) {
                            profiles[i].setVisibility(View.GONE);
                        }
                    }
                }else {
                    for (int i=0;i<cartsNum;i++){
                        if(textView[i].getText().equals("발송")) {
                            profiles[i].setVisibility(View.VISIBLE);
                        }
                    }
                }
            }
        });

    }
}