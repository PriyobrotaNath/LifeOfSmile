package com.example.life_of_smile;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class AllRequestsFragment extends Fragment {

    TextView userName;


    public AllRequestsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
       View v = inflater.inflate(R.layout.fragment_all_requests, container, false);
        // Inflate the layout for this fragment
        userName = v.findViewById(R.id.TV_Name);


        return v;
    }

}
