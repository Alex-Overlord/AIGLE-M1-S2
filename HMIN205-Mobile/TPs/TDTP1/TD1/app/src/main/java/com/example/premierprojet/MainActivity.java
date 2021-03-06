package com.example.premierprojet;

import androidx.annotation.ContentView;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.ContentViewCallback;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

// Exo 1 à 4
//public class MainActivity extends AppCompatActivity {
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);

//        Button button1 = findViewById(R.id.btn1);
//        button1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View arg0) {
//                Toast.makeText(getApplicationContext(), R.string.btn1Text, Toast.LENGTH_SHORT).show();
//            }
//        });
//
//        Button button2 = findViewById(R.id.btn2);
//        button2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View arg0) {
//                Toast.makeText(getApplicationContext(), R.string.btn2Text, Toast.LENGTH_SHORT).show();
//
//                new AlertDialog.Builder(MainActivity.this).setTitle(R.string.adTitle)
//                        .setMessage(R.string.adMsg)
//                        .setPositiveButton(R.string.adPositiveButton, null).create().show();
//            }
//        });
//        button2.setOnLongClickListener(new View.OnLongClickListener() {
//            @Override
//            public boolean onLongClick(View v) {
//                new AlertDialog.Builder(MainActivity.this).setTitle(R.string.adTitle)
//                        .setMessage(R.string.adMsg2)
//                        .setPositiveButton(R.string.adPositiveButton, null).create().show();
//                return true;
//            }
//        });

// Exo 1
//        LinearLayout container = new LinearLayout(this);
//        setContentView(container);
//
//        TextView tv = new TextView(this);
//        tv.setText("Hello Android");
//        container.addView(tv);
//
//        EditText editText = new EditText(this);
//        editText.setText("Ceci est un Edit");
//        container.addView(editText);
//
// Exo 3
//        button = findViewById(R.id.mainbutton);
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View arg0) {
//                Toast.makeText(getApplicationContext(),"Message Bouton 1", Toast.LENGTH_SHORT).show();
//            }
//        });
//
//        Button button2 = findViewById(R.id.button2);
//        button2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View arg0) {
//                Toast.makeText(getApplicationContext(), "Je suis actionné !", Toast.LENGTH_SHORT).show();
//
//                TextView tv2 = new TextView(MainActivity.this);
//                tv2.setText("Exercice 4");
////                addView(tv2);
//                displayMsg("bt1");
//            }
//        });
//    }
//}

// Exo 5
public class MainActivity extends AppCompatActivity {
    private CheckBox linux, macos, windows;
    private Button button;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addListenerOnChkWindows();
        addListenerOnButton();
    }
    public void addListenerOnChkWindows() {
        windows = (CheckBox) findViewById(R.id.windows_option);
        windows.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (((CheckBox) v).isChecked()) {
                    Toast.makeText(MainActivity.this,"Bro, try Linux :)", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
    public void addListenerOnButton() {
        linux = (CheckBox) findViewById(R.id.linux_option);
        macos = (CheckBox) findViewById(R.id.macos_option);
        windows = (CheckBox) findViewById(R.id.windows_option);
        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StringBuffer result = new StringBuffer();
                result.append("Linux check : ").append(linux.isChecked());
                result.append("\nMac OS check : ").append(macos.isChecked());
                result.append("\nWindows check :").append(windows.isChecked());
                Toast.makeText(MainActivity.this, result.toString(), Toast.LENGTH_LONG).show();
            }
        });
    }
}