package com.moringaschool.fuzupayapp.HumanResource.Fragments.Staff.PDF.network;

/**
 * Created by delaroystudios on 10/5/2016.
 */
import com.moringaschool.fuzupayapp.HumanResource.Fragments.Staff.PDF.network.ServerResponse;

import java.util.Map;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Header;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.PartMap;


public interface ApiConfig {

    @Multipart
    @POST("images/upload_image.php")
    Call<ServerResponse> upload(
            @Header("Authorization") String authorization,
            @PartMap Map<String, RequestBody> map
    );
}