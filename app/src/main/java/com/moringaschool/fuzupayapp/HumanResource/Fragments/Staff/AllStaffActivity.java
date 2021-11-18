package com.moringaschool.fuzupayapp.HumanResource.Fragments.Staff;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Layout;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.moringaschool.fuzupayapp.FragmentAdapter.DepartmentAdapter;
import com.moringaschool.fuzupayapp.HumanResource.Dashboard.DashboardActivity;
import com.moringaschool.fuzupayapp.HumanResource.Fragments.Leave.LeaveActivity;
import com.moringaschool.fuzupayapp.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AllStaffActivity extends AppCompatActivity  implements View.OnClickListener{
    @BindView(R.id.ourView)  RecyclerView ourView;
    @BindView(R.id.bottom_navigation)    BottomNavigationView bottomNavigationView;
    @BindView(R.id.fragmentOneBtn)   Button fragmentOneBtn;
    @BindView(R.id.fragmentTwoBtn)  Button fragmentTwoBtn;
    @BindView(R.id.fragmentThreeBtn)  Button fragmentThreeBtn;
    @BindView(R.id.ourFrameLayout)  FrameLayout ourFrameLayout;
    @BindView(R.id.titleBar) RelativeLayout titleBar;

    private List list;
    private String[] names=new String[]{"Allan Limo","Aron Langat","Esther Moki","Judy Rop","Erick Okumu"};
    private String[] position= new String[]{"Manager","C.E.O","Developer","Tester","Production"};
    private String[] employmentType= new String[]{" Full time","Contract","Full time","Internship","Internship"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_staff);
        ButterKnife.bind(this);

        fragmentTwoBtn.setOnClickListener(this);
        fragmentOneBtn.setOnClickListener(this);
        fragmentThreeBtn.setOnClickListener(this);


        // Array adapter feeder

        DepartmentAdapter adapter=new DepartmentAdapter(this,names,position,employmentType);
        ourView.setAdapter(adapter);
        ourView.setLayoutManager(new LinearLayoutManager(this));
        // End of array adapter code


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
    }

    @Override
    protected void onStart() {
        super.onStart();
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
            ourView.setVisibility(View.GONE);
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


    }
    private void fragmentlaunch(){
        FragmentTransaction fragmentTransaction= getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout,new SingleStaffFragment());
        fragmentTransaction.commit();

    }
}