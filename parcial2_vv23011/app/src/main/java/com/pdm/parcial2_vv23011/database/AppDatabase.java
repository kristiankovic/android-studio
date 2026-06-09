package com.pdm.parcial2_vv23011.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.pdm.parcial2_vv23011.daos.IngredienteDAO;
import com.pdm.parcial2_vv23011.daos.RecetaDAO;
import com.pdm.parcial2_vv23011.entities.Ingrediente;
import com.pdm.parcial2_vv23011.entities.Receta;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {Receta.class, Ingrediente.class},
                        version = 1,
                        exportSchema = true)
public abstract class AppDatabase extends RoomDatabase {

    public abstract RecetaDAO recetaDAO();
    public abstract IngredienteDAO ingredienteDAO();

    // PATRON SINGLETON
    private static volatile AppDatabase INSTANCE;
    public static final ExecutorService dbWriterExecutor = Executors.newFixedThreadPool(4);
    public static AppDatabase getInstance(Context contexto){
        if(INSTANCE == null){
            synchronized (AppDatabase.class){
                if(INSTANCE == null){
                    INSTANCE = Room.databaseBuilder(contexto.getApplicationContext(), AppDatabase.class, "db_parcial2").build();
                }
            }
        }
        return INSTANCE;
    }
}
