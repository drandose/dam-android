package com.example.intentquiz;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsCompat;

public class SistemaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        WindowCompat.enableEdgeToEdge(getWindow());
        setContentView(R.layout.activity_sistema);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void abrirQuiz(View v) {
        int sistema;

        if (v.getId() == R.id.btnAndroid) {
            sistema = 1;
        } else if (v.getId() == R.id.btnWindows) {
            sistema = 2;
        } else {
            sistema = 3;
        }

        Intent intent = new Intent(this, QuizActivity.class);
        intent.putExtra("sistema", sistema);
        startActivity(intent);
    }

    public void volverAlMenu(View v) {
        finish();
    }
}
