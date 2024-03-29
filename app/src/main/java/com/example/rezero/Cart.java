package com.example.rezero;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
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

    public static Context context;//다른액티비티에서 변수사용할수있도록

    LinearLayout basicLay;
    Button delBtn;

    int cartsNum=10;
    View[] profiles = new View[cartsNum];
    CheckBox[] checkBoxes = new CheckBox[cartsNum];
    Button[] plusBtns=new Button[cartsNum];
    Button[] minusBtns=new Button[cartsNum];
    TextView[] numTxvs = new TextView[cartsNum];
    CheckBox allCheck;
    TextView[] prices = new TextView[cartsNum];//선택상품가격

    TextView total,tprice;

    int unDcPrice=0;//총상품가격

    Button orderBtn;

    //제품수량
    int n=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        context = this;//다른액티비티에서 사용할 수 있도록

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
            prices[i]=(TextView) profiles[i].findViewById(R.id.price);
        }

        //프로파일레이어붙히기
        for (int i=0;i<cartsNum;i++){
            basicLay.addView(profiles[i]);//프로파일레이아웃 붙힘
        }

        //수량조절 및 수량에 따른 각 항목별 총액
        int [] minitotal = new int[cartsNum];
        for (int i=0;i<cartsNum;i++){//각항목총가격초기화
            n= Integer.parseInt(numTxvs[i].getText().toString());//제품수량
            minitotal[i] = n*Integer.parseInt(prices[i].getText().toString().replace("원",""));
        }

        for (int i=0;i<cartsNum;i++){
            final int INDEX;
            INDEX = i;
            if(checkBoxes[i].isChecked()==false){
                plusBtns[i].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        n= Integer.parseInt(numTxvs[INDEX].getText().toString());//제품수량
                        n+=1;
                        numTxvs[INDEX].setText(Integer.toString(n));
                        minitotal[INDEX] = n*Integer.parseInt(prices[INDEX].getText().toString().replace("원",""));
                    }
                });
                minusBtns[i].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        int n= Integer.parseInt(numTxvs[INDEX].getText().toString());//제품수량
                        if (n>1){
                            n-=1;
                            numTxvs[INDEX].setText(Integer.toString(n));
                            minitotal[INDEX] = n*Integer.parseInt(prices[INDEX].getText().toString().replace("원",""));
                        }
                    }
                });
            }else{
                plusBtns[i].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(getApplicationContext(),"체크를 해제 후 수정해주세요.",Toast.LENGTH_SHORT).show();
                    }
                });
                minusBtns[i].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(getApplicationContext(),"체크를 해제 후 수정해주세요.",Toast.LENGTH_SHORT).show();
                    }
                });
            }
        }


        //전체선택
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

        // 총 상품가격입력
        tprice = (TextView) findViewById(R.id.tprice);
        total = (TextView) findViewById(R.id.total);
        for (int i=0;i<cartsNum;i++){
            final int INDEX;
            INDEX = i;
            checkBoxes[i].setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                    if (b==true){
                        unDcPrice += minitotal[INDEX];
                        //unDcPrice +=Integer.parseInt(prices[INDEX].getText().toString().replace("원",""));
                        tprice.setText(Integer.toString(unDcPrice));
                        total.setText(Integer.toString(unDcPrice));
                    }else{
                        unDcPrice -= minitotal[INDEX];
                        //unDcPrice -=Integer.parseInt(prices[INDEX].getText().toString().replace("원",""));
                        tprice.setText(Integer.toString(0));
                        total.setText(Integer.toString(0));
                    }
                }
            });
        }

        //주문하기버튼이벤트
        Intent goOrder = new Intent(getApplicationContext(),Order.class);
        orderBtn = (Button) findViewById(R.id.orderBtn);
        orderBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(goOrder);
            }
        });

    }
}