package com.example.home;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button A , T , L ;
    private Button adminPageButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        A = findViewById(R.id.Aghatha);
        T = findViewById(R.id.Troos);
        L = findViewById(R.id.login);
        adminPageButton = (Button) findViewById(R.id.adminPageButton);

        adminPageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (MainActivity.this, adminPage.class);
                startActivity(intent);
            }
        });


    }
    public void Apage(View view){
        Intent p = new Intent(this, Cases.class);
        startActivity(p);
    }

    public void Tpage(View view){
        Intent p = new Intent(this, Products.class);
        startActivity(p);
    }
    public void LPage(View view){
        Intent p = new Intent(this, Login.class); ///////// Change to Login Page
        startActivity(p);
    }
}
