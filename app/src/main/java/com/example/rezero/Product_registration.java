package com.example.rezero;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

public class Product_registration extends AppCompatActivity {

    private ViewPager Photo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_registration);
        Photo = (ViewPager)findViewById(R.id.Photo);
        PageAdapter mContentsPagerAdapter = new PageAdapter(getSupportFragmentManager(),2);
        Photo.setAdapter(mContentsPagerAdapter);
    }
}