package com.pdm.colors;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.pdm.colors.models.ListElement;

import java.util.ArrayList;

public class EditContact extends AppCompatActivity {

    public EditText nombre, ciudad, telefono;
    public Button btnEnviar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        layout();

        nombre = findViewById(R.id.etNombre);
        ciudad = findViewById(R.id.etCiudad);
        telefono = findViewById(R.id.etTelefono);
        btnEnviar = findViewById(R.id.btnGuardar);

        Intent intento = getIntent();

        // deserializar el objeto
        ListElement item = (ListElement) intento.getSerializableExtra("contacto");
        int posicion = getIntent().getIntExtra("posicion", -1);

        nombre.setText(item.getName());
        ciudad.setText(item.getCity());
        telefono.setText(item.getNumber());

        Toast.makeText(this, "pos: " + posicion, Toast.LENGTH_SHORT).show();

        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String nombreT = nombre.getText().toString().trim();
                String ciudadT = ciudad.getText().toString().trim();
                String telefonoT = telefono.getText().toString().trim();

                if (nombreT.isEmpty() || ciudadT.isEmpty() || telefonoT.isEmpty()){
                    Toast.makeText(EditContact.this, "Los campos son obligatorios", Toast.LENGTH_SHORT).show();
                    return;
                }

                if(telefonoT.length() > 8){
                    Toast.makeText(EditContact.this, "Cambie el formato de telefono.", Toast.LENGTH_SHORT).show();
                    return;
                }

                item.setName(nombreT);
                item.setCity(ciudadT);
                item.setNumber(telefonoT);

                Toast.makeText(EditContact.this, "!Registro actualizado!", Toast.LENGTH_SHORT).show();
                volverInicio(null);
            }
        });

    }

    public void layout(){
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_edit_contact);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void volverInicio(View view) {
        Intent intento = new Intent(this, MainActivity.class);
        startActivity(intento);
    }

}