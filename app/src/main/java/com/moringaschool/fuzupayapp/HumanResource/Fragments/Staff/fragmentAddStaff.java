package com.moringaschool.fuzupayapp.HumanResource.Fragments.Staff;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RadioButton;

import com.moringaschool.fuzupayapp.R;

import butterknife.BindView;
import butterknife.ButterKnife;


public class fragmentAddStaff extends Fragment implements View.OnClickListener {

    @BindView(R.id.radio_one) RadioButton radioButton1;
    @BindView(R.id.radio_two) RadioButton radioButton2;
    @BindView(R.id.framelayout) FrameLayout framelayout;
    public fragmentAddStaff() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add_staff, container, false);
//        ButterKnife.bind(this);

    }

    @Override
    public void onClick(View v) {

    }
}