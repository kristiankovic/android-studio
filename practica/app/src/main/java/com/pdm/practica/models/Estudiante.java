package com.pdm.practica.models;

public class Estudiante {

    public String nombre;
    public String carnet;

    public Estudiante() {
    }

    public Estudiante(String nombre, String carnet) {
        this.nombre = nombre;
        this.carnet = carnet;
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

    @Override
    public String toString() {
        return nombre + " || " + carnet;
    }
}
