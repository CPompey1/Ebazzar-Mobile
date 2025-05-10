package com.example.myapplication.utils;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GlobalUtilities {


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
