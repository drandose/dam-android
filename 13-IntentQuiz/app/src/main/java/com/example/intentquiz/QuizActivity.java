package com.example.intentquiz;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsCompat;

public class QuizActivity extends AppCompatActivity {

    private TextView textoPregunta, textoPuntuacion;
    private Button btnOpcion1, btnOpcion2, btnOpcion3;

    private String[] preguntas;
    private String[][] opciones;
    private int[] correctas;

    private int numeroPregunta = 0;
    private double puntuacion = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        WindowCompat.enableEdgeToEdge(getWindow());
        setContentView(R.layout.activity_quiz);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        TextView tituloSistema = findViewById(R.id.tituloSistema);
        ImageView logoSistema = findViewById(R.id.logoSistema);
        textoPregunta = findViewById(R.id.textoPregunta);
        textoPuntuacion = findViewById(R.id.textoPuntuacion);
        btnOpcion1 = findViewById(R.id.btnOpcion1);
        btnOpcion2 = findViewById(R.id.btnOpcion2);
        btnOpcion3 = findViewById(R.id.btnOpcion3);

        int sistema = getIntent().getIntExtra("sistema", 1);
        String titulo;

        if (sistema == 1) {
            titulo = "Android";
            logoSistema.setImageResource(R.drawable.movil);
            cargarPreguntasAndroid();
        } else if (sistema == 2) {
            titulo = "Windows";
            logoSistema.setImageResource(R.drawable.ventana);
            cargarPreguntasWindows();
        } else {
            titulo = "Linux";
            logoSistema.setImageResource(R.drawable.terminal);
            cargarPreguntasLinux();
        }

        tituloSistema.setText(titulo);
        mostrarPregunta();
    }

    private void cargarPreguntasAndroid() {
        preguntas = new String[]{
                "¿Qué empresa desarrolla Android?",
                "¿En qué núcleo está basado Android?",
                "¿Qué extensión tienen los instaladores de aplicaciones de Android?",
                "¿Cómo se llama la tienda oficial de aplicaciones de Android?",
                "¿Qué nombre tiene la versión 8.0 de Android?",
                "¿Cómo se llama cada pantalla de una aplicación de Android?",
                "¿Qué clase se usa para pasar de una pantalla a otra?"
        };
        opciones = new String[][]{
                {"Apple", "Google", "Microsoft"},
                {"Linux", "Windows NT", "MS-DOS"},
                {".exe", ".deb", ".apk"},
                {"App Store", "Google Play", "Microsoft Store"},
                {"Oreo", "Nougat", "Pie"},
                {"Window", "Frame", "Activity"},
                {"Toast", "Intent", "Spinner"}
        };
        correctas = new int[]{1, 0, 2, 1, 0, 2, 1};
    }

    private void cargarPreguntasWindows() {
        preguntas = new String[]{
                "¿Qué empresa desarrolla Windows?",
                "¿Qué extensión tienen los programas ejecutables de Windows?",
                "¿Qué sistema de archivos usa Windows en el disco donde está instalado?",
                "¿Qué letra tiene normalmente la unidad donde se instala Windows?",
                "¿Qué combinación de teclas abre directamente el Administrador de tareas?",
                "¿Cómo se llama el intérprete de comandos clásico de Windows?",
                "¿Qué versión de Windows salió en 2021?"
        };
        opciones = new String[][]{
                {"Microsoft", "Google", "IBM"},
                {".apk", ".exe", ".sh"},
                {"ext4", "APFS", "NTFS"},
                {"A:", "C:", "Z:"},
                {"Ctrl + Shift + Esc", "Alt + F4", "Ctrl + C"},
                {"Bash", "Zsh", "Símbolo del sistema (CMD)"},
                {"Windows 8", "Windows 11", "Windows 10"}
        };
        correctas = new int[]{0, 1, 2, 1, 0, 2, 1};
    }

    private void cargarPreguntasLinux() {
        preguntas = new String[]{
                "¿Quién creó el núcleo de Linux?",
                "¿Cuál de estas es una distribución de Linux?",
                "¿Qué comando muestra los archivos de una carpeta?",
                "¿Cómo se llama el usuario administrador en Linux?",
                "¿Qué comando permite ejecutar una orden como administrador?",
                "¿Qué animal es la mascota de Linux?",
                "¿Qué tipo de software es Linux?"
        };
        opciones = new String[][]{
                {"Bill Gates", "Steve Jobs", "Linus Torvalds"},
                {"Ubuntu", "Windows 11", "macOS"},
                {"cd", "ls", "rm"},
                {"root", "admin", "system"},
                {"ping", "echo", "sudo"},
                {"Un gato", "Un pingüino", "Un robot"},
                {"Software libre", "Software de pago", "Software de prueba"}
        };
        correctas = new int[]{2, 0, 1, 0, 2, 1, 0};
    }

    private void mostrarPregunta() {
        String enunciado = (numeroPregunta + 1) + ". " + preguntas[numeroPregunta];
        textoPregunta.setText(enunciado);
        btnOpcion1.setText(opciones[numeroPregunta][0]);
        btnOpcion2.setText(opciones[numeroPregunta][1]);
        btnOpcion3.setText(opciones[numeroPregunta][2]);
    }

    public void responder(View v) {
        int opcionElegida;

        if (v.getId() == R.id.btnOpcion1) {
            opcionElegida = 0;
        } else if (v.getId() == R.id.btnOpcion2) {
            opcionElegida = 1;
        } else {
            opcionElegida = 2;
        }

        if (opcionElegida == correctas[numeroPregunta]) {
            puntuacion += 1;
            Toast.makeText(this, "Correcto", Toast.LENGTH_SHORT).show();
        } else {
            puntuacion -= 0.33;
            Toast.makeText(this, "Incorrecto", Toast.LENGTH_SHORT).show();
        }

        numeroPregunta++;

        if (numeroPregunta < preguntas.length) {
            mostrarPregunta();
        } else {
            mostrarPuntuacion();
        }
    }

    private void mostrarPuntuacion() {
        puntuacion = Math.round(puntuacion * 100) / 100.0;

        String fin = "Fin del quiz";
        String resultado = "Puntuación total: " + puntuacion + " puntos";

        textoPregunta.setText(fin);
        textoPuntuacion.setText(resultado);

        btnOpcion1.setVisibility(View.GONE);
        btnOpcion2.setVisibility(View.GONE);
        btnOpcion3.setVisibility(View.GONE);
    }

    public void volverAlMenu(View v) {
        finish();
    }
}
