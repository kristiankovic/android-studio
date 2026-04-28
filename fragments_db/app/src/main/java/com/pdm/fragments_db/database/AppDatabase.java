package com.pdm.fragments_db.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.pdm.fragments_db.daos.EstudianteDAO;
import com.pdm.fragments_db.entities.Estudiante;
import com.pdm.fragments_db.entities.Materia;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {Estudiante.class, Materia.class}, version = 1, exportSchema = true)
public abstract class AppDatabase extends RoomDatabase {

    public abstract EstudianteDAO estudianteDAO();

    public static volatile AppDatabase INSTANCE;

    public static final ExecutorService dataWriterExecutor = Executors.newFixedThreadPool(4);

    public static AppDatabase getInstance(Context contexto){

        if(INSTANCE == null){
            synchronized (AppDatabase.class){
                if(INSTANCE == null){
                    INSTANCE = Room.databaseBuilder(contexto.getApplicationContext(), AppDatabase.class, "db_estudiantes").build();
                }
            }
        }
        return INSTANCE;
    }
}
