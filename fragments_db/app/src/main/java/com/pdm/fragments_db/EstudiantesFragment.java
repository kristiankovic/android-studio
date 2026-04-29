package com.pdm.fragments_db;

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

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.pdm.fragments_db.adapters.CustomAdapter;
import com.pdm.fragments_db.database.AppDatabase;
import com.pdm.fragments_db.entities.Estudiante;

import java.util.List;

public class EstudiantesFragment extends Fragment {
    private FloatingActionButton btnAgregar;
    private ActivityResultLauncher<Intent> launcher;
    public List<Estudiante> data;
    public CustomAdapter adapter;
    public RecyclerView rvEstudiantes;
    public AppDatabase db;

    public EstudiantesFragment() {}
    public static EstudiantesFragment newInstance() {
        EstudiantesFragment fragment = new EstudiantesFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        launcher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), result -> {
                    if (result.getResultCode() == Activity.RESULT_OK) {
                        cargarDatos();
                        Intent data = result.getData();
                        if (data != null) {
                            Toast.makeText(getContext(), "REGISTRO GUARDADO ", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
        );
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_estudiantes, container, false);
        btnAgregar = view.findViewById(R.id.floatingBtn);
        rvEstudiantes = view.findViewById(R.id.rvEstudiantes);

        btnAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intento = new Intent(getContext(), MainActivity2.class);
                launcher.launch(intento);
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

        AppDatabase.dataWriterExecutor.execute(() -> {

            data = db.estudianteDAO().getEstudiantes();

            requireActivity().runOnUiThread(() -> {
                adapter = new CustomAdapter(getContext(), data);
                rvEstudiantes.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
                rvEstudiantes.setAdapter(adapter);
            });
        });
    }
}