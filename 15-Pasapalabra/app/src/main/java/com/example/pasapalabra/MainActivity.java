package com.example.pasapalabra;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private final TextView[] circulos = new TextView[21];
    private TextView letraActual, textoPregunta;
    private EditText cajaRespuesta;

    private final String[] letras = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "L",
            "M", "N", "O", "P", "R", "S", "T", "U", "V", "Z"};

    private final String[] preguntas = {
            "Empieza por A: cada pantalla de una aplicación de Android.",
            "Empieza por B: componente que el usuario pulsa para ejecutar una acción.",
            "Empieza por C: casilla que se puede marcar y desmarcar.",
            "Empieza por D: carpeta de res donde se guardan las imágenes.",
            "Empieza por E: componente donde el usuario escribe texto.",
            "Empieza por F: método que cierra la Activity actual.",
            "Empieza por G: sistema que compila el proyecto en Android Studio.",
            "Empieza por H: atributo que muestra un texto de ayuda dentro de un EditText.",
            "Empieza por I: clase que se usa para pasar de una Activity a otra.",
            "Empieza por J: lenguaje de programación que usamos en la asignatura.",
            "Empieza por L: carpeta de res donde se guardan los diseños de las pantallas.",
            "Empieza por M: nombre de la Activity principal que crea Android Studio.",
            "Empieza por N: nombre de la versión de Android anterior a Oreo.",
            "Empieza por O: método que se ejecuta cuando se crea una Activity.",
            "Empieza por P: método de Intent que envía un dato a otra Activity.",
            "Empieza por R: botón redondo para elegir una sola opción de un grupo.",
            "Empieza por S: lista desplegable para elegir una opción.",
            "Empieza por T: mensaje breve que aparece unos segundos en la pantalla.",
            "Empieza por U: clase que indica la dirección en un Intent implícito, como una web o un teléfono.",
            "Empieza por V: clase de la que heredan todos los componentes de la pantalla.",
            "Contiene la Z: atributo que cambia el tamaño de la letra de un texto."
    };

    private final String[] respuestas = {
            "Activity",
            "Button",
            "CheckBox",
            "drawable",
            "EditText",
            "finish",
            "Gradle",
            "hint",
            "Intent",
            "Java",
            "layout",
            "MainActivity",
            "Nougat",
            "onCreate",
            "putExtra",
            "RadioButton",
            "Spinner",
            "Toast",
            "Uri",
            "View",
            "textSize"
    };

    private int posicion = 0;
    private int aciertos = 0;
    private int fallos = 0;

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

        letraActual = findViewById(R.id.letraActual);
        textoPregunta = findViewById(R.id.textoPregunta);
        cajaRespuesta = findViewById(R.id.cajaRespuesta);

        circulos[0] = findViewById(R.id.circuloA);
        circulos[1] = findViewById(R.id.circuloB);
        circulos[2] = findViewById(R.id.circuloC);
        circulos[3] = findViewById(R.id.circuloD);
        circulos[4] = findViewById(R.id.circuloE);
        circulos[5] = findViewById(R.id.circuloF);
        circulos[6] = findViewById(R.id.circuloG);
        circulos[7] = findViewById(R.id.circuloH);
        circulos[8] = findViewById(R.id.circuloI);
        circulos[9] = findViewById(R.id.circuloJ);
        circulos[10] = findViewById(R.id.circuloL);
        circulos[11] = findViewById(R.id.circuloM);
        circulos[12] = findViewById(R.id.circuloN);
        circulos[13] = findViewById(R.id.circuloO);
        circulos[14] = findViewById(R.id.circuloP);
        circulos[15] = findViewById(R.id.circuloR);
        circulos[16] = findViewById(R.id.circuloS);
        circulos[17] = findViewById(R.id.circuloT);
        circulos[18] = findViewById(R.id.circuloU);
        circulos[19] = findViewById(R.id.circuloV);
        circulos[20] = findViewById(R.id.circuloZ);

        mostrarPregunta();
    }

    private void mostrarPregunta() {
        letraActual.setText(letras[posicion]);
        textoPregunta.setText(preguntas[posicion]);
        cajaRespuesta.getText().clear();
    }

    public void comprobar(View v) {
        String respuesta = cajaRespuesta.getText().toString().trim();

        if (respuesta.equalsIgnoreCase(respuestas[posicion])) {
            aciertos++;
            circulos[posicion].setBackgroundResource(R.drawable.circulo_verde);
            Toast.makeText(this, "Correcto", Toast.LENGTH_SHORT).show();
        } else {
            fallos++;
            circulos[posicion].setBackgroundResource(R.drawable.circulo_rojo);
            Toast.makeText(this, "Incorrecto. Era: " + respuestas[posicion], Toast.LENGTH_SHORT).show();
        }

        posicion++;

        if (posicion < letras.length) {
            mostrarPregunta();
        } else {
            Intent intent = new Intent(this, ResultadoActivity.class);
            intent.putExtra("aciertos", aciertos);
            intent.putExtra("fallos", fallos);
            startActivity(intent);
            finish();
        }
    }
}
