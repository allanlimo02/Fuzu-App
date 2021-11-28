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
import android.widget.ArrayAdapter;
import android.widget.Spinner;


import com.moringaschool.fuzupayapp.HumanResource.Fragments.Staff.APIinterface.departmentApiInterface;

import com.moringaschool.fuzupayapp.APIRequests.DepartmentAdapter;
import com.moringaschool.fuzupayapp.APIRequests.DepartmentClient;
import com.moringaschool.fuzupayapp.APIRequests.DepartmentResponse;

import com.moringaschool.fuzupayapp.HumanResource.Fragments.Leave.LeaveActivity;
import com.moringaschool.fuzupayapp.HumanResource.Fragments.Leave.RequestAPI.RequestClient;
import com.moringaschool.fuzupayapp.HumanResource.Fragments.Leave.RequestAPI.RequestResponse;

import com.moringaschool.fuzupayapp.R;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;


public class DepartmentsFragment extends Fragment {
//    Spinner spinner;
    private ArrayList<DepartmentsSpinner> departmentsSpinnerArrayList;
    private ArrayList<String> departmentNames = new ArrayList<String>();
    private Spinner spinner;


//    @BindView(R.id.depspinner) Spinner depspinner;
//@Override
//public void onCreate(Bundle savedInstanceState) {
//    super.onCreate(savedInstanceState);
//
//    RecyclerView recyclerView;
//    DepartmentAdapter departmentAdapter;
//
//
//}

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_departments, container, false);

        spinner = view.findViewById(R.id.menu_drop);
        fetchDepartments();
             return view;

//        recyclerView = view.findViewById(R.id.recyclerviewDepartments);
//        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
//        recyclerView.addItemDecoration(new DividerItemDecoration(getActivity(),DividerItemDecoration.VERTICAL));
//        departmentAdapter = new DepartmentAdapter();
//        getDepartment();
//        return view;


    }

    private void fetchDepartments() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(departmentApiInterface.BASEURL)
                .addConverterFactory(ScalarsConverterFactory.create())
                .build();

        departmentApiInterface api = retrofit.create(departmentApiInterface.class);
        Call<String> call = api.getDepartments();
        call.enqueue(new Callback<String>(){
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                Log.i("Responsestring",response.body().toString());
                if (response.isSuccessful()){
                    if (response.body() != null) {
                        Log.i("onSuccess",response.body().toString());

                        String departmentResponse = response.body().toString();
                        spinDepartment(departmentResponse);
                    }else {
                        Log.i("onEmptyResponse","Returned empty response");
                    }
                }

            }

//            @Override
//            public void onFailure(Call<String> call, Throwable t) {
//
//            }

            private void spinDepartment(String departmentResponse) {
                try {
                    JSONObject object = new JSONObject(departmentResponse);
                    if (object.optString("status").equals("true")){
                        departmentsSpinnerArrayList = new ArrayList<>();
                        JSONArray departmentArray = object.getJSONArray("data");
                        for (int i = 0;i<departmentArray.length();i++){
                            DepartmentsSpinner spinnerModel = new DepartmentsSpinner();
                            JSONObject dataObject = departmentArray.getJSONObject(i);

                            spinnerModel.setId(dataObject.getInt("id"));
                            spinnerModel.setName(dataObject.getString("name"));

                            departmentsSpinnerArrayList.add(spinnerModel);

                        }

                        for (int i = 0; i < departmentsSpinnerArrayList.size(); i++){
                            departmentNames.add(departmentsSpinnerArrayList.get(i).getName().toString());
                        }

                        ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, departmentNames);
                        spinnerArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); // The drop down view
                        spinner.setAdapter(spinnerArrayAdapter);

                        }

                    } catch (Exception e) {
                    e.printStackTrace();
                }
            }


            @Override
            public void onFailure(Call<String> call, Throwable t) {

            }
        });
    }

    private void getDepartment() {

        Call<List<DepartmentResponse>> departmentList = DepartmentClient.getDepartmentService().getDepartment();
        departmentList.enqueue(new Callback<List<DepartmentResponse>>() {
            @Override
            public void onResponse(Call<List<DepartmentResponse>> call, Response<List<DepartmentResponse>> response) {
                if (response.isSuccessful()) {
//                    List<DepartmentResponse> departmentResponses = response.body();
//                    departmentAdapter.setData(departmentResponses);
//                    recyclerView.setAdapter(departmentAdapter);
//                    Log.e("successful",response.body().toString());
                }
            }

            @Override
            public void onFailure(Call<List<DepartmentResponse>> call, Throwable t) {
                Log.e("failure",t.getLocalizedMessage());
            }
        });
    }




//        DepartmentApi client = DepartmentClient.getClient();
//
//        Call<DepartmentSearchResponse> call = client.getDepartment("other_names", "position","employment_type");
//        call.enqueue(new Callback<DepartmentSearchResponseOutcomes>() {
//            @Override
//            public void onResponse(@NonNull okhttp3.Call call, @NonNull Response response) throws IOException {
//                if (response.isSuccessful()) {
//                    List<DepartmentSearchResponse> departmentSearchResponseList = response.body().getDepartmentSearchResponseO();
//                    String[] otherNames = new String[departmentSearchResponseList .size()];
//                    String[] position = new String[departmentSearchResponseList .size()];
//                    String[] employmentType = new String[departmentSearchResponseList.size()];
//
//                    for (int i = 0; i < otherNames.length; i++){
//                        otherNames[i] = departmentSearchResponseList .get(i).getOtherNames();
//                    }
//
//                    for (int i = 0; i < position.length; i++) {
//                       position[i] = departmentSearchResponseList.get(i).getPosition();
//                    }
//                    for (int i = 0; i <  employmentType.length; i++) {
//                        employmentType[i] = departmentSearchResponseList.get(i).getEmploymentType();
//                    }
//
//                    //    DepartmentAdapter adapter=new DepartmentAdapter(this,names,position,employmentType);
//                    //   ourView.setAdapter(adapter);
//                    // ourView.setLayoutManager(new LinearLayoutManager(this));
//                    // End of array adapter code
//
//                    DepartmentAdapter adapter =  new DepartmentAdapter(this, android.R.layout.staff_rec_item, otherNames, position,employmentType);
//                    ourView.setAdapter(adapter);
//
//                }
           // }

//            @Override
//            public void onFailure(@NonNull okhttp3.Call call, @NonNull IOException e) {
//
//            }


    }





