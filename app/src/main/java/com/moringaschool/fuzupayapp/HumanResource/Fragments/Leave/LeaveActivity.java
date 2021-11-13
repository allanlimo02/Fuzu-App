package com.moringaschool.fuzupayapp.HumanResource.Fragments.Leave;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.moringaschool.fuzupayapp.HumanResource.Dashboard.DashboardActivity;
import com.moringaschool.fuzupayapp.HumanResource.Fragments.Staff.AllStaff;
import com.moringaschool.fuzupayapp.HumanResource.Fragments.Staff.DepartmentsFragment;
import com.moringaschool.fuzupayapp.HumanResource.Fragments.Staff.StaffActivity;
import com.moringaschool.fuzupayapp.HumanResource.Fragments.Staff.fragmentAddStaff;
import com.moringaschool.fuzupayapp.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LeaveActivity extends AppCompatActivity implements View.OnClickListener{
    @BindView(R.id.bottom_navigation) BottomNavigationView mBottomNavigationView;
    @BindView(R.id.fragmentOneBtn2) Button fragmentOneBtn2;
    @BindView(R.id.fragmentTwoBtn2) Button fragmentTwoBtn2;
    BottomNavigationView bottomNavigationView;


    //    fragment inititializations
//    private TextView fragmentOneBtn2, fragmentTwoBtn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leave2);

        ButterKnife.bind(this);



        fragmentTwoBtn2.setOnClickListener(this);
        fragmentOneBtn2.setOnClickListener(this);


        bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.nav_leave);


        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {


                switch (item.getItemId()) {
                    case R.id.nav_home:
                        startActivity(new Intent(getApplicationContext(), DashboardActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.nav_leave:
                        return true;
                    case R.id.nav_staff:
                        startActivity(new Intent(getApplicationContext(), StaffActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                }
                return false;
            }
        });

    }

    @Override
    public void onClick(View v) {
        if(v == fragmentOneBtn2){
            fragmentTwoBtn2.setBackgroundColor(Color.WHITE);
            fragmentOneBtn2.setBackgroundColor(Color.rgb(0,70,115));
            fragmentTwoBtn2.setTextColor(Color.BLACK);
            fragmentOneBtn2.setTextColor(Color.WHITE);
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.frameLayout2,new Leave_Request_Fragment());
            fragmentTransaction.commit();
        }

        if(v == fragmentTwoBtn2){
            fragmentTwoBtn2.setBackgroundColor(Color.rgb(0,70,115));
            fragmentOneBtn2.setBackgroundColor(Color.WHITE);
            fragmentTwoBtn2.setTextColor(Color.WHITE);
            fragmentOneBtn2.setTextColor(Color.BLACK);
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.frameLayout2,new On_Leave_Fragment());
            fragmentTransaction.commit();
        }


    }
}