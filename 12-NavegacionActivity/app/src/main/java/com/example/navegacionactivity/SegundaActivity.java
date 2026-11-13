package com.example.navegacionactivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsCompat;

public class SegundaActivity extends AppCompatActivity {

    private ImageView imagenGrande;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        WindowCompat.enableEdgeToEdge(getWindow());
        setContentView(R.layout.activity_segunda);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        imagenGrande = findViewById(R.id.imagenGrande);

        int imagenElegida = getIntent().getIntExtra("imagen", R.drawable.playa);
        imagenGrande.setImageResource(imagenElegida);

        Toast.makeText(this, "Para volver al inicio, haz clic sobre la foto", Toast.LENGTH_LONG).show();
    }

    public void volver(View v) {
        finish();
    }
}
