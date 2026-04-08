package com.pdm.parcial1.models;

public class Producto {

    public int imagen, stock;
    public String nombre;
    public float precio;

    public Producto() {}

    public Producto(int imagen, int stock, String nombre, float precio) {
        this.imagen = imagen;
        this.stock = stock;
        this.nombre = nombre;
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "nombre='" + nombre + '\'' +
                ", precio=" + precio +
                ", stock=" + stock +
                '}';
    }
}
