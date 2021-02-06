package com.example.tp2exo2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    private SensorManager sensorManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        Sensor defaultProximitySensor = sensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY);

        Log.v("SensorActivity", "defaultProximitySensor = " + defaultProximitySensor.getName());
    }
}