package com.pdm.parcial2_vv23011.daos;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.PrimaryKey;
import androidx.room.Query;

import com.pdm.parcial2_vv23011.entities.Ingrediente;

import java.util.List;

@Dao
public interface IngredienteDAO {

    @Insert
    long insertIngrediente(Ingrediente ingrediente);

    @Query("UPDATE ingredientes SET nombre_ingrediente=:nombre, cantidad_ingrediente=:cantidad WHERE idIngrediente=:id")
    int updateIngrediente(String nombre, String cantidad, int id);

    @Delete
    int deleteIngrediente(Ingrediente ingrediente);

    @Query("SELECT * FROM ingredientes")
    List<Ingrediente> getIngredientes();
}
