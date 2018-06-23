package com.example.asus.afinal;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.asus.afinal.Fragment.Job_Bookmark;
import com.example.asus.afinal.Fragment.Current_Affairs_Bookmark;
import com.example.asus.afinal.Fragment.News_Bookmark;

public class BookmarkAdapter extends FragmentPagerAdapter {

    int mNoofTabs;
    public BookmarkAdapter(FragmentManager fm, int NumberOfTabs) {

        super(fm);
        this.mNoofTabs = NumberOfTabs;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position)
        {
            case 0:
                return new Job_Bookmark();
            case 1:
                return new Current_Affairs_Bookmark();
            case 2:
                return new News_Bookmark();
        }
        return null;
    }

    @Override
    public int getCount() {
        return mNoofTabs;
    }
}
