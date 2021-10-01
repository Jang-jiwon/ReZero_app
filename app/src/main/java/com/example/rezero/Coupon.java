package com.example.rezero;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

public class Coupon extends AppCompatActivity {

    private int id = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coupon);
    }

    // 버튼 토스트 팝업
    public void onCouponClick(View v){
        Toast.makeText(this, "쿠폰을 다운받았습니다.", Toast.LENGTH_SHORT).show();
    }
}