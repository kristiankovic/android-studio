package com.example.lab_2_pdm.Dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.lab_2_pdm.Entitys.Prestamo;

import java.util.List;

@Dao
public interface PrestamoDao {
    @Insert
    long insertPrestamo(Prestamo Prestamo);

    @Query("SELECT * FROM Prestamos")
    List<Prestamo> getAllPrestamo();

    @Query("SELECT * FROM Prestamos WHERE idPrestamo = :idPrestamo")
    Prestamo getPrestamo(int idPrestamo);

    @Update
    int updatePrestamo(Prestamo Prestamo);

    @Delete
    int deletePrestamo(Prestamo Prestamo);
}
