package com.pdm.arrays;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    // spiners -> cada posicion del spiner retorna algo

    public Spinner spinnerDep;
    public Spinner spinnerDep1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        EdgeToEdge.enable(this);

        setContentView(R.layout.activity_main);

        // vivo con el bug
        spinnerDep = findViewById(R.id.spDep);

        // los lee ya de una fuente que esta en el xml
        ArrayAdapter<CharSequence> data = ArrayAdapter.createFromResource(this, R.array.lista_departamentos, android.R.layout.simple_spinner_item);
        data.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // adapters ->
        spinnerDep.setAdapter(data);

        // usando el constructor
        ArrayList<String> listaNombres = new ArrayList<>();

        // asignacion de datos
        listaNombres.add("Uluazapa");
        listaNombres.add("Uluazapa");
        listaNombres.add("Uluazapa");
        listaNombres.add("Uluazapa");

        // adaptador
        ArrayAdapter<String> datos = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, listaNombres);
        spinnerDep1.setAdapter(datos);
    }
}