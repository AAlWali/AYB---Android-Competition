package com.example.home;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class Register extends AppCompatActivity {
    EditText usrname,usrmail,phone,usrpass;
    Button regbutton;
    String name,password,phone_no,email;
    ProgressDialog progressDialog;
    FirebaseAuth firebaseAuth;
    FirebaseDatabase database;
    DatabaseReference mref,mref2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        progressDialog =new ProgressDialog(this);
        usrname=(EditText)findViewById(R.id.editText3);
        usrmail=(EditText)findViewById(R.id.editText4);
        usrpass=(EditText)findViewById(R.id.editText5);
        phone=(EditText)findViewById(R.id. editText6);
        regbutton=(Button)findViewById(R.id.regButton);
        firebaseAuth =FirebaseAuth.getInstance();
        database = FirebaseDatabase.getInstance();
        mref = database.getReference("/Users");
        regbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (valid())
                {
                    create(email,password);
                    mref = database.getReference(name);
                    addInfo("name",usrname.getText().toString());
                    addInfo("phone",phone.getText().toString());
                    addInfo("admin","false");
                    progressDialog.setMessage("Loading");
                    progressDialog.show();
                    startActivity(new Intent(Register.this,MainActivity.class));
                }

            }
        });
    }
    private Boolean valid()
    {
        Boolean result = false;
        name = usrname.getText().toString();
        password = usrpass.getText().toString();
        email = usrmail.getText().toString();
        phone_no = phone.getText().toString();
        if(name.isEmpty() || password.isEmpty() || email.isEmpty() || phone_no.isEmpty() ){
            Toast.makeText(this, "Please enter all the details", Toast.LENGTH_SHORT).show();
        }
        else if ( !Patterns.EMAIL_ADDRESS.matcher(email).matches()   )
        {              Toast.makeText(this, "Not valid E-Mail", Toast.LENGTH_SHORT).show();
        }
        else{
            result = true;
        }

        return result;
    }
    private void create(String mail,String pass) {
        firebaseAuth.createUserWithEmailAndPassword(mail, pass).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

            }
        });

    }
    public void addInfo(String key,String value){
        Map<String, String> map = new HashMap<>();
        map.put(key, value);
        mref.push().setValue(map);
    }
}

