package com.moringaschool.fuzupayapp.HumanResource.Fragments.Staff;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.moringaschool.fuzupayapp.HumanResource.Dashboard.DashboardActivity;
import com.moringaschool.fuzupayapp.HumanResource.Fragments.Leave.LeaveActivity;
import com.moringaschool.fuzupayapp.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class StaffActivity extends AppCompatActivity implements View.OnClickListener {
    @BindView(R.id.bottom_navigation)
    BottomNavigationView bottomNavigationView;

    @BindView(R.id.fragmentOneBtn)
    Button fragmentOneBtn;
    @BindView(R.id.fragmentTwoBtn)
    Button fragmentTwoBtn;
    @BindView(R.id.fragmentThreeBtn)
    Button fragmentThreeBtn;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_staff);
        ButterKnife.bind(this);

        fragmentTwoBtn.setOnClickListener(this);
        fragmentOneBtn.setOnClickListener(this);
        fragmentThreeBtn.setOnClickListener(this);

        bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.nav_staff);

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
                        return true;
                }
                return false;
            }
        });


    }
    @Override
    public void onStart() {
        super.onStart();
        fragmentThreeBtn.setBackgroundColor(Color.WHITE);
        fragmentTwoBtn.setBackgroundColor(Color.WHITE);
        fragmentOneBtn.setBackgroundColor(Color.rgb(0,70,115));
        fragmentTwoBtn.setTextColor(Color.BLACK);
        fragmentThreeBtn.setTextColor(Color.BLACK);
        fragmentOneBtn.setTextColor(Color.WHITE);
//        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
//        fragmentTransaction.replace(R.id.frameLayout,new AllStaff());
//        fragmentTransaction.commit();
        startActivity(new Intent(getApplicationContext(), AllStaffActivity.class));
        overridePendingTransition(0,0);


    }

    @Override
    public void onClick(View v) {

        if(v==fragmentOneBtn){
            fragmentThreeBtn.setBackgroundColor(Color.WHITE);
            fragmentTwoBtn.setBackgroundColor(Color.WHITE);
            fragmentOneBtn.setBackgroundColor(Color.rgb(0,70,115));
            fragmentTwoBtn.setTextColor(Color.BLACK);
            fragmentThreeBtn.setTextColor(Color.BLACK);
            fragmentOneBtn.setTextColor(Color.WHITE);
//            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
//            fragmentTransaction.replace(R.id.frameLayout,new AllStaff());
//            fragmentTransaction.commit();
            startActivity(new Intent(getApplicationContext(), AllStaffActivity.class));
            overridePendingTransition(0,0);
        }

        if(v==fragmentTwoBtn){
            fragmentTwoBtn.setBackgroundColor(Color.rgb(0,70,115));
            fragmentThreeBtn.setBackgroundColor(Color.WHITE);
            fragmentOneBtn.setBackgroundColor(Color.WHITE);
            fragmentTwoBtn.setTextColor(Color.WHITE);
            fragmentThreeBtn.setTextColor(Color.BLACK);
            fragmentOneBtn.setTextColor(Color.BLACK);
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.frameLayout,new DepartmentsFragment());
            fragmentTransaction.commit();
        }

        if(v==fragmentThreeBtn){
            fragmentThreeBtn.setBackgroundColor(Color.rgb(0,70,115));
            fragmentTwoBtn.setBackgroundColor(Color.WHITE);
            fragmentOneBtn.setBackgroundColor(Color.WHITE);
            fragmentTwoBtn.setTextColor(Color.BLACK);
            fragmentThreeBtn.setTextColor(Color.WHITE);
            fragmentOneBtn.setTextColor(Color.BLACK);
//            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
//            fragmentTransaction.replace(R.id.frameLayout,new fragmentAddStaff());
//            fragmentTransaction.commit();
            startActivity(new Intent(getApplicationContext(), AddStaffMain.class));
            overridePendingTransition(0,0);

        }
    }
    public void recyclerViewPopulate(){

    }
}