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
import com.mad2021june.dianacosmetics.Model.EnqUser;

public class EnqInsertData extends AppCompatActivity {

    Button btnSend;
    EditText editEmail;
    EditText edtMessage;
    DatabaseReference databaseReference;
    public static String userId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enq_insert_data);

        databaseReference = FirebaseDatabase.getInstance().getReference("Enquires");

        btnSend = findViewById(R.id.btnSend);
        editEmail =  findViewById(R.id.edtName);
        edtMessage =  findViewById(R.id.edtMessage);

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = editEmail.getText().toString();
                String message = edtMessage.getText().toString();

                if(TextUtils.isEmpty(email) && TextUtils.isEmpty(message)){
                    editEmail.setError("Enter the Email");
                    editEmail.requestFocus();
                    edtMessage.setError("Enter the Message");
                    edtMessage.requestFocus();
                }else{

                    //save
                    String id = databaseReference.push().getKey();
                    EnqUser enqUser = new EnqUser(id,email,message);
                    databaseReference.child(id).setValue(enqUser);

                    Toast.makeText(EnqInsertData.this, "Enquiry Sent Successfully", Toast.LENGTH_SHORT).show();
                }
                editEmail.setText(null);
                edtMessage.setText(null);
            }
        });
    }
}