package com.example.alumno.parcial1;

/**
 * Created by alumno on 09/05/2019.
 */

public class Producto {
    private int id;
    private String nombre;
    private float precio;
    private int cantidad;

    public Producto() { }

    public Producto(int id, String nombre, float precio, int cantidad) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", precio=" + precio +
                ", cantidad=" + cantidad +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }


    public void masCantidad(){
        this.cantidad = this.cantidad + 1;
    }
    public void menosCantidad(){
        this.cantidad = this.cantidad - 1;
    }
}
