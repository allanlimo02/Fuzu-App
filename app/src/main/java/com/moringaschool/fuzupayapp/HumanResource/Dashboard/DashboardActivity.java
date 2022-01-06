package com.moringaschool.fuzupayapp.HumanResource.Dashboard;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
//import com.moringaschool.fuzupayapp.Holidays.Holiday;
import com.moringaschool.fuzupayapp.APIRequests.Notification.NotificationClient;
import com.moringaschool.fuzupayapp.APIRequests.Notification.NotificationResponse;
import com.moringaschool.fuzupayapp.Holidays.HolidayResponses;
import com.moringaschool.fuzupayapp.Holidays.models.HolidayAdapter;
import com.moringaschool.fuzupayapp.Holidays.models.HolidayClients;
import com.moringaschool.fuzupayapp.HumanResource.Fragments.Leave.LeaveActivity;
import com.moringaschool.fuzupayapp.HumanResource.Fragments.Leave.RequestAPI.RequestClient;
import com.moringaschool.fuzupayapp.HumanResource.Fragments.Leave.RequestAPI.RequestResponse;
import com.moringaschool.fuzupayapp.HumanResource.Fragments.Staff.AddStaffMain;
import com.moringaschool.fuzupayapp.HumanResource.Fragments.Staff.AllStaffActivity;
import com.moringaschool.fuzupayapp.HumanResource.Fragments.Staff.DepartmentsFragment;
import com.moringaschool.fuzupayapp.HumanResource.Fragments.Staff.StaffActivity;
import com.moringaschool.fuzupayapp.R;
import com.moringaschool.fuzupayapp.SwitchAccount.SwitchLogoutActivity;
import com.moringaschool.fuzupayapp.loginAPI.models.LoginResponse;

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
    @BindView(R.id.holidaysRecyclerview)    RecyclerView recycle;
    @BindView(R.id.addstaff) ImageView addstaff;
    @BindView(R.id.onleave) TextView onleave;
    @BindView(R.id.approvebutton)  Button approvebutton;
    @BindView(R.id.errorTextView) TextView mErrorTextView;
    @BindView(R.id.holidayprogressBar) ProgressBar mProgressBar;
    @BindView(R.id.textUser) TextView userName;
    LoginResponse loginResponse;

    @BindView(R.id.imageView6) ImageView notifications;
    @BindView(R.id.imageView5) ImageView logout;
    @BindView(R.id.motifivationsNumberContainer) CardView notify;
    @BindView(R.id.ifleaverequestavailable) LinearLayout ifLeaveRequestAvailable;
    @BindView(R.id.ifleaverequestnotavailable) LinearLayout ifLeaveRequestNotAvailable;
    @BindView(R.id.managestaffbtn) TextView manageStaffBtn;
    @BindView(R.id.relative)  RelativeLayout relative;
    @BindView(R.id.topBarProgress) ProgressBar topBarProgress;
    @BindView(R.id.prog) ProgressBar prog;



    private HolidayAdapter holidayAdapter;


    AllStaffActivity allStaffActivity = new AllStaffActivity();

    @Override
    protected void onStart() {
        super.onStart();
        Intent intent = getIntent();
        if(intent.getExtras() != null){
            loginResponse =(LoginResponse) intent.getSerializableExtra("data");
            userName.setText(loginResponse.getUser().getUsername());
            Log.e("TAG","--------"+loginResponse.getUser().getUsername());
        }
    }

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
        logout.setOnClickListener(this);
        notifications.setOnClickListener(this);
        manageStaffBtn.setOnClickListener(this);
        getLeaveRequests();

        NotificationFetch();

        Intent intent = getIntent();
        if(intent.getExtras() != null){
            loginResponse =(LoginResponse) intent.getSerializableExtra("data");
            userName.setText(loginResponse.getUser().getUsername());
            Log.e("TAG","--------"+loginResponse.getUser().getUsername());
        }


        bottomNavigationView = findViewById(R.id.bottom_navigation);

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

    private void HolidayAll() {
        Call<HolidayResponses>holiday=HolidayClients.getHolidayServices().getHoliday();
        showProgressbar();
        holiday.enqueue(new Callback<HolidayResponses>() {
            @Override
            public void onResponse(Call<HolidayResponses> call, Response<HolidayResponses> response) {
                hideProgressbar();
                if (response.isSuccessful()) {
                    HolidayResponses departmentResponses = response.body();
                    holidayAdapter.setData(departmentResponses);
                    recycle.setAdapter(holidayAdapter);
                    Log.e("successful",response.body().toString());
                }
            }

            @Override
            public void onFailure(Call<HolidayResponses> call, Throwable t) {
                Log.e("failure", t.getLocalizedMessage());
            }
        });
    }

