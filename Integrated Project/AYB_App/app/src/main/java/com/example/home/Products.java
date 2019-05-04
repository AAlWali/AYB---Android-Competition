package com.example.home;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.GridView;


import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Products extends AppCompatActivity {
    GridView gridView;
    ArrayList<model> arrayList;
    itemsAdapter adapter;

    FirebaseDatabase database;
    DatabaseReference myRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_products);
        gridView = findViewById(R.id.gridview);
        arrayList = new ArrayList<>();
        database = FirebaseDatabase.getInstance();
        myRef = database.getReference("Products");

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            // datasnapshot has all posts children now
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot ds : dataSnapshot.getChildren()){
                    String photo = ds.child("Photo").getValue().toString();
                    String post = ds.child("Name").getValue().toString();
                    String price = ds.child("Price").getValue().toString();
                    arrayList.add(new model(photo,post,price));
                }
                adapter = new itemsAdapter(getApplicationContext(), arrayList);
                gridView.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

}
