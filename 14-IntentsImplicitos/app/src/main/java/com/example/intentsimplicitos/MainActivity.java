package com.example.intentsimplicitos;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private CheckBox chkWeb, chkLlamar, chkCorreo, chkMapa, chkGaleria, chkFoto;

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

        chkWeb = findViewById(R.id.chkWeb);
        chkLlamar = findViewById(R.id.chkLlamar);
        chkCorreo = findViewById(R.id.chkCorreo);
        chkMapa = findViewById(R.id.chkMapa);
        chkGaleria = findViewById(R.id.chkGaleria);
        chkFoto = findViewById(R.id.chkFoto);
    }

    public void abrirWeb(View v) {
        if (chkWeb.isChecked()) {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com"));
            abrirAplicacion(intent);
        } else {
            Toast.makeText(this, "Marca primero la casilla", Toast.LENGTH_SHORT).show();
        }
    }

    public void llamar(View v) {
        if (chkLlamar.isChecked()) {
            Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:600123456"));
            abrirAplicacion(intent);
        } else {
            Toast.makeText(this, "Marca primero la casilla", Toast.LENGTH_SHORT).show();
        }
    }

    public void enviarCorreo(View v) {
        if (chkCorreo.isChecked()) {
            Intent intent = new Intent(Intent.ACTION_SENDTO, Uri.parse("mailto:correo@ejemplo.com"));
            intent.putExtra(Intent.EXTRA_SUBJECT, "Práctica Intents II");
            intent.putExtra(Intent.EXTRA_TEXT, "Correo enviado desde mi aplicación.");
            abrirAplicacion(intent);
        } else {
            Toast.makeText(this, "Marca primero la casilla", Toast.LENGTH_SHORT).show();
        }
    }

    public void abrirMapa(View v) {
        if (chkMapa.isChecked()) {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:0,0?q=Madrid"));
            intent.setPackage("com.google.android.apps.maps");
            abrirAplicacion(intent);
        } else {
            Toast.makeText(this, "Marca primero la casilla", Toast.LENGTH_SHORT).show();
        }
    }

    public void abrirGaleria(View v) {
        if (chkGaleria.isChecked()) {
            Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            abrirAplicacion(intent);
        } else {
            Toast.makeText(this, "Marca primero la casilla", Toast.LENGTH_SHORT).show();
        }
    }

    public void tomarFoto(View v) {
        if (chkFoto.isChecked()) {
            Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            abrirAplicacion(intent);
        } else {
            Toast.makeText(this, "Marca primero la casilla", Toast.LENGTH_SHORT).show();
        }
    }

    private void abrirAplicacion(Intent intent) {
        try {
            startActivity(intent);
        } catch (ActivityNotFoundException e) {
            Toast.makeText(this, "No hay ninguna aplicación para abrir esto", Toast.LENGTH_SHORT).show();
        }
    }
}
