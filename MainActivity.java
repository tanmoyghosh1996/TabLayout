package com.example.root.tabview;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    TabLayout tablayout;
    ViewPager viewpager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tablayout = (TabLayout) findViewById(R.id.tablayout);
        viewpager = (ViewPager) findViewById(R.id.viewpager);
        SetViewPage(viewpager);
        tablayout.setupWithViewPager(viewpager);
    }

        private void SetViewPage(ViewPager vp){
            MyAdapter myAdapter = new MyAdapter(getSupportFragmentManager());
            myAdapter.addFragment(new Chat(), "Chat");
            myAdapter.addFragment(new Call(), "Call");
            myAdapter.addFragment(new Status(), "Status");
            vp.setAdapter(myAdapter);
    }

    class MyAdapter extends FragmentPagerAdapter{

            List<Fragment> fragmentContainer = new ArrayList<>();
            List<String> fragmentTitle = new ArrayList<>();


        public MyAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public int getCount() {
            return 3;
        }

        @Override
        public Fragment getItem(int position) {
            return fragmentContainer.get(position);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return fragmentTitle.get(position);
        }

        private void addFragment(Fragment fragment, String string){
            fragmentContainer.add(fragment);
            fragmentTitle.add(string);
        }
    }
}
