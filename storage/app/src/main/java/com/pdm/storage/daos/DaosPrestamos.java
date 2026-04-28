package com.pdm.storage.daos;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.pdm.storage.entities.Articulo;
import com.pdm.storage.entities.Persona;

import java.util.List;

@Dao
public interface DaosPrestamos {

    //CRUD de personas
    @Insert
    long insertPersona(Persona p);

    @Query("SELECT * FROM personas")
    List<Persona> getPersonas();

    @Update
    int updatePersona(Persona p);

    @Delete
    int deletePersona(Persona p);

    @Query("DELETE FROM personas WHERE idPersona=:id")
    int deletePersona(int id);


    // CRUD para los articulos
    @Insert
    long insertArticulo(Articulo a);

    @Query("SELECT * FROM articulos")
    List<Articulo> getArticulos();

    @Update
    int updateArticulo(Articulo a);

    @Delete
    int deleteArticulo(Articulo a);

    @Query("DELETE FROM articulos WHERE idArticulo=:id")
    int deleteArticulo(int id);
}
