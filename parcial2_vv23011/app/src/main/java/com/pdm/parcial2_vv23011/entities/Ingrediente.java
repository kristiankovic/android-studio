package com.pdm.parcial2_vv23011.entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(tableName = "ingredientes",
        foreignKeys = {@ForeignKey(entity = Receta.class,
                                    parentColumns = "idReceta",
                                    childColumns = "idReceta",
                                    onDelete = ForeignKey.CASCADE,
                                    onUpdate = ForeignKey.NO_ACTION)})
public class Ingrediente {
    @PrimaryKey(autoGenerate = true)
    public int idIngrediente;
    public int idReceta;
    @ColumnInfo(name = "nombre_ingrediente")
    public String nombre;

    @ColumnInfo(name = "cantidad_ingrediente")
    public String cantidad;
}
