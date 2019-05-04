package com.example.home;

import android.app.ProgressDialog;
import android.content.Intent;
import android.media.MediaPlayer;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Login extends AppCompatActivity {
    EditText user_email;
    EditText user_pass;
    TextView textv;
    Button b;
    ProgressDialog progressDialog;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        user_email=(EditText)findViewById(R.id.editText);
        user_pass=(EditText)findViewById(R.id.editText2);
        textv=(TextView)findViewById(R.id.textView2);
        b=(Button)findViewById(R.id.button);
        mAuth = FirebaseAuth.getInstance();
        progressDialog = new ProgressDialog(this);
        FirebaseUser user = mAuth.getCurrentUser();
        if(user != null){
            finish();
            startActivity(new Intent(Login.this, MainActivity.class));
        }
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if( check( user_email.getText().toString(),user_pass.getText().toString()) )
                    valid();

            }
        });
        textv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Login.this,Register.class));
            }
        });
    }
    private Boolean check(String mmail,String mpass)
    {
        Boolean flag=false;
        String email=user_email.getText().toString();
        String pass=user_pass.getText().toString();
        if(email.isEmpty() || pass.isEmpty()){
            Toast.makeText(this, "Please enter all the details", Toast.LENGTH_SHORT).show();
        }
        else flag=true;
        return flag;
    }

    private void valid() {
        progressDialog.setMessage("Loading");
        progressDialog.show();
        String email = user_email.getText().toString();
        String pass = user_pass.getText().toString();
        mAuth.signInWithEmailAndPassword(email,pass)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            progressDialog.dismiss();
                            startActivity(new Intent(Login.this, MainActivity.class));
                        } else {
                            progressDialog.dismiss();

                        }
                    }
                }
            );

    }
}
