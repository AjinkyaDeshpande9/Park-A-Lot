package com.example.park_a_lot;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MobileRegistration extends AppCompatActivity {
    Button mSendOTP, mVerifyButton;
    TextView mResendOTP;
    EditText mNumber;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mobile_registration);
        mSendOTP = findViewById(R.id.SendOTP);
        mVerifyButton = findViewById(R.id.Verifybutton);
        mResendOTP = findViewById(R.id.resendOtp);
        mNumber = findViewById(R.id.RegMob);
        mSendOTP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               mSendOTP.setVisibility(View.INVISIBLE);
               mVerifyButton.setVisibility(View.VISIBLE);
               mResendOTP.setVisibility(View.VISIBLE);
            }
        });
    }
}