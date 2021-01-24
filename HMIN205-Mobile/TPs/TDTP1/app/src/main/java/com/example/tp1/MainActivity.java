package com.example.tp1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);

        LinearLayout main_layout = new LinearLayout(this);
        LinearLayout.LayoutParams linearLayoutParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.MATCH_PARENT);
        main_layout.setLayoutParams(linearLayoutParams);
        main_layout.setOrientation(LinearLayout.VERTICAL);
        setContentView(main_layout);

        TextView text = new TextView(this);
        text.setText(R.string.tv);
        text.setTextSize(20);
        main_layout.addView(text);

        TextInputLayout lastNameLayout = new TextInputLayout(this);
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.MATCH_PARENT);


        TextInputLayout firstNameLayout = new TextInputLayout(this);
        TextInputLayout ageLayout = new TextInputLayout(this);
        TextInputLayout domainLayout = new TextInputLayout(this);
        TextInputLayout phoneLayout = new TextInputLayout(this);

        TextInputEditText lastNameEdit = new TextInputEditText(this);
        TextInputEditText firstNameEdit = new TextInputEditText(this);
        TextInputEditText ageEdit = new TextInputEditText(this);
        TextInputEditText domainEdit = new TextInputEditText(this);
        TextInputEditText phoneEdit = new TextInputEditText(this);


    }
}