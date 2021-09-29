package com.example.rezero;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Toast;

public class Drequest  {

    private Context context;

    public Drequest(Context context) {
        this.context = context;
    }
    // 호출할 다이얼로그 함수를 정의한다.
    public void callFunction(final Button btn) {

        // 커스텀 다이얼로그를 정의하기위해 Dialog클래스를 생성한다.
        final Dialog dlg = new Dialog(context);

        // 액티비티의 타이틀바를 숨긴다.
        //dlg.requestWindowFeature(Window.FEATURE_NO_TITLE);

        // 커스텀 다이얼로그의 레이아웃을 설정한다.
        dlg.setContentView(R.layout.activity_request);

        // 커스텀 다이얼로그를 노출한다.
        dlg.show();

        // 커스텀 다이얼로그의 각 위젯들을 정의한다.
        final RadioGroup radioGroup = (RadioGroup)dlg.findViewById(R.id.dgroup);
        final Button ok = (Button)dlg.findViewById(R.id.okbtn);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i){
                    case (R.id.ra0):
                        btn.setText("    부재시 경비실에 맡겨주세요.");break;
                    case (R.id.ra1):
                        btn.setText("    부재 시 집 앞에 놔주세요.");break;
                    case (R.id.ra2):
                        btn.setText("    택배함에 놔주세요.");break;
                    case  (R.id.ra3):
                        btn.setText("    배송 전에 연락주세요.");break;
                }
            }
        });

        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dlg.dismiss();
            }
        });

    }
}