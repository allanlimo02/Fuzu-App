package com.moringaschool.fuzupayapp.HumanResource.Fragments.Staff;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.moringaschool.fuzupayapp.R;

public class AllStaff extends Fragment {



    public AllStaff() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_all_staff, container, false);

        return view;
    }
}