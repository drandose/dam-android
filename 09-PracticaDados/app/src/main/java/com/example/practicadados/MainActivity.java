package com.example.practicadados;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private ImageView imgDado1, imgDado2;
    private int[] caras = {R.drawable.cara1, R.drawable.cara2, R.drawable.cara3,
            R.drawable.cara4, R.drawable.cara5, R.drawable.cara6};
    private Random random = new Random();

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

        imgDado1 = findViewById(R.id.imgDado1);
        imgDado2 = findViewById(R.id.imgDado2);
    }

    public void lanzar(View v) {
        int numero1 = random.nextInt(6);
        int numero2 = random.nextInt(6);

        imgDado1.setImageResource(caras[numero1]);
        imgDado2.setImageResource(caras[numero2]);

        if (numero1 == numero2) {
            Toast.makeText(this, "¡Las caras coinciden!", Toast.LENGTH_SHORT).show();
        }
    }
}