package com.moringaschool.fuzupayapp.Finance;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.moringaschool.fuzupayapp.APIRequests.Notification.NotificationClient;
import com.moringaschool.fuzupayapp.APIRequests.Notification.NotificationResponse;
import com.moringaschool.fuzupayapp.Finance.Expences.Finance_Approve_Activity;
import com.moringaschool.fuzupayapp.Finance.Fragments.FinanceComingSoon;
import com.moringaschool.fuzupayapp.Finance.Fragments.NewrunFragment;
import com.moringaschool.fuzupayapp.Finance.Pazyroll.financePayroll_1;
import com.moringaschool.fuzupayapp.HumanResource.Fragments.Leave.Leave_Request_Fragment;
import com.moringaschool.fuzupayapp.HumanResource.Fragments.Staff.AllStaffActivity;
import com.moringaschool.fuzupayapp.R;
import com.moringaschool.fuzupayapp.SwitchAccount.SwitchLogoutActivity;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Payroll2 extends AppCompatActivity implements View.OnClickListener{
    @BindView(R.id.newrun)  TextView newrun;
    @BindView(R.id.payroll) TextView payrollbtn;
    @BindView(R.id.staff) TextView staffbtn;
    @BindView(R.id.nframe) FrameLayout frameLayout;

    @BindView(R.id.bottom_navigation)
    BottomNavigationView bottom_navigation;
    @BindView(R.id.imageView5)
    ImageView logout;
    @BindView(R.id.motifivationsNumberContainer)
    CardView notify;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.finance_activity_payroll2);
        ButterKnife.bind(this);

        newrun.setOnClickListener(this);
        payrollbtn.setOnClickListener(this);
        staffbtn.setOnClickListener(this);
        logout.setOnClickListener(this);

        NotificationFetch();
        bottom_navigation.setSelectedItemId(R.id.nav_payroll);
        bottom_navigation.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.nav_home:
                        startActivity(new Intent(getApplicationContext(), Dashboard_Finance.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.nav_payroll:
                        return true;
                    case R.id.nav_expenses:
                        startActivity(new Intent(getApplicationContext(), Finance_Approve_Activity.class));
                        overridePendingTransition(0,0);
//                        Toast.makeText(Payroll2.this, "Coming Soon", Toast.LENGTH_SHORT).show();
                        return true;

                }
                return false;
            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
        newrun.setBackgroundColor(Color.rgb(0,70,115));
        newrun.setTextColor(Color.WHITE);
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.nframe,new NewrunFragment());
        fragmentTransaction.commit();
    }

    @Override
    public void onClick(View v) {

        if(v==newrun){
            newrun.setBackgroundColor(Color.rgb(0,70,115));
            newrun.setTextColor(Color.WHITE);
            payrollbtn.setBackgroundResource(R.drawable.thin_border);
            payrollbtn.setTextColor(Color.rgb(0,70,115));
            staffbtn.setBackgroundResource(R.drawable.thin_border);
            staffbtn.setTextColor(Color.rgb(0,70,115));
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.nframe,new NewrunFragment());
            fragmentTransaction.commit();
        }
        if(v==payrollbtn){
            payrollbtn.setBackgroundColor(Color.rgb(0,70,115));
            payrollbtn.setTextColor(Color.WHITE);
            newrun.setBackgroundResource(R.drawable.thin_border);
            newrun.setTextColor(Color.rgb(0,70,115));
            staffbtn.setBackgroundResource(R.drawable.thin_border);
            staffbtn.setTextColor(Color.rgb(0,70,115));
            startActivity(new Intent(getApplicationContext(), financePayroll_1.class));
            overridePendingTransition(0,0);
        }
        if(v==staffbtn){
            staffbtn.setBackgroundColor(Color.rgb(0,70,115));
            staffbtn.setTextColor(Color.WHITE);
            newrun.setBackgroundResource(R.drawable.thin_border);
            newrun.setTextColor(Color.rgb(0,70,115));
            payrollbtn.setBackgroundResource(R.drawable.thin_border);//setBackgroundColor(Color.WHITE);
            payrollbtn.setTextColor(Color.rgb(0,70,115));
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.nframe,new FinanceStaffFragment());
            fragmentTransaction.commit();
        }
        if(v == logout){
            startActivity(new Intent(getApplicationContext(), SwitchLogoutActivity.class));
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