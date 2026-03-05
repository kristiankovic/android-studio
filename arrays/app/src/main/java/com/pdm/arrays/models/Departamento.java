package com.pdm.arrays.models;

public class Departamento {

    private String nombreDepa;
    private String codigo;

    public Departamento() {
    }

    public Departamento(String nombreDepa, String codigo) {
        this.nombreDepa = nombreDepa;
        this.codigo = codigo;
    }

    public String getNombreDepa() {
        return nombreDepa;
    }

    public void setNombreDepa(String nombreDepa) {
        this.nombreDepa = nombreDepa;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    @Override
    public String toString() {
        // esto se muestra en el front
        return nombreDepa;
    }
}
