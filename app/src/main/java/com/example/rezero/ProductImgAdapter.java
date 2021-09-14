package com.example.rezero;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class ProductImgAdapter extends FragmentStatePagerAdapter {

    //페이지수
    private static int NUM_ITEMS = 3;

    public ProductImgAdapter(FragmentManager fragmentManager) {
        super(fragmentManager);
    }

    // Returns total number of pages
    @Override
    public int getCount() {
        return NUM_ITEMS;
    }

    // Returns the fragment to display for that page
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0: ProductImgFragment firstBanner = new ProductImgFragment();
                return firstBanner;
            case 1:ProductImgFragment firstBanner2 = new ProductImgFragment();
                return firstBanner2;
            case 2:ProductImgFragment firstBanner3 = new ProductImgFragment();
                return firstBanner3;
            default:
                return null;
        }
    }

    // Returns the page title for the top indicator
    @Override
    public CharSequence getPageTitle(int position) {
        return "Page " + position;
    }
}
