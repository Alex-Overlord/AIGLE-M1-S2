package com.example.tp1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Activity2 extends AppCompatActivity {

    TextView firstNameText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        firstNameText = findViewById(R.id.textViewFirstName);
        firstNameText.setText(getIntent().getStringExtra("fistName"));

//                getIntent().getExtras().getString("firstName");
//        firstNameText.setText(firstNameString);

//        firstNameText.setText(getIntent().getExtras().getString("firstName", "default"));

//        Intent intent = getIntent();
//        Bundle bundle = intent.getExtras();
//
//        if (bundle != null) {
//            String firstNameString = (String) bundle.get("firstName");
//            firstNameText.setText(firstNameString);
//        }

//        String firstNameString;// = intent.getStringExtra("editTextFirstName");
//
//        if (savedInstanceState == null) {
//
//            if (extras == null) {
//                firstNameString = null;
//            } else {
//                firstNameString = extras.getString("firstName");
//            }
//        } else {
//            firstNameString = (String) savedInstanceState.getSerializable("firstName");
//        }

//        firstNameText.setText(firstName);

//        String firstName = intent.getStringExtra(MainActivity.FIRST_NAME);
//        String lastName = intent.getStringExtra(MainActivity.LAST_NAME);
//        String age = intent.getStringExtra(MainActivity.AGE);
//        String domain = intent.getStringExtra(MainActivity.DOMAIN);
//        String phone = intent.getStringExtra(MainActivity.PHONE);


//        TextView lastNameText = findViewById(R.id.textViewLastName);
//        TextView ageText = findViewById(R.id.textViewAge);
//        TextView domainText = findViewById(R.id.textViewDomain);
//        TextView phoneText = findViewById(R.id.textViewPhone);


//        lastNameText.setText(lastName);
//        ageText.setText(age);
//        domainText.setText(domain);
//        phoneText.setText(phone);
    }
}