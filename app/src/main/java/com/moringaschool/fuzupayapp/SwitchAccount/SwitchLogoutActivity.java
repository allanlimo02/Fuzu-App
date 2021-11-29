package com.moringaschool.fuzupayapp.SwitchAccount;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.moringaschool.fuzupayapp.Finance.Dashboard_Finance;
import com.moringaschool.fuzupayapp.Finance.Log_In_finance;
import com.moringaschool.fuzupayapp.HumanResource.Dashboard.DashboardActivity;
import com.moringaschool.fuzupayapp.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SwitchLogoutActivity extends AppCompatActivity implements View.OnClickListener {
    @BindView(R.id.backswitch) TextView backswitch;
    @BindView(R.id.logout)TextView logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_switch_logout);
        ButterKnife.bind(this);

        backswitch.setOnClickListener(this);
        logout.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        if(view == backswitch){
            startActivity(new Intent(getApplicationContext(), DashboardActivity.class));

            overridePendingTransition(0,0);
        }
        if (view == logout){
            startActivity(new Intent(getApplicationContext(), Log_In_finance.class));
            overridePendingTransition(0,0);
        }
    }
}