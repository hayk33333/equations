package com.example.equations;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    RadioButton radioButton1;
    RadioButton radioButton2;
    RadioButton radioButton1L1;
    RadioButton radioButton2L1;
    RadioButton radioButton1L2;
    RadioButton radioButton2L2;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        radioButton1 = findViewById(R.id.radioButton1);
        radioButton2 = findViewById(R.id.radioButton2);
        radioButton1L1 = findViewById(R.id.radioButton1L1);
        radioButton1L2 = findViewById(R.id.radioButton1L2);
        radioButton2L1 = findViewById(R.id.radioButton2L1);
        radioButton2L2 = findViewById(R.id.radioButton2L2);

    }

    public void onClickButton1(View view) {
        setContentView(R.layout.first_layout);
    }

    public void onClickButton2(View view) {
        setContentView(R.layout.second_layout);
    }

    public void onClickButton1L1(View view) {
        setContentView(R.layout.first_layout);
    }

    public void onClickButton1L2(View view) {
        setContentView(R.layout.first_layout);
    }

    public void onClickButton2L1(View view) {
        setContentView(R.layout.second_layout);
    }

    public void onClickButton2L2(View view) {
        setContentView(R.layout.second_layout);
    }


    public void buttonL1(View view) {
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        EditText objectA = findViewById(R.id.editTextA);
        double a = Double.parseDouble(objectA.getText().toString());
        EditText objectB = findViewById(R.id.editTextB);
        double b = Double.parseDouble(objectB.getText().toString());
        EditText objectC = findViewById(R.id.editTextC);
        double c = Double.parseDouble(objectC.getText().toString());
        TextView res = findViewById(R.id.result);
        double d = Math.pow(b, 2) - (4 * a * c);
        if (a == 0 && b == 0 && c == 0) {
            String r = "any";
            res.setText(r);
        }

        else if (d < 0) {
            String r = "none";
            res.setText(r);
        }
        else if (d == 0) {
            res.setText(String.valueOf(-b / (2 * a)));
        }
        else {
            String r = String.valueOf((-b + Math.sqrt(d)) / (2 * a)) + " " + (-b - Math.sqrt(d)) / (2 * a);
            res.setText(r);
        }


    }
    public void buttonL2(View view) {
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        EditText objectK = findViewById(R.id.editTextK);
        double k = Double.parseDouble(objectK.getText().toString());
        EditText objectB = findViewById(R.id.editTextB);
        double b = Double.parseDouble(objectB.getText().toString());
        TextView res = findViewById(R.id.result2);
        String result = String.valueOf((-b / k));
        res.setText(result);
    }
}