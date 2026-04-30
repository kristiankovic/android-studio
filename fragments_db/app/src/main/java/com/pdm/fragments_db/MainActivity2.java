package com.pdm.fragments_db;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.textfield.TextInputEditText;
import com.pdm.fragments_db.database.AppDatabase;
import com.pdm.fragments_db.entities.Estudiante;

public class MainActivity2 extends AppCompatActivity {
    private AppDatabase db;
    public TextInputEditText txtNombre, txtCarrera, txtCarnet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        layout();

        txtNombre = findViewById(R.id.txtNombre);
        txtCarrera = findViewById(R.id.txtCarrera);
        txtCarnet = findViewById(R.id.txtCarnet);

        Intent data = getIntent();

        if(data != null){
            txtNombre.setText(data.getStringExtra("nombre"));
            txtCarrera.setText(data.getStringExtra("carrera"));
            txtCarnet.setText(data.getStringExtra("carnet"));
        }
    }

    public void layout(){
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    public void regresar(View view) {
        Intent data = new Intent();
        data.putExtra("state", "exito");
        setResult(Activity.RESULT_CANCELED, data);
        finish();
    }

    public void guardar(View view) {

        String nombre = txtNombre.getText().toString().trim();
        String carrera = txtCarrera.getText().toString().trim();
        String carnet = txtCarnet.getText().toString().trim();

        if (nombre.isEmpty() || carrera.isEmpty() || carnet.isEmpty()) {
            Toast.makeText(this, "rellene todos los campos", Toast.LENGTH_SHORT).show();
        } else {

            db = AppDatabase.getInstance(getApplicationContext());

            AppDatabase.dataWriterExecutor.execute(() -> {

                Intent intent = getIntent();

                if(intent.hasExtra("id")){
                    int id = intent.getIntExtra("id", -1);
                    db.estudianteDAO().updateEstudiante(nombre, carrera, carnet, id);
                }

                else {
                    Estudiante e = new Estudiante();

                    e.nombre = nombre;
                    e.carrera = carrera;
                    e.carnet = carnet;

                    db.estudianteDAO().insertEstudiante(e);
                }

                runOnUiThread(() -> {
                    Intent data = new Intent();
                    data.putExtra("state", "exito");
                    setResult(Activity.RESULT_OK, data);
                    finish();
                });
            });
        }
    }
}