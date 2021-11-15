package com.moringaschool.fuzupayapp.HumanResource.Dashboard;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.moringaschool.fuzupayapp.HumanResource.Fragments.Leave.LeaveActivity;
import com.moringaschool.fuzupayapp.HumanResource.Fragments.Staff.AddStaffMain;
import com.moringaschool.fuzupayapp.HumanResource.Fragments.Staff.DepartmentsFragment;
import com.moringaschool.fuzupayapp.HumanResource.Fragments.Staff.StaffActivity;
import com.moringaschool.fuzupayapp.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DashboardActivity extends AppCompatActivity  implements View.OnClickListener{
    @BindView(R.id.bottom_navigation) BottomNavigationView bottomNavigationView;
    @BindView(R.id.managestaff) ImageView managestaff;
    @BindView(R.id.departments) ImageView departments;
    @BindView(R.id.addstaff) ImageView addstaff;
    @BindView(R.id.onleave) TextView onleave;
    @BindView(R.id.approvebutton)  Button approvebutton;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        ButterKnife.bind(this);
        managestaff.setOnClickListener(this);
        departments.setOnClickListener(this);
        addstaff.setOnClickListener(this);
        onleave.setOnClickListener(this);
        approvebutton.setOnClickListener(this);


        bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.nav_home);

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()) {
                    case R.id.nav_home:
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
    }

    @Override
    public void onClick(View v) {
        if(v==managestaff){
            Intent intent= new Intent(DashboardActivity.this,StaffActivity.class);
            startActivity(intent);
//            Toast.makeText(DashboardActivity.this,"Manage Staff Coming up Soon",Toast.LENGTH_SHORT).show();

        }
        if(v==departments){
            Intent intent= new Intent(DashboardActivity.this,StaffActivity.class);
            startActivity(intent);
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.frameLayout,new DepartmentsFragment());
            fragmentTransaction.commit();

        }
        if(v==addstaff){
            Intent intent= new Intent(DashboardActivity.this,StaffActivity.class);
            startActivity(new Intent(getApplicationContext(), AddStaffMain.class));
            overridePendingTransition(0,0);
            startActivity(intent);

        }
        if(v==onleave){
            Toast.makeText(DashboardActivity.this,"Onleave Coming up Soon",Toast.LENGTH_SHORT).show();

        }
        if(v==approvebutton){
            Intent intent=new Intent(DashboardActivity.this,LeaveActivity.class);
            startActivity(intent);

        }

    }
}