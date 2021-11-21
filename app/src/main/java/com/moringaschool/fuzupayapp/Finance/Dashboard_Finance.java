package com.moringaschool.fuzupayapp.Finance;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Switch;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.moringaschool.fuzupayapp.HumanResource.Dashboard.DashboardActivity;
import com.moringaschool.fuzupayapp.HumanResource.Fragments.Leave.LeaveActivity;
import com.moringaschool.fuzupayapp.HumanResource.Fragments.Staff.StaffActivity;
import com.moringaschool.fuzupayapp.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Dashboard_Finance extends AppCompatActivity implements View.OnClickListener{
    @BindView(R.id.bottom_navigation) BottomNavigationView bottom_navigation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.finance_dashboard_activity);
        ButterKnife.bind(this);

        bottom_navigation.setSelectedItemId(R.id.nav_home);
        bottom_navigation.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.nav_home:
                        return true;
                    case R.id.nav_payroll:
                        startActivity(new Intent(getApplicationContext(), Payroll2.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.nav_staff:
//                        startActivity(new Intent(getApplicationContext(), Log_In_finance.class));
//                        overridePendingTransition(0,0);
                        Toast.makeText(Dashboard_Finance.this, "Coming Soon", Toast.LENGTH_SHORT).show();
                        return true;

                }

                return false;
            }
        });


    }

    @Override
    public void onClick(View v) {

    }
}