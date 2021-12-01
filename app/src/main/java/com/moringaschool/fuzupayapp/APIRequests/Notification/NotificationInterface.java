package com.moringaschool.fuzupayapp.APIRequests.Notification;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface NotificationInterface {

    @GET("message/")
    Call<List<NotificationResponse>> getNotification();
}
