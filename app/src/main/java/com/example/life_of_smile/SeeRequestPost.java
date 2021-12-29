package com.example.life_of_smile;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SeeRequestPost extends AppCompatActivity {
    Button allReqButton, myReqButton;
    FragmentManager fragmanager;
    FragmentTransaction fragmentTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_see_request_post);
        allReqButton = findViewById(R.id.all_request);
        myReqButton = findViewById(R.id.my_request);
        //
        final MyRequestsFragment myFrag = new MyRequestsFragment();
        // default fragment
        fragmanager=getSupportFragmentManager();
        fragmentTransaction = fragmanager.beginTransaction();
        final AllRequestsFragment allRequestsFragment = new AllRequestsFragment(); // create a fragment object
        fragmentTransaction.add(R.id.container, allRequestsFragment);
        fragmentTransaction.commit();
        //

        myReqButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fragmentTransaction.add(R.id.container, myFrag);
                fragmentTransaction.commit();
            }
        });

        allReqButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fragmentTransaction.add(R.id.container, allRequestsFragment);
                fragmentTransaction.commit();
            }
        });

    }
}
