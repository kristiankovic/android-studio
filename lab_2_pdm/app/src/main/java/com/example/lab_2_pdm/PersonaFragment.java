package com.example.lab_2_pdm;

import android.os.Bundle;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lab_2_pdm.Entitys.Persona;
import com.example.lab_2_pdm.database.appDataBase;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputEditText;

import java.util.List;
import java.util.regex.Pattern;

public class PersonaFragment extends Fragment {

    private RecyclerView rvPersonas;
    private PersonaAdapter adapter;
    private appDataBase db;

    public PersonaFragment() {
        // requerido por la plataforma para instanciar el componente correctamente
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // inicializando la interfaz grafica desde el recurso xml definido
        View view = inflater.inflate(R.layout.fragment_persona, container, false);

        // vinculando la persistencia de datos y los elementos del layout
        db = appDataBase.getINSTANCE(getContext());
        rvPersonas = view.findViewById(R.id.rvPersonas);
        FloatingActionButton fabAdd = view.findViewById(R.id.fabAddPersona);

        // configurando las acciones de edicion y borrado para cada elemento de la lista
        adapter = new PersonaAdapter(new PersonaAdapter.OnPersonaActionListener() {
            @Override
            public void onEdit(Persona persona) {
                showPersonaDialog(persona);
            }

            @Override
            public void onDelete(Persona persona) {
                confirmDelete(persona);
            }
        });

        // asignando el manejador de diseño y el adaptador al listado principal
        rvPersonas.setLayoutManager(new LinearLayoutManager(getContext()));
        rvPersonas.setAdapter(adapter);

        // activando el formulario de registro al presionar el boton de agregar
        fabAdd.setOnClickListener(v -> showPersonaDialog(null));

        // solicitando la carga inicial de informacion
        loadPersonas();

        return view;
    }

    private void loadPersonas() {
        // obteniendo el listado de personas activas desde el repositorio local
        appDataBase.databaseWriteExcecutor.execute(() -> {
            List<Persona> personas = db.personaDao().getAllPersona();
            if (getActivity() != null) {
                getActivity().runOnUiThread(() -> adapter.setPersonas(personas));
            }
        });
    }

    private void showPersonaDialog(Persona personaToEdit) {
        // construyendo el cuadro de dialogo para el ingreso o modificacion de datos
        MaterialAlertDialogBuilder builder = new MaterialAlertDialogBuilder(getContext());
        View dialogView = getLayoutInflater().inflate(R.layout.add_persona_dialog, null);
        builder.setView(dialogView);

        TextInputEditText etNombre = dialogView.findViewById(R.id.etNombrePersona);
        TextInputEditText etApellido = dialogView.findViewById(R.id.etApellidoPersona);
        TextInputEditText etContacto = dialogView.findViewById(R.id.etContactoPersona);
        TextInputEditText etDireccion = dialogView.findViewById(R.id.etDireccionPersona);

        boolean isEdit = personaToEdit != null;
        if (isEdit) {
            // preparando el formulario con los valores existentes para su actualizacion
            builder.setTitle("Editar Persona");
            etNombre.setText(personaToEdit.nombre);
            etApellido.setText(personaToEdit.apellido);
            etContacto.setText(personaToEdit.contacto);
            etDireccion.setText(personaToEdit.direccion);
        } else {
            // configurando el modo de registro para un nuevo usuario
            builder.setTitle("Registrar Persona");
        }

        builder.setPositiveButton("Guardar", (dialog, which) -> {
            String nombre = etNombre.getText().toString().trim();
            String apellido = etApellido.getText().toString().trim();
            String contacto = etContacto.getText().toString().trim();
            String direccion = etDireccion.getText().toString().trim();

            // comprobando que los campos criticos no esten vacios
            if (nombre.isEmpty() || contacto.isEmpty()) {
                Toast.makeText(getContext(), "Nombre y contacto son obligatorios", Toast.LENGTH_SHORT).show();
                return;
            }

            // verificando que el formato del contacto sea un telefono o un correo valido
            if (!isValidContacto(contacto)) {
                Toast.makeText(getContext(), "Contacto inválido. Use formato xxxx-xxxx o un email válido.", Toast.LENGTH_LONG).show();
                return;
            }

            Persona p = isEdit ? personaToEdit : new Persona();
            p.nombre = nombre;
            p.apellido = apellido;
            p.contacto = contacto;
            p.direccion = direccion;

            // persistiendo los cambios de forma asincrona en la base de datos
            appDataBase.databaseWriteExcecutor.execute(() -> {
                if (isEdit) {
                    db.personaDao().updatePersona(p);
                } else {
                    db.personaDao().insertPersona(p);
                }
                loadPersonas();
            });
        });

        builder.setNegativeButton("Cancelar", null);
        builder.create().show();
    }

    private boolean isValidContacto(String contacto) {
        // aplicando expresiones regulares para validar el formato de entrada
        Pattern phonePattern = Pattern.compile("^[0-9]{4}-[0-9]{4}$");
        boolean isPhone = phonePattern.matcher(contacto).matches();

        // comprobando contra el patron estandar de correos electronicos de android
        boolean isEmail = Patterns.EMAIL_ADDRESS.matcher(contacto).matches();

        return isPhone || isEmail;
    }

    private void confirmDelete(Persona persona) {
        // solicitando confirmacion antes de proceder con el borrado logico
        new MaterialAlertDialogBuilder(getContext())
                .setTitle("Eliminar Persona")
                .setMessage("¿Estás seguro de que deseas eliminar a " + persona.nombre + "?")
                .setPositiveButton("Eliminar", (dialog, which) -> {
                    appDataBase.databaseWriteExcecutor.execute(() -> {
                        // marcando el registro como inactivo en lugar de eliminarlo fisicamente
                        persona.activo = false;
                        db.personaDao().updatePersona(persona);
                        loadPersonas();
                    });
                })
                .setNegativeButton("Cancelar", null)
                .show();
    }
}
