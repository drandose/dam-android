package com.example.pasardatos;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsCompat;

public class RegisterActivity extends AppCompatActivity {

    private EditText cajaId, cajaPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        WindowCompat.enableEdgeToEdge(getWindow());
        setContentView(R.layout.activity_register);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        cajaId = findViewById(R.id.cajaId);
        cajaPassword = findViewById(R.id.cajaPassword);
    }

    public void registrar(View v) {
        String id = cajaId.getText().toString();
        String password = cajaPassword.getText().toString();

        Intent intent = new Intent(this, LoginActivity.class);
        intent.putExtra("id", id);
        intent.putExtra("password", password);
        startActivity(intent);
    }
}
