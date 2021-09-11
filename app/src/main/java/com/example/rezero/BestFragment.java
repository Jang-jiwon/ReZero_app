package com.example.rezero;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.android.material.tabs.TabLayout;

public class BestFragment extends Fragment {

    private Context mContext;
    private ViewPager mViewPager;
    private TabLayout mTabLayout;

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public BestFragment() {
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
    public static BestFragment newInstance(String param1, String param2) {
        BestFragment fragment = new BestFragment();
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

    //은수화이팅ㅎ
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_best, container, false);

        //탭레이아웃
        {mTabLayout = (TabLayout) view.findViewById(R.id.layout_tab_best);

            mTabLayout.addTab(mTabLayout.newTab().setText("전체"));
            mTabLayout.addTab(mTabLayout.newTab().setText("주방"));
            mTabLayout.addTab(mTabLayout.newTab().setText("욕실"));
            mTabLayout.addTab(mTabLayout.newTab().setText("리빙"));
            mTabLayout.addTab(mTabLayout.newTab().setText("문구"));
            mTabLayout.addTab(mTabLayout.newTab().setText("책"));


            mViewPager = (ViewPager) view.findViewById(R.id.pager_content_best);
            BestVPagerAdapter mContentsPagerAdapter = new BestVPagerAdapter(
                    getChildFragmentManager(), mTabLayout.getTabCount());
            mViewPager.setAdapter(mContentsPagerAdapter);

            mViewPager.addOnPageChangeListener(
                    new TabLayout.TabLayoutOnPageChangeListener(mTabLayout));
            mTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {

                @Override
                public void onTabSelected(TabLayout.Tab tab) {
                    mViewPager.setCurrentItem(tab.getPosition());
                }

                @Override
                public void onTabUnselected(TabLayout.Tab tab) {
                }

                @Override
                public void onTabReselected(TabLayout.Tab tab) {
                }
            });}



        return view;
    }

}