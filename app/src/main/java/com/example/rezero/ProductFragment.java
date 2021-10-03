package com.example.rezero;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ProductFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ProductFragment extends Fragment implements SortBtnBottomSheetDialog.BottomSheetListener{

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ProductFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ProductFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ProductFragment newInstance(String param1, String param2) {
        ProductFragment fragment = new ProductFragment();
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

    private View view,view1;

    public static int selectedBtnId=0;

    static Context context;

    Button btnOK;



    private LinearLayout sortBtn,categoryBtn,priceSortBtn;
    // 세로줄수 - colum 가로줄수 - dataNum/colum
    TableLayout table;
    int colum=3;
    int dataNum=30;

    View[] v= new View[dataNum];

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        this.context = getContext();
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_product, container, false);


        sortBtn = (LinearLayout) view.findViewById(R.id.sortBtn);
        categoryBtn = (LinearLayout) view.findViewById(R.id.categoryBtn);
        priceSortBtn=(LinearLayout)view.findViewById(R.id.priceSortBtn);

        sortBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ProductFragment.selectedBtnId=R.id.sortBtn;
                SortBtnBottomSheetDialog bottomSheetDialog = new SortBtnBottomSheetDialog();
                bottomSheetDialog.show(getFragmentManager(), "exampleBottomSheet");

            }
        });
        categoryBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ProductFragment.selectedBtnId=R.id.categoryBtn;
                SortBtnBottomSheetDialog bottomSheetDialog = new SortBtnBottomSheetDialog();
                bottomSheetDialog.show(getFragmentManager(), "exampleBottomSheet");

            }
        });
        priceSortBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ProductFragment.selectedBtnId=R.id.priceSortBtn;
                SortBtnBottomSheetDialog bottomSheetDialog = new SortBtnBottomSheetDialog();
                bottomSheetDialog.show(getFragmentManager(), "exampleBottomSheet");

            }
        });


        //상품관련 - 부착 클릭이벤트
        {
            LinearLayout linearTable = (LinearLayout)view.findViewById(R.id.linearTable);
            LayoutInflater mInflater = (LayoutInflater) getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            for (int i=0;i<dataNum;i++){
                v[i] = mInflater.inflate(R.layout.product_view, null);

            }

            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 0);
            params.weight=1;
            LinearLayout.LayoutParams params2 = new LinearLayout.LayoutParams(0, 550);
            params2.weight=1;
            params2.setMargins(10,0,10,0);

            int n=0;
            for (int i=0;i<dataNum/colum;i++){
                LinearLayout layout = new LinearLayout(getContext());
                layout.setGravity(Gravity.CENTER);
                layout.setLayoutParams(params);
                for (int j=0;j<colum;j++){//3까지
                    v[n].setLayoutParams(params2);
                    layout.addView(v[n]);
                    n +=1 ;
                }
                linearTable.addView(layout);
            }

            Intent intentP = new Intent(view.getContext(), SelectProduct.class);

            for (int i=0;i<dataNum;i++){
                v[i].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        startActivity(intentP);
                    }
                });
            }
        }

        /*// 테이블 생성
        table = (TableLayout) view.findViewById(R.id.table_product);

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
            }
        }
        for(int i=0;i<dataNum/colum;i++){
            table.addView(tableRow[i]);
        }*/


        return view;
    }

    // SortBtnBottomSheetDialog 인터페이스 메소드
    @Override
    public void onButtonClicked(String text) {

    }

}