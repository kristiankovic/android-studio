package com.example.lab_2_pdm;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView navbar;
    private TextView tvTitle, tvSubtitle;
    private static final String KEY_TITLE = "header_title";
    private static final String KEY_SUBTITLE = "header_subtitle";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        // ajustando los margenes para que el contenido no se oculte tras las barras del sistema
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, 0);
            return insets;
        });

        // inicializando componentes y listeners
        setupViews();
        setupEvents();

        if (savedInstanceState != null) {
            // recuperando la informacion de los encabezados tras un cambio de configuracion
            tvTitle.setText(savedInstanceState.getString(KEY_TITLE));
            tvSubtitle.setText(savedInstanceState.getString(KEY_SUBTITLE));
        } else {
            // estableciendo la vista inicial de gestion de articulos
            updateHeader("Gestión de Artículos", "Administra el inventario de recursos disponibles");
            replaceFragment(new ArticulosFragment());
        }
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        // guardando el estado de la interfaz para preservarlo al recrear la actividad
        outState.putString(KEY_TITLE, tvTitle.getText().toString());
        outState.putString(KEY_SUBTITLE, tvSubtitle.getText().toString());
    }

    private void setupViews(){
        // vinculando las variables con los componentes visuales del layout
        navbar = findViewById(R.id.nav_bar);
        tvTitle = findViewById(R.id.tvMainTitle);
        tvSubtitle = findViewById(R.id.tvMainSubtitle);
    }


    private void setupEvents(){
        // definiendo el comportamiento al interactuar con el menu inferior
        navbar.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                int id = menuItem.getItemId();

                // evaluando que opcion fue seleccionada por el usuario
                if (id == R.id.item_1) {
                    updateHeader("Gestión de Artículos", "Administra el inventario de recursos disponibles");
                    replaceFragment(new ArticulosFragment());
                    return true;
                } else if (id == R.id.item_2) {
                    updateHeader("Gestión de Personas", "Registro y control de usuarios del sistema");
                    replaceFragment(new PersonaFragment());
                    return true;
                } else if (id == R.id.item_3) {
                    updateHeader("Gestión de Préstamos", "Control de préstamos activos y devoluciones");
                    replaceFragment(new PrestamoFragment());
                    return true;
                }

                return false;
            }
        });
    }

    private void updateHeader(String title, String subtitle) {
        // refrescando los textos del encabezado superior de la aplicacion
        if (tvTitle != null && tvSubtitle != null) {
            tvTitle.setText(title);
            tvSubtitle.setText(subtitle);
        }
    }

    private void replaceFragment(Fragment fragment) {
        // gestionando el cambio de fragmentos dentro del contenedor principal
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, fragment);
        fragmentTransaction.commit();
    }
}
