package com.pdm.repetido_vv23011;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.pdm.repetido_vv23011.adapters.CustomAdapter;
import com.pdm.repetido_vv23011.models.Equipo;
import com.pdm.repetido_vv23011.models.EquipoAlquilado;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    public ArrayList<Equipo> data;
    public CustomAdapter adapter;
    public ListView lvEquipos;
    public Button btnProceder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        layout();

        // inicializado de variables
        data = new ArrayList<>();
        adapter = new CustomAdapter(this, data);
        lvEquipos = findViewById(R.id.lvEquipos);
        btnProceder = findViewById(R.id.button);

        data.add(new Equipo(R.drawable.mic,"Microfono", 5, "Sonido", 20));
        data.add(new Equipo(R.drawable.camara,"Camara", 10, "Fotografia", 5));
        data.add(new Equipo(R.drawable.mouse,"Mouse", 0.50f, "Perifericos de computadora", 50));
        data.add(new Equipo(R.drawable.laptop,"Laptop", 35, "Laptop", 3));
        data.add(new Equipo(R.drawable.usb,"Memoria USB", 1, "Almacenamiento", 30));
        data.add(new Equipo(R.drawable.tv,"Television", 5, "Entretenimiento", 5));
        data.add(new Equipo(R.drawable.telefono,"Telefono", 5, "Telefonos", 10));
        data.add(new Equipo(R.drawable.headset,"Audifonos", 5, "Perifericos de computadora", 20));

        lvEquipos.setAdapter(adapter);
    }

    public void layout(){
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void proceder(View view) {

        ArrayList<EquipoAlquilado> alquilados = new ArrayList<>();

        for (Equipo item : data){
            if(item.seleccionado){
                float total = item.diasAlquiler * item.tarifaDia;
                EquipoAlquilado e = new EquipoAlquilado(item, total);
                alquilados.add(e);
            }
        }

        if (alquilados.isEmpty()){
            Toast.makeText(view.getContext(), "Seleccione uno o mas items.", Toast.LENGTH_SHORT).show();
        }

        for (EquipoAlquilado item : alquilados){
            Log.d("APP", "ITEM: " + item.equipoAlquilado.nombre + " | TOTAL: $" + item.total);
        }
    }
}