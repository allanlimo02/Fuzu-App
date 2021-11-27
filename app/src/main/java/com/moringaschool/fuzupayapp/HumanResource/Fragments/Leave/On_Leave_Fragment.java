package com.moringaschool.fuzupayapp.HumanResource.Fragments.Leave;

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

import com.moringaschool.fuzupayapp.HumanResource.LeaveApi.OnLeaveApi;
import com.moringaschool.fuzupayapp.HumanResource.LeaveApi.onLeaveClient;
import com.moringaschool.fuzupayapp.HumanResource.onLeaveAdapter;
import com.moringaschool.fuzupayapp.HumanResource.onLeaveResponse;
import com.moringaschool.fuzupayapp.R;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class On_Leave_Fragment extends Fragment {

    RecyclerView recyclerView;
    onLeaveAdapter OnLeaveAdapter;
    ProgressBar progressBar;
    public On_Leave_Fragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View view = inflater.inflate(R.layout.fragment_on__leave_, container, false);
        recyclerView = view.findViewById(R.id.onLeaveRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.addItemDecoration(new DividerItemDecoration(getActivity(),DividerItemDecoration.VERTICAL));
        progressBar = view.findViewById(R.id.OnProgressBar);
        OnLeaveAdapter = new onLeaveAdapter();
        getAllOnLeave();
       return view;
    }
    public void getAllOnLeave(){

        Call<List<onLeaveResponse>> onLeaveList = onLeaveClient.getUserServices().getAllOnLeave();
        showProgressBar();
        onLeaveList.enqueue(new Callback<List<onLeaveResponse>>() {
            @Override
            public void onResponse(Call<List<onLeaveResponse>> call, Response<List<onLeaveResponse>> response) {
                hideProgressBar();
                if(response.isSuccessful()){
                    List<onLeaveResponse> onLeaveResponses = response.body();
                    OnLeaveAdapter.setData(onLeaveResponses);
                    recyclerView.setAdapter(OnLeaveAdapter);
//                    Log.d("Success",response.body().toString());
                }
            }

            @Override
            public void onFailure(Call<List<onLeaveResponse>> call, Throwable t) {
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
}