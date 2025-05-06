package com.example.myapplication.activities;

import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.myapplication.R;
import com.example.myapplication.resources.AppResources;
import com.example.myapplication.resources.RegisterLoginJsInterface;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_authenticated_home);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.authenticated_home), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        WebView webview = new WebView(HomeActivity.this);
        webview.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url){
                view.loadUrl(url);
                return false;
            }
        });
        setContentView(webview);
        webview.loadUrl(String.format("%s/", AppResources.Constants.MOBILE_PAGES));
        webview.getSettings().setJavaScriptEnabled(true);
        webview.addJavascriptInterface(new RegisterLoginJsInterface(this), "RegisterLoginJsInterface");

    }
}
