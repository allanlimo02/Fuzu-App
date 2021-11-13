package com.moringaschool.fuzupayapp.HumanResource.Fragments.Leave;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.moringaschool.fuzupayapp.HumanResource.Dashboard.DashboardActivity;
import com.moringaschool.fuzupayapp.HumanResource.Fragments.Staff.StaffActivity;
import com.moringaschool.fuzupayapp.R;

import butterknife.BindView;

public class LeaveActivity extends AppCompatActivity implements View.OnClickListener{
    @BindView(R.id.bottom_navigation) BottomNavigationView mBottomNavigationView;
    @BindView(R.id.leaverequests) TextView leaveRequestButton;
    @BindView(R.id.onleave) TextView onLeaveButton;
    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leave2);

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
        onLeaveButton.setOnClickListener(this);
        leaveRequestButton.setOnClickListener(this);
        Leave_Request_Fragment leave_request_fragment = new Leave_Request_Fragment();
        On_Leave_Fragment on_leave_fragment;
        FragmentManager manager=getSupportFragmentManager();
        manager.beginTransaction().replace(R.id.frholder,leave_request_fragment,leave_request_fragment.getTag());
    }

    @Override
    public void onClick(View v) {
        if(v==onLeaveButton){
            Toast.makeText(LeaveActivity.this,"on leave clicked",Toast.LENGTH_LONG).show();

        }
        if(v==leaveRequestButton){
            Toast.makeText(LeaveActivity.this,"Leave request clicked",Toast.LENGTH_LONG).show();
        }

    }
}