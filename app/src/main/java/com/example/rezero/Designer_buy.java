package com.example.rezero;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Designer_buy extends AppCompatActivity {

    LinearLayout main_layout;

    int cartsNum=4;
    View[] profiles = new View[cartsNum];
    CheckBox[] checkBoxes = new CheckBox[cartsNum];
    Button[] detail_button = new Button[cartsNum];

    TextView[] numTxvs = new TextView[cartsNum];
    CheckBox allCheck;
    TextView[] prices = new TextView[cartsNum];//선택상품가격

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_designer_buy);


        //스크롤뷰 제일 아래에 깔리는 배경 레이아웃
        main_layout = (LinearLayout) findViewById(R.id.main_layout);
        LayoutInflater mInflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        for (int i=0;i<cartsNum;i++){
            profiles[i] = mInflater.inflate(R.layout.designer_buy_profile, null);//프로파일레이아웃을 인플레이트
            checkBoxes[i] = (CheckBox) profiles[i].findViewById(R.id.check);
            detail_button[i] = (Button) profiles[i].findViewById(R.id.detail_button);
            //minusBtns[i] = (Button) profiles[i].findViewById(R.id.minusbtn);
            //numTxvs[i]=(TextView) profiles[i].findViewById(R.id.numTxv);
            //prices[i]=(TextView) profiles[i].findViewById(R.id.price);
        }

        //프로파일레이어붙히기
        for (int i=0;i<cartsNum;i++){
            main_layout.addView(profiles[i]);//프로파일레이아웃 붙힘
        }

    }
}