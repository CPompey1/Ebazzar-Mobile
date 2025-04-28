package com.example.myapplication.resources;

import android.content.Context;
import android.content.SharedPreferences;
import android.webkit.JavascriptInterface;

import androidx.appcompat.app.AppCompatActivity;

public class WebviewJsInterface {
    @JavascriptInterface
    public void registerAuthToken(String authToken, AppCompatActivity activity){
        SharedPreferences sharedPref = activity.getSharedPreferences(Context.MODE_PRIVATE);
    }
}
