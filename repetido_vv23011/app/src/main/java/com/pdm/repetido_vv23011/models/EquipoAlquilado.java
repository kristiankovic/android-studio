package com.pdm.repetido_vv23011.models;

public class EquipoAlquilado extends Equipo{
    public Equipo equipoAlquilado;
    public float total;

    public EquipoAlquilado(Equipo equipoAlquilado, float total) {
        this.equipoAlquilado = equipoAlquilado;
        this.total = total;
    }

    public EquipoAlquilado(int imagen, String nombre, float tarifaDia, String categoria, int cantidadDisponible, Equipo equipoAlquilado, float total) {
        super(imagen, nombre, tarifaDia, categoria, cantidadDisponible);
        this.equipoAlquilado = equipoAlquilado;
        this.total = total;
    }
}
