package com.example.myapplication.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.example.myapplication.R;

public class HeaderFragment extends Fragment {

    @Override
    public void onCreate(Bundle savedInstance){
        super.onCreate(savedInstance);
        return;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.header, container, false);
        return view;
    }
}
