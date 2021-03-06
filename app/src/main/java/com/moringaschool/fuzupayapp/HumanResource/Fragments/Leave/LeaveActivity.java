package com.moringaschool.fuzupayapp.HumanResource.Fragments.Leave;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.moringaschool.fuzupayapp.APIRequests.Notification.NotificationClient;
import com.moringaschool.fuzupayapp.APIRequests.Notification.NotificationResponse;
import com.moringaschool.fuzupayapp.HumanResource.Dashboard.DashboardActivity;
import com.moringaschool.fuzupayapp.HumanResource.Fragments.Leave.PostrequestApi.PostLeaveRequest;
import com.moringaschool.fuzupayapp.HumanResource.Fragments.Leave.PostrequestApi.PostClient;
import com.moringaschool.fuzupayapp.HumanResource.Fragments.Leave.PostrequestApi.PostResponses;
import com.moringaschool.fuzupayapp.HumanResource.Fragments.Leave.RequestAPI.RequestAdapter;
import com.moringaschool.fuzupayapp.HumanResource.Fragments.Leave.RequestAPI.RequestClient;
import com.moringaschool.fuzupayapp.HumanResource.Fragments.Leave.RequestAPI.RequestResponse;
import com.moringaschool.fuzupayapp.HumanResource.Fragments.Staff.APIApploadDocs.Bank.Docs.DocsApploadApiClient;
import com.moringaschool.fuzupayapp.HumanResource.Fragments.Staff.APIApploadDocs.Bank.Docs.DocsApploadUserResponse;
import com.moringaschool.fuzupayapp.HumanResource.Fragments.Staff.StaffActivity;
import com.moringaschool.fuzupayapp.R;
import com.moringaschool.fuzupayapp.SwitchAccount.SwitchLogoutActivity;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LeaveActivity extends AppCompatActivity implements RequestAdapter.ClickedLeave, View.OnClickListener{
    @BindView(R.id.bottom_navigation) BottomNavigationView mBottomNavigationView;
    @BindView(R.id.fragmentOneBtn2) Button fragmentOneBtn2;
    @BindView(R.id.fragmentTwoBtn2) Button fragmentTwoBtn2;
    @BindView(R.id.recviewRequest)  RecyclerView recyclerView2;
    @BindView(R.id.lineLayout)    RelativeLayout lineLayout;
    BottomNavigationView bottomNavigationView;
    @BindView(R.id.imageView5)
    ImageView logout;
//    @BindView(R.id.iconTick) ImageView iconTick;
//    @BindView(R.id.xIcon) ImageView xIcon;

    @BindView(R.id.progressBars)
    ProgressBar progressBar;
    @BindView(R.id.pleasewaits)
    TextView pleasewait;
    @BindView(R.id.motifivationsNumberContainer)
    CardView notify;


   RequestAdapter requestAdapter;

    //    fragment inititializations
//    private TextView fragmentOneBtn2, fragmentTwoBtn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leave2);

        ButterKnife.bind(this);



        fragmentTwoBtn2.setOnClickListener(this);
        fragmentOneBtn2.setOnClickListener(this);
        logout.setOnClickListener(this);

        NotificationFetch();

        recyclerView2.setLayoutManager(new LinearLayoutManager(this));
        recyclerView2.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));
        requestAdapter = new RequestAdapter(this::ClickedUserleave);

        getAll();

        bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.nav_leave);
        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.nav_home:
                        startActivity(new Intent(getApplicationContext(), DashboardActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.nav_leave:
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
public void getAll(){
    Call<List<RequestResponse>> userlist = RequestClient.getRequests().getAllRequests();
    showProgressbar();
    userlist.enqueue(new Callback<List<RequestResponse>>() {
        @Override
        public void onResponse(Call<List<RequestResponse>> call, Response<List<RequestResponse>> response) {
            if (response.isSuccessful()) {
                List<RequestResponse> requestResponses = response.body();
                hideProgressbar();
                requestAdapter.setData(requestResponses);
                recyclerView2.setAdapter(requestAdapter);
            }
                else {
                }
            }

        @Override
        public void onFailure(Call<List<RequestResponse>> call, Throwable t) {
        }
    });
}

    public  void NotificationFetch() {
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

//                        }

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
    public void onStart() {
        super.onStart();
        Intent intent=getIntent();
        String broughtIntents=intent.getStringExtra("nextPage");

        if(broughtIntents=="LeaveActivity"){
            Toast.makeText(LeaveActivity.this, broughtIntents, Toast.LENGTH_SHORT).show();
            fragmentTwoBtn2.setBackgroundColor(Color.rgb(0,70,115));
            fragmentOneBtn2.setBackgroundColor(Color.WHITE);
            fragmentTwoBtn2.setTextColor(Color.WHITE);
            fragmentOneBtn2.setTextColor(Color.BLACK);
            recyclerView2.setVisibility(View.GONE);
            lineLayout.setVisibility(View.GONE);
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.frameLayout2,new On_Leave_Fragment());
            fragmentTransaction.commit();
        }
        else{
            fragmentTwoBtn2.setBackgroundColor(Color.WHITE);
            fragmentOneBtn2.setBackgroundColor(Color.rgb(0,70,115));
            fragmentTwoBtn2.setTextColor(Color.BLACK);
            fragmentOneBtn2.setTextColor(Color.WHITE);
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.frameLayout2,new Leave_Request_Fragment());
            fragmentTransaction.commit();
        }

    }

    public void removeItem(int position){
        requestAdapter.notifyItemRemoved(position);
    }


    @Override
    public void onClick(View v) {
        if(v == fragmentOneBtn2){
            fragmentTwoBtn2.setBackgroundColor(Color.WHITE);
            fragmentOneBtn2.setBackgroundColor(Color.rgb(0,70,115));
            fragmentTwoBtn2.setTextColor(Color.BLACK);
            fragmentOneBtn2.setTextColor(Color.WHITE);
            recyclerView2.setVisibility(View.VISIBLE);
            lineLayout.setVisibility(View.VISIBLE);
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.frameLayout2,new Leave_Request_Fragment());
            fragmentTransaction.commit();
        }

        if(v == fragmentTwoBtn2){
            fragmentTwoBtn2.setBackgroundColor(Color.rgb(0,70,115));
            fragmentOneBtn2.setBackgroundColor(Color.WHITE);
            fragmentTwoBtn2.setTextColor(Color.WHITE);
            fragmentOneBtn2.setTextColor(Color.BLACK);
            recyclerView2.setVisibility(View.GONE);
            lineLayout.setVisibility(View.GONE);
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.frameLayout2,new On_Leave_Fragment());
            fragmentTransaction.commit();
        }
        if(v == logout){
            startActivity(new Intent(getApplicationContext(), SwitchLogoutActivity.class));
            overridePendingTransition(0,0);
        }


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
    public void ClickedUserleave(RequestResponse requestResponse) {
        PostLeaveRequest postLeaveRequest = new PostLeaveRequest();

        String employee = requestResponse.getEmployee().toString();
        String leave_type = requestResponse.getLeaveType().toString();
        String department = requestResponse.getDepartment().toString();
        String employment_type = requestResponse.getEmploymentType().toString();

        postLeaveRequest.setEmployee(employee);
        postLeaveRequest.setLeave_type(leave_type);
        postLeaveRequest.setDepartment(department);
        postLeaveRequest.setEmployment_type(employment_type);
        Log.e("eiop",employee);
        removeItem(0);


        Call<PostResponses> docsApploadUserResponseCall = PostClient.getleaveservice().saveLeave(postLeaveRequest);
        docsApploadUserResponseCall.enqueue(new Callback<PostResponses>() {
            @Override
            public void onResponse(Call<PostResponses> call, Response<PostResponses> response) {

                if (response.isSuccessful()) {
                    Toast.makeText(LeaveActivity.this, "saved successfully", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(LeaveActivity.this, " not saved successfully", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<PostResponses> call, Throwable t) {
                Toast.makeText(LeaveActivity.this, t.getMessage(), Toast.LENGTH_LONG).show();
                Toast.makeText(LeaveActivity.this, "Well Successfully but on Failure", Toast.LENGTH_SHORT).show();
            }
//
//            @Override
//            public void onFailure(Call<DocsApploadUserResponse> call, Throwable t) {
//
//                Toast.makeText(LeaveActivity.this, t.getMessage(), Toast.LENGTH_LONG).show();
//                Toast.makeText(LeaveActivity.this, "Well Successfully but on Failure", Toast.LENGTH_SHORT).show();
//            }
        });


    }

//    private PostLeaveRequest save() {
//        RequestResponse requestResponse = new RequestResponse();
//        PostLeaveRequest postLeaveRequest = new PostLeaveRequest();
//
//
//        String employee = requestResponse.getEmployee().toString();
//        String leave_type = requestResponse.getLeaveType().toString();
//        String department = requestResponse.getDepartment().toString();
//        String employment_type = requestResponse.getEmploymentType().toString();
//
//        postLeaveRequest.setEmployee(employee);
//        postLeaveRequest.setLeave_type(leave_type);
//        postLeaveRequest.setDepartment(department);
//        postLeaveRequest.setEmployment_type(employment_type);
//        Log.e("eiop",employee);
//        removeItem(0);
//return postLeaveRequest;
//    }

    private void saveleaves(PostLeaveRequest postLeaveRequest) {
        Call<PostResponses> docsApploadUserResponseCall = PostClient.getleaveservice().saveLeave(postLeaveRequest);
        docsApploadUserResponseCall.enqueue(new Callback<PostResponses>() {
            @Override
            public void onResponse(Call<PostResponses> call, Response<PostResponses> response) {

                if (response.isSuccessful()) {
                    Toast.makeText(LeaveActivity.this, "saved successfully", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(LeaveActivity.this, " not saved successfully", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<PostResponses> call, Throwable t) {
                Toast.makeText(LeaveActivity.this, t.getMessage(), Toast.LENGTH_LONG).show();
                Toast.makeText(LeaveActivity.this, "Well Successfully but on Failure", Toast.LENGTH_SHORT).show();
            }
//
//            @Override
//            public void onFailure(Call<DocsApploadUserResponse> call, Throwable t) {
//
//                Toast.makeText(LeaveActivity.this, t.getMessage(), Toast.LENGTH_LONG).show();
//                Toast.makeText(LeaveActivity.this, "Well Successfully but on Failure", Toast.LENGTH_SHORT).show();
//            }
        });


    }


}