package com.pdm.edittext;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    public TextView saludo;

    // editText
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        // metodos automaticos
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        // enlazar elementos con el .XML
        saludo = (TextView)findViewById(R.id.txtSaludo);

        // recibir el indent enviado desde MainActivity2
        Intent intent = getIntent();

        // verificar si contiene el contenido deseado
        if(intent.hasExtra("nombre")){

            String nombre = intent.getStringExtra("nombre");
            saludo.setText(String.format("Bienvenido, %s", nombre));
        }
    }
}