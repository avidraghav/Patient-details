package com.example.medicalhistory;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.StorageTaskScheduler;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    TextInputLayout symptoms;
    AutoCompleteTextView symptoms1;
    TextInputEditText name1, age1, state1, city1, address1, phone1;
    Button submitbtn;
    String NAME, AGE, SYMPTOMS, STATE, CITY, ADDRESS, PHONE;
    FirebaseAuth mAuth;

    Calendar calendar=Calendar.getInstance();
    String currentdate= DateFormat.getDateInstance(DateFormat.FULL).format(calendar.getTime());

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name1=findViewById(R.id.patientname1);
        age1=findViewById(R.id.age1);
        state1=findViewById(R.id.State1);
        city1=findViewById(R.id.City1);
         symptoms1=findViewById(R.id.Symptoms1);
        address1=findViewById(R.id.Address1);
        phone1=findViewById(R.id.Phonenumber1);
        submitbtn=findViewById(R.id.Submit_btn);
        symptoms=findViewById(R.id.Symptoms);


        String[] listsymptoms=new String[]{
                "Cough/Cold/Fever",
                "Other"
        };
       ArrayAdapter<String> adapter=new ArrayAdapter<>(MainActivity.this,R.layout.symptomlist,listsymptoms);
       symptoms1.setAdapter(adapter);

        mAuth = FirebaseAuth.getInstance();
        submitbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NAME=name1.getText().toString();
                AGE=age1.getText().toString();
                STATE=state1.getText().toString();
                CITY=city1.getText().toString();
                SYMPTOMS= symptoms1.getText().toString();
                ADDRESS=address1.getText().toString();
                PHONE=phone1.getText().toString();

                sendUserdata();
                Toast.makeText(MainActivity.this, "Submitted", Toast.LENGTH_SHORT).show();
            }
        });


    }
    public void sendUserdata(){
        FirebaseDatabase firebaseDatabase=FirebaseDatabase.getInstance();
        DatabaseReference databaseReference=firebaseDatabase.getReference(STATE+"/"+CITY+"/"+mAuth.getUid()+"/"+currentdate);
        Details details=new Details(NAME, AGE,STATE,CITY,SYMPTOMS,ADDRESS,PHONE);
        databaseReference.child(databaseReference.push().getKey()).setValue(details);
    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            // your code
            Intent intent=new Intent(MainActivity.this,HomeActivity.class);
            startActivity(intent);
            return true;
        }

        return super.onKeyDown(keyCode, event);
    }

}
