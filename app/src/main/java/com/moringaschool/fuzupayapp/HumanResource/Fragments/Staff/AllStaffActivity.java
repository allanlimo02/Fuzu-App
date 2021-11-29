package com.moringaschool.fuzupayapp.HumanResource.Fragments.Staff;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import android.util.Log;

import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.moringaschool.fuzupayapp.APIRequests.StaffApiResources.ItemOnclickPosition;
import com.moringaschool.fuzupayapp.APIRequests.StaffApiResources.Models.StaffResponse;
import com.moringaschool.fuzupayapp.APIRequests.StaffApiResources.StaffAdapter;
import com.moringaschool.fuzupayapp.APIRequests.StaffApiResources.StaffClientClass;
import com.moringaschool.fuzupayapp.HumanResource.Dashboard.DashboardActivity;
import com.moringaschool.fuzupayapp.HumanResource.Fragments.Leave.LeaveActivity;
import com.moringaschool.fuzupayapp.R;
import com.moringaschool.fuzupayapp.SwitchAccount.SwitchLogoutActivity;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AllStaffActivity extends AppCompatActivity  implements View.OnClickListener, ItemOnclickPosition{
    @BindView(R.id.ourViewStaffHolder)  RecyclerView ourViewStaffHolder;
    @BindView(R.id.bottom_navigation)    BottomNavigationView bottomNavigationView;
    @BindView(R.id.fragmentOneBtn)   Button fragmentOneBtn;
    @BindView(R.id.fragmentTwoBtn)  Button fragmentTwoBtn;
    @BindView(R.id.fragmentThreeBtn)  Button fragmentThreeBtn;
    @BindView(R.id.ourFrameLayout)  FrameLayout ourFrameLayout;
    @BindView(R.id.titleBar) RelativeLayout titleBar;
    @BindView(R.id.imageView5) ImageView logout;
    @BindView(R.id.progressBar2) ProgressBar progressBar;
    @BindView(R.id.pleasewait) TextView pleasewait;
    Context context;
    StaffAdapter staffAdapter;
    private ItemOnclickPosition itemOnclickPosition;



//    private List list;
//    private String[] names=new String[]{"Allan Limo","AronLangat","Esther Moki","Judy Rop","Erick Okumu"};
//    private String[] position= new String[]{"Manager","C.E.O","Developer","Tester","Production"};
//    private String[] employmentType= new String[]{" Full time","Contract","Full time","Internship","Internship"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_staff);
        ButterKnife.bind(this);

        fragmentTwoBtn.setOnClickListener(this);
        fragmentOneBtn.setOnClickListener(this);
        fragmentThreeBtn.setOnClickListener(this);
        logout.setOnClickListener(this);



        ourViewStaffHolder.setLayoutManager(new LinearLayoutManager(this));
        ourViewStaffHolder.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));

        staffAdapter=new StaffAdapter();
        fetchAPI();

        bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.nav_staff);

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {


                switch (item.getItemId()) {
                    case R.id.nav_home:
                        startActivity(new Intent(getApplicationContext(), DashboardActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.nav_leave:
                        startActivity(new Intent(getApplicationContext(), LeaveActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.nav_staff:
                        return true;
                }
                return false;
            }
        });
        //API RESPONSE
//
//
    }
    private void fetchAPI(){
        Call<List<StaffResponse>> stafflist= StaffClientClass.staffInterface().getStaff();
        showProgressbar();
        stafflist.enqueue(new Callback<List<StaffResponse>>() {

            @Override
            public void onResponse(Call<List<StaffResponse>> call, Response<List<StaffResponse>> response) {
                hideProgressbar();
                if(response.isSuccessful()){

                    List<StaffResponse> staffResponses=response.body();
                    staffAdapter.StaffAdapterFilled(staffResponses,itemOnclickPosition);
                    ourViewStaffHolder.setAdapter(staffAdapter);
                }
            }
            @Override
            public void onFailure(Call<List<StaffResponse>> call, Throwable t) {
                hideProgressbar();
                Log.d("Haiwezimake",t.getLocalizedMessage());
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        fetchAPI();
        fragmentThreeBtn.setBackgroundColor(Color.WHITE);
        fragmentTwoBtn.setBackgroundColor(Color.WHITE);
        fragmentOneBtn.setBackgroundColor(Color.rgb(0,70,115));
        fragmentTwoBtn.setTextColor(Color.BLACK);
        fragmentThreeBtn.setTextColor(Color.BLACK);
        fragmentOneBtn.setTextColor(Color.WHITE);
    }

    @Override
    public void onClick(View v) {
        if(v==fragmentOneBtn){
            fragmentThreeBtn.setBackgroundColor(Color.WHITE);
            fragmentTwoBtn.setBackgroundColor(Color.WHITE);
            fragmentOneBtn.setBackgroundColor(Color.rgb(0,70,115));
            fragmentTwoBtn.setTextColor(Color.BLACK);
            fragmentThreeBtn.setTextColor(Color.BLACK);
            fragmentOneBtn.setTextColor(Color.WHITE);
            titleBar.setVisibility(View.VISIBLE);
            startActivity(new Intent(getApplicationContext(), AllStaffActivity.class));
            overridePendingTransition(0,0);
        }

        if(v==fragmentTwoBtn){
            fragmentTwoBtn.setBackgroundColor(Color.rgb(0,70,115));
            fragmentThreeBtn.setBackgroundColor(Color.WHITE);
            fragmentOneBtn.setBackgroundColor(Color.WHITE);
            fragmentTwoBtn.setTextColor(Color.WHITE);
            fragmentThreeBtn.setTextColor(Color.BLACK);
            fragmentOneBtn.setTextColor(Color.BLACK);
            ourViewStaffHolder.setVisibility(View.GONE);
            titleBar.setVisibility(View.GONE);
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.ourFrameLayout,new DepartmentsFragment());
            fragmentTransaction.commit();
        }

        if(v==fragmentThreeBtn){
            fragmentThreeBtn.setBackgroundColor(Color.rgb(0,70,115));
            fragmentTwoBtn.setBackgroundColor(Color.WHITE);
            fragmentOneBtn.setBackgroundColor(Color.WHITE);
            fragmentTwoBtn.setTextColor(Color.BLACK);
            fragmentThreeBtn.setTextColor(Color.WHITE);
            fragmentOneBtn.setTextColor(Color.BLACK);
            startActivity(new Intent(getApplicationContext(), AddStaffMain.class));
            overridePendingTransition(0,0);

        }
        if(v == logout){
            startActivity(new Intent(getApplicationContext(), SwitchLogoutActivity.class));
            overridePendingTransition(0,0);
        }


    }
    private void fragmentlaunch(){
        FragmentTransaction fragmentTransaction= getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout,new SingleStaffFragment());
        fragmentTransaction.commit();
    }
    private void showProgressbar(){
        progressBar.setVisibility(View.VISIBLE);
        pleasewait.setVisibility(View.VISIBLE);
    }
    private void hideProgressbar(){
        progressBar.setVisibility(View.GONE);
        pleasewait.setVisibility(View.GONE);
    }


    @Override
    public void onItemClick(int position) {


    }


    //Api part
//    EmploymentApi client = EmploymentClient.getClient();
//    Call<EmploymentSearchResponse> call = client.getEmployment("employmentType");
//
//    call.enqueue(new Callback<EmploymentSearchResponse>(){
//        @Override
//                public void onResponse (Call<EmploymentSearchResponse> call, Response<EmploymentSearchResponse> response){
//                if (response.isSuccessful()) {
//                    List<name> namList = response.body.getNames();
//                }
//        }
//    })

}