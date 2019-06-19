package com.example.beuintern;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
ViewPager viewPager;
ArrayList<Fragment> fragmentLists;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragmentLists = new ArrayList<>();
        fragmentLists.add(new BlankFragment());
        viewPager = findViewById(R.id.viewPagerFrame);
         viewPager.setAdapter(new ViewPagerAdapter(getSupportFragmentManager(),fragmentLists));
    }
}
