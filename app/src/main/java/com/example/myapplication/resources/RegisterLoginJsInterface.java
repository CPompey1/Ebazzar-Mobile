package com.example.myapplication.resources;

import static androidx.core.content.ContextCompat.startActivity;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.webkit.CookieManager;
import android.webkit.JavascriptInterface;


import com.example.myapplication.activities.ChooseRoleActivity;
import com.example.myapplication.activities.MainActivity;
import com.example.myapplication.utils.GlobalUtilities;

public class RegisterLoginJsInterface {
    Context context;

    public RegisterLoginJsInterface(Context c){
        context = c;
    }

    @JavascriptInterface
    public void returnToMainActivity(){
        Intent intent = new Intent(context, MainActivity.class);
        startActivity(context,intent,null);
        Log.i("RLJSInterface","Return to Main activity clicked");
    }

    @JavascriptInterface
    public void loginClicked(){
        String cookie = CookieManager.getInstance().getCookie(String.format("%s",AppResources.Constants.MOBILE_PAGES));
        String auth_token = GlobalUtilities.getCookieValue(cookie,"auth_token");

        Intent intent = new Intent(context, ChooseRoleActivity.class);
        startActivity(context,intent,null);
        Log.i("RLJSInterface","Login Button clicked");
    }
}
