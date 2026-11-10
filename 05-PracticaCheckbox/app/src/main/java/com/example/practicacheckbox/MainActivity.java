package com.example.practicacheckbox;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.materialswitch.MaterialSwitch;

public class MainActivity extends AppCompatActivity {

    private CheckBox cbEstudias, cbTrabajas, cbDeporte;
    private MaterialSwitch swActivar;

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

        cbEstudias = findViewById(R.id.cbEstudias);
        cbTrabajas = findViewById(R.id.cbTrabajas);
        cbDeporte = findViewById(R.id.cbDeporte);
        swActivar = findViewById(R.id.swActivar);
    }

    public void onCheckboxClicked(View v) {
        if (v.getId() == R.id.cbEstudias && cbEstudias.isChecked()) {
            Toast.makeText(this, "Has marcado Estudias", Toast.LENGTH_SHORT).show();
        }
        if (v.getId() == R.id.cbTrabajas && cbTrabajas.isChecked()) {
            Toast.makeText(this, "Has marcado Trabajas", Toast.LENGTH_SHORT).show();
        }
        if (v.getId() == R.id.cbDeporte && cbDeporte.isChecked()) {
            Toast.makeText(this, "Has marcado Haces deporte", Toast.LENGTH_SHORT).show();
        }
    }

    public void onSwitchClicked(View v) {
        if (swActivar.isChecked()) {
            Toast.makeText(this, "Se ha marcado el switch", Toast.LENGTH_SHORT).show();
        }
    }
}