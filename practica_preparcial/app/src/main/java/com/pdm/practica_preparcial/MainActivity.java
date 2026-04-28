 package com.pdm.practica_preparcial;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.pdm.practica_preparcial.models.CustomAdapter;
import com.pdm.practica_preparcial.models.Producto;
import com.pdm.practica_preparcial.models.ProductoModel;

import java.util.ArrayList;

 public class MainActivity extends AppCompatActivity {

    public ListView lvProductos;
    public ArrayList<Producto> data;
    public CustomAdapter adapter;

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

        // inicializacion de variables
        lvProductos = findViewById(R.id.lvPrueba);

        data = new ArrayList<>();

        data.add(new Producto("Escoba", 20, 2.50f));
        data.add(new Producto("Trapeador", 15, 3.75f));
        data.add(new Producto("Cubeta plástica", 30, 1.80f));
        data.add(new Producto("Detergente 1kg", 50, 2.10f));
        data.add(new Producto("Cloro 1L", 40, 0.90f));
        data.add(new Producto("Esponja de cocina", 100, 0.50f));
        data.add(new Producto("Bolsas para basura", 60, 1.25f));
        data.add(new Producto("Desinfectante Pino", 25, 1.50f));
        data.add(new Producto("Pala de construcción", 10, 12.00f));
        data.add(new Producto("Martillo de acero", 12, 8.50f));
        data.add(new Producto("Cinta métrica 5m", 15, 4.25f));
        data.add(new Producto("Destornillador Phillips", 20, 2.75f));
        data.add(new Producto("Alicate universal", 10, 5.50f));
        data.add(new Producto("Clavos 1 pulgada (lb)", 80, 1.10f));
        data.add(new Producto("Tornillos madera (paquete)", 100, 2.00f));
        data.add(new Producto("Lija de agua #80", 200, 0.35f));
        data.add(new Producto("Brocha de 3 pulgadas", 18, 3.20f));
        data.add(new Producto("Rodillo para pintura", 14, 4.50f));
        data.add(new Producto("Thinner 1/4 galón", 10, 2.80f));
        data.add(new Producto("Espátula de metal", 22, 1.75f));
        data.add(new Producto("Guantes de látex", 45, 1.15f));
        data.add(new Producto("Manguera 10m", 8, 15.00f));
        data.add(new Producto("Foco LED 12W", 50, 1.90f));
        data.add(new Producto("Cinta aislante negra", 35, 0.85f));
        data.add(new Producto("Pegamento de contacto", 20, 2.25f));

        //adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, data);

        adapter = new CustomAdapter(this, data);

        lvProductos.setAdapter(adapter);

        lvProductos.setOnItemClickListener((parent, view, position, id) -> {

            TextView txtNombre = (TextView)findViewById(R.id.tvNombre);
            TextView txtPrecio = (TextView)findViewById(R.id.tvDetalle);

            Producto p = data.get(position);
        });

    }
}