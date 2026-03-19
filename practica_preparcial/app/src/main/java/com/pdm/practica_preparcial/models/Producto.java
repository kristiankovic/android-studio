package com.pdm.practica_preparcial.models;

public class Producto {

    public String nombre;
    public int stock;
    public float precio;

    public Producto() {
    }

    public Producto(String nombre, int stock, float precio) {
        this.nombre = nombre;
        this.stock = stock;
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return
                nombre + " - $" + precio;
    }
}
