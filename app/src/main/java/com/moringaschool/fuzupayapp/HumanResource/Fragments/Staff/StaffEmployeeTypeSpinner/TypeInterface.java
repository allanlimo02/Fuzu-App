package com.moringaschool.fuzupayapp.HumanResource.Fragments.Staff.StaffEmployeeTypeSpinner;

import retrofit2.Call;
import retrofit2.http.GET;

public interface TypeInterface {
    String JSONURL = "https://fuzupay-hr.herokuapp.com/human-resource/api/";

    @GET("employment_types")
    Call<String> getJSONString();
}
