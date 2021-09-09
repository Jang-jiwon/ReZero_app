package com.example.rezero;


import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;


public class SortBtnBottomSheetDialog extends BottomSheetDialogFragment {

    static Context context;//즐겨찾기위해
    // 초기변수 설정
    private View view;
    // 인터페이스 변수
    private BottomSheetListener mListener;
    // 바텀시트 숨기기 버튼
    private Button btn_hide_bt_sheet,okCategory,okPricesort;

    //카테고리버튼 아이디들
    int[] radioIDs = {R.id.allBtn,R.id.kitchenBBtn,R.id.bathBBtn,R.id.livingBBtn,R.id.pencyBBtn,R.id.bookBBtn,R.id.foodBBtn,
            R.id.cosmBBtn,R.id.petBBtn,R.id.womanBBtn};

    //라디오그룹
    RadioGroup radioGCa ;

    //카테고리라디오버튼배열
    RadioButton[] radioBtns = new RadioButton[radioIDs.length];

    //가격순버튼 아이디들
    int[] priceIDs = {R.id.allBBth_pri,R.id.under_1,R.id.above_1,R.id.above_2,R.id.above_3,R.id.above_4,R.id.above_5};

    //가격순체크박스배열
    RadioButton[] prices = new RadioButton[priceIDs.length];

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        //ProductFragment.java에서 눌린 버튼아이디 받기
        //그아이디가 인기순버튼일경우 sort_btnbottom_sheet를 view로 인플레이트하기
        //그아이디가 카테고리일경우 view를 카테고리 바텀시트로 인플레이트하기


        if(ProductFragment.selectedBtnId== R.id.sortBtn){//인기순 눌럿을경우
            view = inflater.inflate(R.layout.sort_btn_bottom_sheet, container, false);
            btn_hide_bt_sheet = view.findViewById(R.id.btn_hide_bt_sheet);
            btn_hide_bt_sheet.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dismiss();
                }
            });
            return view;
        }else if (ProductFragment.selectedBtnId== R.id.categoryBtn){//카테고리눌럿을경우
            view = inflater.inflate(R.layout.category_btn_bottom_sheet, container, false);
            for(int i=0;i< radioIDs.length;i++){
                radioBtns[i] = (RadioButton) view.findViewById(radioIDs[i]);
                radioBtns[i].setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                        if (b==true){
                            compoundButton.setTextColor(Color.WHITE);
                        }else {
                            compoundButton.setTextColor(Color.parseColor("#6D819C"));
                        }
                    }
                });
            }
            /*//카테고리의 체크박스들 객체생성
            for(int i=0;i<cateIDs.length;i++){
                cates[i] = (CheckBox) view.findViewById(cateIDs[i]);
            }
            //체크박스별 체크이벤트
            for (int i=0;i<cateIDs.length;i++){
                cates[i].setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                        if (b==true){
                            compoundButton.setTextColor(Color.WHITE);
                        }else {
                            compoundButton.setTextColor(Color.parseColor("#6D819C"));
                        }
                    }
                });
            }*/
            //확인버튼
            okCategory = view.findViewById(R.id.okCategory);
            okCategory.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dismiss();
                }
            });
            return view;
        }else if(ProductFragment.selectedBtnId== R.id.priceSortBtn){//가격순눌럿을경우
            view = inflater.inflate(R.layout.pricesort_btn_bottom_sheet, container, false);
            //가격대버튼객체생성
            for(int i=0;i<priceIDs.length;i++){
                prices[i] = (RadioButton) view.findViewById(priceIDs[i]);
            }
            //가격대버튼별이벤트
            for (int i=0;i<priceIDs.length;i++){
                prices[i].setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                        if (b==true){
                            compoundButton.setTextColor(Color.WHITE);
                        }else {
                            compoundButton.setTextColor(Color.parseColor("#6D819C"));
                        }
                    }
                });
            }
            //확인버튼
            okPricesort = view.findViewById(R.id.okPricesort);
            okPricesort.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dismiss();
                }
            });
            return view;
        }

        return inflater.inflate(R.layout.fragment_product, container, false);//프로덕트프래그먼트에서 제대로 정보못받앗을때
    }
    // 부모 액티비티와 연결하기위한 인터페이스
    public interface BottomSheetListener {
        void onButtonClicked(String text);
    }



}
