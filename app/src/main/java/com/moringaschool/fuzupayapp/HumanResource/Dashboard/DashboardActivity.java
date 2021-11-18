package com.moringaschool.fuzupayapp.HumanResource.Dashboard;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.petyfinderip_version2.models.SearchResponse;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
//import com.moringaschool.fuzupayapp.Holidays.Holiday;
import com.example.petyfinderip_version2.models.Animal;
import com.moringaschool.fuzupayapp.HumanResource.Fragments.Leave.LeaveActivity;
import com.moringaschool.fuzupayapp.HumanResource.Fragments.Staff.AddStaffMain;
import com.moringaschool.fuzupayapp.HumanResource.Fragments.Staff.AllStaffActivity;
import com.moringaschool.fuzupayapp.HumanResource.Fragments.Staff.DepartmentsFragment;
import com.moringaschool.fuzupayapp.HumanResource.Fragments.Staff.StaffActivity;
import com.moringaschool.fuzupayapp.HumanResource.HrAdapters.HrListAdaper;
import com.moringaschool.fuzupayapp.HumanResource.HrApiInterface.HolidayClient;
import com.moringaschool.fuzupayapp.HumanResource.HrApiInterface.hrApi;
import com.moringaschool.fuzupayapp.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DashboardActivity extends AppCompatActivity  implements View.OnClickListener{
    @BindView(R.id.bottom_navigation) BottomNavigationView bottomNavigationView;
    @BindView(R.id.managestaff) ImageView managestaff;
    @BindView(R.id.departments) ImageView departments;
    @BindView(R.id.holidaysRecyclerview)
    RecyclerView recycle;
    @BindView(R.id.addstaff) ImageView addstaff;
    @BindView(R.id.onleave) TextView onleave;
    @BindView(R.id.approvebutton)  Button approvebutton;
  
    @BindView(R.id.errorTextView) TextView mErrorTextView;
    @BindView(R.id.holidayprogressBar)
    ProgressBar mProgressBar;

    private HrListAdaper mAdapter;
    public List<Animal> genders;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        ButterKnife.bind(this);
        managestaff.setOnClickListener(this);
        departments.setOnClickListener(this);
        addstaff.setOnClickListener(this);
        onleave.setOnClickListener(this);
        approvebutton.setOnClickListener(this);


        bottomNavigationView = findViewById(R.id.bottom_navigation);

//        API
        hrApi client = HolidayClient.getClient();
        Call<SearchResponse> call = client.getPets("horse");

        call.enqueue(new Callback<com.example.petyfinderip_version2.models.SearchResponse>() {
            @Override
            public void onResponse(Call<com.example.petyfinderip_version2.models.SearchResponse> call, Response<com.example.petyfinderip_version2.models.SearchResponse> response) {
                hideProgressBar();
                if (response.isSuccessful()) {
                    genders = response.body().getAnimals();
                    mAdapter = new HrListAdaper(DashboardActivity.this, genders);

                    recycle.setAdapter(mAdapter);
                    RecyclerView.LayoutManager layoutManager =
                            new LinearLayoutManager(DashboardActivity.this);
                    recycle.setLayoutManager(layoutManager);
                    recycle.setHasFixedSize(true);
                    showRestaurants();

                } else {
                    showUnsuccessfulMessage();
                }
            }

            @Override
            public void onFailure(Call<com.example.petyfinderip_version2.models.SearchResponse> call, Throwable t) {
                Log.e("Error Message", "onFailure: ",t );
                hideProgressBar();
                showFailureMessage();
            }

        });

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
    @Override
    public void onClick(View v) {
        if(v==managestaff){
            Intent intent= new Intent(DashboardActivity.this,StaffActivity.class);
            startActivity(intent);
        }
        if(v==departments){
            Intent intent= new Intent(DashboardActivity.this, AllStaffActivity.class);
            startActivity(intent);
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.ourFrameLayout,new DepartmentsFragment());
            fragmentTransaction.commit();
        }
        if(v==addstaff){
            Intent intent= new Intent(DashboardActivity.this,AddStaffMain.class);
//            startActivity(new Intent(getApplicationContext(), AddStaffMain.class));
//            overridePendingTransition(0,0);
            startActivity(intent);
        }
        if(v==onleave){
            Intent intent= new Intent(DashboardActivity.this,LeaveActivity.class);
            startActivity(intent);
        }
        if(v==approvebutton){
            Intent intent=new Intent(DashboardActivity.this,LeaveActivity.class);
            startActivity(intent);
        }
    }
    private void openDepartments(){
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.ourFrameLayout,new DepartmentsFragment());
        fragmentTransaction.commit();
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
        recycle.setVisibility(View.VISIBLE);
    }

    private void hideProgressBar() {
        mProgressBar.setVisibility(View.GONE);
    }
}