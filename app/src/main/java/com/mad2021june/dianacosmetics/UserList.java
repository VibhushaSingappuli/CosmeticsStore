package com.mad2021june.dianacosmetics;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.mad2021june.dianacosmetics.Model.EnqUser;

import java.util.List;

public class UserList extends ArrayAdapter<EnqUser> {
    Button btnUpdate;
    private Activity context;
    private List<EnqUser> enqUsers;
    DatabaseReference databaseReference;


    public UserList(@NonNull Activity context, List<EnqUser> enqUsers, DatabaseReference databaseReference) {
        super(context, R.layout.layout_user_list, enqUsers);
        this.context = context;
        this.enqUsers = enqUsers;
        this.databaseReference = databaseReference;

    }
    public View getView(int pos, View view, ViewGroup parent){
        LayoutInflater inflater = context.getLayoutInflater();
        View listViewItem = inflater.inflate(R.layout.layout_user_list,null,true);

        TextView txtEmail =(TextView) listViewItem.findViewById(R.id.txtEmail);
        TextView txtMessage =(TextView) listViewItem.findViewById(R.id.txtMessage);
        Button btnDelete =(Button) listViewItem.findViewById(R.id.btnDelete);
        Button btnUpdate =(Button) listViewItem.findViewById(R.id.btnUpdate);

        final EnqUser enqUser = enqUsers.get(pos);
        txtEmail.setText(enqUser.getEmail());
        txtMessage.setText(enqUser.getMessage());

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                databaseReference.child(enqUser.getId()).removeValue();
            }
        });

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context.getApplicationContext(), EnqUpdate.class);
                intent.putExtra("EMAIL", enqUser.getEmail());
                intent.putExtra("ID", enqUser.getId());
                intent.putExtra("MESSAGE", enqUser.getMessage());
                context.startActivity(intent);
            }
        });
        return listViewItem;
    }
}