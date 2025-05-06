package com.example.myapplication.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
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

public class ChooseRoleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savednstanceState) {
        super.onCreate(savednstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.choose_role_activity);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.choose_role_activity_layout), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        //todo: sell mobile pages
        Button sellButton = findViewById(R.id.SellButton);
        sellButton.setOnClickListener(b -> {

        });

        Button buyButton = findViewById(R.id.BuyButton);
        buyButton.setOnClickListener(b -> {
            WebView webView = new WebView(ChooseRoleActivity.this);
            webView.setWebViewClient(new WebViewClient() {
                @Override
                public boolean shouldOverrideUrlLoading(WebView view, String url) {
                    view.loadUrl(url);
                    return false;
                }
            });
            setContentView(webView);
            webView.loadUrl(String.format("%s/", AppResources.Constants.MOBILE_PAGES));
            webView.getSettings().setJavaScriptEnabled(true);
            webView.addJavascriptInterface(new RegisterLoginJsInterface(this),"RegisterLoginJsInterface");
        });

        Button deliverButton = findViewById(R.id.BuyButton);
        deliverButton.setOnClickListener(b -> {
            Context context = getBaseContext();
            Intent intent = new Intent(context, DeliverActivity.class);
            startActivity(intent,savednstanceState);
        });
    }
}
