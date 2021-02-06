package com.example.tp2exo1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private SensorManager sensorManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        List<Sensor> sensorList = sensorManager.getSensorList(Sensor.TYPE_ALL);
        StringBuilder sensorDesc = new StringBuilder();

        for (Sensor sensor : sensorList) {
            sensorDesc.append("New sensor detected: \r\n");
            sensorDesc.append("\tName: " + sensor.getName() + "\r\n");
            sensorDesc.append("\tType: " + sensor.getType() + "\r\n");
            sensorDesc.append("Version: " + sensor.getVersion() + "\r\n");
            sensorDesc.append("Resolution (in the sensor unit): " +
                    sensor.getResolution() + "\r\n");
            sensorDesc.append("Power in mA used by this sensor while in use " +
                    sensor.getPower() +"\r\n");
            sensorDesc.append("Vendor: " + sensor.getVendor() + "\r\n");
            sensorDesc.append("Maximum range of the sensor in the sensor's unit: " +
                    sensor.getMaximumRange() + "\r\n");
            sensorDesc.append("Minimum delay allowed between two events in microsecond or zero if "
                    + "this sensor only returns a value when the data it's measuring changes: "
                    + sensor.getMinDelay() + "\r\n \r\n");
        }
        TextView textView = findViewById(R.id.sensor_list);
        textView.setText(sensorDesc.toString());
    }
}