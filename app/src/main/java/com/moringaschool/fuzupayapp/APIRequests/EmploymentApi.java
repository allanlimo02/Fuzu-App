package com.moringaschool.fuzupayapp.APIRequests;

import retrofit2.Call;
import retrofit2.http.GET;

public interface EmploymentApi {
    @GET("employment_types/")
    Call<EmploymentSearchResponse> getEmployment();
}
