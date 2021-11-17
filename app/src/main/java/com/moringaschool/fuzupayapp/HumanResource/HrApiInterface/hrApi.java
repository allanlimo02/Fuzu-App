package com.moringaschool.fuzupayapp.HumanResource.HrApiInterface;

import com.moringaschool.fuzupayapp.Holidays.Responses;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface hrApi {
    @GET ("https://calendarific.com/api/v2/holidays?year=2021&country=KE&api_key=0451cc487d19f1904a83ac787008e1e535140112")
    Call<Responses> getHoliday(
            @Query("year") String year,
            @Query("country") String country
    );
}
