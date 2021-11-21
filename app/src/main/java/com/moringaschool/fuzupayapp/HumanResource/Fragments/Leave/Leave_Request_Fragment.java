package com.moringaschool.fuzupayapp.HumanResource.Fragments.Leave;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.moringaschool.fuzupayapp.FragmentAdapter.DepartmentAdapter;
import com.moringaschool.fuzupayapp.FragmentAdapter.LeaveRequestAdapter;
import com.moringaschool.fuzupayapp.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Leave_Request_Fragment extends Fragment {

//    @BindView(R.id.recview) RecyclerView recyclerView;

   @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_leave__request_, container, false);
       ButterKnife.bind(this,view);


        return view;

    }




}