package com.example.myapplication.activities;

import static com.example.myapplication.resources.AppResources.Constants.AUTH_TOKEN_KEY;
import static com.example.myapplication.resources.AppResources.Constants.MOBILE_PAGES;

import android.content.Context;
import android.os.Bundle;
import android.webkit.CookieManager;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.myapplication.R;
import com.example.myapplication.resources.AppResources;
import com.example.myapplication.resources.RegisterLoginJsInterface;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button registerButton =  findViewById(R.id.loginButton);
        registerButton.setOnClickListener(v -> {
            WebView myWebView = new WebView(MainActivity.this);
            myWebView.setWebViewClient(new WebViewClient(){
                @Override
                public boolean shouldOverrideUrlLoading(WebView view, String url) {
                    view.loadUrl(url); // Load the URL within the WebView
                    return false; // Prevent external browser from opening
                }
            });
            CookieManager cookieManager = CookieManager.getInstance();
            cookieManager.setAcceptCookie(true);
            String cookie = String.format("%s=%s;",AUTH_TOKEN_KEY,this.getPreferences(Context.MODE_PRIVATE).getString(AUTH_TOKEN_KEY,AUTH_TOKEN_KEY));
            cookieManager.setCookie(MOBILE_PAGES,cookie);
            setContentView(myWebView);
            myWebView.loadUrl(String.format("%s/login", MOBILE_PAGES));
            myWebView.getSettings().setJavaScriptEnabled(true);
            myWebView.addJavascriptInterface(new RegisterLoginJsInterface(this), "RegisterLoginJsInterface");
        });

        Button loginButton = findViewById(R.id.registerButton);
        loginButton.setOnClickListener(v -> {
            WebView myWebView = new WebView(MainActivity.this);
            myWebView.setWebViewClient(new WebViewClient(){
                @Override
                public boolean shouldOverrideUrlLoading(WebView view, String url) {
                    view.loadUrl(url); // Load the URL within the WebView
                    return false; // Prevent external browser from opening
                }
            });
            setContentView(myWebView);
            myWebView.setWebViewClient(new WebViewClient());
            myWebView.loadUrl(String.format("%s/register", MOBILE_PAGES));
            myWebView.addJavascriptInterface(new RegisterLoginJsInterface(this), "RegisterLoginJsInterface");
            myWebView.getSettings().setJavaScriptEnabled(true);
        });

        Button guestButton = findViewById(R.id.guestButton);
        guestButton.setOnClickListener(v -> {
            WebView myWebView = new WebView(MainActivity.this);
            myWebView.setWebViewClient(new WebViewClient(){
                @Override
                public boolean shouldOverrideUrlLoading(WebView view, String url) {
                    view.loadUrl(url); // Load the URL within the WebView
                    return false; // Prevent external browser from opening
                }
            });
            setContentView(myWebView);
            myWebView.setWebViewClient(new WebViewClient());
            myWebView.loadUrl(String.format("%s/", MOBILE_PAGES));
            myWebView.addJavascriptInterface(new RegisterLoginJsInterface(this), "RegisterLoginJsInterface");
            myWebView.getSettings().setJavaScriptEnabled(true);
        });

    }
}