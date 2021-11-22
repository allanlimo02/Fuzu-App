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
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.moringaschool.fuzupayapp.Finance.Dashboard_Finance;
import com.moringaschool.fuzupayapp.Finance.Expences.Finance_Approve_Activity;
import com.moringaschool.fuzupayapp.Finance.FinanceStaffFragment;
import com.moringaschool.fuzupayapp.Finance.Fragments.FinanceComingSoon;
import com.moringaschool.fuzupayapp.Finance.Fragments.NewrunFragment;
import com.moringaschool.fuzupayapp.Finance.Payroll2;
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
    @BindView(R.id.payrollActive) FrameLayout payrollActive;
    @BindView(R.id.bottom_navigation) BottomNavigationView bottom_navigation;
    @BindView(R.id.constraintLayout) RelativeLayout relativeLayout;

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



        bottom_navigation.setSelectedItemId(R.id.nav_payroll);
        bottom_navigation.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.nav_home:
                        startActivity(new Intent(getApplicationContext(), Dashboard_Finance.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.nav_payroll:
                        startActivity(new Intent(getApplicationContext(), Payroll2.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.nav_expenses:
                        startActivity(new Intent(getApplicationContext(), Finance_Approve_Activity.class));
                        overridePendingTransition(0,0);
                        return true;
                }
                return false;
            }
        });
    }

    @Override
    public void onStart() {
        super.onStart();
        payrollbtn.setBackgroundColor(Color.rgb(0,70,115));
        payrollbtn.setTextColor(Color.WHITE);
        newrun.setBackgroundResource(R.drawable.thin_border);
        newrun.setTextColor(Color.rgb(0,70,115));
        staffbtn.setBackgroundResource(R.drawable.thin_border);
        staffbtn.setTextColor(Color.rgb(0,70,115));
        review.setTextColor(Color.rgb(0,70,115));
        approvepayment.setTextColor(Color.BLACK);
        payments.setTextColor(Color.BLACK);
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.payrollActive, new Finance_Review_Fragment());
        fragmentTransaction.commit();
    }

    @Override
    public void onClick(View view) {
//fragmentSection
        if(view==review){
            review.setTextColor(Color.rgb(0,70,115));
            approvepayment.setTextColor(Color.BLACK);
            payments.setTextColor(Color.BLACK);
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.payrollActive, new Finance_Review_Fragment());
            fragmentTransaction.commit();
        }
        if(view==approvepayment){
            approvepayment.setTextColor(Color.rgb(0,70,115));
            review.setTextColor(Color.BLACK);
            payments.setTextColor(Color.BLACK);
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.payrollActive,new Finance_Approve_Fragment());
            fragmentTransaction.commit();
        }
        if(view == payments){
            approvepayment.setTextColor(Color.BLACK);
            review.setTextColor(Color.BLACK);
            payments.setTextColor(Color.rgb(0,70,115));
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
            relativeLayout.setVisibility(View.GONE);
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
            relativeLayout.setVisibility(View.GONE);
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.payrollActive,new FinanceStaffFragment());
            fragmentTransaction.commit();
        }
    }
}