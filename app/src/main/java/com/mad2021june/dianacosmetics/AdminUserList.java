package com.mad2021june.dianacosmetics;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.google.firebase.database.DatabaseReference;
import com.mad2021june.dianacosmetics.Model.EnqUser;

import java.util.List;

public class AdminUserList extends ArrayAdapter<EnqUser> {

    Button btnReply;
    private Activity context;
    private List<EnqUser> enqUsers;
    DatabaseReference databaseReference;

    public AdminUserList(@NonNull Activity context, List<EnqUser> enqUsers, DatabaseReference databaseReference) {
        super(context, R.layout.admin_user_list, enqUsers);
        this.context = context;
        this.enqUsers = enqUsers;
        this.databaseReference = databaseReference;

    }

    public View getView(int pos, View view, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View listViewItem = inflater.inflate(R.layout.admin_user_list, null, true);

        TextView txtEmail = (TextView) listViewItem.findViewById(R.id.txtEmail);
        TextView txtMessage = (TextView) listViewItem.findViewById(R.id.txtMessage);

        Button btnReply = (Button) listViewItem.findViewById(R.id.btnReplay);

        final EnqUser enqUser = enqUsers.get(pos);
        txtEmail.setText(enqUser.getEmail());
        txtMessage.setText(enqUser.getMessage());

        btnReply.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                GoToUrl("https://mail.google.com/");
            }
        });
        return listViewItem;
    }

    private void GoToUrl(String s) {
        Uri uri = Uri.parse(s);
        Intent intent = new Intent(Intent.ACTION_VIEW,uri);
        context.startActivity(intent);
    }
}