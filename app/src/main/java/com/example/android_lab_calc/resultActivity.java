package com.example.android_lab_calc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class resultActivity extends AppCompatActivity {
    private TextView output;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        setTitle("Result");
        Intent intent = getIntent();
        String result = intent.getStringExtra("Result");
        String error = intent.getStringExtra("Error");
        output = (TextView) findViewById(R.id.result);
        if (error != null)
            output.setText(error);
        else
            output.setText(result);

        System.out.println(result);

    }
}