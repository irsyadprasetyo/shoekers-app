package com.example.uaspbobj;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class AccountActivity extends AppCompatActivity {

    private TextView tvWelcomeUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);
        NavbarHelper.setupNavbar(this);

        tvWelcomeUser = findViewById(R.id.tvWelcomeUser);
        SharedPreferences preferences = getSharedPreferences("UserPrefs", MODE_PRIVATE);
        String fullName = preferences.getString("fullName", "Admin");

        tvWelcomeUser.setText("Welcome, " + fullName + "!");

        // Button functionality
        Button btnEditProfile = findViewById(R.id.btnEditProfile);
        Button btnOrderHistory = findViewById(R.id.btnOrderHistory);
        Button btnSignOut = findViewById(R.id.btnSignOut);

        btnOrderHistory.setOnClickListener(v -> {
            Intent intent = new Intent(AccountActivity.this, OrderHistoryActivity.class);
            startActivity(intent);
        });

        btnSignOut.setOnClickListener(v -> {
            Intent intent = new Intent(AccountActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        });

        // Navbar functionality
        ImageView ivHome = findViewById(R.id.ivHome);
        ImageView ivCart = findViewById(R.id.ivCart);

        ivHome.setOnClickListener(v -> {
            Intent intent = new Intent(AccountActivity.this, HomeActivity.class);
            startActivity(intent);
        });

        ivCart.setOnClickListener(v -> {
//            Intent intent = new Intent(AccountActivity.this, CartActivity.class);
//            startActivity(intent);
        });
    }
}