package com.example.rezero;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class PageAdapter extends FragmentStatePagerAdapter {

    private int count;

    public PageAdapter(FragmentManager fm, int count) {
        super(fm);
        this.count = count;
    }

    @Override
    public Fragment getItem(int position) {
        switch (count){
            case 1: // 찜한 화면
                AllFragment3 likeFragment = new AllFragment3();
                return likeFragment;
            case 2: // 상품 등록
                PhotoFragment photoFragment = new PhotoFragment();
                return photoFragment;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return count;
    }
}
