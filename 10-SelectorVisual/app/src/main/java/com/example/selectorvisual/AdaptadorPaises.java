package com.example.selectorvisual;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class AdaptadorPaises extends BaseAdapter {

    private Context contexto;
    private String[] nombres;
    private int[] imagenes;

    public AdaptadorPaises(Context contexto, String[] nombres, int[] imagenes) {
        this.contexto = contexto;
        this.nombres = nombres;
        this.imagenes = imagenes;
    }

    @Override
    public int getCount() {
        return nombres.length;
    }

    @Override
    public Object getItem(int position) {
        return nombres[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(contexto);
        View vista = inflater.inflate(R.layout.item_pais, parent, false);

        ImageView imagen = vista.findViewById(R.id.imagenPais);
        TextView texto = vista.findViewById(R.id.textoPais);

        imagen.setImageResource(imagenes[position]);
        texto.setText(nombres[position]);

        return vista;
    }
}
