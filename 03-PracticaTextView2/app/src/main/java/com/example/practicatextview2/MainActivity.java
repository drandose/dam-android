package com.example.practicatextview2;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText etNombre;
    private EditText etApellido;
    private Button btnSaludar;
    private TextView tvMensaje;

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

        etNombre = findViewById(R.id.etNombre);
        etApellido = findViewById(R.id.etApellido);
        btnSaludar = findViewById(R.id.btnSaludar);
        tvMensaje = findViewById(R.id.tvMensaje);

        btnSaludar.setOnClickListener(v -> saludar());
    }

    private void saludar() {
        String nombre = etNombre.getText().toString();
        String apellido = etApellido.getText().toString();

        String mensaje = "Hola, " + nombre + " " + apellido + ". ¡Bienvenido a tu primera app!";

        tvMensaje.setText(mensaje);
        Toast.makeText(this, mensaje, Toast.LENGTH_LONG).show();
    }
}