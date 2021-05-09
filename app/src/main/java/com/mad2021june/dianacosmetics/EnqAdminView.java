package com.mad2021june.dianacosmetics;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
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

public class EnqAdminView extends AppCompatActivity {

    DatabaseReference databaseReference;
    ListView listViewUsers;
    List<EnqUser> enqUsers;
    Button btnReply;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enq_admin_view);

        listViewUsers = (ListView) findViewById(R.id.ListViewUsers);
        databaseReference = FirebaseDatabase.getInstance().getReference("Enquires");
        enqUsers = new ArrayList<EnqUser>();
        btnReply = (Button) findViewById(R.id.btnReplay);
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
                AdminUserList userAdapter = new AdminUserList(EnqAdminView.this, enqUsers,databaseReference);
                listViewUsers.setAdapter(userAdapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}