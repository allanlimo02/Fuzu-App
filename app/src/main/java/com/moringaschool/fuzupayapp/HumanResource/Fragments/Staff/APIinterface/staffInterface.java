package com.moringaschool.fuzupayapp.HumanResource.Fragments.Staff.APIinterface;

import com.moringaschool.fuzupayapp.HumanResource.Fragments.Staff.APIentities.EmployeesDetails_Pojo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface staffInterface {
    @GET("departments")
    Call<List> getDepartmentName();

    @GET("employees")
    Call<List<EmployeesDetails_Pojo>>getDetails();
}
