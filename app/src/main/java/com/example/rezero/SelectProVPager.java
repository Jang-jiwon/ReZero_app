package com.example.rezero;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class SelectProVPager extends FragmentStatePagerAdapter {
    private int mPageCount;

    public SelectProVPager(FragmentManager fm, int pageCount) {
        super(fm);
        this.mPageCount = pageCount;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                DetailFragment detailFragment = new DetailFragment();
                return detailFragment;
            case 1:
                ReviewFragment reviewFragment = new ReviewFragment();
                return reviewFragment;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mPageCount;
    }
}
