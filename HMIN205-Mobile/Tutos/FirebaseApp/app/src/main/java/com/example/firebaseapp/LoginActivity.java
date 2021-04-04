package com.example.firebaseapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;

public class LoginActivity extends AppCompatActivity {

    EditText loginUsernameET, loginPassET;
    Button loginBtn, registerRedirectBtn;

    // Firebase
    FirebaseAuth auth;
    FirebaseUser firebaseUser;

    @Override
    protected void onStart() {
        super.onStart();
        firebaseUser = FirebaseAuth.getInstance().getCurrentUser();

        // Checking for users existence: Saving the current user
        if (firebaseUser != null) {
            Intent i = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(i);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        loginUsernameET = findViewById(R.id.loginUsernameET);
        loginPassET = findViewById(R.id.loginPassET);
        loginBtn = findViewById(R.id.loginBtn);
        registerRedirectBtn = findViewById(R.id.registerRedirectBtn);

        // Firebase Auth
        auth = FirebaseAuth.getInstance();

        // Register Button
        registerRedirectBtn.setOnClickListener(v -> {
            Intent i = new Intent(LoginActivity.this, RegisterActivity.class);
            startActivity(i);
            finish();
        });

        // Login Button
        loginBtn.setOnClickListener(v -> {
            String email_text = loginUsernameET.getText().toString();
            String pass_text = loginPassET.getText().toString();

            // Checking if it is empty
            if (TextUtils.isEmpty(email_text) || TextUtils.isEmpty(pass_text)) {
                Toast.makeText(LoginActivity.this, "Please Fill All Fields", Toast.LENGTH_SHORT).show();
            } else {
                auth.signInWithEmailAndPassword(email_text, pass_text)
                    . addOnCompleteListener(task -> {
                        if (task.isSuccessful()) {
                            Intent i = new Intent(LoginActivity.this, MainActivity.class);
                            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                            startActivity(i);
                            finish();
                        } else {
                            Toast.makeText(LoginActivity.this, "Login Failed!", Toast.LENGTH_SHORT).show();
                        }
                    });
            }
        });
    }

}