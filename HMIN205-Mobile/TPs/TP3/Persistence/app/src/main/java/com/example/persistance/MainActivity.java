package com.example.persistance;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn1 = findViewById(R.id.a0_btn1);
        Button btn2 = findViewById(R.id.a0_btn2);
        Button btn3 = findViewById(R.id.a0_btn3);
        Button btn4 = findViewById(R.id.a0_btn4);
        Button btn5 = findViewById(R.id.a0_btn5);
        Button btn6 = findViewById(R.id.a0_btn6);

        btn1.setOnClickListener(v -> openExo1());
        btn2.setOnClickListener(v -> openExo2());
        btn3.setOnClickListener(v -> openExo3());
        btn4.setOnClickListener(v -> openExo4());
        btn5.setOnClickListener(v -> openExo5());
        btn6.setOnClickListener(v -> openExo6());
    }

    private void openExo1() {
        Intent intent = new Intent(MainActivity.this, Exo1.class);
        startActivity(intent);
    }
    private void openExo2() {
        Intent intent = new Intent(MainActivity.this, Exo2.class);
        startActivity(intent);
    }
    private void openExo3() {
        Intent intent = new Intent(MainActivity.this, Exo3.class);
        startActivity(intent);
    }
    private void openExo4() {
        Intent intent = new Intent(MainActivity.this, Exo4.class);
        startActivity(intent);
    }
    private void openExo5() {
        Intent intent = new Intent(MainActivity.this, Exo5.class);
        startActivity(intent);
    }
    private void openExo6() {
        Intent intent = new Intent(MainActivity.this, Exo6.class);
        startActivity(intent);
    }
}