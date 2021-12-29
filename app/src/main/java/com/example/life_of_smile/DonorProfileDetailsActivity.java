package com.example.life_of_smile;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DonorProfileDetailsActivity extends AppCompatActivity {
    @Override
    protected  void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.donor_profile_details);

        final TextView TV_Name=(TextView)findViewById(R.id.TV_Name);
        final TextView TV_Email=(TextView)findViewById(R.id.TV_Email);
        final TextView TV_Gender=(TextView)findViewById(R.id.TV_Gender);
        final TextView TV_BloodGroup=(TextView)findViewById(R.id.TV_BloodGroup);

        TV_Name.setText(getIntent().getExtras().getString("Name"));
        TV_Email.setText(getIntent().getExtras().getString("Email"));
        TV_Gender.setText(getIntent().getExtras().getString("Gender"));
        TV_BloodGroup.setText(getIntent().getExtras().getString("Blood Group"));
    }
}
