package com.example.android_lab_calc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.math.BigInteger;

public class MainActivity extends AppCompatActivity {
    private Button add;
    private Button subtract;
    private EditText first;
    private EditText second;
    public static BigInteger result = BigInteger.ZERO;
    public static String error = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        add = (Button) findViewById(R.id.button_1);
        subtract = (Button) findViewById(R.id.button_2);
        setTitle("Calculator");

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                error = null;
                if (checker()) {
                    BigInteger result = add();
                    openActivity2(result);
                }else{
                    error = "Invalid input";
                    openActivity2(result);
                }
            }
        });
        subtract.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                error = null;
                if(checker()){
                    result = sub();
                    openActivity2(result);
                }else{
                    error = "Invalid input";
                    openActivity2(result);
                }
            }
        });
    }

    public boolean checker() {
        first = (EditText) findViewById(R.id.edit_text_1);
        second = (EditText) findViewById(R.id.edit_text_2);
        String num_string = first.getText().toString();

        if (num_string.length() == 0)
            return false;

        for (int i = 0; i < num_string.length(); i++) {
            if (num_string.charAt(i) < '0' || num_string.charAt(i) > '9') {
                return false;
            }
        }

        num_string = second.getText().toString();
        if (num_string.length() == 0)
            return false;

        for (int i = 0; i < num_string.length(); i++) {
            if (num_string.charAt(i) < '0' || num_string.charAt(i) > '9') {
                return false;
            }
        }
        return true;
    }

    public BigInteger add() {
        first = (EditText) findViewById(R.id.edit_text_1);
        second = (EditText) findViewById(R.id.edit_text_2);
        String num_string = first.getText().toString();

        BigInteger num1 = new BigInteger(num_string);
        num_string = second.getText().toString();
        BigInteger num2 = new BigInteger(num_string);
        return num1.add(num2);
    }

    public BigInteger sub() {
        first = (EditText) findViewById(R.id.edit_text_1);
        second = (EditText) findViewById(R.id.edit_text_2);
        String num_string = first.getText().toString();

        BigInteger num1 = new BigInteger(num_string);
        num_string = second.getText().toString();
        BigInteger num2 = new BigInteger(num_string);
        return num1.subtract(num2);
    }

    public void openActivity2(BigInteger result) {
        Intent intent = new Intent(this, resultActivity.class);
        intent.putExtra("Result", result.toString());
        intent.putExtra("Error", error);
        startActivity(intent);
    }
}