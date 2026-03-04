package com.pdm.arrays;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.pdm.arrays.models.Departamento;

import java.util.ArrayList;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    // spiners -> cada posicion del spiner retorna algo y funciona como un indice

    public Spinner spinnerDep;
    public Spinner spinnerDep1;
    public ArrayList<String> listaNombres;

    // arraylist q almacena obj departamentos
    public ArrayList<Departamento> dataDep;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        EdgeToEdge.enable(this);

        setContentView(R.layout.activity_main);

        dataDep = new ArrayList<>();
        dataDep.add(new Departamento("101", "San Miguel"));
        dataDep.add(new Departamento("102", "La Union"));

        // vivo con el bug
        spinnerDep = findViewById(R.id.spDep);

        // los lee ya de una fuente que esta en el xml
        ArrayAdapter<CharSequence> data = ArrayAdapter.createFromResource(this, R.array.lista_departamentos, android.R.layout.simple_spinner_item);
        data.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // adapters ->
        //spinnerDep.setAdapter(data);


        // usando el constructor
        listaNombres = new ArrayList<>();

        // asignacion de datos
        listaNombres.add("Uluazapa");
        listaNombres.add("Guazapa");
        listaNombres.add("San Bartolo");
        listaNombres.add("La Perla");

        // adaptador
        //ArrayAdapter<String> datos = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, listaNombres);

        ArrayAdapter<Departamento> datos = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, dataDep);
        datos.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerDep.setAdapter(datos);

        // sale del contexto de la app y entra en la de layout
        spinnerDep.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                // captura el indice del objeto seleccionado
                //Toast.makeText(MainActivity.this, "Indice" +i, Toast.LENGTH_SHORT).show();
                //String selectedIndex = adapterView.getItemAtPosition(i).toString();

                // otras formas para hacerlo
                //String selectedIndex = listaNombres.get(i);
                //String selectedIndex2 = spinnerDep.getSelectedItem().toString();

                // para capturar todo el objeto
                Departamento dep = (Departamento)adapterView.getItemAtPosition(i);

                Toast.makeText(MainActivity.this, "Codigo Departamento: " + dep.getNombreDepa(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
}