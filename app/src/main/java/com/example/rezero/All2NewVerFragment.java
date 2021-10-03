package com.example.rezero;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

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

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link All2NewVerFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class All2NewVerFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public All2NewVerFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment All2NewVerFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static All2NewVerFragment newInstance(String param1, String param2) {
        All2NewVerFragment fragment = new All2NewVerFragment();
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

    View[] v = new View[dataNum];

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        this.context = getContext();

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

        return view;
    }
}