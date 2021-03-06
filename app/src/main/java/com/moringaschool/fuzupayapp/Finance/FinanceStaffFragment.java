package com.moringaschool.fuzupayapp.Finance;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.moringaschool.fuzupayapp.APIRequests.StaffApiResources.Models.StaffResponse;
import com.moringaschool.fuzupayapp.APIRequests.StaffApiResources.StaffAdapter;
import com.moringaschool.fuzupayapp.APIRequests.StaffApiResources.StaffInterface;
import com.moringaschool.fuzupayapp.Finance.ExpensesApi.CompletedAdapter.ECompletedAdapter;
import com.moringaschool.fuzupayapp.Finance.ExpensesApi.EcompletedClient;
import com.moringaschool.fuzupayapp.Finance.ExpensesApi.EcompletedResponse;
import com.moringaschool.fuzupayapp.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class FinanceStaffFragment extends Fragment  implements View.OnClickListener{


    @BindView(R.id.relativeTwo) RelativeLayout relativeTwo;
    @BindView(R.id.headingPart) RelativeLayout headingPart;
    @BindView(R.id.frameComplete) RecyclerView recyclerComplete;
    Context context;
    ECompletedAdapter eCompletedAdapter;
    ProgressBar progressBar;

//    private Factory GsonConverterFactory;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.finance_fragment_staff, container, false);
        ButterKnife.bind(this,view);
//    rowone.setOnClickListener(this);
//    row2.setOnClickListener(this);
//    row3.setOnClickListener(this);
//        recyclerComplete.hasFixedSize();
//        recyclerComplete.setLayoutManager(new LinearLayoutManager(context));
        recyclerComplete = view.findViewById(R.id.frameComplete);
        recyclerComplete.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerComplete.addItemDecoration(new DividerItemDecoration(getActivity(),DividerItemDecoration.VERTICAL));
        progressBar = view.findViewById(R.id.completeProgress);
        eCompletedAdapter = new ECompletedAdapter();
        getCompletedExpe();

        return view;

    }

    private void getCompletedExpe() {
        Call<List<EcompletedResponse>> ecompletedList = EcompletedClient.getCompletedService().getCompletedExpense();
        showProgressBar();
        ecompletedList.enqueue(new Callback<List<EcompletedResponse>>() {
            @Override
            public void onResponse(Call<List<EcompletedResponse>> call, Response<List<EcompletedResponse>> response) {
               hideProgressBar();
                if(response.isSuccessful()){
                    List<EcompletedResponse> ecompletedResponses = response.body();
                    eCompletedAdapter.setData(ecompletedResponses);
                    recyclerComplete.setAdapter(eCompletedAdapter);
                    Toast.makeText(getContext(), "success", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<EcompletedResponse>> call, Throwable t) {
                Log.d("Failure",t.getLocalizedMessage());

            }
        });
    }
    private void showProgressBar() {
        progressBar.setVisibility(View.VISIBLE);
    }
    private void hideProgressBar() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void onClick(View v) {
//    if(v==rowone){
//        relativeTwo.setVisibility(View.GONE);
//        headingPart.setVisibility(View.GONE);
//        FragmentTransaction fragmentTransaction = getChildFragmentManager().beginTransaction();
//        fragmentTransaction.replace(R.id.framebabu,new SingleStaffFragment());
//        fragmentTransaction.commit();
//        babu.setVisibility(View.GONE);
//
//    }
//    if(v==row2){
//        relativeTwo.setVisibility(View.GONE);
//        headingPart.setVisibility(View.GONE);
//        FragmentTransaction fragmentTransaction = getChildFragmentManager().beginTransaction();
//        fragmentTransaction.replace(R.id.framebabu,new SingleStaffFragment());
//        fragmentTransaction.commit();
//        babu.setVisibility(View.GONE);
//
//    }
//    if(v==row3){
//        relativeTwo.setVisibility(View.GONE);
//        headingPart.setVisibility(View.GONE);
//        FragmentTransaction fragmentTransaction = getChildFragmentManager().beginTransaction();
//        fragmentTransaction.replace(R.id.framebabu,new SingleStaffFragment());
//        fragmentTransaction.commit();
//        babu.setVisibility(View.GONE);
//    }
    }
    //Get Staff from API

//    public void getStafffResponse(){
//        StaffInterface staffInterface= StaffClientClass.getClient();
//        Call<StaffResponse>call=staffInterface.getStaff();
//        call.enqueue(new Callback<StaffResponse>() {
//            @Override
//            public void onResponse(Call<StaffResponse> call, Response<StaffResponse> response) {
//                if(response.isSuccessful()){
////                    List<StaffResponse> staff=response;
//                    String[] staff=new String[response.headers().size()];
//                }
//            }
//            @Override
//            public void onFailure(Call<StaffResponse> call, Throwable t) {
//
//            }
//        });
//    }
}