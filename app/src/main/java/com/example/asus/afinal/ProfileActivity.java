package com.example.asus.afinal;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.asus.afinal.Fragment.Upgrade;
import com.example.asus.afinal.Fragment.Add_Friends;
import com.example.asus.afinal.Fragment.ProfileFragment;

import java.util.ArrayList;
import java.util.List;

public class ProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        android.support.v7.widget.Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);




        ViewPager mViewPager = (ViewPager) findViewById(R.id.viewpager);
        ProfileAdapter mViewPagerAdapter = new ProfileAdapter(getSupportFragmentManager());
        mViewPagerAdapter.addFragment(new ProfileFragment(), "PROFILE");
        mViewPagerAdapter.addFragment(new Upgrade(), "UPGRADE");
        mViewPagerAdapter.addFragment(new Add_Friends(), "ADD FRIENDS");
        mViewPager.setAdapter(mViewPagerAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);


    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;

    }
    public class ProfileAdapter  extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();



        public ProfileAdapter(FragmentManager supportFragmentManager) {
            super(supportFragmentManager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }

}
