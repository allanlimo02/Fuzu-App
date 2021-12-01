package com.moringaschool.fuzupayapp.HumanResource.Fragments.Leave.PostrequestApi;


import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface PostleaveInterface {

     @POST("leaves/")
     Call<PostResponses>saveLeave(@Body PostLeaveRequest postLeaveRequest);
}
