package com.pdm.lab1;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.pdm.lab1.models.Producto;
import com.pdm.lab1.models.ProductoComprado;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public Spinner spProductos;
    public ArrayList<Producto> srcData;
    public ArrayAdapter<Producto> adapter;
    public EditText txtCantidad;
    public TextView txtTotal;
    public ArrayList<ProductoComprado> productosComprados;
    public Button btnComprar;

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

        spProductos = findViewById(R.id.spProductos);
        btnComprar  = findViewById(R.id.btnAgregar);

        productosComprados = new ArrayList<>();

        srcData = new ArrayList<>();
        srcData.add(new Producto("Cemento", 8.50f));
        srcData.add(new Producto("Arena", 3.00f));
        srcData.add(new Producto("Ladrillo", 0.75f));
        srcData.add(new Producto("Pintura", 12.00f));

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, srcData);
        spProductos.setAdapter(adapter);

        // iteracion de los productos guardados

    }

    public void venta(View view) {

        txtCantidad = (EditText)findViewById(R.id.txtCantidad);

        if(txtCantidad.getText().toString().isEmpty()) {
            txtCantidad.setError("Este campo es obligatorio");
        }

        else{

            txtTotal = (TextView)findViewById(R.id.txtTotal);

            int cantidad = Integer.parseInt(txtCantidad.getText().toString());

            Producto pTemp = (Producto) spProductos.getSelectedItem();

            float total = cantidad * pTemp.getPrecio();

            // guardar los productos comprados en un arreglo
            productosComprados.add(new ProductoComprado(pTemp, total));

            txtTotal.setText("Total de la venta $" + total);
            //Toast.makeText(this, String.valueOf(total), Toast.LENGTH_SHORT).show();

            txtCantidad.setText("");

            Log.i("TOTAL_VENTA", "Producto: " + pTemp.nombre + " | Total: $" + total);
        }
    }
}