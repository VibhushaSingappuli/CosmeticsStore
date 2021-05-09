package com.mad2021june.dianacosmetics;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.mad2021june.dianacosmetics.Model.Cart;
import com.mad2021june.dianacosmetics.Prevalent.Prevalent;
import com.mad2021june.dianacosmetics.ViewHolder.CartViewHolder;

public class CartActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private Button nextProcessBtn;
    private TextView txtTotalPrice;

    //Commit video 26
    private double overTotalPrice = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        recyclerView = findViewById(R.id.cartList);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        nextProcessBtn =(Button) findViewById(R.id.nextBtn);
        txtTotalPrice =(TextView) findViewById(R.id.totalPriceView);

        // Check Changes
        //txtTotalPrice.setText(Double.toString(overTotalPrice));

        nextProcessBtn.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                txtTotalPrice.setText("Total Price =  LKR" + String.valueOf( overTotalPrice ));
                //You should be changed
                Intent intent = new Intent(CartActivity.this ,HomeActivity.class);
                intent.putExtra( "Total Price " , String.valueOf( overTotalPrice ) );
                startActivity( intent );
                finish();

            }
        } );

    }


}