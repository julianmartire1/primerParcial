package com.example.alumno.parcial1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import android.util.Log;
import java.util.ArrayList;
import java.util.List;
import android.os.Handler;
import android.os.Message;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements Handler.Callback, MyOnItemClick {
    MyAdapter adapter;
    List<Producto> products;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        products = new ArrayList<>();



        /*Button btnRestar = (Button) super.findViewById(R.id.btnRestar);
        btnRestar.setOnClickListener(listener);*/


        RecyclerView rvProd = (RecyclerView) super.findViewById(R.id.rvProducts);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        rvProd.setLayoutManager(layoutManager);

        Handler handler = new Handler(this);

        adapter = new MyAdapter(products,this,handler);
        rvProd.setAdapter(adapter);

        MyThread hilo = new MyThread(handler,"http://192.168.2.166:8080/Productos.xml",0);
        hilo.start();
    }

    @Override
    public boolean handleMessage(Message msg) {
        this.products = this.adapter.SetProds((List<Producto>) msg.obj);
        adapter.notifyDataSetChanged();
        return false;
    }

    @Override
    public void onItemClick(View v, int position) {
        Producto p = this.products.get(position);

        if(v.getId() == R.id.btnRestar){
            Log.d("RESTAR", p.toString());
        }
        if(v.getId() == R.id.btnSumar){
            Log.d("SUMAR", p.toString());
        }
    }
}
