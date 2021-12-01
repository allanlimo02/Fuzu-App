package com.moringaschool.fuzupayapp.Finance;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.moringaschool.fuzupayapp.APIRequests.Notification.NotificationClient;
import com.moringaschool.fuzupayapp.APIRequests.Notification.NotificationResponse;
import com.moringaschool.fuzupayapp.Finance.Expences.Finance_Approve_Activity;
import com.moringaschool.fuzupayapp.HumanResource.Dashboard.DashboardActivity;
import com.moringaschool.fuzupayapp.HumanResource.Fragments.Leave.LeaveActivity;
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

public class Dashboard_Finance extends AppCompatActivity implements View.OnClickListener{
    @BindView(R.id.bottom_navigation) BottomNavigationView bottom_navigation;
    @BindView(R.id.textUser) TextView userName;
    @BindView(R.id.advanceholder) LinearLayout advancerequestLinear;
    LoginResponse loginResponse;
    @BindView(R.id.imageView5) ImageView logout;
    @BindView(R.id.advancerequestimage) ImageView advancerequesttxtV;
    @BindView(R.id.approveExpenses) TextView approveExpenses;
    @BindView(R.id.managestaff) ImageView managestaff;
    @BindView(R.id.runpayrollbtn) Button  runpayrollbtn;
    @BindView(R.id.motifivationsNumberContainer)
    CardView notify;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater=getMenuInflater();
        menuInflater.inflate(R.menu.top_navbar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.notification:
                Toast.makeText(this, "No new Notifications", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.switchaccount:
                Intent intent=new Intent(Dashboard_Finance.this,DashboardActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
                return true;
            case R.id.logout:
                Intent newintent=new Intent(Dashboard_Finance.this,Log_In_finance.class);
                newintent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(newintent);
                return true;

        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.finance_dashboard_activity);
        ButterKnife.bind(this);

        logout.setOnClickListener(this);
        managestaff.setOnClickListener(this);
        approveExpenses.setOnClickListener(this);
        advancerequesttxtV.setOnClickListener(this);
        runpayrollbtn.setOnClickListener(this);

        NotificationFetch();

//        displayName
        Intent intent = getIntent();
        if(intent.getExtras() != null){
            loginResponse =(LoginResponse) intent.getSerializableExtra("data");
            userName.setText(loginResponse.getUser().getUsername());
            Log.e("TAG","--------"+loginResponse.getUser().getUsername());
        }
        bottom_navigation.setSelectedItemId(R.id.nav_home);
        bottom_navigation.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.nav_home:
                        return true;
                    case R.id.nav_payroll:
                        startActivity(new Intent(getApplicationContext(), Payroll2.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.nav_expenses:
                        startActivity(new Intent(getApplicationContext(), Finance_Approve_Activity.class));
                        overridePendingTransition(0,0);
                        return true;
                }
                return false;
            }
        });
    }

    @Override
    public void onClick(View v) {
        if(v == logout){
            startActivity(new Intent(getApplicationContext(), SwitchLogoutActivity.class));
            overridePendingTransition(0,0);
        }
        if(v==managestaff){
            startActivity(new Intent(getApplicationContext(), Payroll2.class));
            overridePendingTransition(0,0);

        }
        if(v==approveExpenses){
            startActivity(new Intent(getApplicationContext(), Finance_Approve_Activity.class));
            overridePendingTransition(0,0);


        }
        if(v==advancerequesttxtV){
            startActivity(new Intent(getApplicationContext(), Payroll2.class));
            overridePendingTransition(0,0);

        }
        if(v==runpayrollbtn){
            startActivity(new Intent(getApplicationContext(), Payroll2.class));
            overridePendingTransition(0,0);
        }

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

}