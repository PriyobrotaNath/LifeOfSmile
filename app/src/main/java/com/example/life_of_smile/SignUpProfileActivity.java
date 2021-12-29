package com.example.life_of_smile;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class SignUpProfileActivity extends AppCompatActivity {
    Button B_done;
    @Override
    protected  void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_up_profile);
        B_done=(Button)findViewById(R.id.B_done);
        final EditText ET_Name=(EditText)findViewById(R.id.ET_Name);
        final EditText ET_Email=(EditText)findViewById(R.id.ET_Email);
        final EditText ET_Gender=(EditText)findViewById(R.id.ET_Gender);
        final EditText ET_BloodGroup=(EditText)findViewById(R.id.ET_BloodGroup);
        B_done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(SignUpProfileActivity.this,DonorProfileDetailsActivity.class);
                intent.putExtra("Name",ET_Name.getText().toString());
                intent.putExtra("Email",ET_Email.getText().toString());
                intent.putExtra("Gender",ET_Gender.getText().toString());
                intent.putExtra("Blood Group",ET_BloodGroup.getText().toString());
                startActivity(intent);
            }
        });
    }
}

