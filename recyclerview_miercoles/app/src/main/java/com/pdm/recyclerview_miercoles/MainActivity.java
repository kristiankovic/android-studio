package com.pdm.recyclerview_miercoles;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.pdm.recyclerview_miercoles.adapters.ProductoAdapter;
import com.pdm.recyclerview_miercoles.models.Producto;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public RecyclerView rvProductos;
    public ArrayList<Producto> productos;
    public ProductoAdapter adapter;

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
        productos = new ArrayList<>();
        adapter = new ProductoAdapter(productos);

        rvProductos = findViewById(R.id.rvProductos);

        // llenado de los datos
        productos.add(new Producto("Rastrillo", 2.50, R.drawable.rastrillo, 4));
        productos.add(new Producto("Trapiador", 1.50, R.drawable.trapiador, 10));
        productos.add(new Producto("Escoba", 0.50, R.drawable.escoba, 30));
        productos.add(new Producto("Basurero", 9.50, R.drawable.basurero, 5));

        //rvProductos.setLayoutManager(new LinearLayoutManager(this));
            rvProductos.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        //rvProductos.setLayoutManager(new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.HORIZONTAL));
        //rvProductos.setLayoutManager(new GridLayoutManager(this, 2));

        rvProductos.setAdapter(adapter);
    }
}