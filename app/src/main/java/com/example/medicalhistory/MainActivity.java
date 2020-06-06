package com.example.medicalhistory;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {
    TextInputLayout name, age, state, city, symptoms, address, id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name=findViewById(R.id.patientname);
        age=findViewById(R.id.age);
        state=findViewById(R.id.State);
        city=findViewById(R.id.City);
        symptoms=findViewById(R.id.Symptoms);
        address=findViewById(R.id.Address);
        id=findViewById(R.id.AadharId);

    }
}
