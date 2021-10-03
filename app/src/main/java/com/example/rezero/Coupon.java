package com.example.rezero;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

public class Coupon extends AppCompatActivity {

    private ImageButton coupon_btn1, coupon_btn2, coupon_btn3;
    private int coupon_num1 = 0, coupon_num2 = 0, coupon_num3 = 0;
    private ImageView back;

    private int id = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coupon);

        // 뒤로가기
        back = (ImageView) findViewById(R.id.backBtn);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        coupon_btn1 = (ImageButton)findViewById(R.id.coupon_btn1);
        coupon_btn2 = (ImageButton)findViewById(R.id.coupon_btn2);
        coupon_btn3 = (ImageButton)findViewById(R.id.coupon_btn3);
    }

    // 버튼 토스트 팝업
    public void onCouponClick1(View v){
        if(coupon_num1 == 0) {
            Toast.makeText(this, "쿠폰을 다운받았습니다.", Toast.LENGTH_SHORT).show();
            coupon_num1++;
            return;
        }
        Toast.makeText(this, "이미 다운받은 쿠폰입니다.", Toast.LENGTH_SHORT).show();
    }
    public void onCouponClick2(View v){
        if(coupon_num2 == 0) {
            Toast.makeText(this, "쿠폰을 다운받았습니다.", Toast.LENGTH_SHORT).show();
            coupon_num2++;
            return;
        }
        Toast.makeText(this, "이미 다운받은 쿠폰입니다.", Toast.LENGTH_SHORT).show();
    }
    public void onCouponClick3(View v){
        if(coupon_num3 == 0) {
            Toast.makeText(this, "쿠폰을 다운받았습니다.", Toast.LENGTH_SHORT).show();
            coupon_num3++;
            return;
        }
        Toast.makeText(this, "이미 다운받은 쿠폰입니다.", Toast.LENGTH_SHORT).show();
    }
}