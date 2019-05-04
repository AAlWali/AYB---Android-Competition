package com.example.home;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.GridView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Cases extends AppCompatActivity {
    GridView gridView;
    ArrayList<casemodel> arrayList;
    casesAdapter adapter;

    FirebaseDatabase database;
    DatabaseReference myRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cases);

        gridView = findViewById(R.id.gridview2);
        arrayList = new ArrayList<>();
        database = FirebaseDatabase.getInstance();
        myRef = database.getReference("Cases");

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            // datasnapshot has all posts children now
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot ds : dataSnapshot.getChildren()){
                    String Details = ds.child("Details").getValue().toString();

                    arrayList.add(new casemodel(Details));
                }
                adapter = new casesAdapter(getApplicationContext(), arrayList);
                gridView.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
