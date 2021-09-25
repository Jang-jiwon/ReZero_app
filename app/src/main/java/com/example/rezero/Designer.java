package com.example.rezero;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class Designer extends AppCompatActivity {

    private LinearLayout sortBtn,categoryBtn,priceSortBtn;
    // 세로줄수 - colum 가로줄수 - dataNum/colum
    TableLayout table;
    int colum=3;
    int dataNum=30;

    int likeNum=0;
    CheckBox likeBtn_d;
    TextView likeNumTxV;

    ImageButton backBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_designer);

        backBtn = (ImageButton)findViewById(R.id.backBtn);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        //좋아요버튼
        likeNumTxV = (TextView)findViewById(R.id.likeNum);
        likeBtn_d = (CheckBox)findViewById(R.id.likeBtn_d);
        likeBtn_d.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b==true){
                    likeNum +=1;
                    likeNumTxV.setText(Integer.toString(likeNum));
                }else {
                    likeNum -=1;
                    likeNumTxV.setText(Integer.toString(likeNum));
                }
            }
        });


        //바텀시트
        sortBtn = (LinearLayout) findViewById(R.id.sortBtn);
        categoryBtn = (LinearLayout) findViewById(R.id.categoryBtn);
        priceSortBtn=(LinearLayout) findViewById(R.id.priceSortBtn);

        sortBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ProductFragment.selectedBtnId=R.id.sortBtn;
                SortBtnBottomSheetDialog bottomSheetDialog = new SortBtnBottomSheetDialog();
                bottomSheetDialog.show(getSupportFragmentManager(), "exampleBottomSheet");

            }
        });
        categoryBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ProductFragment.selectedBtnId=R.id.categoryBtn;
                SortBtnBottomSheetDialog bottomSheetDialog = new SortBtnBottomSheetDialog();
                bottomSheetDialog.show(getSupportFragmentManager(), "exampleBottomSheet");

            }
        });
        priceSortBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ProductFragment.selectedBtnId=R.id.priceSortBtn;
                SortBtnBottomSheetDialog bottomSheetDialog = new SortBtnBottomSheetDialog();
                bottomSheetDialog.show(getSupportFragmentManager(), "exampleBottomSheet");

            }
        });

        // 테이블 생성
        table = (TableLayout) findViewById(R.id.table_product);
        TableRow[] tableRow = new TableRow[dataNum/colum];
        for (int i=0; i<dataNum/colum;i++){
            tableRow[i] = new TableRow(this);
            tableRow[i].setPadding(10,10,10,10);
            tableRow[i].setLayoutParams(new TableRow.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT));
        }
        RelativeLayout.LayoutParams likeBtnParams = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        for(int i = 0 ; i <(dataNum/colum) ; i++) {
            for (int j=0;j<colum;j++){
                //렐러티브레이아웃크기조정을위한 리니어
                LinearLayout lilay= new LinearLayout(this);
                lilay.setPadding(10,10,10,10);
                lilay.setGravity(Gravity.CENTER);
                lilay.setOrientation(LinearLayout.VERTICAL);
                //제품이미지배경레이어
                RelativeLayout ry = new RelativeLayout(this);
                ry.setPadding(5,5,20,10);
                ry.setLayoutParams(new RelativeLayout.LayoutParams(280,300));
                // 여기에 사진백그라운드로부착
                ry.setBackground(getResources().getDrawable(R.drawable.eximg));
                //좋이여버튼생성
                CheckBox likeBtn = new CheckBox(this);
                likeBtn.setButtonDrawable(R.drawable.custom_checkbox);
                likeBtn.setBackgroundColor(Color.TRANSPARENT);
                likeBtn.setLayoutParams(likeBtnParams);
                likeBtnParams.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
                likeBtnParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
                //좋아요버튼부착
                ry.addView(likeBtn);
                //상품명이랑가격
                TextView pName= new TextView(this);
                pName.setText("상품명");
                pName.setTextColor(Color.parseColor("#263959"));
                pName.setGravity(Gravity.CENTER);
                TextView pPrice= new TextView(this);
                pPrice.setText("가격");
                pPrice.setTextColor(Color.parseColor("#263959"));
                pPrice.setGravity(Gravity.CENTER);
                lilay.addView(ry);
                lilay.addView(pName);
                lilay.addView(pPrice);
                tableRow[i].addView(lilay);
            }
        }
        for(int i=0;i<dataNum/colum;i++){
            table.addView(tableRow[i]);
        }



    }
}