package com.moringaschool.fuzupayapp.APIRequests.StaffApiResources;

import com.moringaschool.fuzupayapp.APIRequests.StaffApiResources.Models.StaffResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface StaffInterface {
    @GET("human-resource/api/employees/")
    Call<List<StaffResponse>> getStaff();
}
