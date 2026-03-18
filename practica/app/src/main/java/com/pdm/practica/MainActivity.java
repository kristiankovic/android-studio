package com.pdm.practica;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

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
    public ArrayAdapter<String> adapterString;
    public ArrayList<String> srcDataString;
    public ListView dataList;
    public ArrayList<Estudiante> srcDataEstudiante;
    public ArrayAdapter<Estudiante> adapterEstudiante;

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

        // inicializacion de campos
        btnGuardar = (Button)findViewById(R.id.btnGuardar);
        spInfo     = (Spinner)findViewById(R.id.spInfo);
        txtNombre  = (TextView)findViewById(R.id.txtNombre);
        txtCarnet  = (TextView)findViewById(R.id.txtCarnet);
        //dataList   = (ListView)findViewById(R.id.dataList);

        // inicializacion de contenedores de informacion
        srcData = new ArrayList<>();

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, srcData);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //spInfo.setAdapter(adapter);

        srcDataEstudiante = new ArrayList<>();

        adapterEstudiante = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, srcDataEstudiante);
        dataList.setAdapter(adapterEstudiante);

        srcDataString = new ArrayList<>();
        srcDataString.add("Masculino");
        srcDataString.add("Femenino");

        adapterString = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, srcDataString);
        spInfo.setAdapter(adapterString);
    }

    public void guardarRegistro(View view) {

        txtNombre   = (TextView) findViewById(R.id.txtNombre);
        txtCarnet   = (TextView) findViewById(R.id.txtCarnet);
        spInfo      = (Spinner)findViewById(R.id.spInfo);
        String genero = spInfo.getSelectedItem().toString();

        Estudiante e = new Estudiante();

        if(txtNombre.getText().toString().isEmpty() || txtCarnet.getText().toString().isEmpty()){
            Toast.makeText(this, "Hay campos vacios", Toast.LENGTH_LONG).show();
        }

        else{
            e.setNombre(txtNombre.getText().toString());
            e.setCarnet(txtCarnet.getText().toString());
            e.setGenero(genero);

            srcDataEstudiante.add(e);

            adapterEstudiante.notifyDataSetChanged();

            txtNombre.setText("");
            txtCarnet.setText("");
        }
    }

    public void abrirHistorial(View view) {

        Intent intento = new Intent(MainActivity.this, MainActivity2.class);

        intento.putExtra("data", srcDataEstudiante);

        startActivity(intento);


    }
}