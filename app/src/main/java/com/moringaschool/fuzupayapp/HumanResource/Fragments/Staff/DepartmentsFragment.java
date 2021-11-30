package com.moringaschool.fuzupayapp.HumanResource.Fragments.Staff;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.moringaschool.fuzupayapp.HumanResource.Fragments.Staff.APIinterface.departmentApiInterface;
import com.moringaschool.fuzupayapp.R;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;


public class DepartmentsFragment extends Fragment {
//    Spinner spinner;
    private List<DepartmentsSpinner> departmentsSpinner;
    private ArrayList<String> getDepartmentNames = new ArrayList<String>();
    private Spinner spinner;

//    @BindView(R.id.depspinner) Spinner depspinner;
@Override
public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_departments, container, false);
        spinner = view.findViewById(R.id.menu_drop);
        getDepartmentsList();
             return view;

    }

    private void getDepartmentsList() {
    Retrofit retrofit = new Retrofit.Builder().baseUrl(departmentApiInterface.BASEURL).addConverterFactory(GsonConverterFactory.create()).build();
    departmentApiInterface apiInterface = retrofit.create(departmentApiInterface.class);
    Call<List> call = apiInterface.getDepartments();
    call.enqueue(new Callback<List>() {
        @Override
        public void onResponse(Call<List> call, Response<List> response) {
            Log.i("Response",response.body().toString());
            if (response.isSuccessful()){
                    Log.i("Success",response.body().toString());
                    try {
                        List getResponse = response.body();
//                        List<DepartmentsSpinner> departmentsSpinner = new ArrayList<DepartmentsSpinner>();
                        departmentsSpinner = new ArrayList<DepartmentsSpinner>();
                        JSONArray jsonArray = new JSONArray(getResponse);
                        departmentsSpinner.add(new DepartmentsSpinner());
                        for (int i=0;i<jsonArray.length();i++){
                            DepartmentsSpinner deSpinner = new DepartmentsSpinner();
                            JSONObject jsonObject = jsonArray.getJSONObject(i);
                            deSpinner.setId(jsonObject.getInt("id"));
                            deSpinner.setName(jsonObject.getString("name"));
                            departmentsSpinner.add(deSpinner);
                            Log.d("anything",deSpinner.getName());
                        }
                        for (int i=0;i<departmentsSpinner.size();i++){
                            getDepartmentNames.add(departmentsSpinner.get(i).getName());
                        }
                        ArrayAdapter<String> spinDepartmentAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item,getDepartmentNames);
                                spinDepartmentAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        spinner.setAdapter(spinDepartmentAdapter);
                        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                            @Override
                            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                            }

                            @Override
                            public void onNothingSelected(AdapterView<?> adapterView) {

                            }
                        });
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

            }

        }

        @Override
        public void onFailure(Call<List> call, Throwable t) {
            Log.e("error",t.getMessage());

        }
    });
    }

//    private void fetchDepartments() {
//        Retrofit retrofit = new Retrofit.Builder()
//                .baseUrl(departmentApiInterface.BASEURL)
//                .addConverterFactory(ScalarsConverterFactory.create())
//                .build();
//
//        departmentApiInterface api = retrofit.create(departmentApiInterface.class);
//        Call<String> call = api.getDepartments();
//        call.enqueue(new Callback<String>(){
//            @Override
//            public void onResponse(Call<String> call, Response<String> response) {
//                Log.i("Responsestring",response.body().toString());
//                if (response.isSuccessful()){
//                    if (response.body() != null) {
//                        Log.i("onSuccess",response.body().toString());
//
//                        String departmentResponse = response.body().toString();
//                        spinDepartment(departmentResponse);
//                    }else {
//                        Log.i("onEmptyResponse","Returned empty response");
//                    }
//                }
//
//            }
//
////            @Override
////            public void onFailure(Call<String> call, Throwable t) {
////
////            }
//
//            private void spinDepartment(String departmentResponse) {
//                try {
//                    JSONObject object = new JSONObject(departmentResponse);
//                    if (object.optString("status").equals("true")){
//                        departmentsSpinnerArrayList = new ArrayList<>();
//                        JSONArray departmentArray = object.getJSONArray("data");
//                        for (int i = 0;i<departmentArray.length();i++){
//                            DepartmentsSpinner spinnerModel = new DepartmentsSpinner();
//                            JSONObject dataObject = departmentArray.getJSONObject(i);
//
//                            spinnerModel.setId(dataObject.getInt("id"));
//                            spinnerModel.setName(dataObject.getString("name"));
//
//                            departmentsSpinnerArrayList.add(spinnerModel);
//
//                        }
//
//                        for (int i = 0; i < departmentsSpinnerArrayList.size(); i++){
//                            departmentNames.add(departmentsSpinnerArrayList.get(i).getName().toString());
//                        }
//
//                        ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, departmentNames);
//                        spinnerArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); // The drop down view
//                        spinner.setAdapter(spinnerArrayAdapter);
//
//                        }
//
//                    } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
//
//
//            @Override
//            public void onFailure(Call<String> call, Throwable t) {
//
//            }
//        });
//    }


}