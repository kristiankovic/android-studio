package com.pdm.parcial2_vv23011;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.pdm.parcial2_vv23011.adapters.RecetaAdapter;
import com.pdm.parcial2_vv23011.database.AppDatabase;
import com.pdm.parcial2_vv23011.entities.Receta;

import java.util.List;

public class RecetaFragment extends Fragment {
    private ActivityResultLauncher<Intent> launcher;
    private FloatingActionButton btnFlotante;
    public AppDatabase db;
    public List<Receta> data;
    public RecetaAdapter adapter;
    public RecyclerView rvRecetas;


    public RecetaFragment() {

    }
    public static RecetaFragment newInstance(String param1, String param2) {
        RecetaFragment fragment = new RecetaFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        launcher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), result -> {
           if(result.getResultCode() == Activity.RESULT_OK){
               cargarDatos();
               Intent intento = result.getData();
               if(intento != null){
               }
           }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_receta, container, false);

        btnFlotante = view.findViewById(R.id.btnAgregarReceta);
        rvRecetas = view.findViewById(R.id.rvRecetas);

        btnFlotante.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent abrirActivity = new Intent(getContext(), NuevaReceta.class);
                launcher.launch(abrirActivity);
            }
        });

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        cargarDatos();
    }

    public void cargarDatos(){
        db = AppDatabase.getInstance(getContext());

        AppDatabase.dbWriterExecutor.execute(() -> {
            data = db.recetaDAO().getRecetas();

            requireActivity().runOnUiThread(() -> {
                //Toast.makeText(getContext(), "se cargo la base de datos", Toast.LENGTH_SHORT).show();

                adapter = new RecetaAdapter(getContext(), data, (receta) -> {
                    Intent data = new Intent(getContext(), NuevaReceta.class);
                    data.putExtra("id", receta.idReceta);
                    data.putExtra("nombre", receta.nombre);
                    data.putExtra("descripcion", receta.descripcion);
                    data.putExtra("porciones", receta.porciones);
                    launcher.launch(data);
                });

                rvRecetas.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
                rvRecetas.setAdapter(adapter);
            });
        });
    }
}