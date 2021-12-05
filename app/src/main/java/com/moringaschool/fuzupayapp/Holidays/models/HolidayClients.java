package com.moringaschool.fuzupayapp.Holidays.models;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

    public class HolidayClients {
        private static Retrofit getHolidRetrofit(){

            HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
            httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

            OkHttpClient okHttpClient = new OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor).build();
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("https://holidayapi.com/v1/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(okHttpClient)
                    .build();

            return retrofit;
        }
        public static HolidayInterface getHolidayServices(){
            HolidayInterface userService = getHolidRetrofit().create(HolidayInterface.class);
            return userService;
        }
    }