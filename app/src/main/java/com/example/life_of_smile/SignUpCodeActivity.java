package com.example.life_of_smile;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.arch.core.executor.TaskExecutor;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskExecutors;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.concurrent.TimeUnit;

public class SignUpCodeActivity extends AppCompatActivity {
    private String verificationId;
    TextView textView2;
    TextView TV_code;
    EditText ET_code;
    Button B_signup;

    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_up_code);

        //initialize Firebase
        mAuth = FirebaseAuth.getInstance();

        B_signup=(Button)findViewById(R.id.B_signup);
        TV_code=(TextView)findViewById(R.id.TV_code);
        textView2=(TextView)findViewById(R.id.textView2);
        ET_code=(EditText) findViewById(R.id.ET_code);
        String phonenumber= getIntent().getStringExtra("phonenumber");

        sendVerificationCode(phonenumber);

        findViewById(R.id.B_signup).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String code = ET_code.getText().toString().trim();
                if (code.isEmpty() || code.length() < 4){
                    ET_code.setError("Enter code ..");
                    ET_code.requestFocus();
                    return;
                }
                verifyCode(code);

            }
        });




    }

    private void sendVerificationCode(String number)
    {
        PhoneAuthProvider.getInstance().verifyPhoneNumber(
                number,
                60,
                TimeUnit.SECONDS,
                TaskExecutors.MAIN_THREAD,
                mCallBack
        );
    }
    private PhoneAuthProvider.OnVerificationStateChangedCallbacks
    mCallBack= new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {

        @Override
        public void onCodeSent(String s, PhoneAuthProvider.ForceResendingToken forceResendingToken) {
            super.onCodeSent(s, forceResendingToken);
            verificationId = s;
        }

        @Override
        public void onVerificationCompleted(PhoneAuthCredential phoneAuthCredential) {
            String code = phoneAuthCredential.getSmsCode();

            if (code !=null){
                ET_code.setText(code);
                verifyCode(code);
            }


        }

        @Override
        public void onVerificationFailed(FirebaseException e) {
            Toast.makeText(SignUpCodeActivity.this, ""+e.getMessage(), Toast.LENGTH_SHORT).show();

        }
    };


    private void verifyCode(String code)
    {
        PhoneAuthCredential credential = PhoneAuthProvider.getCredential(verificationId,code);
        signInWithCredential(credential);
    }

    private void signInWithCredential(PhoneAuthCredential credential) {

        mAuth.signInWithCredential(credential)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        // sign in success
                        if (task.isSuccessful()){
                            Toast.makeText(SignUpCodeActivity.this, "Sign in success!", Toast.LENGTH_SHORT).show();
                            Intent goSignUp = new Intent(SignUpCodeActivity.this, SignUpProfileActivity.class);
                            goSignUp.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                            startActivity(goSignUp);
                            finish();
                        }else{
                            Toast.makeText(SignUpCodeActivity.this, "Something is went wrong!", Toast.LENGTH_SHORT).show();
                        }

                    }
                });
    }
}
