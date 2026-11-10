package com.example.selectorvisual;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private Spinner spinnerPaises;
    private ImageView imagenGrande;
    private TextView textoNombre;

    private String[] nombres = {"España", "Francia", "Italia", "Alemania", "Bélgica"};
    private int[] imagenes = {R.drawable.espana, R.drawable.francia, R.drawable.italia,
            R.drawable.alemania, R.drawable.belgica};

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

        spinnerPaises = findViewById(R.id.spinnerPaises);
        imagenGrande = findViewById(R.id.imagenGrande);
        textoNombre = findViewById(R.id.textoNombre);

        AdaptadorPaises adaptador = new AdaptadorPaises(this, nombres, imagenes);
        spinnerPaises.setAdapter(adaptador);

        spinnerPaises.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                imagenGrande.setImageResource(imagenes[position]);
                textoNombre.setText(nombres[position]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }
}
