package com.example.lab_2_pdm.Entitys;

import androidx.room.Embedded;
import androidx.room.Relation;

public class ArticuloConCategoria {
    @Embedded
    public Articulo articulo;

    @Relation(
            parentColumn = "idcategoria",
            entityColumn = "idcategoria"
    )
    public Categoria categoria;
}
