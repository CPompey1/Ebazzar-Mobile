package com.example.myapplication.activities;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;
import com.example.myapplication.fragments.DeliverMapView;


public class DeliverActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstance){
        super.onCreate(savedInstance);

        if (savedInstance == null){
            Bundle bundle = new Bundle();
            getSupportFragmentManager().beginTransaction()
                    .setReorderingAllowed(true)
                    .add(R.id.deliver_map_view, DeliverMapView.class,bundle)
                    .commit();
        }


    }
}
