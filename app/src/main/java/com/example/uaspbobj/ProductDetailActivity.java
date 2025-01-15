package com.example.uaspbobj;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class ProductDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_detail);

        ImageView productImage = findViewById(R.id.productDetailImage);
        TextView productName = findViewById(R.id.productDetailName);
        TextView productPrice = findViewById(R.id.productDetailPrice);
        TextView productDescription = findViewById(R.id.productDetailDescription);

        productName.setText(getIntent().getStringExtra("productName"));
        productPrice.setText(getIntent().getStringExtra("productPrice"));
        productImage.setImageResource(getIntent().getIntExtra("productImage", 0));
        productDescription.setText(getIntent().getStringExtra("productDescription"));
    }
}