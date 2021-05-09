package com.mad2021june.dianacosmetics.ViewHolder;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.mad2021june.dianacosmetics.Interface.ItemClickListner;
import com.mad2021june.dianacosmetics.R;


public class CartViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    public TextView txtProductName , txtProductPrice, txtProductQty;

    private ItemClickListner itemClickListener;

    public CartViewHolder(View itemView) {
        super(itemView);

        txtProductName = itemView.findViewById( R.id.cart_product_name);
        txtProductPrice = itemView.findViewById(R.id.cart_product_price);
        txtProductQty = itemView.findViewById(R.id.cart_product_qty);



    }

    @Override
    public void onClick(View v) {

        itemClickListener.onClick(v , getAdapterPosition() , false);

    }

    public void setItemClickListener(ItemClickListner itemClickListener) {
        this.itemClickListener = itemClickListener;
    }
}
