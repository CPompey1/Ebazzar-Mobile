package com.example.myapplication.utils;
import android.os.Build;
import android.util.Log;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GlobalUtilities {

    public static boolean isPhysicalDevice(){

        if (Build.BRAND.equalsIgnoreCase("generic") && Build.DEVICE.equalsIgnoreCase("generic")) {
            // Running on emulator
            Log.i("isPhysical","NO");
            return false;

        } else {
            // Running on physical device
            Log.i("isPhysical","YES");
            return true;
        }
    }

    public static HashMap<String,String> getCookieMap(String fullCookieString){
        HashMap<String,String> out = new HashMap<>();
        for (String cookieLine :  Arrays.asList(fullCookieString.trim().split(";"))){
            List<String> keyValue = Arrays.asList(cookieLine.split("="));
            out.put(keyValue.get(0).trim(), keyValue.get(1).trim());
        }
        return out;
    }

    public static String getCookieValue(String fullCookieString, String key){
        return getCookieMap(fullCookieString).get(key);
    }
}
