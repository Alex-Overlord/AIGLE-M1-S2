package com.example.persistance;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileInputStream;

public class Exo3 extends AppCompatActivity {

    private EditText a3_et_lastName;
    private EditText a3_et_firstName;
    private EditText a3_et_age;
    private EditText a3_et_phone;
    private EditText a3_et_password;
    private TextView a3_tv_id;
    private TextView a3_tv_counter;

    private final static String LAST_NAME = "LAST_NAME";
    private final static String FIRST_NAME = "FIRST_NAME";
    private final static String AGE = "AGE";
    private final static String PHONE = "PHONE";
    private final static String ID = "ID";

    private static int id = 0;
    private final String TAG = this.getClass().getSimpleName();
    Utilisation utilisation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.exo3);

        a3_et_lastName = findViewById(R.id.a3_et_lastName);
        a3_et_firstName = findViewById(R.id.a3_et_firstName);
        a3_et_age = findViewById(R.id.a3_et_age);
        a3_et_phone = findViewById(R.id.a3_et_phone);
        a3_et_password = findViewById(R.id.a3_et_password);
        a3_tv_id = findViewById(R.id.a3_tv_id);
        a3_tv_counter = findViewById(R.id.a3_tv_counter);

        // Récupération des données
        if (savedInstanceState != null) {
            if (savedInstanceState.containsKey(LAST_NAME)) {
                a3_et_lastName.setText(savedInstanceState.getString(LAST_NAME));
            }
            if (savedInstanceState.containsKey(FIRST_NAME)) {
                a3_et_firstName.setText(savedInstanceState.getString(FIRST_NAME));
            }
            if (savedInstanceState.containsKey(AGE)) {
                a3_et_age.setText(savedInstanceState.getString(AGE));
            }
            if (savedInstanceState.containsKey(PHONE)) {
                a3_et_phone.setText(savedInstanceState.getString(PHONE));
            }
            if (savedInstanceState.containsKey(ID)) {
                id = Integer.parseInt(savedInstanceState.get(ID).toString());
            }
        }
        utilisation = new Utilisation();
        getLifecycle().addObserver(utilisation);
        a3_tv_counter.setText(a3_tv_counter.getText().toString().concat(String.valueOf(utilisation.getCounter())));
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putString(LAST_NAME, a3_et_lastName.getText().toString());
        savedInstanceState.putString(FIRST_NAME, a3_et_firstName.getText().toString());
        savedInstanceState.putString(AGE, a3_et_age.getText().toString());
        savedInstanceState.putString(PHONE, a3_et_phone.getText().toString());
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