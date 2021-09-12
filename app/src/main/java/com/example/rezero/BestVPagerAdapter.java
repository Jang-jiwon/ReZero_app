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
                /*KitchenFragment kitchenFragment = new KitchenFragment();
                return kitchenFragment;*/
                AllFragment2 allFragment3 = new AllFragment2();
                return allFragment3;
            case 2:
                /*BathFragment bathFragment = new BathFragment();
                return bathFragment;*/
                AllFragment2 allFragment4 = new AllFragment2();
                return allFragment4;
            case 3:
                /*LivingFragment livingFragment = new LivingFragment();
                return livingFragment;*/
                AllFragment2 allFragment5 = new AllFragment2();
                return allFragment5;
            case 4:
                /*PencyFragment pencyFragment = new PencyFragment();
                return pencyFragment;*/
                AllFragment2 allFragment6 = new AllFragment2();
                return allFragment6;
            case 5:
                /*BookFragment bookFragment = new BookFragment();
                return bookFragment;*/
                AllFragment2 allFragment7 = new AllFragment2();
                return allFragment7;
            case 6:
                /*FoodFragment foodFragment = new FoodFragment();
                return foodFragment;*/
                AllFragment2 allFragment8 = new AllFragment2();
                return allFragment8;
            case 7:
                /*CosFragment cosFragment = new CosFragment();
                return cosFragment;*/
                AllFragment2 allFragment9 = new AllFragment2();
                return allFragment9;
            case 8:
                /*PetFragment petFragment = new PetFragment();
                return petFragment;*/
                AllFragment2 allFragment10 = new AllFragment2();
                return allFragment10;
            case 9:
                /*WomanFragment womanFragment = new WomanFragment();
                return womanFragment;*/
                AllFragment2 allFragment11 = new AllFragment2();
                return allFragment11;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mPageCount;
    }

}