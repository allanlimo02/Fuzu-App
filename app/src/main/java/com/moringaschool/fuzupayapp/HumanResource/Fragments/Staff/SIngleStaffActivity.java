package com.moringaschool.fuzupayapp.HumanResource.Fragments.Staff;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

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
import com.moringaschool.fuzupayapp.APIRequests.StaffApiResources.Models.StaffResponse;
import com.moringaschool.fuzupayapp.HumanResource.Dashboard.DashboardActivity;
import com.moringaschool.fuzupayapp.HumanResource.Fragments.Leave.LeaveActivity;
import com.moringaschool.fuzupayapp.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SIngleStaffActivity extends AppCompatActivity implements View.OnClickListener{
    @BindView(R.id.username) TextView mUsername;
    @BindView(R.id.departments) TextView departments;
    @BindView(R.id.workingPeriod) TextView workingPeriod;
    @BindView(R.id.bottom_navigation)  BottomNavigationView bottomNavigationView;
    @BindView(R.id.fragmentOneBtn)  Button fragmentOneBtn;
    @BindView(R.id.fragmentTwoBtn)    Button fragmentTwoBtn;
    @BindView(R.id.fragmentThreeBtn) Button fragmentThreeBtn;
    @BindView(R.id.company) TextView companies;
    @BindView(R.id.workEmail) TextView mWorkEmail;
    @BindView(R.id.personalEmail) TextView mPersonalEmail;
    @BindView(R.id.insuranceNo) TextView mInsuranceNo;
    @BindView(R.id.pinNumber) TextView mPinNumber;
    @BindView(R.id.employeeId) TextView mEmployeeId;
    @BindView(R.id.employmentDate) TextView mEmploymentDate;
    @BindView(R.id.department) TextView mDepartment;
    @BindView(R.id.grossPay) TextView mGrossPay;
    @BindView(R.id.netPay) TextView mNetPay;







    StaffResponse staffResponse;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_staff);
        ButterKnife.bind(this);

        Intent intent=getIntent();

            staffResponse= (StaffResponse) intent.getSerializableExtra("data");

            String username = staffResponse.getOtherNames();
            String role = staffResponse.getDepartment();
            String jobType = staffResponse.getMaritalStatus();
            String company = "FuzuPay";
            String workEmail = staffResponse.getWorkEmail();
            String personalEmail = String.valueOf(staffResponse.getPersonalEmail());
            String insuranceNo = String.valueOf(staffResponse.getInsuranceNumber());
            String pinNumber = (String) staffResponse.getTaxPinNumber();
            String employeeId  = staffResponse.getEmployeeId();
            String employmentDate   = staffResponse.getEmploymentDate();
            String department  = staffResponse.getDepartment();
            String grossPay  = staffResponse.getGrossSalary();
            String netPay = "20,000";






        Toast.makeText(SIngleStaffActivity.this,"Hello"+username,Toast.LENGTH_SHORT).show();
        mUsername.setText(username);
        departments.setText(role);
        workingPeriod.setText(jobType);
        companies.setText(company);
        mWorkEmail.setText(workEmail);
        mPersonalEmail.setText(personalEmail);
        mInsuranceNo.setText(personalEmail);
        mPinNumber.setText(pinNumber);
        mEmployeeId.setText(employeeId);
        mEmploymentDate.setText(employmentDate);
        mDepartment.setText(department);
        mGrossPay.setText(grossPay);
        mNetPay.setText(netPay);



        fragmentTwoBtn.setOnClickListener(this);
        fragmentOneBtn.setOnClickListener(this);
        fragmentThreeBtn.setOnClickListener(this);

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
    public void onClick(View v) {

        if(v==fragmentOneBtn){
            fragmentThreeBtn.setBackgroundColor(Color.WHITE);
            fragmentTwoBtn.setBackgroundColor(Color.WHITE);
            fragmentOneBtn.setBackgroundColor(Color.rgb(0,70,115));
            fragmentTwoBtn.setTextColor(Color.BLACK);
            fragmentThreeBtn.setTextColor(Color.BLACK);
            fragmentOneBtn.setTextColor(Color.WHITE);
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
            startActivity(new Intent(getApplicationContext(), DepartmentsFragment.class));
            overridePendingTransition(0,0);
           }

        if(v==fragmentThreeBtn){
            fragmentThreeBtn.setBackgroundColor(Color.rgb(0,70,115));
            fragmentTwoBtn.setBackgroundColor(Color.WHITE);
            fragmentOneBtn.setBackgroundColor(Color.WHITE);
            fragmentTwoBtn.setTextColor(Color.BLACK);
            fragmentThreeBtn.setTextColor(Color.WHITE);
            fragmentOneBtn.setTextColor(Color.BLACK);
            startActivity(new Intent(getApplicationContext(), AddStaffMain.class));
            overridePendingTransition(0,0);

        }

    }
}