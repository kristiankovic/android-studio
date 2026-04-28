package com.pdm.fragments_db;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    private BottomNavigationView menu;
    private ActivityResultLauncher<Intent> launcher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        layout();
        cargarFragmento(new HomeFragment());
        menu = findViewById(R.id.menuBtn);
        menu.setOnItemSelectedListener(item -> {
            if(item.getItemId() == R.id.home){
                cargarFragmento(new HomeFragment());
                return true;
            } else if (item.getItemId() == R.id.estudiantes) {
                cargarFragmento(new EstudiantesFragment());
                return true;
            }
            return false;
        });


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
    private void cargarFragmento(Fragment fragmento){
        getSupportFragmentManager().beginTransaction().replace(R.id.container, fragmento).commit();
    }
}