package com.pdm.parcial2_vv23011.daos;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.pdm.parcial2_vv23011.entities.Receta;

import java.util.List;

@Dao
public interface RecetaDAO {
    @Insert
    long insertReceta(Receta receta);

    @Query("UPDATE recetas SET nombre_receta=:nombre, descripcion_receta=:descripcion, porciones_receta=:porciones WHERE idReceta=:id")
    int updateReceta(String nombre, String descripcion, int porciones, int id);

    @Query("SELECT * FROM recetas")
    List<Receta> getRecetas();

    @Delete
    int deleteReceta(Receta receta);
}