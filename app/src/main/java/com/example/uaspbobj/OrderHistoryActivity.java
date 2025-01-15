package com.example.uaspbobj;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class OrderHistoryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ordhist);

        ImageView btnBack = findViewById(R.id.btnBack);

        btnBack.setOnClickListener(v -> {
            btnBack.setImageResource(R.drawable.z_icon_back_button);
            Intent intent = new Intent(OrderHistoryActivity.this, AccountActivity.class);
            startActivity(intent);
        });
    }
}
