package com.example.tp1;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {
    private Button validate;
    private TextInputEditText firstNameEdit = findViewById(R.id.editTextFirstName);
    public static final String FIRST_NAME = "com.example.tp1.MainActivity.FIRST_NAME";
//    public static final String LAST_NAME = "com.example.tp1.MainActivity.LAST_NAME";
//    public static final String AGE = "com.example.tp1.MainActivity.AGE";
//    public static final String DOMAIN = "com.example.tp1.MainActivity.DOMAIN";
//    public static final String PHONE = "com.example.tp1.MainActivity.PHONE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        LinearLayout main_layout = new LinearLayout(this);
//        LinearLayout.LayoutParams linearLayoutParams = new LinearLayout.LayoutParams(
//                LinearLayout.LayoutParams.MATCH_PARENT,
//                LinearLayout.LayoutParams.WRAP_CONTENT);
//        main_layout.setLayoutParams(linearLayoutParams);
//        main_layout.setOrientation(LinearLayout.VERTICAL);
//        setContentView(main_layout);
//
//        TextView text = new TextView(this);
//        text.setText(R.string.tv);
//        text.setTextSize(20);
//        main_layout.addView(text);
//
//        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(
//                ViewGroup.LayoutParams.MATCH_PARENT,
//                ViewGroup.LayoutParams.WRAP_CONTENT);
//
//        // firstNameLayout
//        TextInputLayout firstNameLayout = new TextInputLayout(this);
//        firstNameLayout.setHint(getString(R.string.firstname));
//        firstNameLayout.setHintEnabled(true);
//        firstNameLayout.setLayoutParams(layoutParams);
//        main_layout.addView(firstNameLayout);
//
//        // firstNameEdit
//        TextInputEditText firstNameEdit = new TextInputEditText(this);
//        firstNameEdit.setInputType(InputType.TYPE_CLASS_TEXT);
//        firstNameLayout.addView(firstNameEdit);
//
//        // lastNameLayout
//        TextInputLayout lastNameLayout = new TextInputLayout(this);
//        lastNameLayout.setHint(getString(R.string.lastname));
//        lastNameLayout.setHintEnabled(true);
//        lastNameLayout.setLayoutParams(layoutParams);
//        main_layout.addView(lastNameLayout);
//
//        // lastNameEdit
//        TextInputEditText lastNameEdit = new TextInputEditText(this);
//        lastNameEdit.setInputType(InputType.TYPE_CLASS_TEXT);
//        lastNameLayout.addView(lastNameEdit);
//
//        // ageLayout
//        TextInputLayout ageLayout = new TextInputLayout(this);
//        ageLayout.setHint(getString(R.string.age));
//        ageLayout.setHintEnabled(true);
//        ageLayout.setLayoutParams(layoutParams);
//        main_layout.addView(ageLayout);
//
//        // ageEdit
//        TextInputEditText ageEdit = new TextInputEditText(this);
//        ageEdit.setInputType(InputType.TYPE_CLASS_NUMBER);
//        ageLayout.addView(ageEdit);
//
//        // domainLayout
//        TextInputLayout domainLayout = new TextInputLayout(this);
//        domainLayout.setHint(getString(R.string.domain));
//        domainLayout.setHintEnabled(true);
//        domainLayout.setLayoutParams(layoutParams);
//        main_layout.addView(domainLayout);
//
//        // domainEdit
//        TextInputEditText domainEdit = new TextInputEditText(this);
//        domainEdit.setInputType(InputType.TYPE_CLASS_TEXT);
//        domainLayout.addView(domainEdit);
//
//        // phoneLayout
//        TextInputLayout phoneLayout = new TextInputLayout(this);
//        phoneLayout.setHint(getString(R.string.phone));
//        phoneLayout.setHintEnabled(true);
//        phoneLayout.setLayoutParams(layoutParams);
//        main_layout.addView(phoneLayout);
//
//        // phoneEdit
//        TextInputEditText phoneEdit = new TextInputEditText(this);
//        phoneEdit.setInputType(InputType.TYPE_CLASS_PHONE);
//        phoneLayout.addView(phoneEdit);

        // validate
        validate = new Button(this);
        validate.setId(R.id.validate);
        validate.setText(getString(R.string.validate));
        validate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                String form = "" + firstNameEdit.getText() + lastNameEdit.getText()
                        + ageEdit.getText() + domainEdit.getText() + phoneEdit.getText();

                new AlertDialog.Builder(MainActivity.this)
                        .setTitle(R.string.validate)
                        .setMessage(form)
                        .setPositiveButton(R.string.validate, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                firstNameEdit.setBackgroundColor(getResources().getColor(R.color.green));
                                lastNameEdit.setBackgroundColor(getResources().getColor(R.color.green));
                                ageEdit.setBackgroundColor(getResources().getColor(R.color.green));
                                domainEdit.setBackgroundColor(getResources().getColor(R.color.green));
                                phoneEdit.setBackgroundColor(getResources().getColor(R.color.green));
                                openActivity2();
                            }
                        })
                        .setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                firstNameEdit.setBackgroundColor(getResources().getColor(R.color.red));
                                lastNameEdit.setBackgroundColor(getResources().getColor(R.color.red));
                                ageEdit.setBackgroundColor(getResources().getColor(R.color.red));
                                domainEdit.setBackgroundColor(getResources().getColor(R.color.red));
                                phoneEdit.setBackgroundColor(getResources().getColor(R.color.red));
                            }
                        })
                        .create().show();
            }
        });
        main_layout.addView(validate);
    }

    private void openActivity2() {
        TextInputEditText firstNameEdit = findViewById(R.id.editTextFirstName);

        startActivity(new Intent(MainActivity.this, Activity2.class)
                .putExtra("firstName", firstNameEdit.getText().toString()));

//        Intent intent = new Intent(MainActivity.this, Activity2.class);
//        String firstNameNull = null;
//        intent.putExtra(Intent.EXTRA_TEXT, firstNameNull);
//        startActivity(intent);

//        TextInputEditText lastNameEdit = findViewById(R.id.editTextLastName);
//        TextInputEditText ageEdit = findViewById(R.id.editTextAge);
//        TextInputEditText domainEdit = findViewById(R.id.editTextDomain);
//        TextInputEditText phoneEdit = findViewById(R.id.editTextPhone);

//        String lastName = lastNameEdit.getText().toString();
//        String age = ageEdit.getText().toString();
//        String domain = domainEdit.getText().toString();
//        String phone = phoneEdit.getText().toString();

//        intent.putExtra(LAST_NAME, lastName);
//        intent.putExtra(AGE, age);
//        intent.putExtra(DOMAIN, domain);
//        intent.putExtra(PHONE, phone);

//        intent.putExtra(FIRST_NAME, firstName);
//        intent.putExtra(LAST_NAME, lastName);
//        intent.putExtra(AGE, age);
//        intent.putExtra(DOMAIN, domain);
//        intent.putExtra(PHONE, phone);

//        startActivity(intent);
    }
}