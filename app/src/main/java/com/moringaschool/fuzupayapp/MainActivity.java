package com.moringaschool.fuzupayapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

//import com.moringaschool.fuzupayapp.FragmentAdapter.AdapterFragment;
import com.moringaschool.fuzupayapp.HumanResource.Dashboard.DashboardActivity;
import com.moringaschool.fuzupayapp.HumanResource.Dashboard.DashboardFragment;
import com.moringaschool.fuzupayapp.HumanResource.Fragments.Leave.LeaveActivity;
import com.moringaschool.fuzupayapp.HumanResource.Fragments.Staff.StaffActivity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.moringaschool.fuzupayapp.HumanResource.Dashboard.DashboardFragment;
import com.moringaschool.fuzupayapp.HumanResource.Fragments.Leave.mainLeave;
import com.moringaschool.fuzupayapp.HumanResource.Fragments.Staff.StaffMain;

import butterknife.BindView;
import butterknife.ButterKnife;

//import com.moringaschool.fuzupayapp.FragmentAdapter.AdapterFragment;

public class MainActivity extends AppCompatActivity {
//
//    TableLayout tableLayout;
//    ViewPager2 pager2;
//    AdapterFragment adapter;


    @BindView(R.id.bottom_navigation)
BottomNavigationView bottomNavigationView;
//    @BindView(R.id.tab_layout)
//    TabLayout tableLayout;
//    @BindView(R.id.view_pager2) ViewPager2 pager2;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.nav_home);

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {


                switch (item.getItemId()) {
                    case R.id.nav_home:
                        startActivity(new Intent(getApplicationContext(), DashboardActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.nav_leave:
                        startActivity(new Intent(getApplicationContext(), LeaveActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.nav_staff:
                        startActivity(new Intent(getApplicationContext(), StaffActivity.class));
                        overridePendingTransition(0,0);
                        return true;

                }
                return false;
            }
        });

//        getSupportFragmentManager()
//        FragmentManager fm = getSupportFragmentManager();
//        adapter = new AdapterFragment(fm, getLifecycle());
//        pager2.setAdapter(adapter);
//
//        tableLayout.addTab(tableLayout.newTab().setText("All staff"));
//        tableLayout.addTab(tableLayout.newTab().setText("Department"));
//        tableLayout.addTab(tableLayout.newTab().setText("Add Staff"));
//
//        tableLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
//            @Override
//            public void onTabSelected(TabLayout.Tab tab) {
//                pager2.setCurrentItem(tab.getPosition());
//            }
//
//            @Override
//            public void onTabUnselected(TabLayout.Tab tab) {
//
//            }
//
//            @Override
//            public void onTabReselected(TabLayout.Tab tab) {
//
//            }
//        });
//
//        pager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
//            @Override
//            public void onPageSelected(int position) {
//                tableLayout.selectTab(tableLayout.getTabAt(position));
//            }
//        });
//    }
//
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        MenuInflater inflater = getMenuInflater();
//        inflater.inflate(R.menu.top_navbar,menu);
//        return true;
//    }
    }
}