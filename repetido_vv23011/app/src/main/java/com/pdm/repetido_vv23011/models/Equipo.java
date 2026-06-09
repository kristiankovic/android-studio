package com.pdm.repetido_vv23011.models;

public class Equipo {
    public int imagen;
    public String nombre;
    public float tarifaDia;
    public String categoria;
    public int cantidadDisponible;
    public boolean seleccionado = false;
    public int cantidadAlquiler = 0;
    public int diasAlquiler = 0;

    public Equipo() {
    }

    public Equipo(int imagen, String nombre, float tarifaDia, String categoria, int cantidadDisponible) {
        this.imagen = imagen;
        this.nombre = nombre;
        this.tarifaDia = tarifaDia;
        this.categoria = categoria;
        this.cantidadDisponible = cantidadDisponible;
    }

    @Override
    public String toString() {
        return "Equipo{" +
                "nombre='" + nombre + '\'' +
                ", tarifaDia=" + tarifaDia +
                ", categoria='" + categoria + '\'' +
                ", cantidadDisponible=" + cantidadDisponible +
                '}';
    }
}
