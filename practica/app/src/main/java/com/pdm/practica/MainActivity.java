package com.pdm.practica;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.pdm.practica.models.Estudiante;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public Button btnGuardar;
    public Spinner spInfo;
    public TextView txtNombre, txtCarnet;
    public ArrayList<Estudiante> srcData;
    public ArrayAdapter<Estudiante> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        btnGuardar = (Button)findViewById(R.id.btnGuardar);
        spInfo     = (Spinner)findViewById(R.id.spInfo);
        txtNombre  = (TextView)findViewById(R.id.txtNombre);
        txtCarnet  = (TextView)findViewById(R.id.txtCarnet);

        srcData = new ArrayList<>();
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, srcData);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spInfo.setAdapter(adapter);

        srcData.add(new Estudiante("Cristian Ventura", "VV23011"));
        srcData.add(new Estudiante("María López", "ML23012"));
        srcData.add(new Estudiante("José Martínez", "JM23013"));
        srcData.add(new Estudiante("Ana González", "AG23014"));
        srcData.add(new Estudiante("Luis Hernández", "LH23015"));
        srcData.add(new Estudiante("Carla Ramírez", "CR23016"));
        srcData.add(new Estudiante("Pedro Castillo", "PC23017"));
        srcData.add(new Estudiante("Sofía Torres", "ST23018"));
        srcData.add(new Estudiante("Diego Cruz", "DC23019"));
        srcData.add(new Estudiante("Valeria Morales", "VM23020"));

    }

    public void guardarRegistro(View view) {

        txtNombre   = (TextView) findViewById(R.id.txtNombre);
        txtCarnet   = (TextView) findViewById(R.id.txtCarnet);

        Estudiante e = new Estudiante();

        e.setNombre(txtNombre.getText().toString());
        e.setCarnet(txtCarnet.getText().toString());

        srcData.add(e);

        adapter.notifyDataSetChanged();

        txtNombre.setText("");
        txtCarnet.setText("");
    }
}