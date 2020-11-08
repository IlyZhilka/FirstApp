package com.example.firstapp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements Adapter.OnClickListener{

    RecyclerView recyclerView;

    private Adapter adapter;

    private DatabaseReference myRef;

    private ArrayList<Data> dataList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.rv_main);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
        recyclerView.setHasFixedSize(true);


        myRef = FirebaseDatabase.getInstance().getReference();

        dataList = new ArrayList<>();


        getDataFromDb();



    }

    private void getDataFromDb() {
        Query query = myRef.child("info");
        query.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot snapshot :dataSnapshot.getChildren()){
                    Data data = new Data();
                    data.setImage(snapshot.child("image").getValue().toString());
                    data.setTitle(snapshot.child("title").getValue().toString());
                    data.setBodyInfo(snapshot.child("bodyInfo").getValue().toString());
                    dataList.add(data);
                }
                adapter = new Adapter(getApplicationContext(),dataList);
                adapter.setOnClickListener(MainActivity.this);
                recyclerView.setAdapter(adapter);
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }


    @Override
    public void onClick(Data model) {
        Bundle bundle = new Bundle();
        bundle.putSerializable("keyModel", model);

        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra("keyIntent", bundle);
        startActivity(intent);
    }
}