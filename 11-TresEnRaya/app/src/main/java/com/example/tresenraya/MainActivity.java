package com.example.tresenraya;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private Button[] casillas = new Button[9];
    private TextView tvPuntosX, tvPuntosO, tvEmpates;

    private String turno = "X";
    private int jugadas = 0;
    private boolean partidaTerminada = false;

    private int puntosX = 0;
    private int puntosO = 0;
    private int empates = 0;

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

        tvPuntosX = findViewById(R.id.tvPuntosX);
        tvPuntosO = findViewById(R.id.tvPuntosO);
        tvEmpates = findViewById(R.id.tvEmpates);

        casillas[0] = findViewById(R.id.casilla0);
        casillas[1] = findViewById(R.id.casilla1);
        casillas[2] = findViewById(R.id.casilla2);
        casillas[3] = findViewById(R.id.casilla3);
        casillas[4] = findViewById(R.id.casilla4);
        casillas[5] = findViewById(R.id.casilla5);
        casillas[6] = findViewById(R.id.casilla6);
        casillas[7] = findViewById(R.id.casilla7);
        casillas[8] = findViewById(R.id.casilla8);
    }

    public void pulsarCasilla(View v) {
        Button casilla = (Button) v;

        if (partidaTerminada || !casilla.getText().toString().isEmpty()) {
            return;
        }

        casilla.setText(turno);
        if (turno.equals("X")) {
            casilla.setTextColor(Color.parseColor("#1F4E9C"));
        } else {
            casilla.setTextColor(Color.parseColor("#D32F2F"));
        }
        jugadas++;

        if (hayGanador()) {
            partidaTerminada = true;
            if (turno.equals("X")) {
                puntosX++;
            } else {
                puntosO++;
            }
            actualizarMarcador();
            Toast.makeText(this, "Gana el jugador " + turno, Toast.LENGTH_SHORT).show();
        } else if (jugadas == 9) {
            partidaTerminada = true;
            empates++;
            actualizarMarcador();
            Toast.makeText(this, "Empate", Toast.LENGTH_SHORT).show();
        } else {
            if (turno.equals("X")) {
                turno = "O";
            } else {
                turno = "X";
            }
        }
    }

    private boolean hayGanador() {
        return comprobarLinea(0, 1, 2) || comprobarLinea(3, 4, 5) || comprobarLinea(6, 7, 8)
                || comprobarLinea(0, 3, 6) || comprobarLinea(1, 4, 7) || comprobarLinea(2, 5, 8)
                || comprobarLinea(0, 4, 8) || comprobarLinea(2, 4, 6);
    }

    private boolean comprobarLinea(int posicion1, int posicion2, int posicion3) {
        String texto1 = casillas[posicion1].getText().toString();
        String texto2 = casillas[posicion2].getText().toString();
        String texto3 = casillas[posicion3].getText().toString();
        return !texto1.isEmpty() && texto1.equals(texto2) && texto1.equals(texto3);
    }

    public void nuevaPartida(View v) {
        for (int i = 0; i < casillas.length; i++) {
            casillas[i].setText("");
        }
        turno = "X";
        jugadas = 0;
        partidaTerminada = false;
    }

    public void reiniciarPuntuacion(View v) {
        puntosX = 0;
        puntosO = 0;
        empates = 0;
        actualizarMarcador();
    }

    private void actualizarMarcador() {
        tvPuntosX.setText(String.valueOf(puntosX));
        tvPuntosO.setText(String.valueOf(puntosO));
        tvEmpates.setText(String.valueOf(empates));
    }
}
