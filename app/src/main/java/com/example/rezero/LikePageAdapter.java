package com.example.rezero;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class LikePageAdapter extends FragmentStatePagerAdapter {

    private int count;

    public LikePageAdapter(FragmentManager fm, int count) {
        super(fm);
        this.count = count;
    }

    @Override
    public Fragment getItem(int position) {
        switch (count){
            case 1:
                AllFragment3 likeFragment = new AllFragment3();
                return likeFragment;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return count;
    }
}
