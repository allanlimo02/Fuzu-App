package com.moringaschool.fuzupayapp.Finance.Expences;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.Spinner;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.moringaschool.fuzupayapp.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ArdaFragment extends Fragment {
    @BindView(R.id.SpinnerARD)  Spinner spinner;
//    @BindView(R.id.bottom_navigation) BottomNavigationView bottomNavigationView;

    private Context context;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.finance_arda_fragment, container, false);
        ButterKnife.bind(this,view);

//        ArrayAdapter<CharSequence> adapter = ArrayAdapter .createFromResource(context,R.array.approves, android.R.layout.simple_spinner_item);
//        adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
//        spinner.setAdapter(adapter);

//        spinner.setOnItemSelectedListener(spinner);

        return view;
    }
}