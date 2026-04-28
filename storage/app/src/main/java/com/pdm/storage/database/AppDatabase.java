package com.pdm.storage.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.pdm.storage.daos.DaosPrestamos;
import com.pdm.storage.entities.Articulo;
import com.pdm.storage.entities.Persona;

@Database(entities = {Persona.class, Articulo.class},
          version = 1,
          exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {
    public abstract DaosPrestamos PrestamosDAO();
}
