package com.moringaschool.fuzupayapp.HumanResource.Fragments.Staff.APIApploadDocs.Bank;



import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface BankApploadUserService {
    @POST("bank_details/")
    Call<BankApploadUserResponse> saveBankDetails(@Body BankApploadUserRequest bankRequest);

}
