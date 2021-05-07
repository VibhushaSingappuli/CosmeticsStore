package com.mad2021june.dianacosmetics;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class AdminAddNewProductActivity extends AppCompatActivity {

    private Button AddNewProductButton;
    private EditText InputProductName,InputProductPrice,InputProductQuantity, InputProductDescription;
    private ImageView InputProductImage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_add_new_product);

        AddNewProductButton = (Button) findViewById(R.id.add_new_product);
        InputProductImage = (ImageView) findViewById(R.id.select_product_image);
        InputProductName = (EditText) findViewById(R.id.product_name);
        InputProductPrice = (EditText) findViewById(R.id.product_price);
        InputProductQuantity = (EditText) findViewById(R.id.product_quantity);
        InputProductDescription = (EditText) findViewById(R.id.product_description);

        Toast.makeText(this, "Welcome admin", Toast.LENGTH_SHORT).show();
    }
}