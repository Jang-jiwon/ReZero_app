package com.example.rezero;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

// 로그인 > 아이디/비밀번호 찾기 fragment 어댑터
public class login_find_fragment_adapter extends FragmentPagerAdapter {

    private List<Fragment> fragmentList = new ArrayList<>();

    public login_find_fragment_adapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    public void addFragment(Fragment fragment) {
        fragmentList.add(fragment);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }
}

