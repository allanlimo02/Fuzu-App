package com.moringaschool.fuzupayapp.Finance.Pazyroll;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.moringaschool.fuzupayapp.Finance.Dashboard_Finance;
import com.moringaschool.fuzupayapp.Finance.Fragments.FinanceComingSoon;
import com.moringaschool.fuzupayapp.Finance.Fragments.NewrunFragment;
import com.moringaschool.fuzupayapp.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class financePayroll_1 extends AppCompatActivity implements View.OnClickListener {
    @BindView(R.id.newrun) TextView newrun;
    @BindView(R.id.payroll) TextView payrollbtn;
    @BindView(R.id.staff) TextView staffbtn;
    @BindView(R.id.payments) TextView approvepayment;
    @BindView(R.id.approvepayment) TextView review;
    @BindView(R.id.review) TextView payments;
    @BindView(R.id.payrollActive)
    FrameLayout payrollActive;
    @BindView(R.id.bottom_navigation)
    BottomNavigationView bottom_navigation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finance_payroll1);
        ButterKnife.bind(this);

        approvepayment.setOnClickListener(this);
        payments.setOnClickListener(this);
        review.setOnClickListener(this);
        newrun.setOnClickListener(this);
        payrollbtn.setOnClickListener(this);
        staffbtn.setOnClickListener(this);



        bottom_navigation.setSelectedItemId(R.id.nav_home);
        bottom_navigation.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.nav_home:
                        startActivity(new Intent(getApplicationContext(), Dashboard_Finance.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.nav_payroll:
                        return true;
                    case R.id.nav_staff:
//                        startActivity(new Intent(getApplicationContext(), Log_In_finance.class));
//                        overridePendingTransition(0,0);
                        Toast.makeText(financePayroll_1.this, "Coming Soon", Toast.LENGTH_SHORT).show();
                        return true;

                }

                return false;
            }
        });
    }

    @Override
    public void onStart() {
        super.onStart();
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.payrollActive, new Finance_Review_Fragment());
        fragmentTransaction.commit();
    }

    @Override
    public void onClick(View view) {
//fragmentSection
        if(view==review){
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.payrollActive, new Finance_Review_Fragment());
            fragmentTransaction.commit();
        }
        if(view==approvepayment){
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.payrollActive,new Finance_Approve_Fragment());
            fragmentTransaction.commit();
        }
        if(view == payments){
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.payrollActive,new Payments_Fragment());
            fragmentTransaction.commit();
        }

//        navigation place
        if(view==newrun){
            newrun.setBackgroundColor(Color.rgb(0,70,115));
            newrun.setTextColor(Color.WHITE);
            payrollbtn.setBackgroundResource(R.drawable.thin_border);
            payrollbtn.setTextColor(Color.rgb(0,70,115));
            staffbtn.setBackgroundResource(R.drawable.thin_border);
            staffbtn.setTextColor(Color.rgb(0,70,115));
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.payrollActive,new NewrunFragment());
            fragmentTransaction.commit();

        }
        if(view==payrollbtn){
            payrollbtn.setBackgroundColor(Color.rgb(0,70,115));
            payrollbtn.setTextColor(Color.WHITE);
            newrun.setBackgroundResource(R.drawable.thin_border);
            newrun.setTextColor(Color.rgb(0,70,115));
            staffbtn.setBackgroundResource(R.drawable.thin_border);
            staffbtn.setTextColor(Color.rgb(0,70,115));
            startActivity(new Intent(getApplicationContext(), financePayroll_1.class));
            overridePendingTransition(0,0);

        }
        if(view==staffbtn){
            staffbtn.setBackgroundColor(Color.rgb(0,70,115));
            staffbtn.setTextColor(Color.WHITE);
            newrun.setBackgroundResource(R.drawable.thin_border);
            newrun.setTextColor(Color.rgb(0,70,115));
            payrollbtn.setBackgroundResource(R.drawable.thin_border);//setBackgroundColor(Color.WHITE);
            payrollbtn.setTextColor(Color.rgb(0,70,115));
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.payrollActive,new FinanceComingSoon());
            fragmentTransaction.commit();
        }
    }
}