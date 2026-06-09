package com.pdm.parcial2_vv23011.entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "recetas")
public class Receta {

    @PrimaryKey(autoGenerate = true)
    public int idReceta;

    @ColumnInfo(name = "nombre_receta")
    public String nombre;

    @ColumnInfo(name = "descripcion_receta")
    public String descripcion;

    @ColumnInfo(name = "porciones_receta")
    public int porciones;
}
