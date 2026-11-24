package com.example.pasapalabra;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsCompat;

public class ResultadoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        WindowCompat.enableEdgeToEdge(getWindow());
        setContentView(R.layout.activity_resultado);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        TextView textoPuntuacion = findViewById(R.id.textoPuntuacion);
        TextView textoCorrectas = findViewById(R.id.textoCorrectas);
        TextView textoIncorrectas = findViewById(R.id.textoIncorrectas);

        int aciertos = getIntent().getIntExtra("aciertos", 0);
        int fallos = getIntent().getIntExtra("fallos", 0);
        int total = aciertos + fallos;

        String puntuacion = "Puntuación: " + aciertos + " de " + total;
        String correctas = "Preguntas correctas: " + aciertos;
        String incorrectas = "Preguntas incorrectas: " + fallos;

        textoPuntuacion.setText(puntuacion);
        textoCorrectas.setText(correctas);
        textoIncorrectas.setText(incorrectas);
    }
}