//            @Override
//            public void onFailure(Call<List<HolidayResponse>> call, Throwable t) {
//
//            }
//        });
//    }

    private   void NotificationFetch() {
        Call<List<NotificationResponse>> userlist = NotificationClient.getNotification().getNotification();

        userlist.enqueue(new Callback<List<NotificationResponse>>() {
            @Override
            public void onResponse(Call<List<NotificationResponse>> call, Response<List<NotificationResponse>> response) {
                if (response.isSuccessful()){
                    List<NotificationResponse> notificationIcon = response.body();
                    for(NotificationResponse notes:notificationIcon){
                        String id = String.valueOf(notes.getId().toString());
                        int intid = new Integer(id).intValue();
                        if(intid<1){
                            notify.setVisibility(View.GONE);
                        }
                        else {
                            notify.setVisibility(View.VISIBLE);
                        }
                    }
                }
            }
            @Override
            public void onFailure(Call<List<NotificationResponse>> call, Throwable t) {
                Log.e("failure",t.getLocalizedMessage());
            }
        });
    }
    @Override
    public void onClick(View v) {
        if(v == notifications){
            Intent intent= new Intent(DashboardActivity.this,LeaveActivity.class);
            startActivity(intent);
        }
        if(v==managestaff){
            Intent intent= new Intent(DashboardActivity.this,StaffActivity.class);
            startActivity(intent);
        }
        if(v==departments){
            Intent intent= new Intent(DashboardActivity.this, AllStaffActivity.class);
            String nPage="AddStaffMain";
            startActivity(intent);
        }
        if(v==addstaff){
            Intent intent= new Intent(DashboardActivity.this,AddStaffMain.class);
            String nPage="AddStaffMain";
//            startActivity(new Intent(getApplicationContext(), AddStaffMain.class));
//            overridePendingTransition(0,0);
            startActivity(intent);
        }
        if(v==onleave){
            Intent intent=new Intent(DashboardActivity.this,LeaveActivity.class);
            String nPage="LeaveActivity";
            intent.putExtra("nextPage",nPage);
            startActivity(intent);
        }
        if(v==approvebutton){
            Intent intent=new Intent(DashboardActivity.this,LeaveActivity.class);
//            Intent intent = new Intent(DashboardActivity.this,)
            startActivity(intent);
        }
        if(v == logout){
            startActivity(new Intent(getApplicationContext(), SwitchLogoutActivity.class));
            overridePendingTransition(0,0);
        }
        if(v==manageStaffBtn){
            startActivity(new Intent(getApplicationContext(), StaffActivity.class));
            overridePendingTransition(0,0);
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

    private void showRestaurantss() {
        prog.setVisibility(View.VISIBLE);
    }

    private void hideProgressBars() {
        prog.setVisibility(View.GONE);
    }
    private void showProgressbar() {
        mProgressBar.setVisibility(View.VISIBLE);
    }

    private void hideProgressbar() {
        mProgressBar.setVisibility(View.GONE);
    }


    public void getLeaveRequests(){
        showRestaurantss();
        Call<List<RequestResponse>> userlist = RequestClient.getRequests().getAllRequests();
        userlist.enqueue(new Callback<List<RequestResponse>>() {
            @Override
            public void onResponse(Call<List<RequestResponse>> call, Response<List<RequestResponse>> response) {
                hideProgressBars();
                List<RequestResponse> requestResponses = response.body();
                for(RequestResponse reqres:requestResponses ){
                    String id=String.valueOf(reqres.getId().toString());
                    int listlength=Integer.valueOf(id).intValue();
                    if(id==null){
                        listlength=0;
                    }
                    if(listlength<1){
                        lRequestProgressHide();
                        relative.setBackgroundColor(Color.rgb(0,70,115));
                        ifLeaveRequestNotAvailable.setVisibility(View.VISIBLE);
                        ifLeaveRequestAvailable.setVisibility(View.GONE);
                    }else{
                        lRequestProgressHide();
                        relative.setBackgroundColor(Color.rgb(200, 208, 211));
                        ifLeaveRequestNotAvailable.setVisibility(View.GONE);
                        ifLeaveRequestAvailable.setVisibility(View.VISIBLE);
                    }
            }
            }

            @Override
            public void onFailure(Call<List<RequestResponse>> call, Throwable t) {

            }
        });

    }
    private void lRequestProgressHide(){
        topBarProgress.setVisibility(View.GONE);
    }


}