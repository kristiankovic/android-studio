package com.pdm.recyclerview.models;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.pdm.recyclerview.R;

import java.util.ArrayList;
import java.util.List;

public class AdaptadorProducto extends RecyclerView.Adapter<AdaptadorProducto.ViewHolder> {

    private Context context;
    private ArrayList<Producto> data;

    @Override
    public int getItemCount() {
        return 0;
    }

    // constructor
    public AdaptadorProducto(Context context, ArrayList<Producto> data) {
        this.context = context;
        this.data = data;
    }



    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {



    }

    // se encarga de crear la estructura visual de cada fila (el contenedor)
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_main, parent, false);
        return new ViewHolder(view);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        // declaracion de los elementos que ya estan en el xml
        public TextView txtNombre, txtPrecio;
        public ImageView imgProducto;
        public Button btnEliminar;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            // vinvular las variables con los ids del xml
            txtNombre = itemView.findViewById(R.id.txtNombre);
            txtPrecio = itemView.findViewById(R.id.txtPrecio);
            imgProducto = itemView.findViewById(R.id.imgView);

            btnEliminar =itemView.findViewById(R.id.btnEliminar);
        }
    }
}
