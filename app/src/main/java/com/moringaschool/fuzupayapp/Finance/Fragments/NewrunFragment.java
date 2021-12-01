package com.moringaschool.fuzupayapp.Finance.Fragments;

import android.app.DatePickerDialog;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.moringaschool.fuzupayapp.R;


public class NewrunFragment extends Fragment {

    private DatePickerDialog  datepicker;
    private TextView dateText;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.finance_fragment_newrun, container, false);
    }
}