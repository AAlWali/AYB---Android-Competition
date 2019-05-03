package com.example.aybapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class adminPage extends AppCompatActivity {

    private Button addPerson ;
    private Button addTshirt;
    private EditText serviceDetails;
    private EditText tshirtName;
    private CheckBox acquired;
    private RadioButton black;
    private RadioButton blue;
    private RadioButton green;
    private RadioButton orange;
    private RadioButton purple;
    private RadioButton red;
    private RadioButton white;
    private RadioButton yellow;
    private RadioButton small;
    private RadioButton medium;
    private RadioButton large;
    private RadioButton xlarge;

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_page);


        myRef = database.getReference();
        myRef.setValue("Hello");

        addPerson = (Button) findViewById(R.id.addPersonButton);
        addTshirt = (Button) findViewById(R.id.addTshirtButton);
        serviceDetails = (EditText) findViewById(R.id.serviceDetailsEditText);
        tshirtName = (EditText) findViewById(R.id.tshirNameEditText);
        acquired = (CheckBox) findViewById(R.id.acquiredCheckBox);
        black = (RadioButton) findViewById(R.id.blackRB);
        blue = (RadioButton) findViewById(R.id.blueRB);
        green = (RadioButton) findViewById(R.id.greenRB);
        orange = (RadioButton) findViewById(R.id.orangeRB);
        purple = (RadioButton) findViewById(R.id.purpleRB);
        red = (RadioButton) findViewById(R.id.redRB);
        white = (RadioButton) findViewById(R.id.whiteRB);
        yellow = (RadioButton) findViewById(R.id.yellowRB);
        small = (RadioButton) findViewById(R.id.smallRB);
        medium = (RadioButton) findViewById(R.id.mediumRB);
        large = (RadioButton) findViewById(R.id.largeRB);
        xlarge = (RadioButton) findViewById(R.id.xlargeRB);

        /*addPerson.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });*/
    }
}
