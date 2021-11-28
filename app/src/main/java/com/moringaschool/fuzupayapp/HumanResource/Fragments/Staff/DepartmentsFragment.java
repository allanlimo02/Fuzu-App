package com.moringaschool.fuzupayapp.HumanResource.Fragments.Staff;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Spinner;


import com.moringaschool.fuzupayapp.APIRequests.DepartmentAdapter;
import com.moringaschool.fuzupayapp.APIRequests.DepartmentClient;
import com.moringaschool.fuzupayapp.APIRequests.DepartmentResponse;

import com.moringaschool.fuzupayapp.HumanResource.Fragments.Leave.LeaveActivity;
import com.moringaschool.fuzupayapp.HumanResource.Fragments.Leave.RequestAPI.RequestClient;
import com.moringaschool.fuzupayapp.HumanResource.Fragments.Leave.RequestAPI.RequestResponse;
import com.moringaschool.fuzupayapp.R;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;


public class DepartmentsFragment extends Fragment {
    LeaveActivity leaveActivity = new LeaveActivity();
//    Spinner spinner;
    private Spinner spinner;
    RecyclerView recyclerView;
    DepartmentAdapter departmentAdapter;


    public DepartmentsFragment() {
        // Required empty public constructor
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_departments, container, false);
        recyclerView = view.findViewById(R.id.recyclerviewDepartments);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.addItemDecoration(new DividerItemDecoration(getActivity(),DividerItemDecoration.VERTICAL));
        departmentAdapter = new DepartmentAdapter();
        getDepartment();
        return view;
    }

    private void getDepartment() {
        Call<List<DepartmentResponse>> departmentList = DepartmentClient.getDepartmentService().getDepartment();
        departmentList.enqueue(new Callback<List<DepartmentResponse>>() {
            @Override
            public void onResponse(Call<List<DepartmentResponse>> call, Response<List<DepartmentResponse>> response) {
                if (response.isSuccessful()) {
                    List<DepartmentResponse> departmentResponses = response.body();
                    departmentAdapter.setData(departmentResponses);
                    recyclerView.setAdapter(departmentAdapter);
                    Log.e("successful",response.body().toString());
                }
            }

            @Override
            public void onFailure(Call<List<DepartmentResponse>> call, Throwable t) {
                Log.e("failure",t.getLocalizedMessage());
            }
        });
    }
    }

