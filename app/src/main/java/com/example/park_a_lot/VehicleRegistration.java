package com.example.park_a_lot;

import androidx.annotation.NonNull;
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

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class VehicleRegistration extends AppCompatActivity {
    String[] items = {"Two Wheeler","Three Wheeler","Four Wheeler"};
    AutoCompleteTextView autoCompleteTxt;
    ArrayAdapter<String> adapterItems;
    Button mProceed;
    EditText mName, mEmail, mPassword, mVecNumber, mMobNumber, mVecType;


    FirebaseDatabase rootNode;
    DatabaseReference reference = FirebaseDatabase.getInstance().getReferenceFromUrl("https://parkalot-b98ef-default-rtdb.firebaseio.com/");


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
                String uName = mName.getText().toString();
                String uEmail = mEmail.getText().toString();
                String uPassword = mPassword.getText().toString();
                String uMobNumber = mMobNumber.getText().toString();
                String uVecNumber = mVecNumber.getText().toString();
                String uVectype = mVecType.getText().toString();

                //     UserHelperClass helperClass = new UserHelperClass(uName,uEmail,uPassword,uMobNumber,uVecNumber);


                reference.child("users").addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {

                        //check if phone not registered
                        if(snapshot.hasChild(uName)){
                            Toast.makeText(VehicleRegistration.this, "Name already registered", Toast.LENGTH_SHORT).show();
                        }
                        else{
                            //using Name as unique identity of the user(temporary)
                            //other details comes under the above mentioned unique ID
                            reference.child("users").child(uName).child("Email").setValue(uEmail);
                            reference.child("users").child(uName).child("Password").setValue(uPassword);
                            reference.child("users").child(uName).child("Mobile Number").setValue(uMobNumber);
                            reference.child("users").child(uName).child("Vehicle Number").setValue(uVecNumber);
                            reference.child("users").child(uName).child("Vehicle Type").setValue(uVectype);

                            //success message
                            Toast.makeText(VehicleRegistration.this, "User registered successfully.", Toast.LENGTH_SHORT).show();
                            finish();
                        }

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
                startActivity(new Intent(getApplicationContext(),MainActivity.class));



            }
        });
    }
}