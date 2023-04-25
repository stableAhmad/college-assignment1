package com.example.android_lab_calc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private Button add;
    private Button subtract;
    private EditText first;
    private EditText second;
    public static final String EXTRA_TEXT = "com.example.android_lab_calc.EXTRA_TEXT";
    public static final String EXTRA_NUMBER = "com.example.android_lab_calc.EXTRA_NUMBER";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        add = (Button) findViewById(R.id.button_1);
        subtract = (Button) findViewById(R.id.button_2);


        add.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {

                int result = add();
                openActivity2(result);
            }
        });
        subtract.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                int result = sub();
                openActivity2(result);
            }
        });
    }
    public int add() {
        first = (EditText) findViewById(R.id.edit_text_1);
        second = (EditText) findViewById(R.id.edit_text_2);
        String num_string =  first.getText().toString();
        int num1 = Integer.parseInt(num_string);
        num_string = second.getText().toString();
        int num2 = Integer.parseInt(num_string);
        return num1+num2;
    }
       public int sub() {
        first = (EditText) findViewById(R.id.edit_text_1);
        second = (EditText) findViewById(R.id.edit_text_2);
        String num_string =  first.getText().toString();
        int num1 = Integer.parseInt(num_string);
        num_string = second.getText().toString();
        int num2 = Integer.parseInt(num_string);
        return num1-num2;
    }
    public void openActivity2(int result) {
        Intent intent = new Intent(this, resultActivity.class);
        intent.putExtra(EXTRA_NUMBER, result);
        startActivity(intent);
    }
}