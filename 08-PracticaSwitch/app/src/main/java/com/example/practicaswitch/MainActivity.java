package com.example.practicaswitch;

import android.os.Bundle;
import android.view.View;
import android.widget.Switch;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private Switch swDatos, swWifi;

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

        swDatos = findViewById(R.id.swDatos);
        swWifi = findViewById(R.id.swWifi);
    }

    public void verificar(View v) {
        if (swDatos.isChecked() && swWifi.isChecked()) {
            Toast.makeText(this, "Datos móviles y Wifi activados", Toast.LENGTH_SHORT).show();
        } else if (swDatos.isChecked()) {
            Toast.makeText(this, "Datos móviles activados", Toast.LENGTH_SHORT).show();
        } else if (swWifi.isChecked()) {
            Toast.makeText(this, "Wifi activado", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Ningún switch activado", Toast.LENGTH_SHORT).show();
        }
    }
}