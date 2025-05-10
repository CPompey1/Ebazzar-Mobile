package com.example.myapplication.models;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface WebApiService {
    @GET("/api/accounts/validate_token/{auth_token}")
    Call<ResponseBody> isLoggedIn(@Path("auth_token")String auth_token);
}
