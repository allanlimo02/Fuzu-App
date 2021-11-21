package com.moringaschool.fuzupayapp.Finance;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.moringaschool.fuzupayapp.Finance.Fragments.FinanceComingSoon;
import com.moringaschool.fuzupayapp.Finance.Fragments.NewrunFragment;
import com.moringaschool.fuzupayapp.HumanResource.Fragments.Leave.Leave_Request_Fragment;
import com.moringaschool.fuzupayapp.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Payroll2 extends AppCompatActivity implements View.OnClickListener{
    @BindView(R.id.newrun)  TextView newrun;
    @BindView(R.id.payroll) TextView payrollbtn;
    @BindView(R.id.staff) TextView staffbtn;
    @BindView(R.id.nframe) FrameLayout frameLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.finance_activity_payroll2);
        ButterKnife.bind(this);

        newrun.setOnClickListener(this);
        payrollbtn.setOnClickListener(this);
        staffbtn.setOnClickListener(this);

    }

    @Override
    protected void onStart() {
        super.onStart();
        newrun.setBackgroundColor(Color.rgb(0,70,115));
        newrun.setTextColor(Color.WHITE);
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.nframe,new NewrunFragment());
        fragmentTransaction.commit();
    }

    @Override
    public void onClick(View v) {

        if(v==newrun){
            newrun.setBackgroundColor(Color.rgb(0,70,115));
            newrun.setTextColor(Color.WHITE);
            payrollbtn.setBackgroundResource(R.drawable.thin_border);
            payrollbtn.setTextColor(Color.rgb(0,70,115));
            staffbtn.setBackgroundResource(R.drawable.thin_border);
            staffbtn.setTextColor(Color.rgb(0,70,115));
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.nframe,new NewrunFragment());
            fragmentTransaction.commit();

        }
        if(v==payrollbtn){
            payrollbtn.setBackgroundColor(Color.rgb(0,70,115));
            payrollbtn.setTextColor(Color.WHITE);
            newrun.setBackgroundResource(R.drawable.thin_border);
            newrun.setTextColor(Color.rgb(0,70,115));
            staffbtn.setBackgroundResource(R.drawable.thin_border);
            staffbtn.setTextColor(Color.rgb(0,70,115));
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.nframe,new FinanceComingSoon());
            fragmentTransaction.commit();

        }
        if(v==staffbtn){
            staffbtn.setBackgroundColor(Color.rgb(0,70,115));
            staffbtn.setTextColor(Color.WHITE);
            newrun.setBackgroundResource(R.drawable.thin_border);
            newrun.setTextColor(Color.rgb(0,70,115));
            payrollbtn.setBackgroundResource(R.drawable.thin_border);//setBackgroundColor(Color.WHITE);
            payrollbtn.setTextColor(Color.rgb(0,70,115));
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.nframe,new FinanceComingSoon());
            fragmentTransaction.commit();
        }
    }
}