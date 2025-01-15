package com.example.uaspbobj;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Patterns;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class RegisterActivity extends AppCompatActivity {
    private DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        dbHelper = new DBHelper(this);
        TextView tvSignInLink = findViewById(R.id.tvSignInLink);
        Button btnSignUp = findViewById(R.id.btnSignUp);
        EditText etEmail = findViewById(R.id.etEmail);
        EditText etPassword = findViewById(R.id.etPasswordRegister);
        EditText etFullName = findViewById(R.id.etName);

        tvSignInLink.setOnClickListener(v -> {
            Intent intent = new Intent(RegisterActivity.this, MainActivity.class);
            startActivity(intent);
        });

        btnSignUp.setOnClickListener(v -> {
            String email = etEmail.getText().toString();
            String password = etPassword.getText().toString();
            String fullName = etFullName.getText().toString();

            if (email.isEmpty() || password.isEmpty() || fullName.isEmpty()) {
                Toast.makeText(RegisterActivity.this, "Please fill all fields!",
                        Toast.LENGTH_SHORT).show();
                return;
            } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                Toast.makeText(RegisterActivity.this, "Please fill correct email! (e.g. test@mail.com)", Toast.LENGTH_LONG).show();
                return;
            } else if (password.length() < 6) {
                Toast.makeText(RegisterActivity.this, "Please input password 6 characters or more!",
                        Toast.LENGTH_LONG).show();
                return;
            }

            // Check if the email is already registered
            if (dbHelper.isEmailRegistered(email)) {
                Toast.makeText(RegisterActivity.this, "Email is already registered!", Toast.LENGTH_SHORT).show();
                return;
            }

            // Proceed with registration
            boolean isInserted = dbHelper.addUser(email, password);
            if (isInserted) {
                // Save the full name to SharedPreferences
                SharedPreferences preferences = getSharedPreferences("UserPrefs", MODE_PRIVATE);
                SharedPreferences.Editor editor = preferences.edit();
                editor.putString("fullName", fullName);
                editor.apply();

                Toast.makeText(RegisterActivity.this, "Registration successful!",
                        Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(RegisterActivity.this, MainActivity.class);
                startActivity(intent);
            } else {
                Toast.makeText(RegisterActivity.this, "Registration failed. Try again!",
                        Toast.LENGTH_SHORT).show();
            }
        });
    }
}

