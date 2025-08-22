package com.example.redragonapp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.graphics.Insets;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class home_screen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);
        ImageView cartIcon = findViewById(R.id.cartIcon);
        cartIcon.setOnClickListener(v -> {
            Intent intent = new Intent(home_screen.this, CartActivity.class);
            startActivity(intent);
        });
        GridView homeGridView = findViewById(R.id.homeGridView);

        ArrayList<Product> products = new ArrayList<>();
        products.add(new Product("Redragon H510", R.drawable.product1, 150));
        products.add(new Product("Mouse M616", R.drawable.product6, 80));
        products.add(new Product("Redragon M808", R.drawable.product3, 130));
        products.add(new Product("Redragon K720", R.drawable.product7, 200));
        products.add(new Product("Keyboard K617 FIZZ", R.drawable.product8, 120));
        products.add(new Product("Redragon M913", R.drawable.product5, 40));


        // ربط Adapter بالـ GridView
        HomeGridAdapter adapter = new HomeGridAdapter(this, products);
        homeGridView.setAdapter(adapter);

        // عند الضغط على أي منتج
        homeGridView.setOnItemClickListener((parent, view, position, id) -> {
            Product clicked = products.get(position);
            Toast.makeText(this, "اخترت: " + clicked.getName(), Toast.LENGTH_SHORT).show();
        });
        ImageButton btnSettings = findViewById(R.id.btnSettings);
        btnSettings.setOnClickListener(v -> {
            Intent intent = new Intent(home_screen.this, settings.class);
            startActivity(intent);

        });


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}