package com.example.lr_2_quest1;

import static java.lang.Math.sqrt;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText editA;
    private EditText editB;
    private EditText editC;
    private Button btnRes;
    private TextView TextRes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editA = findViewById(R.id.editTextNumberSigned4);
        editB = findViewById(R.id.editTextNumberSigned2);
        editC = findViewById(R.id.editTextNumberSigned3);
        btnRes = findViewById(R.id.button_2);
        TextRes = findViewById(R.id.textView2);
        btnRes.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (R.id.button_2 == view.getId()) {
            if (editA.getText().toString().equals("") || editB.getText().toString().equals("") || editC.getText().toString().equals("")) {
                TextRes.setText(getString(R.string.invalid_input_numbers));
                return;
            }
            float a = Float.parseFloat(editA.getText().toString());
            float b = Float.parseFloat(editB.getText().toString());
            float c = Float.parseFloat(editC.getText().toString());
            double D = b * b - 4 * a * c;
            if (D < 0) {
                TextRes.setText((getString(R.string.no_solutions)));
            } else {
                double x1 = (-b + Math.sqrt(D)) / (2 * a);
                double x2 = (-b - Math.sqrt(D)) / (2 * a);
                TextRes.setText(getString(R.string.solutions, x1, x2));
            }
        }
    }
}