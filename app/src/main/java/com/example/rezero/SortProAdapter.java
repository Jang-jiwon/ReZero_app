package com.example.rezero;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;


public class SortProAdapter extends FragmentStatePagerAdapter {
    private int mPageCount;

    public SortProAdapter(FragmentManager fm, int pageCount) {
        super(fm);
        this.mPageCount = pageCount;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                All2NewVerFragment allFragment2 = new All2NewVerFragment();
                return allFragment2;
            case 1:
                /*KitchenFragment kitchenFragment = new KitchenFragment();
                return kitchenFragment;*/
                All2NewVerFragment allFragment3 = new All2NewVerFragment();
                return allFragment3;
            case 2:
                /*BathFragment bathFragment = new BathFragment();
                return bathFragment;*/
                All2NewVerFragment allFragment4 = new All2NewVerFragment();
                return allFragment4;
            case 3:
                /*LivingFragment livingFragment = new LivingFragment();
                return livingFragment;*/
                All2NewVerFragment allFragment5 = new All2NewVerFragment();
                return allFragment5;
            case 4:
                /*PencyFragment pencyFragment = new PencyFragment();
                return pencyFragment;*/
                All2NewVerFragment allFragment6 = new All2NewVerFragment();
                return allFragment6;
            case 5:
                /*BookFragment bookFragment = new BookFragment();
                return bookFragment;*/
                All2NewVerFragment allFragment7 = new All2NewVerFragment();
                return allFragment7;
            case 6:
                /*FoodFragment foodFragment = new FoodFragment();
                return foodFragment;*/
                All2NewVerFragment allFragment8 = new All2NewVerFragment();
                return allFragment8;
            case 7:
                /*CosFragment cosFragment = new CosFragment();
                return cosFragment;*/
                All2NewVerFragment allFragment9 = new All2NewVerFragment();
                return allFragment9;
            case 8:
                /*PetFragment petFragment = new PetFragment();
                return petFragment;*/
                All2NewVerFragment allFragment10 = new All2NewVerFragment();
                return allFragment10;
            case 9:
                /*WomanFragment womanFragment = new WomanFragment();
                return womanFragment;*/
                All2NewVerFragment allFragment11 = new All2NewVerFragment();
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