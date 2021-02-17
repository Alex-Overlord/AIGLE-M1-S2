package com.example.sensors;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;

public class Exo2 extends AppCompatActivity {

    SensorManager sensorManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exo2);

        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        TextView tv2 = findViewById(R.id.a2_tv2);

        if (sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER) == null) {
            tv2.append("ACCELEROMETER unavailable" + "\t\n");
        }
        if (sensorManager.getDefaultSensor(Sensor.TYPE_AMBIENT_TEMPERATURE) == null) {
            tv2.append("AMBIENT_TEMPERATURE unavailable" + "\t\n");
        }
        if (sensorManager.getDefaultSensor(Sensor.TYPE_GRAVITY) == null) {
            tv2.append("GRAVITY unavailable" + "\t\n");
        }
        if (sensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE) == null) {
            tv2.append("GYROSCOPE unavailable" + "\t\n");
        }
        if (sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT) == null) {
            tv2.append("LIGHT unavailable" + "\t\n");
        }
        if (sensorManager.getDefaultSensor(Sensor.TYPE_LINEAR_ACCELERATION) == null) {
            tv2.append("LINEAR_ACCELERATION unavailable" + "\t\n");
        }
        if (sensorManager.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD) == null) {
            tv2.append("MAGNETIC_FIELD unavailable" + "\t\n");
        }
        if (sensorManager.getDefaultSensor(Sensor.TYPE_ORIENTATION) == null) {
            tv2.append("ORIENTATION unavailable" + "\t\n");
        }
        if (sensorManager.getDefaultSensor(Sensor.TYPE_PRESSURE) == null) {
            tv2.append("PRESSURE unavailable" + "\t\n");
        }
        if (sensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY) == null) {
            tv2.append("PROXIMITY unavailable" + "\t\n");
        }
        if (sensorManager.getDefaultSensor(Sensor.TYPE_RELATIVE_HUMIDITY) == null) {
            tv2.append("RELATIVE_HUMIDITY unavailable" + "\t\n");
        }
        if (sensorManager.getDefaultSensor(Sensor.TYPE_ROTATION_VECTOR) == null) {
            tv2.append("ROTATION_VECTOR unavailable" + "\t\n");
        }
        if (sensorManager.getDefaultSensor(Sensor.TYPE_TEMPERATURE) == null) {
            tv2.append("TEMPERATURE unavailable" + "\t\n");
        }
    }
}