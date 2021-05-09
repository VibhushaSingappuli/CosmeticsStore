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

public class Card extends AppCompatActivity {

    private EditText account, name, date, cvc;
    private Button button, update, delete;

    DatabaseReference adddataRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card);

        account = (EditText) findViewById(R.id.account);
        name = (EditText) findViewById(R.id.name);
        date = (EditText) findViewById(R.id.date);
        cvc = (EditText) findViewById(R.id.cvc);
        button = (Button) findViewById(R.id.button);
        update = (Button) findViewById(R.id.update);
        delete = (Button) findViewById(R.id.delete);

        adddataRef = FirebaseDatabase.getInstance().getReference().child("Person");

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insertPersonData();
            }
        });
    }


    private void insertPersonData() {

        String Account = account.getText().toString();
        String Name = name.getText().toString();
        String Date = date.getText().toString();
        String CVC = cvc.getText().toString();

        Person person = new Person(Account, Name, Date, CVC);
        adddataRef.push().setValue(person);
        Toast.makeText(Card.this, "data inserted", Toast.LENGTH_LONG).show();
    }
}