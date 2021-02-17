package com.example.tp2exo5;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraManager;
import android.os.Build;
import android.os.Bundle;
import android.widget.TextView;

@RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
public class MainActivity extends AppCompatActivity implements SensorEventListener {

    SensorManager sensorManager;
    CameraManager cameraManager;
    Sensor gyroscope;
    TextView tv0;
    TextView tv1;
    TextView tv2;
    TextView tv3;
    TextView tv4;
    TextView tv5;
    Long startTime;
    Long currentTime;
    Long diffTime;
    Boolean lightOn;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        gyroscope = sensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE);
        cameraManager = (CameraManager) getSystemService(Context.CAMERA_SERVICE);

        tv0 = findViewById(R.id.tv0);
        tv1 = findViewById(R.id.tv1);
        tv2 = findViewById(R.id.tv2);
        tv3 = findViewById(R.id.tv3);
        tv4 = findViewById(R.id.tv4);
        tv5 = findViewById(R.id.tv5);

        startTime = System.currentTimeMillis();
        lightOn = false;

        boolean supported = sensorManager.registerListener(this,
                gyroscope,
                SensorManager.SENSOR_DELAY_UI);

        if (!supported) {
            sensorManager.unregisterListener(this, gyroscope);
            tv0.setText(R.string.gyroscope_unavailable);
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.Q)
    @Override
    public void onSensorChanged(SensorEvent event) {
        if (event.sensor.getType() == Sensor.TYPE_GYROSCOPE
                && getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA_FLASH)) {
            try {
                onGyroscopeChanged(event);
            } catch (CameraAccessException e) {
                e.printStackTrace();
            }
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.Q)
    @SuppressLint({"SetTextI18n", "ResourceType"})
    private void onGyroscopeChanged(SensorEvent event) throws CameraAccessException {
        String cameraId = cameraManager.getCameraIdList()[0];
        currentTime = System.currentTimeMillis();

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

        diffTime = currentTime - startTime;
        tv5.setText(String.valueOf(diffTime));


        if (diffTime > 500) {
            if (x > 10 || y > 10 || z > 10 ||
                    x < -10 || y < -10 || z < -10) {
                startTime = currentTime;
                lightOn = !lightOn;
                if (lightOn) {
                    tv4.setText(R.string.light_on);
                    cameraManager.setTorchMode(cameraId, true);
                } else {
                    tv4.setText(R.string.light_off);
                    cameraManager.setTorchMode(cameraId, false);
                }
            }
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}