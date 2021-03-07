package com.example.persistance;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Exo4 extends AppCompatActivity {

    private EditText a4_et_lastName;
    private EditText a4_et_firstName;
    private EditText a4_et_age;
    private EditText a4_et_phone;
    private EditText a4_et_password;

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
        setContentView(R.layout.exo4);

        a4_et_lastName = findViewById(R.id.a4_et_lastName);
        a4_et_firstName = findViewById(R.id.a4_et_firstName);
        a4_et_age = findViewById(R.id.a4_et_age);
        a4_et_phone = findViewById(R.id.a4_et_phone);
        a4_et_password = findViewById(R.id.a4_et_password);
        Button a4_btn_validate = findViewById(R.id.a4_btn_validate);
        Button a4_btn_planning = findViewById(R.id.a4_btn_planning);

        // Récupération des données
        if (savedInstanceState != null) {
            if (savedInstanceState.containsKey(LAST_NAME)) {
                a4_et_lastName.setText(savedInstanceState.getString(LAST_NAME));
            }
            if (savedInstanceState.containsKey(FIRST_NAME)) {
                a4_et_firstName.setText(savedInstanceState.getString(FIRST_NAME));
            }
            if (savedInstanceState.containsKey(AGE)) {
                a4_et_age.setText(savedInstanceState.getString(AGE));
            }
            if (savedInstanceState.containsKey(PHONE)) {
                a4_et_phone.setText(savedInstanceState.getString(PHONE));
            }
            if (savedInstanceState.containsKey(ID)) {
                id = Integer.parseInt(savedInstanceState.get(ID).toString());
            }
        }

        // Vérification des champs
        a4_btn_validate.setOnClickListener(v -> {
            if (fieldEmpty()) {
                Toast.makeText(this, "Missing field, user unregistered.", Toast.LENGTH_SHORT).show();
            } else if (id == 0) {
                id = generateID();
                Toast.makeText(this, "User registered : " + id, Toast.LENGTH_SHORT).show();
            }
        });

        // Sauvegarde des données dans un fichier
        a4_btn_planning.setOnClickListener(v -> {
            if (fieldEmpty()) {
                Toast.makeText(this, "Missing field, user unregistered.", Toast.LENGTH_SHORT).show();
            } else {
                if (id == 0) {
                    id = generateID();
                    Toast.makeText(this, "User registered : " + id, Toast.LENGTH_SHORT).show();
                }
                fileName = a4_et_lastName.getText().toString() + id;

                try {
                    FileOutputStream fos;
                    fos = openFileOutput(fileName, Context.MODE_PRIVATE);
                    fos.write(a4_et_lastName.getText().toString().concat("\n").getBytes());
                    fos.write(a4_et_firstName.getText().toString().concat("\n").getBytes());
                    fos.write(a4_et_age.getText().toString().concat("\n").getBytes());
                    fos.write(a4_et_phone.getText().toString().concat("\n").getBytes());
                    fos.write(String.valueOf(id).getBytes());
                    Log.i(TAG, "Ecriture du fichier " + fileName);
                    fos.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                Intent intent = new Intent(Exo4.this, Planning.class);
                intent.putExtra(F_KEY, fileName);
                startActivity(intent);
            }
        });
    }

    public boolean fieldEmpty() {
        return TextUtils.isEmpty(a4_et_lastName.getText())
                || TextUtils.isEmpty(a4_et_firstName.getText())
                || TextUtils.isEmpty(a4_et_age.getText())
                || TextUtils.isEmpty(a4_et_phone.getText())
                || TextUtils.isEmpty(a4_et_password.getText());
    }

    public int generateID() {
        return 1 + (int) (Math.random() * ((100000 - 1) + 1));
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putString(LAST_NAME, a4_et_lastName.getText().toString());
        savedInstanceState.putString(FIRST_NAME, a4_et_firstName.getText().toString());
        savedInstanceState.putString(AGE, a4_et_age.getText().toString());
        savedInstanceState.putString(PHONE, a4_et_phone.getText().toString());
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