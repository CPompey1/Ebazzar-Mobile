package com.example.myapplication.utils;

import static com.example.myapplication.resources.AppResources.Constants.BASE_WEBAPP_URL;
import static java.net.HttpURLConnection.HTTP_OK;

import android.util.Log;
import com.example.myapplication.models.ResponseBody;
import com.example.myapplication.models.WebApiService;
import java.io.IOException;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class UserAuthentication {
    private final Retrofit retrofit;

    public UserAuthentication(){
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_WEBAPP_URL) // Replace with your API's base URL
                .addConverterFactory(GsonConverterFactory.create()) // Add Gson converter
                .build();
    }
    /*
    * Blocking call
    * */
    public boolean isLoggedIn(String auth_code){
        WebApiService service = retrofit.create(WebApiService.class);
        Call<ResponseBody> call = service.isLoggedIn(auth_code);
        Response<ResponseBody> response;

        try {
             response = call.execute();
        } catch (IOException e) {
            Log.e("UserAuthentication","Error parsing validate_token response");
            throw new RuntimeException(e);
        }
        return response.code() == HTTP_OK;

    }
}
