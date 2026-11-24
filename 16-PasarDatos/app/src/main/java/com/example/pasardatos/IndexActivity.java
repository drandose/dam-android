package com.example.pasardatos;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsCompat;

public class IndexActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        WindowCompat.enableEdgeToEdge(getWindow());
        setContentView(R.layout.activity_index);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        TextView textoBienvenida = findViewById(R.id.textoBienvenida);
        TextView textoId = findViewById(R.id.textoId);
        TextView textoPassword = findViewById(R.id.textoPassword);

        String id = getIntent().getStringExtra("id");
        String password = getIntent().getStringExtra("password");

        String bienvenida = "Welcome, " + id;
        String lineaId = "ID: " + id;
        String lineaPassword = "PASSWORD: " + password;

        textoBienvenida.setText(bienvenida);
        textoId.setText(lineaId);
        textoPassword.setText(lineaPassword);
    }
}
