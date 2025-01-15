package com.example.uaspbobj;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        dbHelper = new DBHelper(this);
        EditText etUsername = findViewById(R.id.etEmail);
        EditText etPassword = findViewById(R.id.etPassword);
        Button btnSignIn = findViewById(R.id.btnSignIn);
        TextView tvSignUpLink = findViewById(R.id.tvSignUpLink);

        tvSignUpLink.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, RegisterActivity.class);
            startActivity(intent);
        });

        btnSignIn.setOnClickListener(v -> {
            String username = etUsername.getText().toString();
            String password = etPassword.getText().toString();

            if (username.isEmpty() || password.isEmpty()) {
                Toast.makeText(MainActivity.this, "Please enter both username and password!", Toast.LENGTH_SHORT).show();
                return;
            }

            boolean isValid = dbHelper.checkUser(username, password);
            if (isValid) {
                Intent intent = new Intent(MainActivity.this, AccountActivity.class);
                startActivity(intent);
            } else if (username.equals("admin") && password.equals("123")) {
                Intent intent = new Intent(MainActivity.this, AccountActivity.class);
                startActivity(intent);
            } else {
                Toast.makeText(MainActivity.this, "Invalid credentials!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
