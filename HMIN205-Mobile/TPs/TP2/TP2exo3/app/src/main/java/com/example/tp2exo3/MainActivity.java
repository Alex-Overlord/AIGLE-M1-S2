package com.example.tp2exo3;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements SensorEventListener {

    SensorManager sensorManager;
    Sensor accelerometer;
    TextView tv1;
    TextView tv2;
    TextView tv3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        accelerometer = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);

        tv1 = findViewById(R.id.tv1);
        tv2 = findViewById(R.id.tv2);
        tv3 = findViewById(R.id.tv3);

        boolean supported = sensorManager.registerListener(this,
                accelerometer,
                SensorManager.SENSOR_DELAY_UI);

        if (!supported) {
            sensorManager.unregisterListener(this, accelerometer);
            tv1.setText(R.string.accelerator_unavailable);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        sensorManager.registerListener(this,
                accelerometer,
                SensorManager.SENSOR_DELAY_UI);
    }

    @Override
    protected void onPause() {
        super.onPause();
        sensorManager.unregisterListener(this);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        if (event.sensor.getType() == Sensor.TYPE_ACCELEROMETER) {
            onAccelerometerChanged(event);
        }
    }

    @SuppressLint("SetTextI18n")
    private void onAccelerometerChanged(SensorEvent event) {
        int red = Color.rgb(255,0,0);
        int green = Color.rgb(0,255,0);
        int black = Color.rgb(0,0,0);

        float x = event.values[0];
        float y = event.values[1];
        float z = event.values[2];

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
        switch (accuracy) {
            case SensorManager.SENSOR_STATUS_ACCURACY_LOW:
            case SensorManager.SENSOR_STATUS_ACCURACY_MEDIUM:
            case SensorManager.SENSOR_STATUS_ACCURACY_HIGH:
            case SensorManager.SENSOR_STATUS_UNRELIABLE:
        }
        Log.d("Sensor", sensor.getType() + ":" + accuracy);
    }
}