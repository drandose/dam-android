package com.example.practicaradiobutton;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText caja1, caja2;
    private RadioButton rbSumar, rbMultiplicar, rbDividir, rbRestar;
    private TextView tvResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        caja1 = findViewById(R.id.caja1);
        caja2 = findViewById(R.id.caja2);
        rbSumar = findViewById(R.id.rbSumar);
        rbMultiplicar = findViewById(R.id.rbMultiplicar);
        rbDividir = findViewById(R.id.rbDividir);
        rbRestar = findViewById(R.id.rbRestar);
        tvResultado = findViewById(R.id.tvResultado);
    }

    public void calcular(View v) {
        String valor1 = caja1.getText().toString();
        String valor2 = caja2.getText().toString();

        if (valor1.isEmpty() || valor2.isEmpty()) {
            Toast.makeText(this, "Introduce los dos números", Toast.LENGTH_SHORT).show();
            return;
        }

        int numero1 = Integer.parseInt(valor1);
        int numero2 = Integer.parseInt(valor2);
        int resultado = 0;

        if (rbSumar.isChecked()) {
            resultado = numero1 + numero2;
        } else if (rbMultiplicar.isChecked()) {
            resultado = numero1 * numero2;
        } else if (rbDividir.isChecked()) {
            if (numero2 == 0) {
                Toast.makeText(this, "No se puede dividir entre 0", Toast.LENGTH_SHORT).show();
                return;
            }
            resultado = numero1 / numero2;
        } else if (rbRestar.isChecked()) {
            resultado = numero1 - numero2;
        } else {
            Toast.makeText(this, "Elige una operación", Toast.LENGTH_SHORT).show();
            return;
        }

        String mensaje = "El resultado es: " + resultado;
        tvResultado.setText(mensaje);
    }
}