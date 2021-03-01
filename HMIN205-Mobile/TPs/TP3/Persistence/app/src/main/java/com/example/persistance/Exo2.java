package com.example.persistance;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Exo2 extends AppCompatActivity {

    private EditText a1_et_lastName;
    private EditText a1_et_firstName;
    private EditText a1_et_age;
    private EditText a1_et_phone;
    private EditText a1_et_password;
    private Button a1_btn_validate;
    private Button a1_btn_submit;

    private final static String LAST_NAME = "LAST_NAME";
    private final static String FIRST_NAME = "FIRST_NAME";
    private final static String AGE = "AGE";
    private final static String PHONE = "PHONE";
    private final static String ID = "ID";

    private static int id = 0;
    String FILENAME = "save";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.exo2);

        a1_et_lastName = findViewById(R.id.a1_et_lastName);
        a1_et_firstName = findViewById(R.id.a1_et_firstName);
        a1_et_age = findViewById(R.id.a1_et_age);
        a1_et_phone = findViewById(R.id.a1_et_phone);
        a1_et_password = findViewById(R.id.a1_et_password);
        a1_btn_validate = findViewById(R.id.a1_btn_validate);
        a1_btn_submit = findViewById(R.id.a1_btn_submit);

        if (savedInstanceState != null) {
            if (savedInstanceState.containsKey(LAST_NAME)) {
                a1_et_lastName.setText(savedInstanceState.getString(LAST_NAME));
            }
            if (savedInstanceState.containsKey(FIRST_NAME)) {
                a1_et_firstName.setText(savedInstanceState.getString(FIRST_NAME));
            }
            if (savedInstanceState.containsKey(AGE)) {
                a1_et_age.setText(savedInstanceState.getString(AGE));
            }
            if (savedInstanceState.containsKey(PHONE)) {
                a1_et_phone.setText(savedInstanceState.getString(PHONE));
            }
            if (savedInstanceState.containsKey(ID)) {
                id = Integer.parseInt(savedInstanceState.get(ID).toString());
            }
        }

        a1_btn_validate.setOnClickListener(v -> {
            if (TextUtils.isEmpty(a1_et_lastName.getText())
                    || TextUtils.isEmpty(a1_et_firstName.getText())
                    || TextUtils.isEmpty(a1_et_age.getText())
                    || TextUtils.isEmpty(a1_et_phone.getText())
                    || TextUtils.isEmpty(a1_et_password.getText())) {
                Toast.makeText(this, "Missing field, user unregistered.", Toast.LENGTH_SHORT).show();
            } else {
                id = 1 + (int) (Math.random() * ((100000 - 1) + 1));
                Toast.makeText(this, "User registered : " + id, Toast.LENGTH_SHORT).show();
            }
        });

//        FileOutputStream fos;
//        try {
//            fos = openFileOutput(FILENAME, Context.MODE_PRIVATE);
//            fos.write(a1_et_lastName.getText().toString().getBytes());
//            fos.close();
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putString(LAST_NAME, a1_et_lastName.getText().toString());
        savedInstanceState.putString(FIRST_NAME, a1_et_firstName.getText().toString());
        savedInstanceState.putString(AGE, a1_et_age.getText().toString());
        savedInstanceState.putString(PHONE, a1_et_phone.getText().toString());
        if (id != 0) {
            savedInstanceState.putString(ID, String.valueOf(id));
        }
        Toast.makeText(this, "Etat de l'activité sauvegardé", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Toast.makeText(this, "Etat de l'activité restauré", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "L'activité est détruite", Toast.LENGTH_SHORT).show();
    }
}