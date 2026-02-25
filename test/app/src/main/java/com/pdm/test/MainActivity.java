package com.pdm.test;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    public int numeroContador = 0;
    public TextView contador;
    public Button btnContar;
    public Button btnRestar;



    //activity -> diseño|logica

    //ciclo de vida de una activity ->

    //onCreate: primer metodo que se ejecuta, sirve para inicializar los componentes
    //onRestart: se llama despues de que se crea la aplicacion

    //onResume: vuelve a interactuar con la activity, se ejecuta cada vez que se cambie de estado
    //onPause: entra en hibernacion
    //onStop: detiene la aplicacion
    //onDestroy: finaliza la aplicacion al completo
    //onConfiguration: cambia config de la app


    //PRIMER METODO QUE SE EJECUTA AL INICIAR LA APP
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

        Log.i("LIFE_CICLE", "ON CREATE"); //permite mostrar mensajes

        // asociar las variables con el xml
        this.btnContar = findViewById(R.id.btnContador);
        this.btnRestar = findViewById(R.id.btnDecrementar);
        this.contador  = findViewById(R.id.lblContador);

        this.btnContar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //Log.i("LIFE_CICLE", "click on the button");
                numeroContador++;

                // asignar el numero del contador al lbl
                contador.setText(String.valueOf(numeroContador));
            }
        });

        this.btnRestar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                if (numeroContador != 0){
                    numeroContador--;

                    // asignar el numero del contador al lbl
                    contador.setText(String.valueOf(numeroContador));
                }

                else{
                    Toast.makeText(MainActivity.this, "Se alcanzo el valor mínimo.", Toast.LENGTH_LONG).show();
                }

            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("LIFE_CICLE","ON START");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("LIFE_CICLE","ON PAUSE");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("LIFE_CICLE","ON RESUME");
    }

    @Override
    protected void onDestroy() { // se ejecuta al cerrar la app
        super.onDestroy();
        Log.i("LIFE_CICLE","ON DESTROY");
    }

    @Override
    protected void onRestart() { // va junto al start
        super.onRestart();
        Log.i("LIFE_CICLE","ON RESTART");
    }

}