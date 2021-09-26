package com.example.rezero;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

public class Order extends AppCompatActivity {


    LinearLayout orderList;

    Dialog dialog01;

    final int cartsNum=((Cart)Cart.context).cartsNum;
    View[] profiles = new View[cartsNum];
    CheckBox[] checkBoxes = new CheckBox[cartsNum];

    final int n = ((Cart)Cart.context).unDcPrice;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        ScrollView scroll = new ScrollView(this);
        LinearLayout.LayoutParams scrollP = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        scroll.setLayoutParams(scrollP);

        LinearLayout lay = new LinearLayout(this);
        LinearLayout.LayoutParams layP = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        lay.setOrientation(LinearLayout.VERTICAL);
        lay.setLayoutParams(layP);

        scroll.addView(lay);

        LayoutInflater mInflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        int n=0;//선택된 상품 개수 - for문을 돌리기위해
        //선택된 체크박스확인위해 Cart클래스의 체크박스들 가져옴
        for (int i=0;i<cartsNum;i++){
            /*checkBoxes[i] = ((Cart)Cart.context).checkBoxes[i];
            if (checkBoxes[i].isChecked() == true){
                profiles[i] = ((Cart)Cart.context).profiles[i];//체크 된 프로필만 가져오기
                lay.addView(profiles[i]);
            }*/
            profiles[i] = mInflater.inflate(R.layout.order_list_profil, null);
            lay.addView(profiles[i]);
        }


        orderList = (LinearLayout) findViewById(R.id.orderList);
        orderList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(getApplicationContext(),Integer.toString(n),Toast.LENGTH_SHORT).show();
                AlertDialog.Builder dlg = new AlertDialog.Builder(Order.this);
                dlg.setTitle("주문 목록");
                dlg.setView(scroll);
                dlg.setNegativeButton("닫기",null);
                dlg.show();
            }
        });

    }
}