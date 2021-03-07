package com.example.persistance;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileInputStream;

public class Exo2bis extends AppCompatActivity {

    private EditText a2bis_et_lastName;
    private EditText a2bis_et_firstName;
    private EditText a2bis_et_age;
    private EditText a2bis_et_phone;
    private EditText a2bis_et_id;

    private final static String LAST_NAME = "LAST_NAME";
    private final static String FIRST_NAME = "FIRST_NAME";
    private final static String AGE = "AGE";
    private final static String PHONE = "PHONE";
    private final static String ID = "ID";

    private static int id = 0;
    private final String TAG = this.getClass().getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.exo2bis);

        a2bis_et_lastName = findViewById(R.id.a2bis_et_lastName);
        a2bis_et_firstName = findViewById(R.id.a2bis_et_firstName);
        a2bis_et_age = findViewById(R.id.a2bis_et_age);
        a2bis_et_phone = findViewById(R.id.a2bis_et_phone);
        a2bis_et_id = findViewById(R.id.a2bis_et_id);

        Intent intent = getIntent();

        // Récupération des données
        if (savedInstanceState != null) {
            if (savedInstanceState.containsKey(LAST_NAME)) {
                a2bis_et_lastName.setText(savedInstanceState.getString(LAST_NAME));
            }
            if (savedInstanceState.containsKey(FIRST_NAME)) {
                a2bis_et_firstName.setText(savedInstanceState.getString(FIRST_NAME));
            }
            if (savedInstanceState.containsKey(AGE)) {
                a2bis_et_age.setText(savedInstanceState.getString(AGE));
            }
            if (savedInstanceState.containsKey(PHONE)) {
                a2bis_et_phone.setText(savedInstanceState.getString(PHONE));
            }
            if (savedInstanceState.containsKey(ID)) {
                id = Integer.parseInt(savedInstanceState.get(ID).toString());
            }
        }

        if(intent != null && intent.hasExtra(Exo2.F_KEY)) {
            String fileName = intent.getStringExtra(Exo2.F_KEY);
            try {
                FileInputStream file = openFileInput(fileName);
                StringBuilder content = new StringBuilder();
                byte[] buffer = new byte[1024];
                int n = 0;

                while ((n = file.read(buffer)) != -1)
                    content.append(new String(buffer, 0, n));

                String[] informations = content.toString().split("\n");
                a2bis_et_lastName.setText(informations[0]);
                a2bis_et_firstName.setText(informations[1]);
                a2bis_et_age.setText(informations[2]);
                a2bis_et_phone.setText(informations[3]);
                a2bis_et_id.setText(informations[4]);

            } catch (Exception ignored) { }
        }
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putString(LAST_NAME, a2bis_et_lastName.getText().toString());
        savedInstanceState.putString(FIRST_NAME, a2bis_et_firstName.getText().toString());
        savedInstanceState.putString(AGE, a2bis_et_age.getText().toString());
        savedInstanceState.putString(PHONE, a2bis_et_phone.getText().toString());
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