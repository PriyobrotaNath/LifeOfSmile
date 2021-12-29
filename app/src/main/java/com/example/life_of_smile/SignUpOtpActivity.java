package com.example.life_of_smile;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;

public class SignUpOtpActivity extends AppCompatActivity {
    TextView textView1;
    TextView TV_PhoneNumber;
   private EditText ET_PhoneNumber;
    Button B_otp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_up_otp);

        B_otp=(Button)findViewById(R.id.B_otp);
        TV_PhoneNumber=(TextView)findViewById(R.id.TV_PhoneNumber);
        textView1=(TextView)findViewById(R.id.textView1);
        ET_PhoneNumber=(EditText) findViewById(R.id.ET_PhoneNumber);
    findViewById(R.id.B_otp).setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String number=ET_PhoneNumber.getText().toString();
            if(number.isEmpty() || number.length()<11){
                ET_PhoneNumber.setError("valid number is required");
                ET_PhoneNumber.requestFocus();
                return;
            }
            String phonenumber="+88"+number;
            Intent intent=new Intent(SignUpOtpActivity.this,SignUpCodeActivity.class);
            intent.putExtra("phonenumber",phonenumber);
            startActivity(intent);
        }
    });
    }
    @Override
    protected void onStart(){
        super.onStart();
        if(FirebaseAuth.getInstance().getCurrentUser()!=null){
            Intent intent=new Intent(this,SignUpProfileActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
        }

    }
}
