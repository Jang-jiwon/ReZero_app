package com.example.rezero;

import android.content.Context;
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

    View[] v = new View[dataNum];


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
            params2.setMargins(80,0,80,0);

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
