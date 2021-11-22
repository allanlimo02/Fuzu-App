package com.moringaschool.fuzupayapp.HumanResource.Fragments.Leave;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.moringaschool.fuzupayapp.FragmentAdapter.LeaveRequestAdapter;
import com.moringaschool.fuzupayapp.HumanResource.Dashboard.DashboardActivity;
import com.moringaschool.fuzupayapp.HumanResource.Fragments.Staff.StaffActivity;
import com.moringaschool.fuzupayapp.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LeaveActivity extends AppCompatActivity implements View.OnClickListener{
    @BindView(R.id.bottom_navigation) BottomNavigationView mBottomNavigationView;
    @BindView(R.id.fragmentOneBtn2) Button fragmentOneBtn2;
    @BindView(R.id.fragmentTwoBtn2) Button fragmentTwoBtn2;
    @BindView(R.id.recview2)  RecyclerView recyclerView2;
    @BindView(R.id.lineLayout)    LinearLayout lineLayout;
    BottomNavigationView bottomNavigationView;

    private String[] leaveName=new String[]{"Martenity Leave","Annual Leave ","Sabbatical Leave","Ramadhan Leave","Annual Leave"};
    private String[] dates=new String[]{"12-11-2021","34-12-2021","22-22-2021","22-22-2021","22-22-2021"};
    private String[] names=new String[]{"Winnie Lagat","Kawira Kinyua","June Adhiambo","Moses Chelimo","Triza Cherorot"};
    private String[] durations=new String[]{"10 Days","23 Days","5 Days","5 Days","5 Days"};


    //    fragment inititializations
//    private TextView fragmentOneBtn2, fragmentTwoBtn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leave2);

        ButterKnife.bind(this);



        fragmentTwoBtn2.setOnClickListener(this);
        fragmentOneBtn2.setOnClickListener(this);

        LeaveRequestAdapter adapter=new LeaveRequestAdapter(this,leaveName,names,dates,durations);
        recyclerView2.setAdapter(adapter);
        recyclerView2.setLayoutManager(new LinearLayoutManager(this));


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

    @Override
    public void onStart() {
        super.onStart();
        fragmentTwoBtn2.setBackgroundColor(Color.WHITE);
        fragmentOneBtn2.setBackgroundColor(Color.rgb(0,70,115));
        fragmentTwoBtn2.setTextColor(Color.BLACK);
        fragmentOneBtn2.setTextColor(Color.WHITE);
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout2,new Leave_Request_Fragment());
        fragmentTransaction.commit();
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


    }
}