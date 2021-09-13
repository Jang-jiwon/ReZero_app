package com.example.rezero;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

import me.relex.circleindicator.CircleIndicator;


public class TodayFragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    GridLayout gridLayout;
    ViewPager pagerBanner;
    CircleIndicator indicator;
    LinearLayout basicLay;


    // 세로줄수 - colum 가로줄수 - dataNum/colum
    TableLayout table;
    int colum=2;
    int dataNum=20;


    public TodayFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment AllFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static TodayFragment newInstance(String param1, String param2) {
        TodayFragment fragment = new TodayFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }


    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        View view = inflater.inflate(R.layout.fragment_today, container, false);

        Intent intentP = new Intent(view.getContext(), SelectProduct.class);


//        GridLayout gridLayout = (GridLayout) view.findViewById(R.id.gridLayout);

        ViewPager viewPager = (ViewPager) view.findViewById(R.id.pagerBanner);
        CircleIndicator indicator = (CircleIndicator)view.findViewById(R.id.indicator);
        BannerAdapter adapter = new BannerAdapter(getChildFragmentManager());//탭레이아웃대신 서클 인디케이터
        viewPager.setAdapter(adapter);
        indicator.setViewPager(viewPager);


        // 테이블 생성
        table = (TableLayout) view.findViewById(R.id.table);

        //TableRow tableRow = new TableRow(this);
        TableRow[] tableRow = new TableRow[dataNum/colum];
        for (int i=0; i<dataNum/colum;i++){
            tableRow[i] = new TableRow(getContext());
            tableRow[i].setPadding(10,10,10,10);
            tableRow[i].setLayoutParams(new TableRow.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT));
        }


        RelativeLayout.LayoutParams likeBtnParams = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        for(int i = 0 ; i <(dataNum/colum) ; i++) {
            for (int j=0;j<colum;j++){
                //렐러티브레이아웃크기조정을위한 리니어
                LinearLayout lilay= new LinearLayout(getContext());
                lilay.setPadding(10,10,10,10);
                lilay.setGravity(Gravity.CENTER);
                lilay.setOrientation(LinearLayout.VERTICAL);
                //제품이미지배경레이어
                RelativeLayout ry = new RelativeLayout(getContext());
                ry.setPadding(5,5,20,10);
                ry.setLayoutParams(new RelativeLayout.LayoutParams(300,300));
                // 여기에 사진백그라운드로부착
                ry.setBackground(getResources().getDrawable(R.drawable.eximg));
                //좋이여버튼생성
                CheckBox likeBtn = new CheckBox(getContext());
                likeBtn.setButtonDrawable(R.drawable.custom_checkbox);
                likeBtn.setBackgroundColor(Color.TRANSPARENT);
                likeBtn.setLayoutParams(likeBtnParams);
                likeBtnParams.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
                likeBtnParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
                //좋아요버튼부착
                ry.addView(likeBtn);
                //상품명이랑가격
                TextView pName= new TextView(getContext());
                pName.setText("상품명");
                pName.setTextColor(Color.parseColor("#263959"));
                pName.setGravity(Gravity.CENTER);
                TextView pPrice= new TextView(getContext());
                pPrice.setText("가격");
                pPrice.setTextColor(Color.parseColor("#263959"));
                pPrice.setGravity(Gravity.CENTER);
                lilay.addView(ry);
                lilay.addView(pName);
                lilay.addView(pPrice);
                tableRow[i].addView(lilay);
                tableRow[i].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        startActivity(intentP);
                    }
                });
            }
        }
        for(int i=0;i<dataNum/colum;i++){
            table.addView(tableRow[i]);
        }

        return view;
    }


}
