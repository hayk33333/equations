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
        closeKeyBoard(view);
        TextView res = findViewById(R.id.result);
        EditText objectA = findViewById(R.id.editTextA);
        boolean isNumber = true;
        try {
            double a = Double.parseDouble(objectA.getText().toString());
        }catch (NumberFormatException e){
            objectA.setError("Пожалуйста, введите число.");
            isNumber = false;
        }
        EditText objectB = findViewById(R.id.editTextB);
        try {
            double b = Double.parseDouble(objectB.getText().toString());
        }catch (NumberFormatException e){
            objectB.setError("Пожалуйста, введите число.");
            isNumber = false;
        }
        EditText objectC = findViewById(R.id.editTextC);
        try {
            double c = Double.parseDouble(objectC.getText().toString());
        }catch (NumberFormatException e){
            objectC.setError("Пожалуйста, введите число.");
            isNumber = false;
        }
        if (!isNumber){
            return;
        }
        double a = Double.parseDouble(objectA.getText().toString());
        double b = Double.parseDouble(objectB.getText().toString());
        double c = Double.parseDouble(objectC.getText().toString());
        double d = Math.pow(b, 2) - (4 * a * c);
        if (a == 0){
            res.setTextSize(20);
            res.setTextColor(getResources().getColor(R.color.red));
            res.setText("Значение а в квадратном уравнении не может быть равно нулю.");
        }else{
            if (d < 0){
                res.setTextSize(30);
                res.setTextColor(getResources().getColor(R.color.black));
                res.setText("Квадратное уравнение не имеет решения.");
            }
            else if (d == 0) {
                double x = -b / (2 * a);
                String result = String.valueOf(x);
                res.setTextSize(30);
                res.setTextColor(getResources().getColor(R.color.black));
                res.setText("x = " + result);
            }
            else {
                double x1 = (-b + Math.sqrt(d)) / (2 * a);
                double x2 = (-b - Math.sqrt(d)) / (2 * a);
                String result1 = String.valueOf(x1);
                String result2 = String.valueOf(x2);
                res.setTextSize(30);
                res.setTextColor(getResources().getColor(R.color.black));
                res.setText("x = " + result1 + "\n" + "x = " + result2);
            }
        }


    }
    public void buttonL2(View view) {
        closeKeyBoard(view);
        boolean isNumber = true;
        EditText objectK = findViewById(R.id.editTextK);
        try {
            double a = Double.parseDouble(objectK.getText().toString());
        }catch (NumberFormatException e){
            objectK.setError("Пожалуйста, введите число.");
            isNumber = false;
        }
        EditText objectB = findViewById(R.id.editTextB);
        try {
            double b = Double.parseDouble(objectB.getText().toString());
        }catch (NumberFormatException e){
            objectB.setError("Пожалуйста, введите число.");
            isNumber = false;
        }
        TextView res = findViewById(R.id.result2);
        if (!isNumber){
            return;
        }
        double k = Double.parseDouble(objectK.getText().toString());
        double b = Double.parseDouble(objectB.getText().toString());
        if (k == 0){
            res.setTextSize(20);
            res.setTextColor(getResources().getColor(R.color.red));
            res.setText("Значение k в уравнении не может быть равно нулю.");
        }
        else {
            res.setTextSize(30);
            res.setTextColor(getResources().getColor(R.color.black));
            double x = (-b / k);
            if ((int) x == x){
                x = (int) x;
            }
            String result = String.valueOf(x);
            res.setText("x = " + result);
        }

    }
    public void closeKeyBoard(View view){
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }
}