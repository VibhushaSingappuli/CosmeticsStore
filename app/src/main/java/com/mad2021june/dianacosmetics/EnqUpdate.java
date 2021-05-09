package com.mad2021june.dianacosmetics;



import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class EnqUpdate extends AppCompatActivity {

    String email;
    String id;
    String message;
    Button btnChange;
    EditText editEmail;
    EditText edtMessage;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enq_update);
        editEmail = findViewById(R.id.editEmail);
        edtMessage = findViewById(R.id.edtMessage);
        databaseReference =  FirebaseDatabase.getInstance().getReference("Enquires");
        btnChange = findViewById(R.id.btnChange);
        email= getIntent().getStringExtra("EMAIL");
        id= getIntent().getStringExtra("ID");
        message= getIntent().getStringExtra("MESSAGE");

        editEmail.setText(email);
        edtMessage.setText(message);

        btnChange.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                email = editEmail.getText().toString();
                message = edtMessage.getText().toString();
                databaseReference.child(id).child("email").setValue(email);
                databaseReference.child(id).child("message").setValue(message);

                if(TextUtils.isEmpty(email) && TextUtils.isEmpty(message)){
                    editEmail.setError("Enter the Email");
                    editEmail.requestFocus();
                    edtMessage.setError("Enter the Message");
                    edtMessage.requestFocus();
                }else{
                    Toast.makeText(EnqUpdate.this, "Enquiry Updated Successfully", Toast.LENGTH_SHORT).show();
                    editEmail.setText(null);
                    edtMessage.setText(null);
                    finish();
                }
            }
        });
    }
}