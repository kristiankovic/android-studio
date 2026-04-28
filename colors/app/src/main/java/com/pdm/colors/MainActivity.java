package com.pdm.colors;

import android.os.Bundle;
import android.widget.LinearLayout;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.pdm.colors.adapters.ListAdapter;
import com.pdm.colors.models.ListElement;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public ArrayList<ListElement> contactos;
    public ListAdapter adapter;
    public RecyclerView rvItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        layout();

        inicializar();

        adapter = new ListAdapter(this, contactos);
        rvItems = findViewById(R.id.rvLista);

        rvItems.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        rvItems.setAdapter(adapter);
    }

    public void inicializar(){
        contactos = new ArrayList<>();

        contactos.add(new ListElement("#FF5733", "Juan Pérez", "San Salvador", "7000-1111", "Activo"));
        contactos.add(new ListElement("#33FF57", "María López", "Santa Ana", "7000-2222", "Inactivo"));
        contactos.add(new ListElement("#3357FF", "Carlos Ruiz", "San Miguel", "7000-3333", "Activo"));
        contactos.add(new ListElement("#F333FF", "Ana García", "La Libertad", "7000-4444", "Activo"));
        contactos.add(new ListElement("#FF33A1", "Roberto Sosa", "Sonsonate", "7000-5555", "Inactivo"));
        contactos.add(new ListElement("#33FFF3", "Elena Torres", "Ahuachapán", "7000-6666", "Activo"));
        contactos.add(new ListElement("#A1FF33", "Luis Méndez", "Usulután", "7000-7777", "Inactivo"));
        contactos.add(new ListElement("#8D33FF", "Sofía Castro", "San Vicente", "7000-8888", "Activo"));
        contactos.add(new ListElement("#FF8D33", "Diego Rivas", "Cuscatlán", "7000-9999", "Inactivo"));
        contactos.add(new ListElement("#33FFBD", "Lucía Meza", "La Paz", "7000-0000", "Activo"));
        contactos.add(new ListElement("#BD33FF", "Fernando Gil", "Cabañas", "7000-1212", "Inactivo"));
        contactos.add(new ListElement("#FFBD33", "Gabriela Paz", "Chalatenango", "7000-2323", "Activo"));
        contactos.add(new ListElement("#33DBFF", "Ricardo Vigil", "Morazán", "7000-3434", "Inactivo"));
        contactos.add(new ListElement("#DBFF33", "Valeria Sol", "La Unión", "7000-4545", "Activo"));
        contactos.add(new ListElement("#FF3333", "Jorge Blanco", "San Salvador", "7000-5656", "Inactivo"));
        contactos.add(new ListElement("#33FF33", "Patricia Noel", "Santa Ana", "7000-6767", "Activo"));
        contactos.add(new ListElement("#3333FF", "Andrés Luna", "San Miguel", "7000-7878", "Activo"));
        contactos.add(new ListElement("#FFFF33", "Mónica Jara", "La Libertad", "7000-8989", "Inactivo"));
        contactos.add(new ListElement("#FF33FF", "Héctor Valente", "Sonsonate", "7000-9090", "Activo"));
        contactos.add(new ListElement("#33FFFF", "Beatriz Peña", "San Salvador", "7000-0101", "Ocupado"));
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
}