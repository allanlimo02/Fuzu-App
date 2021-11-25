package com.moringaschool.fuzupayapp.HumanResource.Fragments.Staff;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.moringaschool.fuzupayapp.FragmentAdapter.DepartmentAdapter;
import com.moringaschool.fuzupayapp.HumanResource.Dashboard.DashboardActivity;
import com.moringaschool.fuzupayapp.HumanResource.Fragments.Leave.LeaveActivity;
import com.moringaschool.fuzupayapp.HumanResource.Fragments.Staff.APIclient.staffClient;
import com.moringaschool.fuzupayapp.HumanResource.Fragments.Staff.APIentities.Department_pojo;
import com.moringaschool.fuzupayapp.HumanResource.Fragments.Staff.APIinterface.staffInterface;
import com.moringaschool.fuzupayapp.R;
import com.moringaschool.fuzupayapp.SwitchAccount.SwitchLogoutActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AllStaffActivity extends AppCompatActivity  implements View.OnClickListener{
    @BindView(R.id.ourView)  RecyclerView ourView;
    @BindView(R.id.bottom_navigation)    BottomNavigationView bottomNavigationView;
    @BindView(R.id.fragmentOneBtn)   Button fragmentOneBtn;
    @BindView(R.id.fragmentTwoBtn)  Button fragmentTwoBtn;
    @BindView(R.id.fragmentThreeBtn)  Button fragmentThreeBtn;
    @BindView(R.id.ourFrameLayout)  FrameLayout ourFrameLayout;
    @BindView(R.id.titleBar) RelativeLayout titleBar;
    @BindView(R.id.imageView5) ImageView logout;
    @BindView(R.id.spinnerDep) Spinner spinnerDep;

    private List<Department_pojo> departmentlist;
    private ArrayList<String>getDepName = new ArrayList<String>();


    private String[] names=new String[]{"Allan Limo","Aron Langat","Esther Moki","Judy Rop","Erick Okumu"};
    private String[] position= new String[]{"Manager","C.E.O","Developer","Tester","Production"};
    private String[] employmentType= new String[]{" Full time","Contract","Full time","Internship","Internship"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_staff);
        ButterKnife.bind(this);
        getDetpartMent();

        fragmentTwoBtn.setOnClickListener(this);
        fragmentOneBtn.setOnClickListener(this);
        fragmentThreeBtn.setOnClickListener(this);
        logout.setOnClickListener(this);

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

    private void getDetpartMent() {
        staffInterface serviceAPI = staffClient.getDepClient().create(staffInterface.class);
        serviceAPI.getDepartmentName().enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                Log.i("Response",response.body().toString());
                if(response.isSuccessful()){
                    Log.i("Success",response.body().toString());
                    try{
                        String getResponse = response.body();
                        departmentlist=new ArrayList<Department_pojo>();
                        JSONArray jsonArray = new JSONArray(getResponse);
                        departmentlist.add(new Department_pojo(-1,"All"));
                        for(int i=0;i<jsonArray.length();i++){
                            Department_pojo department_pojo = new Department_pojo();
                            JSONObject jsonObject = jsonArray.getJSONObject(i);
                            department_pojo.setId(jsonObject.getInt("id"));
                            department_pojo.setDname(jsonObject.getString("name"));
                            departmentlist.add(department_pojo);
                            Log.d("name",department_pojo.getDname().toString());
//                            Log.i("id",department_pojo.getId());
//                            Toast toast=Toast.makeText(getApplicationContext(),"Hello Javatpoint",Toast.LENGTH_SHORT);
                        }
                        for(int i= 0;i<departmentlist.size();i++){
                            getDepName.add(departmentlist.get(i).getDname());
                        }
                        ArrayAdapter<String> newDepNameAD = new ArrayAdapter<String>(AllStaffActivity.this, android.R.layout.simple_spinner_item,getDepName);
                        newDepNameAD.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        spinnerDep.setAdapter(newDepNameAD);
                        spinnerDep.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                            @Override
                            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                            }

                            @Override
                            public void onNothingSelected(AdapterView<?> adapterView) {

                            }
                        });
                    }
                    catch (JSONException ex){
                        ex.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                Toast.makeText(AllStaffActivity.this,t.getMessage(),Toast.LENGTH_LONG).show();
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
}