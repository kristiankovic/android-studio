package com.pdm.parcial1;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.pdm.parcial1.adapters.ProductoAdapter;
import com.pdm.parcial1.models.Producto;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public ProductoAdapter adapter;
    public ArrayList<Producto> data;
    public RecyclerView rvProductos;

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

        // enlazar las variables
        rvProductos = findViewById(R.id.rvPrincipal);

        // inicializar las variables
        data = new ArrayList<>();

        data.add(new Producto(R.drawable.pala_redonda, 10, "Pala de Punta Redonda", 15.50f));
        data.add(new Producto(R.drawable.serrucho, 34, "Serrucho ", 10.50f));
        data.add(new Producto(R.drawable.martillo, 100, "Martillo", 8.25f));
        data.add(new Producto(R.drawable.destornillador, 20, "Destornillador Phillips", 3.75f));
        data.add(new Producto(R.drawable.llave_inglesa, 15, "Llave Inglesa 10\"", 12.00f));

        adapter = new ProductoAdapter(data);

        // definir la orientacion del recylerview
        rvProductos.setLayoutManager(new LinearLayoutManager(this,  LinearLayoutManager.HORIZONTAL, false));

        // asignarle el adaptador
        rvProductos.setAdapter(adapter);
    }
}