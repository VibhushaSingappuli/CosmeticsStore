package com.mad2021june.dianacosmetics;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.mad2021june.dianacosmetics.Model.EnqUser;

import java.util.ArrayList;
import java.util.List;

public class EnqList extends AppCompatActivity {

    DatabaseReference databaseReference;
    ListView listViewUsers;
    List<EnqUser> enqUsers;
    Button btnAdd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enq_list);

        listViewUsers = (ListView) findViewById(R.id.ListViewUsers);
        databaseReference = FirebaseDatabase.getInstance().getReference("Enquires");
        enqUsers = new ArrayList<EnqUser>();
        btnAdd = (Button) findViewById(R.id.btnAdd);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), EnqInsertData.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                enqUsers.clear();

                for(DataSnapshot postSnapshot:dataSnapshot.getChildren()){
                    EnqUser enqUser = postSnapshot.getValue(EnqUser.class);
                    enqUsers.add(enqUser);
                }
                UserList userAdapter = new UserList(EnqList.this, enqUsers,databaseReference);
                listViewUsers.setAdapter(userAdapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}