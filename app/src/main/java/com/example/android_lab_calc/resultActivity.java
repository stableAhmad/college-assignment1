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
        Intent intent = getIntent();
        int res = intent.getIntExtra(MainActivity.EXTRA_NUMBER, 0);
        output = (TextView) findViewById(R.id.result);
        System.out.println("rrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrr");
        System.out.println(res);
        output.setText(res+"");

    }
}