package com.example.tp1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.InputType;
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

        // lastNameLayout
        TextInputLayout lastNameLayout = new TextInputLayout(this);
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        lastNameLayout.setHint(getString(R.string.lastname));
        lastNameLayout.setHintEnabled(true);
        lastNameLayout.setLayoutParams(layoutParams);
        main_layout.addView(lastNameLayout);

        // lastNameEdit
        TextInputEditText lastNameEdit = new TextInputEditText(this);
        lastNameEdit.setInputType(InputType.TYPE_CLASS_TEXT);
        lastNameLayout.addView(lastNameEdit);

        // firstNameLayout
        TextInputLayout firstNameLayout = new TextInputLayout(this);
        firstNameLayout.setHint(getString(R.string.firstname));
        firstNameLayout.setHintEnabled(true);
        firstNameLayout.setLayoutParams(layoutParams);
        main_layout.addView(firstNameLayout);

        // firstNameEdit
        TextInputEditText firstNameEdit = new TextInputEditText(this);
        firstNameEdit.setInputType(InputType.TYPE_CLASS_TEXT);
        firstNameLayout.addView(firstNameEdit);

        // ageLayout
        TextInputLayout ageLayout = new TextInputLayout(this);
        ageLayout.setHint(getString(R.string.age));
        ageLayout.setHintEnabled(true);
        ageLayout.setLayoutParams(layoutParams);
        main_layout.addView(ageLayout);

        TextInputLayout domainLayout = new TextInputLayout(this);
        TextInputLayout phoneLayout = new TextInputLayout(this);


        TextInputEditText ageEdit = new TextInputEditText(this);
        TextInputEditText domainEdit = new TextInputEditText(this);
        TextInputEditText phoneEdit = new TextInputEditText(this);


    }
}