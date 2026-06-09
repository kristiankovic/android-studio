package com.pdm.parcial2_vv23011;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.result.ActivityResultLauncher;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class IngredienteFragment extends Fragment {
    private ActivityResultLauncher<Intent> launcher;
    private FloatingActionButton btnFlotante;

    public IngredienteFragment() {
        // Required empty public constructor
    }

    public static IngredienteFragment newInstance(String param1, String param2) {
        IngredienteFragment fragment = new IngredienteFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_ingrediente, container, false);

        btnFlotante = view.findViewById(R.id.btnAgregarIngrediente);

        btnFlotante.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent abrirActivity = new Intent(getContext(), NuevoIngrediente.class);
                launcher.launch(abrirActivity);
            }
        });

        return view;
    }
}