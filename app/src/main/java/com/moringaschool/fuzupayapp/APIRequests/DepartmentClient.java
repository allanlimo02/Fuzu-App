package com.moringaschool.fuzupayapp.APIRequests;


import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DepartmentClient {

    private static Retrofit getRetrofit(){


        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient okHttpClient = new OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor).build();


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://fuzupay-hr.herokuapp.com/human-resource/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build();

        return retrofit;

    }

    public static DepartmentApi getDepartmentService(){
        DepartmentApi departmentApi = getRetrofit().create(DepartmentApi.class);
        return departmentApi;
    }


//    private static Retrofit retrofit = null;
//
//    public static DepartmentApi getClient() {
//
//        if (retrofit == null) {
//            OkHttpClient okHttpClient = new OkHttpClient.Builder()
//                    .addInterceptor(new Interceptor() {
//                        @Override
//                        public Response intercept(Chain chain) throws IOException {
//                            Request newRequest  = chain.request().newBuilder()
//                                    .addHeader("Authorization", DEPARTMENT_API_KEY)
//                                    .build();
//                            return chain.proceed(newRequest);
//                        }
//                    })
//                    .build();
//
//            retrofit = new Retrofit.Builder()
//                    .baseUrl(DEPARTMENT_BASE_URL)
//                    .client(okHttpClient)
//                    .addConverterFactory(GsonConverterFactory.create())
//                    .build();
//        }
//
//        return retrofit.create(DepartmentApi.class);
//    }
}
