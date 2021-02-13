package com.example.tp2exo6;

import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.PackageManager;
import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraManager;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements SensorEventListener {

    SensorManager sensorManager;
    Sensor proximity;
    TextView tv0;
    TextView tv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        proximity = sensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY);

        tv0 = findViewById(R.id.tv0);
        tv1 = findViewById(R.id.tv1);

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

    private void onProximityChanged(SensorEvent event) {

        if (event.values[0] < proximity.getMaximumRange()) {
            getWindow().getDecorView().setBackgroundColor(Color.RED);
        } else {
            getWindow().getDecorView().setBackgroundColor(Color.GREEN);
        }

        tv1.setText(event.values[0] + " cm");
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}