package com.example.alumno.parcial1;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by alumno on 09/05/2019.
 */

public class MyViewHolder extends RecyclerView.ViewHolder implements  View.OnClickListener {

    private MyOnItemClick listener;
    public TextView tvNombre;
    public TextView tvCantidad;
    public TextView tvPrecio;
    private int position;

    public ImageView viewImagenSumar;
    public ImageView viewImagenRestar;
    public MyViewHolder(View v,MyOnItemClick listener){
        super(v);
        v.setOnClickListener(this);
        tvNombre = (TextView) v.findViewById(R.id.nombre);
        tvCantidad = (TextView) v.findViewById(R.id.cantidad);
        tvPrecio = (TextView) v.findViewById(R.id.precio);

        viewImagenRestar = (ImageView) v.findViewById(R.id.btnRestar);
        viewImagenSumar = (ImageView) v.findViewById(R.id.btnSumar);

        viewImagenSumar.setOnClickListener(this);
        viewImagenRestar.setOnClickListener(this);

        this.listener = listener;

    }

    public void setPosition(int position)
    {
        this.position = position;
    }

    @Override
    public void onClick(View v) {
        listener.onItemClick(v, position);

    }
}