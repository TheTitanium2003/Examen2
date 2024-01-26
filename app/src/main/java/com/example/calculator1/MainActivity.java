package com.example.calculator1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText editTextParcial1;
    private EditText editTextParcial2;
    private TextView textViewResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextParcial1 = findViewById(R.id.edit_text_parcial1);
        editTextParcial2 = findViewById(R.id.edit_text_parcial2);
        textViewResult = findViewById(R.id.text_view_result);

        Button buttonCalculate = findViewById(R.id.button_calculate);
        buttonCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateGrade();
            }
        });

        Button buttonPresent = findViewById(R.id.button_present);
        buttonPresent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presentGrade();
            }
        });
    }

    private void calculateGrade() {
        String parcial1Str = editTextParcial1.getText().toString();
        String parcial2Str = editTextParcial2.getText().toString();

        if (parcial1Str.isEmpty() || parcial2Str.isEmpty()) {
            textViewResult.setText("Ingrese las calificaciones");
            return;
        }

        double parcial1 = Double.parseDouble(parcial1Str);
        double parcial2 = Double.parseDouble(parcial2Str);

        double grade = (parcial1 + parcial2) / 2;

        textViewResult.setText("Promedio: " + grade);
    }

    private void presentGrade() {
        if (textViewResult.getText().toString().equals("")) {
            textViewResult.setText("Ingrese las calificaciones");
            return;
        }

        textViewResult.setText("Su promedio es: " + textViewResult.getText().toString().substring(9));
    }
}