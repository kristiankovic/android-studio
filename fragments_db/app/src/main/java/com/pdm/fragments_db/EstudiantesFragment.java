package com.pdm.fragments_db;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link EstudiantesFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class EstudiantesFragment extends Fragment {
    private FloatingActionButton btnAgregar;
    private ActivityResultLauncher<Intent> launcher;

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

                        Intent data = result.getData();

                        if (data != null) {
                            String respuesta = data.getStringExtra("state");
                            Toast.makeText(getContext(), "Recibido: " + respuesta, Toast.LENGTH_SHORT).show();
                        }
                    }

                    else if (result.getResultCode() == Activity.RESULT_CANCELED) {
                        Log.d("KEY", "El usuario regresó sin guardar nada");
                    }
                }
        );
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_estudiantes, container, false);
        btnAgregar = view.findViewById(R.id.floatingBtn);

        btnAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intento = new Intent(getContext(), MainActivity2.class);
                launcher.launch(intento);
            }
        });
        return view;
    }
}