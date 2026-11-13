package com.example.navegacionactivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        WindowCompat.enableEdgeToEdge(getWindow());
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void verImagen(View v) {
        int imagenElegida;

        if (v.getId() == R.id.imagen1) {
            imagenElegida = R.drawable.playa;
        } else if (v.getId() == R.id.imagen2) {
            imagenElegida = R.drawable.montana;
        } else {
            imagenElegida = R.drawable.bosque;
        }

        Intent intent = new Intent(this, SegundaActivity.class);
        intent.putExtra("imagen", imagenElegida);
        startActivity(intent);
    }
}
