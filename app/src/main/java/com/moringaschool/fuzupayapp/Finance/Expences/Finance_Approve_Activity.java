package com.moringaschool.fuzupayapp.Finance.Expences;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.moringaschool.fuzupayapp.Finance.Dashboard_Finance;
import com.moringaschool.fuzupayapp.Finance.Payroll2;
import com.moringaschool.fuzupayapp.Finance.Pazyroll.financePayroll_1;
import com.moringaschool.fuzupayapp.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Finance_Approve_Activity extends AppCompatActivity implements View.OnClickListener {

    @BindView(R.id.EPending1)
    Button Pending;
    @BindView(R.id.Epayments)Button
    payments;
    @BindView(R.id.Ecompleted)Button
    completed;
    @BindView(R.id.frameLayoutPendings)
    FrameLayout Rpendings;
    @BindView(R.id.bottom_navigation)
    BottomNavigationView bottom_navigation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finance_approve);
        ButterKnife.bind(this);
        Pending.setOnClickListener(this);
        payments.setOnClickListener(this);
        completed.setOnClickListener(this);


        bottom_navigation.setSelectedItemId(R.id.nav_expenses);
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
                        return true;
                }
                return false;
            }
        });
    }

    @Override
    public void onClick(View view) {
       if (view == Pending){
           startActivity(new Intent(getApplicationContext(), ARDActivity.class));
           overridePendingTransition(0,0);

       }

    }
}