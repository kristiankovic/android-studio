package com.pdm.fragments_db.entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "estudiantes")
public class Estudiante {
    @PrimaryKey(autoGenerate = true)
    public int idEstudiante;
    @ColumnInfo(name = "nombre_estudiante")
    public String nombre;
    @ColumnInfo(name = "carrera_estudiante")
    public String carrera;
    @ColumnInfo(name = "carnet_estudiante")
    public String carnet;
}
