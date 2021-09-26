package com.example.rezero;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class Cart extends AppCompatActivity {

    LinearLayout basicLay;
    Button delBtn;

    int cartsNum=10;
    View[] profiles = new View[cartsNum];
    CheckBox[] checkBoxes = new CheckBox[cartsNum];
    Button[] plusBtns=new Button[cartsNum];
    Button[] minusBtns=new Button[cartsNum];
    TextView[] numTxvs = new TextView[cartsNum];
    CheckBox allCheck;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        //스크롤뷰 제일 아래에 깔리는 배경 레이아웃
        basicLay = (LinearLayout) findViewById(R.id.basicLay);
        LayoutInflater mInflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);


        //프로필레이아웃의 객체들생성
        for (int i=0;i<cartsNum;i++){
            profiles[i] = mInflater.inflate(R.layout.profile, null);//프로파일레이아웃을 인플레이트
            checkBoxes[i] = (CheckBox) profiles[i].findViewById(R.id.check);
            plusBtns[i] = (Button) profiles[i].findViewById(R.id.plusbtn);
            minusBtns[i] = (Button) profiles[i].findViewById(R.id.minusbtn);
            numTxvs[i]=(TextView) profiles[i].findViewById(R.id.numTxv);
        }

        //프로파일레이어붙히기
        for (int i=0;i<cartsNum;i++){
            basicLay.addView(profiles[i]);//프로파일레이아웃 붙힘
        }

        //수량조절버튼
        for (int i=0;i<cartsNum;i++){
            final int INDEX;
            INDEX = i;
            plusBtns[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int n= Integer.parseInt(numTxvs[INDEX].getText().toString());//제품수량
                    n+=1;
                    numTxvs[INDEX].setText(Integer.toString(n));
                }
            });
            minusBtns[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int n= Integer.parseInt(numTxvs[INDEX].getText().toString());//제품수량
                    if (n>1){
                        n-=1;
                        numTxvs[INDEX].setText(Integer.toString(n));
                    }
                }
            });
        }

        //전체선택삭제
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

        //선택삭제
        delBtn = (Button) findViewById(R.id.delBtn);
        delBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for (int i=0;i<cartsNum;i++){
                    if (checkBoxes[i].isChecked()==true){
                        basicLay.removeView(profiles[i]);
                    }
                }
            }
        });

    }
}