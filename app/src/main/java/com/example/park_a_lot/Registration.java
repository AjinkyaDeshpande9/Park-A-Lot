package com.example.park_a_lot;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;


public class Registration extends AppCompatActivity {
    EditText mName, mEmail, mPassword, mCPassword;
    TextView mLogin;
    Button mProceedButton;
    ProgressBar progressBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_registration);
        mName = findViewById(R.id.regName);
        mEmail = findViewById(R.id.regEmail);
        mPassword = findViewById(R.id.regPassword);
        mCPassword = findViewById(R.id.regConPassword);
        mProceedButton = findViewById(R.id.Proceedbutton);
        mLogin = findViewById(R.id.loginHere);

        mLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),Login.class));
            }
        });

        mProceedButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
            String name = mName.getText().toString();
            String email = mEmail.getText().toString();
            String password = mPassword.getText().toString();
            String cpassword = mCPassword.getText().toString();

            //this is the new code
                Intent intent1 = new Intent(Registration.this,VehicleRegistration.class);
                intent1.putExtra("passname",name);
                intent1.putExtra("passemail",email);
                intent1.putExtra("passpassword",password);
                startActivity(intent1);
            // code ends for passing to vehicle registration

                if(TextUtils.isEmpty(name) || TextUtils.isEmpty(email) || TextUtils.isEmpty(password) || TextUtils.isEmpty(cpassword))
                {
                    Toast.makeText(Registration.this,"All Fields are Required", Toast.LENGTH_SHORT).show();
                    mName.setError("Name is Required.");
                    mEmail.setError("Email is Required.");
                    mPassword.setError("Password is Required.");
                    mCPassword.setError("Password is Required.");
                }
                else
                {
                    if(password.equals(cpassword)){
                       startActivity(new Intent(getApplicationContext(),MobileRegistration.class));
                       progressBar.setVisibility(View.VISIBLE);
                    }
                    else{
                        mCPassword.setError("Password does not match.");
                    }
                }
            }
        });
    }
}



