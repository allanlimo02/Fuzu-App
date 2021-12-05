package com.moringaschool.fuzupayapp.Finance;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.moringaschool.fuzupayapp.APIRequests.FinancePayrolePaymentApi.PayrolePaymentAdapter;
import com.moringaschool.fuzupayapp.APIRequests.FinancePayrolePaymentApi.PayrolePaymentClient;
import com.moringaschool.fuzupayapp.APIRequests.FinancePayrolePaymentApi.PayrolePaymentResponse;

import com.moringaschool.fuzupayapp.R;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FinancePayrolePaymentFragment extends Fragment {
    RecyclerView recyclerviewMain;
    PayrolePaymentAdapter adapters;

    public FinancePayrolePaymentFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_epayments, container, false);
        recyclerviewMain = view.findViewById(R.id.recyclerviewMainPay);
        recyclerviewMain.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerviewMain.addItemDecoration(new DividerItemDecoration(getActivity(),DividerItemDecoration.VERTICAL));
//        progressBar = view.findViewById(R.id.OnProgressBar);
        adapters = new PayrolePaymentAdapter();
        getAllOnPayments();
        return view;
    }

    private void getAllOnPayments() {
        Call<List<PayrolePaymentResponse>> payList = PayrolePaymentClient.getPayStatus().getAllpayments();
//        showProgressBar();
        payList.enqueue(new Callback<List<PayrolePaymentResponse>>() {
            @Override
            public void onResponse(Call<List<PayrolePaymentResponse>> call, Response<List<PayrolePaymentResponse>> response) {
//                hideProgressBar();
                if(response.isSuccessful()){
                    List<PayrolePaymentResponse> payroleResponses = response.body();
                    adapters.setData(payroleResponses);
                    recyclerviewMain.setAdapter(adapters);
                    Log.d("Success",response.body().toString());
                }
            }

            @Override
            public void onFailure(Call<List<PayrolePaymentResponse>> call, Throwable t) {
                Log.d("Failure",t.getLocalizedMessage());


            }
        });
    }

//    private void hideProgressBar() {
//    }
//
//    private void showProgressBar() {
//    }

}