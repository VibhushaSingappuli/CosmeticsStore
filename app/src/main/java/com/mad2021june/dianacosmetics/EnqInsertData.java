package com.mad2021june.dianacosmetics;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class EnqInsertData extends AppCompatActivity {

    Button btnSend;
    EditText editName;
    EditText edtMessage;
    DatabaseReference databaseReference;
    public static String userId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enq_insert_data);

        databaseReference = FirebaseDatabase.getInstance().getReference("Enquires");

        btnSend = findViewById(R.id.btnSend);
        editName =  findViewById(R.id.edtName);
        edtMessage =  findViewById(R.id.edtMessage);
    }
}