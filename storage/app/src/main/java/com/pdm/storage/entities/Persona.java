package com.pdm.storage.entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "personas")
public class Persona {
    @PrimaryKey(autoGenerate = true)
    public int idPersona;
    @ColumnInfo(name = "nombre_persona")
    public String nombre;
    @ColumnInfo(name = "tel_persona")
    public String telefono;
}
