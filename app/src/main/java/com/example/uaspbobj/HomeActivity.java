package com.example.uaspbobj;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);
        NavbarHelper.setupNavbar(this);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));

        List<Product> productList = new ArrayList<>();
        productList.add(new Product("Regatta Clydebank", "Rp. 2.000.000", R.drawable.prd_regatta, "A premium shoe designed for comfort and style."));
        productList.add(new Product("Adidas Duramo", "Rp. 1.599.999", R.drawable.prd_adidas, "A lightweight and durable running shoe."));
        productList.add(new Product("Nike RN Ruins", "Rp. 2.999.999", R.drawable.prd_nike_rn, "High-performance footwear for active lifestyles."));
        // productList.add(new Product("Nike Air Presto", "Rp. 3.500.000", R.drawable.nike_presto, "The ultimate combination of style and comfort."));

        ProductAdapter adapter = new ProductAdapter(productList, product -> {
            Intent intent = new Intent(HomeActivity.this, ProductDetailActivity.class);
            intent.putExtra("productName", product.getName());
            intent.putExtra("productPrice", product.getPrice());
            intent.putExtra("productImage", product.getImageResId());
            intent.putExtra("productDescription", product.getDescription());
            startActivity(intent);
        });
        recyclerView.setAdapter(adapter);

        ImageView ivCart = findViewById(R.id.ivCart);
        ImageView ivAccount = findViewById(R.id.ivAccount);

        ivCart.setOnClickListener(v -> {
            Intent intent = new Intent(HomeActivity.this, CartActivity.class);
            startActivity(intent);
        });
        ivAccount.setOnClickListener(v -> {
           Intent intent = new Intent(HomeActivity.this, AccountActivity.class);
            startActivity(intent);
        });
    }
}