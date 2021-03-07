package com.example.persistance;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.text.MessageFormat;

import static java.lang.Math.random;

public class PlanningExo5 extends AppCompatActivity {

    TextView pla5_tv_1;
    TextView pla5_tv_2;
    TextView pla5_tv_3;
    TextView pla5_tv_4;
    Button pla5_btn_file_data;
    private final String TAG = this.getClass().getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_planning_exo5);

        pla5_tv_1 = findViewById(R.id.pla5_tv_1);
        pla5_tv_2 = findViewById(R.id.pla5_tv_2);
        pla5_tv_3 = findViewById(R.id.pla5_tv_3);
        pla5_tv_4 = findViewById(R.id.pla5_tv_4);
        pla5_btn_file_data = findViewById(R.id.pla5_btn_file_data);

        final Observer<String[]> observer = slots -> {
            pla5_tv_1.setText(MessageFormat.format("{0}{1}", R.string.pla5_tv_1, slots[0]));
            pla5_tv_2.setText(MessageFormat.format("{0}{1}", R.string.pla5_tv_2, slots[1]));
            pla5_tv_3.setText(MessageFormat.format("{0}{1}", R.string.pla5_tv_3, slots[2]));
            pla5_tv_4.setText(MessageFormat.format("{0}{1}", R.string.pla5_tv_4, slots[3]));
        };

        PlanningModelExo5 model = ViewModelProviders.of(this).get(PlanningModelExo5.class);
        model.getSlots().observe(this, observer);

        pla5_btn_file_data.setOnClickListener(v -> {
            try {
                FileOutputStream fos = openFileOutput("planning", Context.MODE_PRIVATE);
                fos.write("Rencontre client Dupont (".concat(String.valueOf(random()).concat(")\n")).getBytes());
                fos.write("Travailler le dossier recrutement (".concat(String.valueOf(random()).concat(")\n")).getBytes());
                fos.write("Réunion équipe (".concat(String.valueOf(random()).concat(")\n")).getBytes());
                fos.write("Préparation dossier vente (".concat(String.valueOf(random()).concat(")\n")).getBytes());
                fos.close();

                FileInputStream fis = openFileInput("planning");
                StringBuilder content = new StringBuilder();
                byte[] buffer = new byte[1024];
                int n = 0;

                while ((n = fis.read(buffer)) != -1)
                    content.append(new String(buffer, 0, n));

                String[] slots = content.toString().split("\n");
                model.getSlots().setValue(slots);
                Log.i(TAG, "Slots mis à jour");
                Toast.makeText(this, "Slots mis à jour", Toast.LENGTH_SHORT).show();
            } catch (Exception ignored) {
            }
        });
    }
}