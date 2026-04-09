package com.pdm.parcial1_vv23011.models;

public class Producto {

    public int imagen;
    public String nombre;
    public float precio;
    public String categoria;
    public int cantidadComprada = 0;
    public boolean comprado = false;

    public Producto() {
    }

    public Producto(int imagen, String nombre, float precio, String categoria) {
        this.imagen = imagen;
        this.nombre = nombre;
        this.precio = precio;
        this.categoria = categoria;
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

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return  nombre + precio + categoria;
    }
}
