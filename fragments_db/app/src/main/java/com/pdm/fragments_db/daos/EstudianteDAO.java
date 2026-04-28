package com.pdm.fragments_db.daos;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.pdm.fragments_db.entities.Estudiante;

import java.util.List;

@Dao
public interface EstudianteDAO {

    @Insert
    long insertEstudiante(Estudiante estudiante);

    @Query("SELECT * FROM estudiantes")
    List<Estudiante> getEstudiantes();

    @Update
    int updateEstudiante(Estudiante estudiante);

    @Query("DELETE FROM estudiantes WHERE idEstudiante=:id")
    int deleteEstudiante(int id);
}
