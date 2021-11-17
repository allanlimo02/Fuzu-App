package com.moringaschool.fuzupayapp.HumanResource.HrApiInterface;

//import com.moringaschool.fuzupayapp.Holidays.Responses;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface hrApi {
        @GET("animals")
        Call<com.example.petyfinderip_version2.models.SearchResponse> getPets(
                @Query("type") String type
        );
    }
