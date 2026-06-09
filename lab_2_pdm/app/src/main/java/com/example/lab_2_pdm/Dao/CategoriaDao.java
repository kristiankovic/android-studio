package com.example.lab_2_pdm.Dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.lab_2_pdm.Entitys.Categoria;

import java.util.List;

@Dao
public interface CategoriaDao {

    @Insert
    long insertCategoria(Categoria categoria);

    @Query("SELECT * FROM categorias")
    List<Categoria> getAllCategoria();

    @Query("SELECT * FROM categorias WHERE idcategoria = :idcategoria")
    Categoria getCategoria(int idcategoria);

    @Update
    int updateCategoria(Categoria categoria);

    @Delete
    int deleteCategoria(Categoria categoria);


}