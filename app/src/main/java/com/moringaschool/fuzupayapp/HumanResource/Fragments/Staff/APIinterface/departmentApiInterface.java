package com.moringaschool.fuzupayapp.HumanResource.Fragments.Staff.APIinterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface departmentApiInterface {
    String BASEURL = "https://fuzupay-hr.herokuapp.com/human-resource/api/";

    @GET("departments")
    Call<List> getDepartments();
}
