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

    @Override
    protected void onStart() {

        super.onStart();

        final DatabaseReference cartListRef = FirebaseDatabase.getInstance().getReference().child("Cart List");

        FirebaseRecyclerOptions<Cart> options = new FirebaseRecyclerOptions.Builder<Cart>()
                .setQuery(cartListRef.child("User View")
                        .child( Prevalent.currentOnlineUser.getPhone()).child("Products"), Cart.class)
                .build();

        FirebaseRecyclerAdapter<Cart, CartViewHolder> adapter = new FirebaseRecyclerAdapter<Cart, CartViewHolder>(options) {
            @Override
            protected void onBindViewHolder(@NonNull CartViewHolder holder, int i, @NonNull Cart cart) {
                holder.txtProductQty.setText("Quantity = "+cart.getQuantity());
                holder.txtProductPrice.setText("Price "+ cart.getPrice() + "LKR");
                holder.txtProductName.setText(cart.getPname());

                //Commit Video 26
                double oneTypeProductPrice = ((Double.valueOf( cart.getPrice() ))) * Double .valueOf( cart.getQuantity() );
                overTotalPrice = overTotalPrice + oneTypeProductPrice;


                //Edit Delete Commit
                holder.itemView.setOnClickListener( new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        CharSequence options[] = new CharSequence[]{
                                "Edit",
                                "Delete"

                        };

                        AlertDialog.Builder builder = new AlertDialog.Builder( CartActivity.this);
                        builder.setTitle( "Cart Options: " );

                        builder.setItems( options, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                                if(which == 0){
                                    Intent intent = new Intent(CartActivity.this,ProductDetailsActivity.class);
                                    intent.putExtra( "pid",cart.getPid() );
                                    startActivity( intent );
                                }

                                if(which == 1){
                                    cartListRef.child( "User View" )
                                            .child( Prevalent.currentOnlineUser.getPhone() )
                                            .child( "Products" )
                                            .child( cart.getPid() )
                                            .removeValue()
                                            .addOnCompleteListener( new OnCompleteListener<Void>() {
                                                @Override
                                                public void onComplete(@NonNull Task<Void> task) {
                                                    if(task.isSuccessful()){
                                                        Toast.makeText( CartActivity.this,"Item removed successfully",Toast.LENGTH_SHORT).show();

                                                        Intent intent = new Intent(CartActivity.this,HomeActivity.class);
                                                        startActivity( intent );
                                                    }

                                                }
                                            } );

                                }

                            }
                        } );
                        builder.show();
                    }
                } );

            }

