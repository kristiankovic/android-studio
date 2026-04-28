package com.pdm.fragments_db.entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(tableName = "materias",
        foreignKeys = {@ForeignKey(entity = Estudiante.class,
                        parentColumns = "idEstudiante",
                        childColumns = "idEstudiante",
                        onDelete = ForeignKey.RESTRICT,
                        onUpdate = ForeignKey.NO_ACTION)})
public class Materia {
    @PrimaryKey(autoGenerate = true)
    public int idMateria;
    public int idEstudiante;
    @ColumnInfo(name = "nombre_materia")
    public String nombre;
}
