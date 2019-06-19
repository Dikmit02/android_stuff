package com.example.beuintern;

import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.view.View;

import java.util.ArrayList;

public class ViewPagerAdapter extends FragmentPagerAdapter {
    ArrayList<Fragment> fragments;
    public ViewPagerAdapter(FragmentManager fm, ArrayList<Fragment> fragment) {
        super(fm);
        this.fragments = fragment;
    }
    @Override
    public Fragment getItem(int i) {


                return fragments.get(i); //ChildFragment1 at position 0
    }

    @Override
    public int getCount() {
        return fragments.size();
    }
}
