package com.example.alumno.parcial1;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.os.Handler;

import java.util.List;

/**
 * Created by alumno on 09/05/2019.
 */

public class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {
    List<Producto> items;
    private MyOnItemClick listener;
    private Handler myHanler;
    public MyAdapter(List<Producto> productos,MyOnItemClick listener,Handler myHanler){
        this.items = productos;
        this.listener = listener;
        this.myHanler = myHanler;
    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_products,parent,false);

        MyViewHolder myViewHoleder = new MyViewHolder(v,listener);
        return myViewHoleder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Producto i = this.items.get(position);

        holder.tvNombre.setText(i.getNombre());
        //holder.tvCantidad.setText("C: " + Integer.toString(i.getCantidad()));
        //holder.tvPrecio.setText(" - PU: " + Float.toString(i.getPrecio()));

        holder.tvCantidad.setText(Integer.toString(i.getCantidad()));
        holder.tvPrecio.setText(Float.toString(i.getPrecio()));

        holder.setPosition(position);
    }

    public List<Producto> SetProds(List<Producto> prods){
        this.items = prods;
        return this.items;
    }

    @Override
    public int getItemCount() {
        return this.items.size();
    }


}
