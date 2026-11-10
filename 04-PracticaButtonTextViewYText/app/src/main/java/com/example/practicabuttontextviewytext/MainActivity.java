package com.example.practicabuttontextviewytext;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText caja1, caja2;
    private TextView texto1, texto2, titulo;

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
        titulo = findViewById(R.id.titulo);
        texto1 = findViewById(R.id.texto1);
        texto2 = findViewById(R.id.texto2);
    }

    public void calcular(View v) {
        int numero1 = 10;
        int numero2 = 5;
        int resultado = 0;

        String operacion = caja1.getText().toString().trim().toLowerCase();

        if (operacion.isEmpty()) {
            Toast.makeText(this, "Escribe una operación", Toast.LENGTH_SHORT).show();
            return;
        }

        switch (operacion) {
            case "suma":
                resultado = numero1 + numero2;
                break;
            case "resta":
                resultado = numero1 - numero2;
                break;
            case "multiplicación":
            case "multiplicacion":
                resultado = numero1 * numero2;
                break;
            case "división":
            case "division":
                resultado = numero1 / numero2;
                break;
            default:
                Toast.makeText(this, "Operación no válida", Toast.LENGTH_SHORT).show();
                return;
        }

        String mensaje = "El resultado es: " + resultado;
        caja2.setText(mensaje);
        Toast.makeText(this, mensaje, Toast.LENGTH_SHORT).show();
    }
}