package com.example.rezero;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.SimpleExpandableListAdapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BuyBtnBottomSheetDialog extends BottomSheetDialogFragment {

    View view;

    private static final String NAME = "NAME";



    private ExpandableListView listView;



    private String group[] = {"옵션1" /*, "Data Process Team"*/};
    private String[][] child = { { "1", "2","3","4" } /*,{ "Alice", "David" }*/ };


    ImageButton closeBtn;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.activity_buy_btn_bottom_sheet, container, false);

        //확장리스트뷰
        {
            Display newDisplay = getActivity().getWindowManager().getDefaultDisplay();
            int width = newDisplay.getWidth();

            ArrayList<myGroup> DataList = new ArrayList<myGroup>();
            listView = (ExpandableListView)view.findViewById(R.id.mylist);
            myGroup temp = new myGroup("option1");
            temp.child.add("1");
            temp.child.add("2");
            temp.child.add("3");
            temp.child.add("4");
            DataList.add(temp);
            temp = new myGroup("option2");
            temp.child.add("1");
            temp.child.add("2");
            temp.child.add("3");
            temp.child.add("4");
            DataList.add(temp);

            ExpandAdapter adapter = new ExpandAdapter(getContext().getApplicationContext(),R.layout.group_row,R.layout.child_row,DataList);
            listView.setIndicatorBounds(width-400, width); //이 코드를 지우면 화살표 위치가 바뀐다.
            listView.setAdapter(adapter);
        }

        //닫기버튼
        {
            closeBtn = (ImageButton) view.findViewById(R.id.closeBtn);
            closeBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    dismiss();
                }
            });
        }


        return view;
    }
    // 부모 액티비티와 연결하기위한 인터페이스
    public interface BottomSheetListener {
        void onButtonClicked(String text);
    }
}
