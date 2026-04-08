package com.pdm.lab1.models;

public class ProductoComprado extends Producto{

    public Producto productoComprado;
    public float total;

    public ProductoComprado(Producto productoComprado, float total) {
        this.productoComprado = productoComprado;
        this.total = total;
    }

    public ProductoComprado(String nombre, float precio, Producto productoComprado, float total) {
        super(nombre, precio);
        this.productoComprado = productoComprado;
        this.total = total;
    }
}
