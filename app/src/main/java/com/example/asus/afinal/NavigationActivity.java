package com.example.asus.afinal;

import android.annotation.SuppressLint;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.Spinner;

import com.example.asus.afinal.Fragment.AboutFragment;
import com.example.asus.afinal.Fragment.AllIndiaTestFragment;
import com.example.asus.afinal.Fragment.AnalysisFragment;
import com.example.asus.afinal.Fragment.DoubtsFragment;
import com.example.asus.afinal.Fragment.HelpFragment;
import com.example.asus.afinal.Fragment.HomeFragment;
import com.example.asus.afinal.Fragment.JoinPlusFragment;
import com.example.asus.afinal.Fragment.LanguageFragment;
import com.example.asus.afinal.Fragment.MyBookmarksFragment;
import com.example.asus.afinal.Fragment.MyPurchaseFragment;
import com.example.asus.afinal.Fragment.NightModeFragment;
import com.example.asus.afinal.Fragment.ProfileFragment;
import com.example.asus.afinal.Fragment.RecentlyViewedFragment;
import com.example.asus.afinal.Fragment.SettingsFragment;
import com.example.asus.afinal.Fragment.ShareAppFragment;
import com.example.asus.afinal.Fragment.TestFragment;

import java.util.ArrayList;
import java.util.List;

public class NavigationActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener,BottomNavigationView.OnNavigationItemSelectedListener, Tab1.OnFragmentInteractionListener,Tab2.OnFragmentInteractionListener,Tab3.OnFragmentInteractionListener{

    private DrawerLayout drawer ;
    Spinner spinner;
    @SuppressLint("WrongConstant")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);
        setTitle(" ");
        android.support.v7.widget.Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        spinner =(Spinner)findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.spinner_list_item_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

//        final List<String> list = new ArrayList<String>();
//        list.add("Select Exam");
//        list.add("JEE Main");
//        list.add("JEE Advanced");
//        list.add("NEET");
//
//        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,list);
//        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        spinner.setAdapter(arrayAdapter);
//        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
//                spinner.setSelection(i);
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> parent) {
//
//            }
//        });

        FrameLayout fragment_container = (FrameLayout) findViewById(R.id.fragment_container);
        fragment_container.setVisibility(View.VISIBLE);
        drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        BottomNavigationView navigation =  findViewById(R.id.bottom_navigation);
        BottomNavigationViewHelper.removeShiftMode(navigation);
        navigation.setOnNavigationItemSelectedListener(this);


        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,drawer,toolbar,R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new HomeFragment()).commit();
            navigationView.setCheckedItem(R.id.home);
        }
    }



        @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)){
            drawer.closeDrawer(GravityCompat.START);
        }else {
            super.onBackPressed();
        }
    }
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.change_Language:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new LanguageFragment()).commit();
                break;
            case R.id.join_plus:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new JoinPlusFragment()).commit();
                break;
            case R.id.my_purchase:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new MyPurchaseFragment()).commit();
                break;
            case R.id.all_india_tests:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new AllIndiaTestFragment()).commit();
                break;
            case R.id.my_bookmarks:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new MyBookmarksFragment()).commit();
                break;
            case R.id.recently_viewed:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new RecentlyViewedFragment()).commit();
                break;
            case R.id.night_mode:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new NightModeFragment()).commit();
                break;
            case R.id.settings:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new SettingsFragment()).commit();
                break;
            case R.id.share_app:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new ShareAppFragment()).commit();
                break;
            case R.id.help:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new HelpFragment()).commit();
                break;
            case R.id.about:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new AboutFragment()).commit();
                break;
            case R.id.navigation_Home:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new HomeFragment()).commit();
                break;

            case R.id.navigation_Analysis:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new AnalysisFragment()).commit();
                break;

            case R.id.navigation_Test:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new TestFragment()).commit();
                break;

            case R.id.navigation_Doubts:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new DoubtsFragment()).commit();
                break;

            case R.id.navigation_Profile:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new ProfileFragment()).commit();
                break;

        }
        drawer.closeDrawer(GravityCompat.START);

        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.nav_item, menu);
        return true;
    }
    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }

    @Override
    public void onFragmentInteraction(Uri uri) {
    }
}
