package com.example.tp1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import static com.example.tp1.MainActivity.EXTRA_AGE;
import static com.example.tp1.MainActivity.EXTRA_DOMAIN;
import static com.example.tp1.MainActivity.EXTRA_FIRST_NAME;
import static com.example.tp1.MainActivity.EXTRA_LAST_NAME;
import static com.example.tp1.MainActivity.EXTRA_PHONE;

public class Activity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        TextView a2_tv_firstName = findViewById(R.id.a2_tv_firstName);
        TextView a2_tv_lastName = findViewById(R.id.a2_tv_lastName);
        TextView a2_tv_age = findViewById(R.id.a2_tv_age);
        TextView a2_tv_domain = findViewById(R.id.a2_tv_domain);
        TextView a2_tv_phone = findViewById(R.id.a2_tv_phone);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        String string_firstName = (String) bundle.get(EXTRA_FIRST_NAME);
        String string_lastName = (String) bundle.get(EXTRA_LAST_NAME);
        String string_age = (String) bundle.get(EXTRA_AGE);
        String string_domain = (String) bundle.get(EXTRA_DOMAIN);
        String string_phone = (String) bundle.get(EXTRA_PHONE);

        a2_tv_firstName.setText(string_firstName);
        a2_tv_lastName.setText(string_lastName);
        a2_tv_age.setText(string_age);
        a2_tv_domain.setText(string_domain);
        a2_tv_phone.setText(string_phone);

        Button a2_btn_ok = findViewById(R.id.a2_btn_ok);
        a2_btn_ok.setOnClickListener(v -> {
            Intent intentA3 = new Intent(Activity2.this, Activity3.class);
            intentA3.putExtra(EXTRA_PHONE, string_phone);
            startActivity(intentA3);
        });

        Button a2_btn_back = findViewById(R.id.a2_btn_back);
        a2_btn_back.setOnClickListener(v -> {
            Intent intentA1 = new Intent(Activity2.this, MainActivity.class);
            startActivity(intentA1);
        });
    }
}