package com.moringaschool.fuzupayapp.HumanResource.LeaveApi;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface OnLeaveApi {

   @GET("on_leave")
   Call<List<onLeaveResponse>> getAllOnLeave();
}
