package com.moringaschool.fuzupayapp.HumanResource.Fragments.Staff.APIinterface;

import retrofit2.Call;
import retrofit2.http.GET;

public interface departmentApiInterface {
    String BASEURL = "https://fuzupay-hr.herokuapp.com/human-resource/api/";

    @GET("departments")
    Call<String> getDepartments();
}
