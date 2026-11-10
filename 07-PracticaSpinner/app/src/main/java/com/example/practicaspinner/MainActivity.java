package com.example.practicaspinner;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText caja1, caja2;
    private Spinner mispinner;
    private TextView tvResultado;
    private String[] misdatos = {"Escoge una opción", "sumar", "restar", "multiplicar", "dividir"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        caja1 = findViewById(R.id.caja1);
        caja2 = findViewById(R.id.caja2);
        mispinner = findViewById(R.id.mispinner);
        tvResultado = findViewById(R.id.tvResultado);

        ArrayAdapter<String> adaptador1 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, misdatos);
        adaptador1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mispinner.setAdapter(adaptador1);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
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

        String datoseleccionado = mispinner.getSelectedItem().toString();

        switch (datoseleccionado) {
            case "sumar":
                resultado = numero1 + numero2;
                break;
            case "restar":
                resultado = numero1 - numero2;
                break;
            case "multiplicar":
                resultado = numero1 * numero2;
                break;
            case "dividir":
                if (numero2 == 0) {
                    Toast.makeText(this, "No se puede dividir entre 0", Toast.LENGTH_SHORT).show();
                    return;
                }
                resultado = numero1 / numero2;
                break;
            default:
                Toast.makeText(this, "Escoge una operación", Toast.LENGTH_SHORT).show();
                return;
        }

        String mensaje = "El resultado es: " + resultado;
        tvResultado.setText(mensaje);
    }
}