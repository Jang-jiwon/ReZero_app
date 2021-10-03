package com.example.rezero;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

public class login_find_activity extends AppCompatActivity {

    private static final String TAG = "login_find_activity";
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private login_find_fragment_adapter adapter;
    private ImageView back;

    public static Context mContext;


    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_find); //레이아웃에서 띄울 xml 화면 선택 - 이거 바꾸기 delete는 지우고!!

        /* 1. 탭 */
        //대입
        tabLayout = findViewById(R.id.tabs);
        viewPager = findViewById(R.id.view_pager);
        adapter = new login_find_fragment_adapter(getSupportFragmentManager(), 1);

        //FragmentAdapter에 아이디랑 비밀번호 화면 (컬렉션) 달기
        adapter.addFragment(new login_find_id());
        adapter.addFragment(new login_find_pwd());

        //ViewPager - Fragment 연결
        viewPager.setAdapter(adapter);

        //ViewPager과 TabLayout 연결
        tabLayout.setupWithViewPager(viewPager);

        //탭 이름 선언
        tabLayout.getTabAt(0).setText("아이디");
        tabLayout.getTabAt(1).setText("비밀번호");


        /* 2. 뒤로 가기 구현 */

        back = (ImageView) findViewById(R.id.login_find_image_back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                onBackPressed();
            }
        });

        /* 비밀번호 탭으로 전환 하기 위해 빌드업 */
        mContext = this;

    }

    /* 3.  비밀번호 탭으로 전환 함수 구현 */
    public void TabTransition()
    {
        viewPager.setCurrentItem(1);
    }

}
