package com.example.rezero;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Cart extends AppCompatActivity {

    LinearLayout basicLay;
    LinearLayout profil,profil2,profil3;
    CheckBox check;
    TextView dName;

    ImageView slice;

    int cartsNum=10;
    View[] profiles = new View[cartsNum];
    CheckBox[] checkBoxes = new CheckBox[cartsNum];
    CheckBox allCheck;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        //스크롤뷰 제일 아래에 깔리는 배경 레이아웃
        basicLay = (LinearLayout) findViewById(R.id.basicLay);
        LayoutInflater mInflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);


        for (int i=0;i<cartsNum;i++){
            profiles[i] = mInflater.inflate(R.layout.profile, null);
            checkBoxes[i] = (CheckBox) profiles[i].findViewById(R.id.check);
        }
        for (int i=0;i<cartsNum;i++){
            basicLay.addView(profiles[i]);
            slice = new ImageView(this);
            slice.setBackground(getResources().getDrawable(R.drawable.slicebar));
            basicLay.addView(slice);
        }
        allCheck = (CheckBox) findViewById(R.id.allCheck);
        allCheck.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
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

    }
}