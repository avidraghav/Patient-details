package com.example.medicalhistory;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {
    TextInputLayout symptoms;
    AutoCompleteTextView symptoms1;
    TextInputEditText name1, age1, state1, city1, address1, id1;
    Button submitbtn;

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
        id1=findViewById(R.id.Phonenumber1);
        submitbtn=findViewById(R.id.Submit_btn);
        symptoms=findViewById(R.id.Symptoms);

        String[] listsymptoms=new String[]{
                "Cough/Cold/Fever",
                "Other"
        };
       ArrayAdapter<String> adapter=new ArrayAdapter<>(MainActivity.this,R.layout.symptomlist,listsymptoms);
       symptoms1.setAdapter(adapter);


        submitbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, name1.getText().toString(), Toast.LENGTH_SHORT).show();
            }
        });


    }
}
