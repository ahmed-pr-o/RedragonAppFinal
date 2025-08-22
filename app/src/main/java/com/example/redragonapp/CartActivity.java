package com.example.redragonapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class CartActivity extends AppCompatActivity {

    ArrayList<Product> cartItems;
    CartAdapter adapter;
    TextView totalPrice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        cartItems = new ArrayList<>();
        cartItems.add(new Product("Keyboard K617 FIZZ", R.drawable.product8, 120));
        cartItems.add(new Product("Mouse M616", R.drawable.product6, 80));
        cartItems.add(new Product("Headset H868", R.drawable.product2, 200));
        cartItems.add(new Product("Headset Headset", R.drawable.product1, 150));
        cartItems.add(new Product("Redragon M913", R.drawable.product5, 40));
        cartItems.add(new Product("Redragon M808", R.drawable.product3, 130));
        cartItems.add(new Product("Redragon K720", R.drawable.product7, 200));
        cartItems.add(new Product("Headset H520", R.drawable.product4, 70));


        ListView listView = findViewById(R.id.cartListView);
        totalPrice = findViewById(R.id.totalPrice);
        adapter = new CartAdapter(this, cartItems);
        listView.setAdapter(adapter);

        double total = 0;
        for (Product p : cartItems) total += p.getPrice();
        totalPrice.setText("total: " + total + " $");
        Button btnPay = findViewById(R.id.btnPay);
        btnPay.setOnClickListener(v -> {
            Intent intent = new Intent(CartActivity.this, PaymentActivity.class);
            startActivity(intent);

        });
    }
}
