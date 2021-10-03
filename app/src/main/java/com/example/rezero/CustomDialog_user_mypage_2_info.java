package com.example.rezero;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.Objects;

public class CustomDialog_user_mypage_2_info extends Dialog {
    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mypage_2_info_dialog);

        // 다이얼로그의 배경을 투명으로 만든다.
        Objects.requireNonNull(getWindow()).setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        // 커스텀 다이얼로그의 각 위젯들을 정의한다.
        Button saveButton = findViewById(R.id.btnSave);

        // 버튼 리스너 설정
        saveButton.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                // '확인' 버튼 클릭시

                // Custom Dialog 종료
                dismiss();
            }
        });
    }

    public CustomDialog_user_mypage_2_info(Context mContext) {
        super(mContext);
        this.mContext = mContext;
    }

}
