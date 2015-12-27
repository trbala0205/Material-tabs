package com.bala.scrollablematerialtab;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.bala.scrollablematerialtab.fragments.EightFragment;
import com.bala.scrollablematerialtab.fragments.FiveFragment;
import com.bala.scrollablematerialtab.fragments.FourFragment;
import com.bala.scrollablematerialtab.fragments.NineFragment;
import com.bala.scrollablematerialtab.fragments.OneFragment;
import com.bala.scrollablematerialtab.fragments.SevenFragment;
import com.bala.scrollablematerialtab.fragments.SixFragment;
import com.bala.scrollablematerialtab.fragments.TenFragment;
import com.bala.scrollablematerialtab.fragments.ThreeFragment;
import com.bala.scrollablematerialtab.fragments.TwoFragment;

public class ScrollableTabsActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrollable_tabs);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        viewPager = (ViewPager) findViewById(R.id.viewpager);
        setupViewPager(viewPager);

        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFrag(new OneFragment(), "TAB ONE");
        adapter.addFrag(new TwoFragment(), "TAB TWO");
        adapter.addFrag(new ThreeFragment(), "TAB THREE");
        adapter.addFrag(new FourFragment(), "TAB FOUR");
        adapter.addFrag(new FiveFragment(), "TAB FIVE");
        adapter.addFrag(new SixFragment(), "TAB SIX");
        adapter.addFrag(new SevenFragment(), "TAB SEVEN");
        adapter.addFrag(new EightFragment(), "TAB EIGHT");
        adapter.addFrag(new NineFragment(), "TAB NINE");
        adapter.addFrag(new TenFragment(), "TAB TEN");
        viewPager.setAdapter(adapter);
    }

    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFrag(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }
}