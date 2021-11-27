package com.moringaschool.fuzupayapp.APIRequests;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface DepartmentApi {
   @GET("employees/")
     Call<List<DepartmentResponse>> getDepartment(
           // @Query("other_names") String otherName,
           // @Query("position") String position,
           // @Query("employment_type") String employment_type
    );
}
