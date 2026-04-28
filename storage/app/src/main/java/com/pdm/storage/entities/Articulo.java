package com.pdm.storage.entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "articulos")
public class Articulo {
    @PrimaryKey(autoGenerate = true)
    public int idArticulo;
    @ColumnInfo(name = "nombre_articulo")
    public String nombre;
    @ColumnInfo(name = "descripcion_articulo")
    public String descripcion;
    @ColumnInfo(name = "categoria_articulo")
    public String categoria;
}
