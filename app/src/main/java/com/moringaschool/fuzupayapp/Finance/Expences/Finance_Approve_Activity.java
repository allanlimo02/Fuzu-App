package com.moringaschool.fuzupayapp.Finance.Expences;

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

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.moringaschool.fuzupayapp.APIRequests.Notification.NotificationClient;
import com.moringaschool.fuzupayapp.APIRequests.Notification.NotificationResponse;
import com.moringaschool.fuzupayapp.Finance.Dashboard_Finance;
import com.moringaschool.fuzupayapp.Finance.FinancePayrolePaymentFragment;
import com.moringaschool.fuzupayapp.Finance.FinanceStaffFragment;
import com.moringaschool.fuzupayapp.Finance.Payroll2;
import com.moringaschool.fuzupayapp.R;
import com.moringaschool.fuzupayapp.SwitchAccount.SwitchLogoutActivity;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Finance_Approve_Activity extends AppCompatActivity implements View.OnClickListener {

    @BindView(R.id.newrun)   TextView Pending;
    @BindView(R.id.payroll) TextView payments;
    @BindView(R.id.staff) TextView completed;
    @BindView(R.id.frameLayoutPendings) FrameLayout Rpendings;
    @BindView(R.id.my_bottom_navigation) BottomNavigationView our_bottom_navigation;
    @BindView(R.id.imageView5)
    ImageView logout;
    @BindView(R.id.motifivationsNumberContainer)
    CardView notify;
    @Override
    protected void onStart() {
        super.onStart();
//        startActivity(new Intent(getApplicationContext(), ARDActivity.class));
//        overridePendingTransition(0,0);
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frameLayoutPendings,new ArdaFragment());
        fragmentTransaction.commit();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finance_approve);
        ButterKnife.bind(this);
        Pending.setOnClickListener(this);
        payments.setOnClickListener(this);
        completed.setOnClickListener(this);
        logout.setOnClickListener(this);

        NotificationFetch();

        Pending.setBackgroundColor(Color.rgb(0,70,115));
        Pending.setTextColor(Color.WHITE);
        payments.setTextColor(Color.rgb(0,70,115));
        completed.setTextColor(Color.rgb(0,70,115));

        our_bottom_navigation.setSelectedItemId(R.id.nav_expenses);
        our_bottom_navigation.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.nav_home:
                        startActivity(new Intent(getApplicationContext(), Dashboard_Finance.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.nav_payroll:
                        startActivity(new Intent(getApplicationContext(), Payroll2.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.nav_expenses:
                        return true;
                }
                return false;
            }
        });
    }

    @Override
    public void onClick(View view) {
       if (view == Pending){
           Pending.setBackgroundColor(Color.rgb(0,70,115));
           Pending.setTextColor(Color.WHITE);
           completed.setBackgroundResource(R.drawable.thin_border);
           completed.setTextColor(Color.rgb(0,70,115));
           payments.setBackgroundResource(R.drawable.thin_border);
           payments.setTextColor(Color.rgb(0,70,115));
           FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
           fragmentTransaction.replace(R.id.frameLayoutPendings,new ArdaFragment());
           fragmentTransaction.commit();

       }
       if(view==payments){
           payments.setBackgroundColor(Color.rgb(0,70,115));
           payments.setTextColor(Color.WHITE);
           completed.setBackgroundResource(R.drawable.thin_border);
           completed.setTextColor(Color.rgb(0,70,115));
           Pending.setBackgroundResource(R.drawable.thin_border);
           Pending.setTextColor(Color.rgb(0,70,115));
           FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
           fragmentTransaction.replace(R.id.frameLayoutPendings,new FinancePayrolePaymentFragment());
           fragmentTransaction.commit();

       }
       if(view==completed){
           completed.setBackgroundColor(Color.rgb(0,70,115));
           completed.setTextColor(Color.WHITE);
           payments.setBackgroundResource(R.drawable.thin_border);
           payments.setTextColor(Color.rgb(0,70,115));
           Pending.setBackgroundResource(R.drawable.thin_border);
           Pending.setTextColor(Color.rgb(0,70,115));
           FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
           fragmentTransaction.replace(R.id.frameLayoutPendings,new FinanceStaffFragment());
           fragmentTransaction.commit();
       }
        if(view == logout){
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