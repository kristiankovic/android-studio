package com.pdm.parcial2_vv23011;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.textfield.TextInputEditText;
import com.pdm.parcial2_vv23011.database.AppDatabase;
import com.pdm.parcial2_vv23011.entities.Receta;

public class NuevaReceta extends AppCompatActivity {

    public TextInputEditText txtNombre, txtDescripcion, txtPorciones;
    private AppDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        layout();

        txtNombre = findViewById(R.id.txtNombreReceta);
        txtDescripcion = findViewById(R.id.txtDescripcionReceta);
        txtPorciones = findViewById(R.id.txtPorcionesReceta);

        Intent dataRecibida = getIntent();

        if(dataRecibida != null){
            txtNombre.setText(dataRecibida.getStringExtra("nombre"));
            txtDescripcion.setText(dataRecibida.getStringExtra("descripcion"));
            txtPorciones.setText(String.valueOf(dataRecibida.getIntExtra("porciones", 0)));
        }

    }

    public void layout(){
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_nueva_receta);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    public void regresar(View view) {
        Intent data = new Intent();
        data.putExtra("state", "cancelado");
        setResult(Activity.RESULT_CANCELED, data);
        finish();
    }

    public void guardar(View view) {

        String nombre = txtNombre.getText().toString().trim();
        String descripcion = txtDescripcion.getText().toString().trim();
        int porciones = Integer.parseInt(txtPorciones.getText().toString().trim());

        if(nombre.isEmpty() || descripcion.isEmpty() || (porciones < 1)){
            Toast.makeText(this, "Rellene los campos", Toast.LENGTH_SHORT).show();
        }

        else{
            db = AppDatabase.getInstance(getApplicationContext());

            AppDatabase.dbWriterExecutor.execute(() -> {
                Receta r = new Receta();

                r.nombre = nombre;
                r.descripcion = descripcion;
                r.porciones = porciones;

                db.recetaDAO().insertReceta(r);

                runOnUiThread(() -> {
                    Intent data = new Intent();
                    data.putExtra("state", "exito");
                    setResult(Activity.RESULT_OK);
                    finish();
                });
            });
        }
    }
}