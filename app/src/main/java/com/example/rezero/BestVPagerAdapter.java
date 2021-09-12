package com.example.rezero;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;


public class BestVPagerAdapter extends FragmentStatePagerAdapter {
    private int mPageCount;

    public BestVPagerAdapter(FragmentManager fm, int pageCount) {
        super(fm);
        this.mPageCount = pageCount;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                AllFragment2 allFragment2 = new AllFragment2();
                return allFragment2;
            case 1:
                KitchenFragment kitchenFragment = new KitchenFragment();
                return kitchenFragment;
            case 2:
                BathFragment bathFragment = new BathFragment();
                return bathFragment;
            case 3:
                LivingFragment livingFragment = new LivingFragment();
                return livingFragment;
            case 4:
                PencyFragment pencyFragment = new PencyFragment();
                return pencyFragment;
            case 5:
                BookFragment bookFragment = new BookFragment();
                return bookFragment;
            case 6:
                FoodFragment foodFragment = new FoodFragment();
                return foodFragment;
            case 7:
                CosFragment cosFragment = new CosFragment();
                return cosFragment;
            case 8:
                PetFragment petFragment = new PetFragment();
                return petFragment;
            case 9:
                WomanFragment womanFragment = new WomanFragment();
                return womanFragment;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mPageCount;
    }

}