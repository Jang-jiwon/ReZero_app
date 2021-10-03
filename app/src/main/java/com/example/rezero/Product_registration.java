package com.example.rezero;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class Product_registration extends AppCompatActivity {

    private ViewPager Photo;
    Button product_explanation_write;
    private ImageView back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_registration);
        Photo = (ViewPager)findViewById(R.id.Photo);
        PageAdapter mContentsPagerAdapter = new PageAdapter(getSupportFragmentManager(),2);
        Photo.setAdapter(mContentsPagerAdapter);

        // 뒤로가기
        back = (ImageView) findViewById(R.id.backBtn);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        product_explanation_write = (Button) findViewById(R.id.product_explanation_write);
        product_explanation_write.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Product_registration.this, Product_registration_write.class);
                startActivity(intent);
            }
        });
    }
}