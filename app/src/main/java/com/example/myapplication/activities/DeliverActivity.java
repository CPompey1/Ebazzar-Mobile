package com.example.myapplication.activities;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;
import com.example.myapplication.fragments.DeliverMapView;
import com.example.myapplication.fragments.HeaderFragment;


public class DeliverActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstance){
        super.onCreate(savedInstance);
        setContentView(R.layout.activity_deliver);
        if (savedInstance == null){
            Bundle bundle = new Bundle();
            getSupportFragmentManager().beginTransaction()
                    .setReorderingAllowed(true)
                    .add(R.id.mapbox_deliver_container, DeliverMapView.class,bundle)
                    .add(R.id.header_frag_container, HeaderFragment.class,bundle)
                    .commit();
        }


    }
}
