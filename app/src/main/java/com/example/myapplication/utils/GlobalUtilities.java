package com.example.myapplication.utils;
import android.os.Build;
import android.util.Log;

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
}
