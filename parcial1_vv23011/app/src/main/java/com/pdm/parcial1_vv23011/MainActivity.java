package com.pdm.parcial1_vv23011;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.pdm.parcial1_vv23011.models.Producto;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public ArrayList<Producto> productos;
    public CustomAdapter adaptador;
    public ListView lvProductos;
    public ArrayList<String> dataCategorias;
    public ArrayAdapter<String> adaptadorStrig;

    public ArrayList<Producto> productosComprados;

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

        // incializacion de variables
        lvProductos = findViewById(R.id.lvProductos);

        dataCategorias = new ArrayList<>();
        productos = new ArrayList<>();
        productosComprados = new ArrayList<>();

        dataCategorias.add("Construccion");
        dataCategorias.add("Hogar");
        dataCategorias.add("Informatica");

        productos.add(new Producto(R.drawable.img, "Escoba", 2.50f, "Hogar"));
        productos.add(new Producto(R.drawable.img_1, "Martillo", 3.75f, "Construccion"));
        productos.add(new Producto(R.drawable.img_2, "Clavos 1/2", 1.25f, "Construccion"));
        productos.add(new Producto(R.drawable.img_3, "Tableta Samsung", 200.00f, "Informatica"));
        productos.add(new Producto(R.drawable.img_4, "Pala", 6.70f, "Construccion"));

        adaptador = new CustomAdapter(this, productos);
        lvProductos.setAdapter(adaptador);
    }

    public void comprar(View view) {
        for(Producto item : productos){
            if(item.comprado){
                productosComprados.add(item);
                Log.d("VENTA", "Producto: " + item.getNombre());
            }
        }
    }
}