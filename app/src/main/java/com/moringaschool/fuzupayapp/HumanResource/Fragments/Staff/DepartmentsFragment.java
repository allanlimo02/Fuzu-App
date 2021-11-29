package com.moringaschool.fuzupayapp.HumanResource.Fragments.Staff;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;


import com.moringaschool.fuzupayapp.APIRequests.DepartmentAdapter;
import com.moringaschool.fuzupayapp.APIRequests.DepartmentClient;
import com.moringaschool.fuzupayapp.APIRequests.DepartmentResponse;

import com.moringaschool.fuzupayapp.HumanResource.Fragments.Leave.LeaveActivity;
import com.moringaschool.fuzupayapp.HumanResource.Fragments.Leave.RequestAPI.RequestClient;
import com.moringaschool.fuzupayapp.HumanResource.Fragments.Leave.RequestAPI.RequestResponse;
import com.moringaschool.fuzupayapp.HumanResource.Fragments.Staff.APIclient.staffClient;
import com.moringaschool.fuzupayapp.HumanResource.Fragments.Staff.APIentities.Department_pojo;
import com.moringaschool.fuzupayapp.HumanResource.Fragments.Staff.APIinterface.staffInterface;
import com.moringaschool.fuzupayapp.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;


public class DepartmentsFragment extends Fragment implements AdapterView.OnItemSelectedListener {
    LeaveActivity leaveActivity = new LeaveActivity();
    //        Spinner spinner;
    Spinner spinner,spinnerDep;
    RecyclerView recyclerView;
    DepartmentAdapter departmentAdapter;
    private List<Department_pojo> departmentlist;
    private ArrayList<String>getDepName = new ArrayList<String>();

    public DepartmentsFragment() {
        // Required empty public constructor
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_departments, container, false);
//        Spinner
        spinner= view.findViewById(R.id.statusDrop);
        spinnerDep= view.findViewById(R.id.menu_drop);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getActivity(),R.array.dissaprove, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
        getDetpartMent();



        recyclerView = view.findViewById(R.id.recyclerviewDepartments);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.addItemDecoration(new DividerItemDecoration(getActivity(),DividerItemDecoration.VERTICAL));
        departmentAdapter = new DepartmentAdapter();
        getDepartment();
        return view;





    }

    private void getDepartment() {

        Call<List<DepartmentResponse>> departmentList = DepartmentClient.getDepartmentService().getDepartment();
        departmentList.enqueue(new Callback<List<DepartmentResponse>>() {
            @Override
            public void onResponse(Call<List<DepartmentResponse>> call, Response<List<DepartmentResponse>> response) {
                if (response.isSuccessful()) {
                    List<DepartmentResponse> departmentResponses = response.body();
                    departmentAdapter.setData(departmentResponses);
                    recyclerView.setAdapter(departmentAdapter);
                    Log.e("successful",response.body().toString());
                }
            }

            @Override
            public void onFailure(Call<List<DepartmentResponse>> call, Throwable t) {
                Log.e("failure",t.getLocalizedMessage());
            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        String text = adapterView.getItemAtPosition(i).toString();
        Toast.makeText(adapterView.getContext(),text,Toast.LENGTH_LONG).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

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
                        ArrayAdapter<String> newDepNameAD = new ArrayAdapter<String>(getActivity()
                                , android.R.layout.simple_spinner_item,getDepName);
                        newDepNameAD.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        spinnerDep.setAdapter(newDepNameAD);
                        spinnerDep.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                            @Override
                            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
//                                int getdepid = departmentlist.get(i).getId();
//                                getEmpDetails(getdepid);
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
}