package com.example.tp1;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    private TextInputEditText a1_tiet_firstName;
    private TextInputEditText a1_tiet_lastName;
    private TextInputEditText a1_tiet_age;
    private TextInputEditText a1_tiet_domain;
    private TextInputEditText a1_tiet_phone;

    private String string_firstName;
    private String string_lastName;
    private String string_age;
    private String string_domain;
    private String string_phone;

    public static final String EXTRA_FIRST_NAME = "com.example.tp1.FIRST_NAME";
    public static final String EXTRA_LAST_NAME = "com.example.tp1.LAST_NAME";
    public static final String EXTRA_AGE = "com.example.tp1.AGE";
    public static final String EXTRA_DOMAIN = "com.example.tp1.DOMAIN";
    public static final String EXTRA_PHONE = "com.example.tp1.PHONE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        a1_tiet_firstName = findViewById(R.id.a1_tiet_firstName);
        a1_tiet_lastName = findViewById(R.id.a1_tiet_lastName);
        a1_tiet_age = findViewById(R.id.a1_tiet_age);
        a1_tiet_domain = findViewById(R.id.a1_tiet_domain);
        a1_tiet_phone = findViewById(R.id.a1_tiet_phone);
        Button a1_btn_submit = findViewById(R.id.a1_btn_submit);

        // à enlever à la fin
        a1_tiet_firstName.setText("Steve");
        a1_tiet_lastName.setText("Jobs");
        a1_tiet_age.setText("66");
        a1_tiet_domain.setText("Informatique");
        a1_tiet_phone.setText("0700101010");

        a1_btn_submit.setOnClickListener(v -> {
            String form_result = ""
                    + a1_tiet_firstName.getText() + " "
                    + a1_tiet_lastName.getText() + " "
                    + a1_tiet_age.getText() + " "
                    + a1_tiet_domain.getText() + " "
                    + a1_tiet_phone.getText();

            string_firstName = Objects.requireNonNull(a1_tiet_firstName.getText()).toString();
            string_lastName = Objects.requireNonNull(a1_tiet_lastName.getText()).toString();
            string_age = Objects.requireNonNull(a1_tiet_age.getText()).toString();
            string_domain = Objects.requireNonNull(a1_tiet_domain.getText()).toString();
            string_phone = Objects.requireNonNull(a1_tiet_phone.getText()).toString();

            new AlertDialog.Builder(MainActivity.this)
                    .setTitle(R.string.validate)
                    .setMessage(form_result)
                    .setPositiveButton(R.string.validate, (dialog, which) -> {
                        int green = getResources().getColor(R.color.green);
                        a1_btn_submit.setBackgroundColor(green);
                        openActivity2();
                    })
                    .setNegativeButton(R.string.cancel, (dialog, which) -> {
                        int red = getResources().getColor(R.color.red);
                        a1_btn_submit.setBackgroundColor(red);
                    })
                    .create().show();
        });
    }

    private void openActivity2() {
        Intent intentA2 = new Intent(MainActivity.this, Activity2.class);
        intentA2.putExtra(EXTRA_FIRST_NAME, string_firstName);
        intentA2.putExtra(EXTRA_LAST_NAME, string_lastName);
        intentA2.putExtra(EXTRA_AGE, string_age);
        intentA2.putExtra(EXTRA_DOMAIN, string_domain);
        intentA2.putExtra(EXTRA_PHONE, string_phone);
        startActivity(intentA2);
    }
}