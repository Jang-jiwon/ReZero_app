package com.example.rezero;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

public class Order extends AppCompatActivity {


    LinearLayout orderList;

    Dialog dialog01;

    final int cartsNum=((Cart)Cart.context).cartsNum;
    View[] profiles = new View[cartsNum];
    CheckBox[] checkBoxes = new CheckBox[cartsNum];

    final int unDcPrice = ((Cart)Cart.context).unDcPrice;
    TextView totalPrice;

    TextView cartN;

    Button request,orderBtn;

    String m ;


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

        //일단 실험
        /*for (int i=0;i<cartsNum;i++){
            profiles[i] = mInflater.inflate(R.layout.order_list_profil, null);
        }
*/
        int num=0;//선택상품개수
        int[] n=new int[cartsNum];//선택된 상품 개수
        //선택된 체크박스확인위해 Cart클래스의 체크박스들 가져와서 몇번째 상품들이 구매되는지 확인
        for (int i=0;i<cartsNum;i++){
            checkBoxes[i] = ((Cart)Cart.context).checkBoxes[i];
            if(checkBoxes[i].isChecked()==true){
                n[i]=i;
                num+=1;
            }else{
                n[i]=-1;
            }
        }
        //선택된상품만 표시
        for (int i=0;i<cartsNum;i++){
            if (n[i]>=0){
                profiles[n[i]] = mInflater.inflate(R.layout.order_list_profil, null);
                lay.addView(profiles[i]);
            }
        }

        cartN = (TextView)findViewById(R.id.cartNum);
        cartN.setText(Integer.toString(num));



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

        totalPrice = (TextView) findViewById(R.id.totalPrice);
        totalPrice.setText(Integer.toString(unDcPrice));


        request = (Button) findViewById(R.id.request);
        request.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Drequest drequest = new Drequest(Order.this);
                drequest.callFunction(request);
            }
        });

        orderBtn = (Button) findViewById(R.id.orderBtn);
        orderBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goPaid = new Intent(Order.this,Paid.class);
                startActivity(goPaid);
            }
        });


    }

}