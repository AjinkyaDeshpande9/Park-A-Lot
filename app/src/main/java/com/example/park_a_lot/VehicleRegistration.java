package com.example.park_a_lot;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class VehicleRegistration extends AppCompatActivity {
    String[] items = {"Two Wheeler","Three Wheeler","Four Wheeler"};
    AutoCompleteTextView autoCompleteTxt;
    ArrayAdapter<String> adapterItems;
    Button mProceed;
    EditText mName, mEmail, mPassword, mVecNumber, mMobNumber;


    FirebaseDatabase rootNode;
    DatabaseReference reference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vehicle_registration);

        mName = findViewById(R.id.regName);
        mEmail = findViewById(R.id.regEmail);
        mPassword = findViewById(R.id.regPassword);
        mVecNumber = findViewById(R.id.regVecNumber);
        mMobNumber = findViewById(R.id.RegMob);

        autoCompleteTxt = findViewById(R.id.regvehicleType);
        mProceed = findViewById(R.id.Submitbtn);
        adapterItems = new ArrayAdapter<String>(this,R.layout.list_items,items);
        autoCompleteTxt.setAdapter(adapterItems);



        autoCompleteTxt.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String item = parent.getItemAtPosition(position).toString();


            }
        });


        mProceed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                rootNode= FirebaseDatabase.getInstance();
                reference = rootNode.getReference("Users") ;

                //Getting all the values
                String uName = ;
                String uEmail = mEmail.getText().toString();
                String uPassword = mPassword.getText().toString();
                String uMobNumber = mMobNumber.getText().toString();
                String uVecNumber = mVecNumber.getText().toString();
               // String uVectype = mVectype.getText().toString();

           //     UserHelperClass helperClass = new UserHelperClass(uName,uEmail,uPassword,uMobNumber,uVecNumber);

                reference.setValue("First test");


            }
        });
    }
}