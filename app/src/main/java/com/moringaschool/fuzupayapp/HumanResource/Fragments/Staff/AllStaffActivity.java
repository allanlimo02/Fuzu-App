package com.moringaschool.fuzupayapp.HumanResource.Fragments.Staff;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
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
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.gson.reflect.TypeToken;
import com.moringaschool.fuzupayapp.APIRequests.Notification.NotificationClient;
import com.moringaschool.fuzupayapp.APIRequests.Notification.NotificationResponse;
import com.moringaschool.fuzupayapp.APIRequests.StaffApiResources.ItemOnclickPosition;
import com.moringaschool.fuzupayapp.APIRequests.StaffApiResources.Models.StaffResponse;
import com.moringaschool.fuzupayapp.APIRequests.StaffApiResources.StaffAdapter;
import com.moringaschool.fuzupayapp.APIRequests.StaffApiResources.StaffClientClass;
import com.moringaschool.fuzupayapp.APIRequests.StaffApiResources.StaffInterface;
import com.moringaschool.fuzupayapp.FragmentAdapter.DepartmentAdapter;
import com.moringaschool.fuzupayapp.HumanResource.Dashboard.DashboardActivity;
import com.moringaschool.fuzupayapp.HumanResource.Fragments.Leave.LeaveActivity;
import com.moringaschool.fuzupayapp.HumanResource.Fragments.Leave.RequestAPI.RequestResponse;
import com.moringaschool.fuzupayapp.HumanResource.Fragments.Staff.APIclient.staffClient;
import com.moringaschool.fuzupayapp.HumanResource.Fragments.Staff.APIentities.Department_pojo;
import com.moringaschool.fuzupayapp.HumanResource.Fragments.Staff.APIentities.EmployeesDetails_Pojo;
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

public class AllStaffActivity extends AppCompatActivity  implements StaffAdapter.ClickedItems, View.OnClickListener{
    @BindView(R.id.ourViewStaffHolder)  RecyclerView ourViewStaffHolder;
    @BindView(R.id.bottom_navigation)    BottomNavigationView bottomNavigationView;
    @BindView(R.id.fragmentOneBtn)   Button fragmentOneBtn;
    @BindView(R.id.fragmentTwoBtn)  Button fragmentTwoBtn;
    @BindView(R.id.fragmentThreeBtn)  Button fragmentThreeBtn;
    @BindView(R.id.ourFrameLayout)  FrameLayout ourFrameLayout;
    @BindView(R.id.titleBar) RelativeLayout titleBar;
    @BindView(R.id.imageView5) ImageView logout;
    @BindView(R.id.spinnerDep) Spinner spinnerDep;
    @BindView(R.id.progressBar2)
    ProgressBar progressBar;
    @BindView(R.id.pleasewait) TextView pleasewait;
    @BindView(R.id.imageView6) ImageView notifications;

    @BindView(R.id.motifivationsNumberContainer) CardView notify;
    Context context;
    StaffAdapter staffAdapter;
    Department_pojo department_pojos;

    private List<Department_pojo> departmentlist;
    private List<StaffResponse> staffRes;
    private ArrayList<String>getDepName = new ArrayList<String>();
    private ItemOnclickPosition itemOnclickPosition;
    String text="Human Resource";




    @Override
    protected  void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_staff);
        ButterKnife.bind(this);
        getDetpartMent();




        fetchAPI();

        NotificationFetch();
//                                                         /search filter
        fragmentTwoBtn.setOnClickListener(this);
        fragmentOneBtn.setOnClickListener(this);
        fragmentThreeBtn.setOnClickListener(this);
        logout.setOnClickListener(this);
        notifications.setOnClickListener(this);

        ourViewStaffHolder.setLayoutManager(new LinearLayoutManager(this));
        ourViewStaffHolder.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));
        staffAdapter=new StaffAdapter(this::ClickedUser);


        bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.nav_staff);
        bottomNavigation();


    }


//    Notifications
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


    private void getDetpartMent() {
        staffInterface serviceAPI = staffClient.getDepClient().create(staffInterface.class);
        serviceAPI.getDepartmentName().enqueue(new Callback<List>() {
            @Override
            public void onResponse(Call<List> call, Response<List> response) {
                Log.i("Response",response.body().toString());
                if(response.isSuccessful()){
                    Log.i("Success",response.body().toString());
                    try{
                        List getResponse = response.body();
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
                                text = adapterView.getItemAtPosition(i).toString();
                                fetchAPItext(text);

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
            public void onFailure(Call<List> call, Throwable t) {
//                Toast.makeText(AllStaffActivity.this,t.getMessage(),Toast.LENGTH_LONG).show();
                Log.e("error",t.getMessage());
            }
        });
    }

//    method in
    private void fetchAPItext(String text) {
        Call<List<StaffResponse>> stafflist= StaffClientClass.staffInterface().getStaff();
        showProgressbar();
        stafflist.enqueue(new Callback<List<StaffResponse>>() {


            @Override
            public void onResponse(Call<List<StaffResponse>> call, Response<List<StaffResponse>> response) {
                hideProgressbar();
                if(response.isSuccessful()){

                    List<StaffResponse> staffResponses = response.body();
                    for(StaffResponse stafs:staffResponses){
                        String departments1 = String.valueOf(stafs.getPosition());
//                        Toast.makeText(AllStaffActivity.this,departments1,Toast.LENGTH_LONG).show();
                        if(text.equals("Human Resource")){
                            staffAdapter.StaffAdapterFilled(staffResponses, itemOnclickPosition);
                            ourViewStaffHolder.setAdapter(staffAdapter);
                        }

                    }



//                    for(int i= 0;i<departmentlist.size();i++){
//                        saffResponse.add(staffResponse.getDepartment().toString());
//                    }

                }
            }
            @Override
            public void onFailure(Call<List<StaffResponse>> call, Throwable t) {
                hideProgressbar();
                Log.e("Haiwezimake",t.getLocalizedMessage());
            }
        });
    }

    private void fetchAPI() {
        Call<List<StaffResponse>> stafflist= StaffClientClass.staffInterface().getStaff();
        showProgressbar();
        stafflist.enqueue(new Callback<List<StaffResponse>>() {


            @Override
            public void onResponse(Call<List<StaffResponse>> call, Response<List<StaffResponse>> response) {
                hideProgressbar();
                if(response.isSuccessful()){

                        List<StaffResponse> staffResponses = response.body();
                        for(StaffResponse stafs:staffResponses){
                            String departments1 = String.valueOf(stafs.getDepartment());
//                            Toast.makeText(AllStaffActivity.this,departments1,Toast.LENGTH_LONG).show();
                            staffAdapter.StaffAdapterFilled(staffResponses, itemOnclickPosition);
                            ourViewStaffHolder.setAdapter(staffAdapter);
                        }



                }
            }
            @Override
            public void onFailure(Call<List<StaffResponse>> call, Throwable t) {
                hideProgressbar();
                Log.e("Haiwezimake",t.getLocalizedMessage());
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

    private void bottomNavigation() {
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
    public void onClick(View v) {
        if(v==notifications){
            startActivity(new Intent(getApplicationContext(), LeaveActivity.class));
            overridePendingTransition(0,0);
        }

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

//    @Override
//    public void onItemClick(int position) {
//    }


    @Override
    public void ClickedUser(StaffResponse staffResponse) {
       startActivity(new Intent(this,SIngleStaffActivity.class).putExtra("data",staffResponse));
    }
}