package com.example.rezero;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class DesignerVpAdapter extends FragmentStatePagerAdapter {
    private int mPageCount;

    public DesignerVpAdapter(FragmentManager fm, int pageCount) {
        super(fm);
        this.mPageCount = pageCount;
    }
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                DesignerFragment designerFragment = new DesignerFragment();
                return designerFragment;
            case 1:
                LikeDesigner likeDesigner = new LikeDesigner();
                return likeDesigner;

            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mPageCount;
    }
}
