package com.example.tp2exo6;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements SensorEventListener {

    SensorManager sensorManager;
    Sensor proximity;
    TextView tv0;
    TextView tv1;
    TextView tv2;
    TextView tv3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        proximity = sensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY);

        tv0 = findViewById(R.id.tv0);
        tv1 = findViewById(R.id.tv1);
        tv2 = findViewById(R.id.tv2);
        tv3 = findViewById(R.id.tv3);

        boolean supported = sensorManager.registerListener(this,
                proximity,
                SensorManager.SENSOR_DELAY_UI);

        if (!supported) {
            sensorManager.unregisterListener(this, proximity);
            tv0.setText(R.string.proximity_unavailable);
        }
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        if (event.sensor.getType() == Sensor.TYPE_GYROSCOPE) {
            onProximityChanged(event);
        }
    }

    private void onProximityChanged(SensorEvent event) {
        int red = Color.rgb(255, 0, 0);
        int green = Color.rgb(0, 255, 0);
        int black = Color.rgb(0, 0, 0);

        float x = event.values[0]; // vitesse angulaire autour de x
        float y = event.values[1]; // vitesse angulaire autour de y
        float z = event.values[2]; // vitesse angulaire autour de z

        tv1.setText("x = " + (int) x);
        tv2.setText("y = " + (int) y);
        tv3.setText("z = " + (int) z);

        if (x < -1) {
            tv1.setTextColor(red);
        } else if (x > 1) {
            tv1.setTextColor(green);
        } else {
            tv1.setTextColor(black);
        }

        if (y < -1) {
            tv2.setTextColor(red);
        } else if (y > 1) {
            tv2.setTextColor(green);
        } else {
            tv2.setTextColor(black);
        }

        if (z < -1) {
            tv3.setTextColor(red);
        } else if (z > 1) {
            tv3.setTextColor(green);
        } else {
            tv3.setTextColor(black);
        }

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}