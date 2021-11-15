package com.moringaschool.fuzupayapp.HumanResource.Fragments.Staff;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.moringaschool.fuzupayapp.R;

import butterknife.BindView;
import butterknife.ButterKnife;


public class DepartmentsFragment extends Fragment {
//    Spinner spinner;
    private Spinner spinner;

//    @BindView(R.id.depspinner) Spinner depspinner;


    public DepartmentsFragment() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_departments, container, false);
             return view;

    }

}