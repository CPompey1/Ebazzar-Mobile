package com.example.myapplication;

import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.myapplication.resources.AppResources;

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
            setContentView(myWebView);
            myWebView.loadUrl(String.format("%s/login_account", AppResources.Constants.LOCAL_SERVER_DOMAIN));
            myWebView.getSettings().setJavaScriptEnabled(true);
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
            myWebView.loadUrl(String.format("%s/register", AppResources.Constants.LOCAL_SERVER_DOMAIN));
            myWebView.getSettings().setJavaScriptEnabled(true);
        });

    }
}