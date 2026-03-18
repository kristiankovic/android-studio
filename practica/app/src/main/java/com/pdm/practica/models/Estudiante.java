package com.pdm.practica.models;

public class Estudiante {

    public String nombre;
    public String carnet;
    public String genero;

    public Estudiante() {
    }

    public Estudiante(String nombre, String carnet, String genero) {
        this.nombre = nombre;
        this.carnet = carnet;
        this.genero = genero;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCarnet() {
        return carnet;
    }

    public void setCarnet(String carnet) {
        this.carnet = carnet;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    @Override
    public String toString() {
        return nombre + " | " + carnet;
    }
}
