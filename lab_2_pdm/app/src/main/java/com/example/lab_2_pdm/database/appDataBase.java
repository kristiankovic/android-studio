package com.example.lab_2_pdm.database;


import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.lab_2_pdm.Convertions.Convertidor;
import com.example.lab_2_pdm.Dao.ArticuloDao;
import com.example.lab_2_pdm.Dao.CategoriaDao;
import com.example.lab_2_pdm.Dao.PersonaDao;
import com.example.lab_2_pdm.Dao.PrestamoDao;
import com.example.lab_2_pdm.Entitys.Articulo;
import com.example.lab_2_pdm.Entitys.Categoria;
import com.example.lab_2_pdm.Entitys.Persona;
import com.example.lab_2_pdm.Entitys.Prestamo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {Categoria.class, Articulo.class, Persona.class, Prestamo.class}, version = 3, exportSchema = true)
@TypeConverters({Convertidor.class})
public abstract class appDataBase extends RoomDatabase {

    public abstract CategoriaDao categoriaDao();
    public abstract ArticuloDao articuloDao();
    public abstract PersonaDao personaDao();
    public abstract PrestamoDao prestamoDao();

    private static volatile appDataBase INSTANCE;
    public static final ExecutorService databaseWriteExcecutor = Executors.newFixedThreadPool(4);

    // Migración de la versión 1 a la 2: Agregando campos apellido y direccion a la tabla personas
    static final Migration MIGRATION_1_2 = new Migration(1, 2) {
        @Override
        public void migrate(@NonNull SupportSQLiteDatabase database) {
            database.execSQL("ALTER TABLE personas ADD COLUMN apellido TEXT");
            database.execSQL("ALTER TABLE personas ADD COLUMN direccion TEXT");
        }
    };

    // Migración de la versión 2 a la 3: Agregando campo activo para borrado lógico
    static final Migration MIGRATION_2_3 = new Migration(2, 3) {
        @Override
        public void migrate(@NonNull SupportSQLiteDatabase database) {
            database.execSQL("ALTER TABLE personas ADD COLUMN activo INTEGER NOT NULL DEFAULT 1");
        }
    };

    public static appDataBase getINSTANCE(Context context) {
        if (INSTANCE == null) {
            synchronized (appDataBase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(
                            context.getApplicationContext(),
                            appDataBase.class,
                            "nexus_db"
                    )
                    .addMigrations(MIGRATION_1_2, MIGRATION_2_3)
                    .fallbackToDestructiveMigrationOnDowngrade()
                    .build();
                }
            }
        }
        return INSTANCE;
    }
}
