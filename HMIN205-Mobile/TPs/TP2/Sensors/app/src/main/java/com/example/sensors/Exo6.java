package com.example.sensors;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;

public class Exo6 extends AppCompatActivity implements SensorEventListener {

    SensorManager sensorManager;
    Sensor proximity;
    TextView tv0;
    TextView tv1;
    TextView tv2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exo6);

        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        proximity = sensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY);

        tv0 = findViewById(R.id.a6_tv0);
        tv1 = findViewById(R.id.a6_tv1);
        tv2 = findViewById(R.id.a6_tv2);

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
        if (event.sensor.getType() == Sensor.TYPE_PROXIMITY) {
            onProximityChanged(event);
        }
    }

    @SuppressLint("SetTextI18n")
    private void onProximityChanged(SensorEvent event) {

        if (event.values[0] < proximity.getMaximumRange()) {
            tv2.setText("NEAR");
            getWindow().getDecorView().setBackgroundColor(Color.RED);
        } else {
            tv2.setText("FAR");
            getWindow().getDecorView().setBackgroundColor(Color.GREEN);
        }

        tv1.setText(event.values[0] + " cm");
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {}

    @Override
    protected void onPause() {
        super.onPause();
        sensorManager.unregisterListener(this);
    }
}