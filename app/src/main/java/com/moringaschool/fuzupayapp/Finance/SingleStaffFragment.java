package com.moringaschool.fuzupayapp.Finance;

import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.moringaschool.fuzupayapp.Finance.Fragments.FinanceFragmentSingleStaffOverview;
import com.moringaschool.fuzupayapp.Finance.Fragments.FinanceFragmentStaffDeduction;
import com.moringaschool.fuzupayapp.Finance.Fragments.FragmentSingleStaffBenefits;
import com.moringaschool.fuzupayapp.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SingleStaffFragment extends Fragment implements View.OnClickListener{
    @BindView(R.id.overView) TextView overViewBtn;
    @BindView(R.id.deductions) TextView deductionsBtn;
    @BindView(R.id.benefits) TextView benefitsBtn;
    @BindView(R.id.flayout) FrameLayout flayout;
    @BindView(R.id.deductionDisplay) TextView deductionDisplay;

    @Override
    public void onStart() {
        super.onStart();
        overViewBtn.setBackgroundColor(Color.rgb(0,70,115));
        overViewBtn.setTextColor(Color.WHITE);
        FragmentTransaction fragmentTransaction = getChildFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.flayout,new FinanceFragmentSingleStaffOverview());
        fragmentTransaction.commit();
        deductionDisplay.setText("StaffInterface information");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_staff, container, false);
        ButterKnife.bind(this, view);

        overViewBtn.setOnClickListener(this);
        deductionsBtn.setOnClickListener(this);
        benefitsBtn.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        String overView=overViewBtn.getText().toString();
        String deduction=deductionsBtn.getText().toString();
        String benefits=benefitsBtn.getText().toString();
        if(v==overViewBtn){
            overViewBtn.setBackgroundColor(Color.rgb(0,70,115));
            overViewBtn.setTextColor(Color.WHITE);
            deductionsBtn.setBackgroundResource(R.drawable.thin_border);
            deductionsBtn.setTextColor(Color.rgb(0,70,115));
            benefitsBtn.setBackgroundResource(R.drawable.thin_border);
            benefitsBtn.setTextColor(Color.rgb(0,70,115));
            FragmentTransaction fragmentTransaction = getChildFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.flayout,new FinanceFragmentSingleStaffOverview());
            fragmentTransaction.commit();
            deductionDisplay.setText("StaffInterface information");
        }
        if(v==deductionsBtn){
            deductionsBtn.setBackgroundColor(Color.rgb(0,70,115));
            deductionsBtn.setTextColor(Color.WHITE);
            overViewBtn.setBackgroundResource(R.drawable.thin_border);
            overViewBtn.setTextColor(Color.rgb(0,70,115));
            benefitsBtn.setBackgroundResource(R.drawable.thin_border);
            benefitsBtn.setTextColor(Color.rgb(0,70,115));
            FragmentTransaction fragmentTransaction = getChildFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.flayout,new FinanceFragmentStaffDeduction());
            fragmentTransaction.commit();
            deductionDisplay.setText(deduction);
        }
        if(v==benefitsBtn){
            benefitsBtn.setBackgroundColor(Color.rgb(0,70,115));
            benefitsBtn.setTextColor(Color.WHITE);
            overViewBtn.setBackgroundResource(R.drawable.thin_border);
            overViewBtn.setTextColor(Color.rgb(0,70,115));
            deductionsBtn.setBackgroundResource(R.drawable.thin_border);
            deductionsBtn.setTextColor(Color.rgb(0,70,115));
            deductionDisplay.setText(benefits);
            FragmentTransaction fragmentTransaction = getChildFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.flayout,new FragmentSingleStaffBenefits());
            fragmentTransaction.commit();
            deductionDisplay.setText(benefits);
        }
    }
}