package com.example.aybapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;


import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class adminPage extends AppCompatActivity {

    private Button addPerson ;
    private Button addTshirt;
    private EditText serviceDetails;
    private EditText tshirtName;
    private EditText price;
    private CheckBox acquired;
    private CheckBox black;
    private CheckBox blue;
    private CheckBox green;
    private CheckBox orange;
    private CheckBox purple;
    private CheckBox red;
    private CheckBox white;
    private CheckBox yellow;
    private CheckBox small;
    private CheckBox medium;
    private CheckBox large;
    private CheckBox xlarge;

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myPersonRef;
    DatabaseReference myTshirtRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_page);

        myPersonRef = database.getReference("/People");
        myTshirtRef = database.getReference("/T-Shirts");

        addPerson = (Button) findViewById(R.id.addPersonButton);
        addTshirt = (Button) findViewById(R.id.addTshirtButton);
        serviceDetails = (EditText) findViewById(R.id.serviceDetailsEditText);
        tshirtName = (EditText) findViewById(R.id.tshirNameEditText);
        price = (EditText) findViewById(R.id.priceEditText);
        acquired = (CheckBox) findViewById(R.id.acquiredCheckBox);
        black = (CheckBox) findViewById(R.id.blackRB);
        blue = (CheckBox) findViewById(R.id.blueRB);
        green = (CheckBox) findViewById(R.id.greenRB);
        orange = (CheckBox) findViewById(R.id.orangeRB);
        purple = (CheckBox) findViewById(R.id.purpleRB);
        red = (CheckBox) findViewById(R.id.redRB);
        white = (CheckBox) findViewById(R.id.whiteRB);
        yellow = (CheckBox) findViewById(R.id.yellowRB);
        small = (CheckBox) findViewById(R.id.smallRB);
        medium = (CheckBox) findViewById(R.id.mediumRB);
        large = (CheckBox) findViewById(R.id.largeRB);
        xlarge = (CheckBox) findViewById(R.id.xlargeRB);

        addPerson.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String personId = myPersonRef.push().getKey();
                String details = serviceDetails.getText().toString();
                boolean acq = acquired.isChecked();
                Service service = new Service(details, acq);

                myPersonRef.child(personId).setValue(service);

            }
        });

        addTshirt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String tshirtId = myTshirtRef.push().getKey();

                String name = tshirtName.getText().toString();
                String tprice = price.getText().toString();
                float tpriceFloat = Float.valueOf(tprice);
                String color;
                String size;
                if(black.isChecked())
                    color = "Black";
                else if (blue.isChecked())
                    color = "Blue";
                else if (green.isChecked())
                    color = "Green";
                else if (orange.isChecked())
                    color = "Orange";
                else if (purple.isChecked())
                    color = "Purple";
                else if (red.isChecked())
                    color = "Red";
                else if (white.isChecked())
                    color = "White";
                else if(yellow.isChecked())
                    color = "Yellow";
                else color = "No color selected";

                if(small.isChecked())
                    size = "Small";
                else if (medium.isChecked())
                    size = "Medium";
                else if (large.isChecked())
                    size = "Large";
                else if (xlarge.isChecked())
                    size = "XLarge";
                else if (xlarge.isChecked())
                    size = "XLarge";
                else
                    size = "No size selected";

                Tshirt tshirt = new Tshirt(name, tpriceFloat, color, size);
                myTshirtRef.child(tshirtId).setValue(tshirt);

            }
        });
    }
}
