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
    EditText mOTP1,mOTP2,mOTP3,mOTP4,mOTP5,mOTP6;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mobile_registration);
        mSendOTP = findViewById(R.id.SendOTP);
        mVerifyButton = findViewById(R.id.Verifybutton);
        mResendOTP = findViewById(R.id.resendOtp);
        mSendOTP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mVerifyButton.setVisibility(View.VISIBLE);
                mResendOTP.setVisibility(View.VISIBLE);
                mSendOTP.setVisibility(View.INVISIBLE);
                mOTP1.setVisibility(View.VISIBLE);
                mOTP2.setVisibility(View.VISIBLE);
                mOTP3.setVisibility(View.VISIBLE);
                mOTP4.setVisibility(View.VISIBLE);
                mOTP5.setVisibility(View.VISIBLE);
                mOTP6.setVisibility(View.VISIBLE);
            }
        });
    }
}