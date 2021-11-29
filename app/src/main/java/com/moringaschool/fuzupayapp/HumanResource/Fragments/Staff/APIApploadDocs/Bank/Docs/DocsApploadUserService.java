package com.moringaschool.fuzupayapp.HumanResource.Fragments.Staff.APIApploadDocs.Bank.Docs;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface DocsApploadUserService {

    @POST("employees/")
    Call<DocsApploadUserResponse> saveDocs(@Body DocsApploadUserRequest docsApploadUserRequest);
}
