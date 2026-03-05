package com.pdm.arrays;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
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

    // spinners -> cada posicion del spinner retorna algo y funciona como un indice

    public Spinner spinnerDep;
    public ArrayList<String> listaNombres;

    // arraylist q almacena obj departamentos
    public ArrayList<Departamento> dataDep;
    public ArrayAdapter<Departamento> dataArray;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        EdgeToEdge.enable(this);

        setContentView(R.layout.activity_main);

        dataDep = new ArrayList<>();
        dataDep.add(new Departamento( "San Miguel", "101"));
        dataDep.add(new Departamento("La Union", "102"));

        // vivo con el bug
        spinnerDep = findViewById(R.id.spDep);

        // primera forma de llenar con datos (desde recursos XML):

        // uso de listas estaticas definidas en strings.xml
        // ArrayAdapter: renderiza los datos del arrayList y los convierte en vistas individuales

        //contexto, layout del item, fuente de datos
        ArrayAdapter<CharSequence> dataXML = ArrayAdapter.createFromResource(this, R.array.lista_departamentos, android.R.layout.simple_spinner_item);
        dataXML.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

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
        ArrayAdapter<String> dataStrings = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, listaNombres);

        // segunda forma de llenar con datos (desde codigo):

        // uso de los ArrayAdapter vinculado al ArrayList
        dataArray = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, dataDep);
        dataArray.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerDep.setAdapter(dataArray);

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

                // obtener el objeto seleccionado dentro del Spinner y castearlo
                Departamento dep = (Departamento)adapterView.getItemAtPosition(i);

                Toast.makeText(MainActivity.this, "Codigo Departamento: " + dep.getCodigo(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
    }

    // metodo para agregar un nuevo elemento
    public void add(View view) {

        // linkear las variables
        EditText txtNombre = (EditText)findViewById(R.id.txtNombre);
        EditText txtCodigo = (EditText)findViewById(R.id.txtCodigo);

        // instanciar el nuevo objeto
        Departamento nuevo = new Departamento();

        // obtener el texto de cada campo con .getText() y convertirlo
        nuevo.setNombreDepa(txtNombre.getText().toString());
        nuevo.setCodigo(txtCodigo.getText().toString());

        // agregar el objeto nuevo al ArrayList
        dataDep.add(nuevo);

        // notificar al adapter el nuevo cambio
        dataArray.notifyDataSetChanged();

        // limpiar los campos
        txtNombre.setText("");
        txtCodigo.setText("");
    }
}