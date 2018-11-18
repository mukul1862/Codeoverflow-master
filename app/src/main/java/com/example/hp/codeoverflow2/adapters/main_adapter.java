package com.example.hp.codeoverflow2.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.hp.codeoverflow2.fragments.article_fragment;
import com.example.hp.codeoverflow2.fragments.home_fragment;
import com.example.hp.codeoverflow2.fragments.profile_fragment;

public class main_adapter extends FragmentPagerAdapter {
    private static final String[] TITLES = {"Home", "My Articles", "Profile"};

    public main_adapter(FragmentManager fm) {
        super(fm);
    }


    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
             return new home_fragment();
            case 1:
                return new article_fragment();
            case 2:
                return new profile_fragment();
        }
        return new home_fragment();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return TITLES[position];
    }

    @Override
    public int getCount() {
        return 3;
    }
}
