package com.mad2021june.dianacosmetics.Payment;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.mad2021june.dianacosmetics.R;

public class YourDetails extends AppCompatActivity {
    private EditText fName, lName, mail, phone, address;
    private Button button, update,Next;

    DatabaseReference adddataRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_your_details);

        fName = (EditText) findViewById(R.id.fName);
        lName = (EditText) findViewById(R.id.lName);
        mail = (EditText) findViewById(R.id.mail);
        phone = (EditText) findViewById(R.id.phone);
        address = (EditText) findViewById(R.id.address);
        button = (Button) findViewById(R.id.button);
        update = (Button) findViewById(R.id.update);
        Next = (Button) findViewById(R.id.Next);

        adddataRef = FirebaseDatabase.getInstance().getReference().child("Student");
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                insertStudentData();
            }
        });

    }

    private void insertStudentData(){
        String name = fName.getText().toString();
        String lastName = lName.getText().toString();
        String email = mail.getText().toString();
        String phoneNo = phone.getText().toString();
        String Address = address.getText().toString();

        Student student = new Student(name,lastName,email,phoneNo,Address);
        adddataRef.push().setValue(student);
        Toast.makeText( YourDetails.this, "data inserted", Toast.LENGTH_LONG).show();

    }




}