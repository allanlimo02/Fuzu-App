package com.moringaschool.fuzupayapp.Finance.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.moringaschool.fuzupayapp.APIRequests.DepartmentAdapter;
import com.moringaschool.fuzupayapp.APIRequests.DepartmentClient;
import com.moringaschool.fuzupayapp.APIRequests.DepartmentResponse;
import com.moringaschool.fuzupayapp.APIRequests.PayrollAdapter;
import com.moringaschool.fuzupayapp.APIRequests.PayrollApiClient;
import com.moringaschool.fuzupayapp.APIRequests.PayrollResponse;
import com.moringaschool.fuzupayapp.R;

import java.util.List;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class NewrunFragment extends Fragment {
    RecyclerView recyclerView;
    PayrollAdapter payrollAdapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.finance_fragment_newrun, container, false);
        recyclerView = view.findViewById(R.id.recyclerviewMain);
        // Inflate the layout for this fragment
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.addItemDecoration(new DividerItemDecoration(getActivity(),DividerItemDecoration.VERTICAL));
        payrollAdapter = new PayrollAdapter();
        getAllPayrolls();
        return view;


    }

        private void getAllPayrolls() {
            Call<List<PayrollResponse>> payrollList = PayrollApiClient.getPayrollService().getAllPayrolls();
            payrollList.enqueue(new Callback<List<PayrollResponse>>() {

                @Override
                public void onResponse(Call<List<PayrollResponse>> call, Response<List<PayrollResponse>> response) {
                    if (response.isSuccessful()){
                        //Log.e("success",response.body().toString());
                        List<PayrollResponse> payrollResponses = response.body();
                        payrollAdapter.setData(payrollResponses);
                        recyclerView.setAdapter(payrollAdapter);

                    }
                }

                @Override
                public void onFailure(Call<List<PayrollResponse>> call, Throwable t) {
                    Log.e("failure",t.getLocalizedMessage());
                }
        });
    }

    }



