package com.example.persistance;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Exo5 extends AppCompatActivity {

    private EditText a5_et_lastName;
    private EditText a5_et_firstName;
    private EditText a5_et_age;
    private EditText a5_et_phone;
    private EditText a5_et_password;

    public final static String LAST_NAME = "LAST_NAME";
    public final static String FIRST_NAME = "FIRST_NAME";
    public final static String AGE = "AGE";
    public final static String PHONE = "PHONE";
    public final static String ID = "ID";
    public final static String F_KEY = "F_KEY";

    private static int id = 0;
    private final String TAG = this.getClass().getSimpleName();
    String fileName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.exo5);

        a5_et_lastName = findViewById(R.id.a5_et_lastName);
        a5_et_firstName = findViewById(R.id.a5_et_firstName);
        a5_et_age = findViewById(R.id.a5_et_age);
        a5_et_phone = findViewById(R.id.a5_et_phone);
        a5_et_password = findViewById(R.id.a5_et_password);
        Button a5_btn_validate = findViewById(R.id.a5_btn_validate);
        Button a5_btn_planning = findViewById(R.id.a5_btn_planning);

        // Récupération des données
        if (savedInstanceState != null) {
            if (savedInstanceState.containsKey(LAST_NAME)) {
                a5_et_lastName.setText(savedInstanceState.getString(LAST_NAME));
            }
            if (savedInstanceState.containsKey(FIRST_NAME)) {
                a5_et_firstName.setText(savedInstanceState.getString(FIRST_NAME));
            }
            if (savedInstanceState.containsKey(AGE)) {
                a5_et_age.setText(savedInstanceState.getString(AGE));
            }
            if (savedInstanceState.containsKey(PHONE)) {
                a5_et_phone.setText(savedInstanceState.getString(PHONE));
            }
            if (savedInstanceState.containsKey(ID)) {
                id = Integer.parseInt(savedInstanceState.get(ID).toString());
            }
        }

        // Vérification des champs
        a5_btn_validate.setOnClickListener(v -> {
            if (fieldEmpty()) {
                Toast.makeText(this, "Missing field, user unregistered.", Toast.LENGTH_SHORT).show();
            } else if (id == 0) {
                id = generateID();
                Toast.makeText(this, "User registered : " + id, Toast.LENGTH_SHORT).show();
            }
        });

        // Sauvegarde des données dans un fichier
        a5_btn_planning.setOnClickListener(v -> {
            if (fieldEmpty()) {
                Toast.makeText(this, "Missing field, user unregistered.", Toast.LENGTH_SHORT).show();
            } else {
                if (id == 0) {
                    id = generateID();
                    Toast.makeText(this, "User registered : " + id, Toast.LENGTH_SHORT).show();
                }
                fileName = a5_et_lastName.getText().toString() + id;

                Intent intent = new Intent(Exo5.this, PlanningExo5.class);
                intent.putExtra(F_KEY, fileName);
                startActivity(intent);
            }
        });
    }

    public boolean fieldEmpty() {
        return TextUtils.isEmpty(a5_et_lastName.getText())
                || TextUtils.isEmpty(a5_et_firstName.getText())
                || TextUtils.isEmpty(a5_et_age.getText())
                || TextUtils.isEmpty(a5_et_phone.getText())
                || TextUtils.isEmpty(a5_et_password.getText());
    }

    public int generateID() {
        return 1 + (int) (Math.random() * ((100000 - 1) + 1));
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putString(LAST_NAME, a5_et_lastName.getText().toString());
        savedInstanceState.putString(FIRST_NAME, a5_et_firstName.getText().toString());
        savedInstanceState.putString(AGE, a5_et_age.getText().toString());
        savedInstanceState.putString(PHONE, a5_et_phone.getText().toString());
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