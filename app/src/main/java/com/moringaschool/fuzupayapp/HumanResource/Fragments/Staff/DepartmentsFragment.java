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
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;


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


public class DepartmentsFragment extends Fragment implements AdapterView.OnItemSelectedListener {
    LeaveActivity leaveActivity = new LeaveActivity();
//        Spinner spinner;
    Spinner spinner;
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
//        Spinner
        spinner= view.findViewById(R.id.statusDrop);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getActivity(),R.array.dissaprove, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);



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

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
            String text = adapterView.getItemAtPosition(i).toString();
        Toast.makeText(adapterView.getContext(),text,Toast.LENGTH_LONG).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}