package com.moringaschool.fuzupayapp.HumanResource.Dashboard;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.moringaschool.fuzupayapp.Holidays.Holiday;
import com.moringaschool.fuzupayapp.Holidays.Responses;
import com.moringaschool.fuzupayapp.HumanResource.Fragments.Leave.LeaveActivity;
import com.moringaschool.fuzupayapp.HumanResource.Fragments.Staff.StaffActivity;
import com.moringaschool.fuzupayapp.HumanResource.HrAdapters.HrListAdaper;
//import com.moringaschool.fuzupayapp.HumanResource.HrApiInterface.HolidayClient;
import com.moringaschool.fuzupayapp.HumanResource.HrApiInterface.hrApi;
import com.moringaschool.fuzupayapp.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DashboardActivity extends AppCompatActivity {
    @BindView(R.id.bottom_navigation)
    BottomNavigationView bottomNavigationView;
    @BindView(R.id.errorTextView)
    TextView mErrorTextView;
    @BindView(R.id.holidayprogressBar)
    ProgressBar mProgressBar;
    @BindView(R.id.textUser)TextView
    Username;
    @BindView(R.id.holidaysRecyclerview)
    RecyclerView mRecyclerView;
    private HrListAdaper mAdapter;
    public List<Holiday> mHoliday;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        ButterKnife.bind(this);
        String Country = "KE";

//        hrApi client = HolidayClient.getClient();
//        Call<Responses> call = client.getHoliday("2021",Country);

//        call.enqueue(new Callback<Responses>() {
//            @Override
//            public void onResponse(Call<Responses> call, Response<Responses> response) {
//                hideProgressBar();
//                if (response.isSuccessful()) {
//                    mHoliday = response.body().getHolidays();
//                    mAdapter = new HrListAdaper(DashboardActivity.this, mHoliday);

//
//                    mRecyclerView.setAdapter(mAdapter);
//                    RecyclerView.LayoutManager layoutManager =
//                            new LinearLayoutManager(DashboardActivity.this);
//                    mRecyclerView.setLayoutManager(layoutManager);
//                    mRecyclerView.setHasFixedSize(true);
//
//                    showRestaurants();
//
////                    mErrorTextView.setText("yeii");
////                    mErrorTextView.setVisibility(View.VISIBLE);
//                } else {
//                    showUnsuccessfulMessage();
//                }
//            }
//
//            @Override
//            public void onFailure(Call<Responses> call, Throwable t) {
//                Log.e("Error Message", "onFailure: ",t );
//                hideProgressBar();
//                showFailureMessage();
//            }
//
//        });


        bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.nav_home);

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {


                switch (item.getItemId()) {
                    case R.id.nav_home:
                        return true;
                    case R.id.nav_leave:
                        startActivity(new Intent(getApplicationContext(), LeaveActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.nav_staff:
                        startActivity(new Intent(getApplicationContext(), StaffActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                }
                return false;
            }
        });
    }

    private void showFailureMessage() {
        mErrorTextView.setText("Something went wrong. Please check your Internet connection and try again later");
        mErrorTextView.setVisibility(View.VISIBLE);
    }

    private void showUnsuccessfulMessage() {
        mErrorTextView.setText("Something went wrong. Please try again later");
        mErrorTextView.setVisibility(View.VISIBLE);
    }

    private void showRestaurants() {
        mRecyclerView.setVisibility(View.VISIBLE);
//        mLocationTextView.setVisibility(View.VISIBLE);
    }

    private void hideProgressBar() {
        mProgressBar.setVisibility(View.GONE);
    }
}