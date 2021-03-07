package com.example.persistance;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.widget.TextView;

public class Planning extends AppCompatActivity {

    TextView pla_tv_1;
    TextView pla_tv_2;
    TextView pla_tv_3;
    TextView pla_tv_4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_planning);

        pla_tv_1 = findViewById(R.id.pla_tv_1);
        pla_tv_2 = findViewById(R.id.pla_tv_2);
        pla_tv_3 = findViewById(R.id.pla_tv_3);
        pla_tv_4 = findViewById(R.id.pla_tv_4);

        PlanningModel model = ViewModelProviders.of(this).get(PlanningModel.class);
        String[] creneaux = model.getCreneaux();

        pla_tv_1.append(creneaux[0]);
        pla_tv_2.append(creneaux[1]);
        pla_tv_3.append(creneaux[2]);
        pla_tv_4.append(creneaux[3]);
    }
}