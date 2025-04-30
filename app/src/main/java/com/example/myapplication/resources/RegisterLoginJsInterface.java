package com.example.myapplication.resources;

import static androidx.core.content.ContextCompat.startActivity;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.webkit.JavascriptInterface;


import com.example.myapplication.MainActivity;

public class RegisterLoginJsInterface {
    Context context;

    public RegisterLoginJsInterface(Context c){
        context = c;
    }

    @JavascriptInterface
    public void registerClicked(){
        Intent intent = new Intent(context, MainActivity.class);
        startActivity(context,intent,null);

        Log.i("RLJSInterface","RegisterClicked");
    }

    @JavascriptInterface
    public void loginClicked(){
        Intent intent = new Intent(context, MainActivity.class);
        startActivity(context,intent,null);
        Log.i("RLJSInterface","LoginClicked");
    }
}
