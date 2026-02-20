package com.example.helloworld;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import models.Alumno;

public class MainActivity extends AppCompatActivity {

    //Declarar las variables para los elementos de la interfaz
    private EditText studentName, studentID;
    private TextView msgSaludo;
    private Button btnSaludar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        //Enlazar con el XML
        studentName     = findViewById(R.id.studentName);
        studentID       = findViewById(R.id.studenID);
        msgSaludo       = findViewById(R.id.msgSaludo);
        btnSaludar      = findViewById(R.id.btnSaludar);

        btnSaludar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View vista){

                String name = studentName.getText().toString();
                String id = studentID.getText().toString();

                //Crear el objeto
                Alumno alumno = new Alumno();

                //Imprimir en pantalla
                msgSaludo.setText(String.format("¡Bienvenido %s! \nTu registro con id: %s ha sido exitoso.", name, id));

                //Limpiar campos
                studentName.setText("");
                studentID.setText("");

                //Devolver el foco al primer registro
                studentName.requestFocus();
            }
        });

    }
}