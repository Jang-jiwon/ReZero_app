package com.example.rezero;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AllFragment2#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AllFragment3 extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public AllFragment3() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment AllFragment2.
     */
    // TODO: Rename and change types and number of parameters
    public static AllFragment3 newInstance(String param1, String param2) {
        AllFragment3 fragment = new AllFragment3();
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

    private View view;

    static Context context;

    // 세로줄수 - column 가로줄수 - dataNum/column
    TableLayout table;
    int column = 2;
    int dataNum = 20;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        this.context = getContext();
        view = inflater.inflate(R.layout.fragment_all2, container, false);


        // 테이블 생성
        table = (TableLayout) view.findViewById(R.id.table_product);

        //TableRow tableRow = new TableRow(this);
        TableRow[] tableRow = new TableRow[dataNum/column];
        for (int i=0; i<dataNum/column;i++){
            tableRow[i] = new TableRow(getContext());
            tableRow[i].setPadding(10,10,10,10);
            tableRow[i].setLayoutParams(new TableRow.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT));
        }


        int r=1;
        RelativeLayout.LayoutParams likeBtnParams = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        for(int i = 0 ; i <(dataNum/column) ; i++) {
            for (int j=0;j<column;j++){
                //렐러티브레이아웃크기조정을위한 리니어
                LinearLayout lilay= new LinearLayout(getContext());
                lilay.setGravity(Gravity.CENTER);
                lilay.setOrientation(LinearLayout.VERTICAL);
                //제품이미지배경레이어
                RelativeLayout ry = new RelativeLayout(getContext());
                ry.setPadding(5,5,20,20);
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
                //순위
                TextView rank = new TextView(getContext());
                rank.setText( Integer.toString(r));
                rank.setTextColor(Color.parseColor("#55967E"));
                rank.setPadding(120,5,0,5);
                //슬라이스바
                ImageView s = new ImageView(getContext());
                s.setImageDrawable(getResources().getDrawable(R.drawable.customsbar));
                s.setScaleType(ImageView.ScaleType.FIT_CENTER);
                //상품명이랑가격
                TextView pName= new TextView(getContext());
                pName.setText("상품명");
                pName.setTextSize(18);
                pName.setTextColor(Color.parseColor("#263959"));
                pName.setPadding(115,5,0,5);
                TextView pPrice= new TextView(getContext());
                pPrice.setText("가격");
                pPrice.setTextSize(14);
                pPrice.setTextColor(Color.parseColor("#6D819C"));
                pPrice.setPadding(120,5,0,5);
                lilay.addView(ry);
                lilay.addView(rank);
                lilay.addView(s);
                lilay.addView(pName);
                lilay.addView(pPrice);
                tableRow[i].addView(lilay);
                r += 1;
            }
        }
        for(int i=0;i<dataNum/column;i++){
            table.addView(tableRow[i]);
        }

        return view;
    }
}