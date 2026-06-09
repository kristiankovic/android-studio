package com.example.lab_2_pdm.Dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.lab_2_pdm.Entitys.Articulo;

import java.util.List;

@Dao
public interface ArticuloDao {

    @Insert
    long insertArticulo(Articulo articulo);

    @Query("SELECT * FROM articulos")
    List<Articulo> getAllArticulos();

    @Query("SELECT * FROM articulos WHERE idarticulo = :idarticulo")
    Articulo getArticulo(int idarticulo);

    @Update
    int updateArticulo(Articulo articulo);

    @Delete
    int deleteArticulo(Articulo articulo);
}
