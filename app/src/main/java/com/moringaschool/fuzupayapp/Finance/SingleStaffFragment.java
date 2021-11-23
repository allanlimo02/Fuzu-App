package com.moringaschool.fuzupayapp.Finance;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.moringaschool.fuzupayapp.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SingleStaffFragment extends Fragment {
    @BindView(R.id.overView) TextView overViewBtn;
    @BindView(R.id.deductions) TextView deductionsBtn;
    @BindView(R.id.benefits) TextView benefitsBtn;
    @BindView(R.id.flayout) FrameLayout flayout;

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_staff, container, false);
        ButterKnife.bind(this, view);
        return view;
    }
}