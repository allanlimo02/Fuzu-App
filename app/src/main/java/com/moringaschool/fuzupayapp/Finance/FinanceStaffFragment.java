package com.moringaschool.fuzupayapp.Finance;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.moringaschool.fuzupayapp.Finance.Fragments.NewrunFragment;
import com.moringaschool.fuzupayapp.R;

import butterknife.BindView;
import butterknife.ButterKnife;


public class FinanceStaffFragment extends Fragment  implements View.OnClickListener{



    @BindView(R.id.rowone)  RelativeLayout rowone;
    @BindView(R.id.row2) RelativeLayout row2;
    @BindView(R.id.row3) RelativeLayout row3;
    @BindView(R.id.babu) RelativeLayout babu;
    @BindView(R.id.relativeTwo) RelativeLayout relativeTwo;
    @BindView(R.id.headingPart) RelativeLayout headingPart;

@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container,
                         Bundle savedInstanceState) {
    // Inflate the layout for this fragment
    View view=inflater.inflate(R.layout.finance_fragment_staff, container, false);
    ButterKnife.bind(this,view);
    rowone.setOnClickListener(this);
    row2.setOnClickListener(this);
    row3.setOnClickListener(this);



    return view;

}

    @Override
    public void onClick(View v) {
    if(v==rowone){
        relativeTwo.setVisibility(View.GONE);
        headingPart.setVisibility(View.GONE);
        FragmentTransaction fragmentTransaction = getChildFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.framebabu,new SingleStaffFragment());
        fragmentTransaction.commit();
        babu.setVisibility(View.GONE);

    }
    if(v==row2){
        relativeTwo.setVisibility(View.GONE);
        headingPart.setVisibility(View.GONE);
        FragmentTransaction fragmentTransaction = getChildFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.framebabu,new SingleStaffFragment());
        fragmentTransaction.commit();
        babu.setVisibility(View.GONE);

    }
    if(v==row3){
        relativeTwo.setVisibility(View.GONE);
        headingPart.setVisibility(View.GONE);
        FragmentTransaction fragmentTransaction = getChildFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.framebabu,new SingleStaffFragment());
        fragmentTransaction.commit();
        babu.setVisibility(View.GONE);

    }


    }
}