package com.example.sys.animation;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class Tabed_adaptor extends FragmentPagerAdapter {
    private Context myContext;
    int totalTabs;

    public Tabed_adaptor(Context context, FragmentManager fm, int totalTabs) {
        super(fm);
        myContext = context;
        this.totalTabs = totalTabs;
    }

    // this is for fragment tabs
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                Home_fragment homeFragment = new Home_fragment();
                return homeFragment;
            case 1:
                Sports_fragment sportFragment = new Sports_fragment();
                return sportFragment;
            case 2:
                Movie_fragment movieFragment = new Movie_fragment();
                return movieFragment;
            default:
                return null;
        }
    }

    // this counts total number of tabs
    @Override
    public int getCount() {
        return totalTabs;
    }
}
