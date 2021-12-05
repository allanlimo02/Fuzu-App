package com.moringaschool.fuzupayapp.Holidays.models;

import com.moringaschool.fuzupayapp.Holidays.HolidayResponses;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface HolidayInterface {
    @GET("holidays?pretty&key=ced8d107-04f4-4478-8877-880f4f31d322&country=KE&year=2020")
    Call<HolidayResponses> getHoliday();
}