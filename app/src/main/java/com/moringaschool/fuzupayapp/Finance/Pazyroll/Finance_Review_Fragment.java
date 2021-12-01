package com.moringaschool.fuzupayapp.Finance.Pazyroll;

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

import com.moringaschool.fuzupayapp.Finance.Pazyroll.reviewApi.ReviewAdapter;
import com.moringaschool.fuzupayapp.Finance.Pazyroll.reviewApi.ReviewClient;
import com.moringaschool.fuzupayapp.Finance.Pazyroll.reviewApi.reviewResponse;
import com.moringaschool.fuzupayapp.HumanResource.LeaveApi.onLeaveClient;
import com.moringaschool.fuzupayapp.HumanResource.onLeaveAdapter;
import com.moringaschool.fuzupayapp.HumanResource.onLeaveResponse;
import com.moringaschool.fuzupayapp.R;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Finance_Review_Fragment extends Fragment {

    RecyclerView recyclerView;
    ReviewAdapter reviewAdapter;
    ProgressBar progressBar;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_finance__review_, container, false);
        recyclerView = view.findViewById(R.id.reviewRecycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.addItemDecoration(new DividerItemDecoration(getActivity(),DividerItemDecoration.VERTICAL));
        progressBar = view.findViewById(R.id.reviewProgressBar);
        reviewAdapter = new ReviewAdapter();
        getAllReviews();
        return view;
    }

    private void getAllReviews() {
        Call<List<reviewResponse>> reviewResponseList = ReviewClient.getStaffReviews().getStaffReviews();
        showProgressBar();
        reviewResponseList.enqueue(new Callback<List<reviewResponse>>() {

            @Override
            public void onResponse(Call<List<reviewResponse>> call, Response<List<reviewResponse>> response) {

                hideProgressBar();
                if(response.isSuccessful()){
                    List<reviewResponse> reviewResponses = response.body();
                    reviewAdapter.setData(reviewResponses);
                    recyclerView.setAdapter(reviewAdapter);
//                    Log.d("Success",response.body().toString());
                }
            }

            @Override
            public void onFailure(Call<List<reviewResponse>> call, Throwable t) {
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