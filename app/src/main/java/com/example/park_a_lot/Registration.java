package com.example.park_a_lot;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

public class Registration extends AppCompatActivity {
    EditText mName, mEmail, mPassword, mCPassword;
    TextView mLogin;
    Button mProceedButton;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        mName = findViewById(R.id.regName);
        mEmail = findViewById(R.id.regVecType);
        mPassword = findViewById(R.id.regVecNumber);
        mCPassword = findViewById(R.id.regConPassword);
        mProceedButton = findViewById(R.id.Verifybutton);
        mLogin = findViewById(R.id.loginHere);

        mLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),Login.class));
            }
        });


        mProceedButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = mEmail.getText().toString().trim();
                String password = mPassword.getText().toString().trim();

                if (TextUtils.isEmpty(email)) {
                    mEmail.setError("Email is Required.");
                    return;
                }
                if (TextUtils.isEmpty(password)) {
                    mPassword.setError("Password is Required.");
                    return;
                }

                if (password.length() < 6) {
                    mPassword.setError("Password must be atleast 6 characters long");
                }

                else
                    {
                        startActivity(new Intent(getApplicationContext(), VehicleRegistration.class));
                    }

            }
        });
    }
}
                //check this code
//                {
//                    if (mCPassword.equals(mPassword)) {
//                        startActivity(new Intent(getApplicationContext(), VehicleRegistration.class));
//                    } else
//                        mCPassword.setError("Password does not match");
//                }
//                        progressBar.setVisibility(View.VISIBLE);


