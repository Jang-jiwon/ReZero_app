package com.example.rezero;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ScrollView;
import android.widget.Toast;

import me.relex.circleindicator.CircleIndicator;

public class SelectProduct extends AppCompatActivity {
    ScrollView scroll;

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_product);
        /*ViewPager viewPager = (ViewPager) findViewById(R.id.pagerBanner);
        CircleIndicator indicator = (CircleIndicator)findViewById(R.id.indicator);
        ProductImgAdapter adapter = new ProductImgAdapter(getSupportFragmentManager());//탭레이아웃대신 서클 인디케이터
        viewPager.setAdapter(adapter);
        indicator.setViewPager(viewPager);*/


    }
}