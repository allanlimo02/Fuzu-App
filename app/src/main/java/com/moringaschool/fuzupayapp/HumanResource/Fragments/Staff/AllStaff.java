package com.moringaschool.fuzupayapp.HumanResource.Fragments.Staff;

import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.moringaschool.fuzupayapp.FragmentAdapter.DepartmentAdapter;
import com.moringaschool.fuzupayapp.R;

public class AllStaff extends Fragment {
    RecyclerView recyclerView;
    public AllStaff() {
        // Required empty public constructor
    }
    String names[],position[],workTypes[];
    Context context;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        names=getResources().getStringArray(R.array.names);
        position=getResources().getStringArray(R.array.position);
        workTypes=getResources().getStringArray(R.array.workTypes);

//        recyclerView= recyclerView.findViewById(R.id.recyclerview);
//        DepartmentAdapter departmentAdapter=new DepartmentAdapter(AllStaff.this,names,position,workTypes);
//        recyclerView.setAdapter(departmentAdapter);
//        recyclerView.setLayoutManager(new LinearLayoutManager(context));


        View view = inflater.inflate(R.layout.fragment_all_staff, container, false);

        return view;
    }
//    init()
}