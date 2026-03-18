package com.pdm.recyclerview.models;

public class Producto {

    public int imagen;
    public String nombre;
    public float precio;

    public Producto() {
    }

    public Producto(int imagen, String nombre, float precio) {
        this.imagen = imagen;
        this.nombre = nombre;
        this.precio = precio;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
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
}
