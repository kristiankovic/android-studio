package com.pdm.parcial2_vv23011;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    public BottomNavigationView menuBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        layout();

        menuBtn = findViewById(R.id.menuBtn);
        cargarFragmento(new HomeFragment());
        menuBtn.setOnItemSelectedListener(item -> {
            if(item.getItemId() == R.id.home){
                cargarFragmento(new HomeFragment());
                return true;
            } else if (item.getItemId() == R.id.receta) {
                cargarFragmento(new RecetaFragment());
                return true;
            } else if (item.getItemId() == R.id.ingrediente) {
                cargarFragmento(new IngredienteFragment());
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