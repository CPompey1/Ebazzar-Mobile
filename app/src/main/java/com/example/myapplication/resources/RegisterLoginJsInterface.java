package com.example.myapplication.resources;

import static androidx.core.content.ContextCompat.startActivity;

import static com.example.myapplication.resources.AppResources.Constants.AUTH_TOKEN_KEY;
import static com.example.myapplication.resources.AppResources.Constants.SHARED_PREFERENCES_FILE;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
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
        Log.i("RLJSInterface",String.format("Cookie: %s",cookie));
        String auth_token = GlobalUtilities.getCookieValue(cookie,AUTH_TOKEN_KEY);
        SharedPreferences preferences = context.getApplicationContext().getSharedPreferences(SHARED_PREFERENCES_FILE,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(AUTH_TOKEN_KEY,auth_token);
        editor.commit();

//        Log.i("RLJSInterface", String.format("cookie: %s",context.getSharedPreferences(AUTH_TOKEN_KEY,"DEFAULT"));

        Intent intent = new Intent(context, ChooseRoleActivity.class);
        startActivity(context,intent,null);
        Log.i("RLJSInterface","Login Button clicked");
    }
}
