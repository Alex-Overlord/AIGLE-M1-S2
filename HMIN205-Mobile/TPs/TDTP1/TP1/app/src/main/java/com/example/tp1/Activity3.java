package com.example.tp1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import static com.example.tp1.MainActivity.EXTRA_PHONE;

public class Activity3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);

        TextView a3_tv_phone = findViewById(R.id.a3_tv_phone);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        String string_phone = (String) bundle.get(EXTRA_PHONE);
        Uri uri = Uri.parse("tel:" + string_phone);
        a3_tv_phone.setText(string_phone);

        Button a3_btn_call = findViewById(R.id.a3_btn_call);
        a3_btn_call.setOnClickListener(v -> {
            Intent callIntent = new Intent(Intent.ACTION_CALL, uri);
            startActivity(callIntent);
        });
    }
}