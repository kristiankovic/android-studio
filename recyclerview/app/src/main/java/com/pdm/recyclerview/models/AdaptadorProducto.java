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
    private ArrayList<Producto> data;

    // constructor
    public AdaptadorProducto(ArrayList<Producto> data) {
        this.data = data;
    }

    //1. viewHolder guarda referencias a las vistas
    public static class ViewHolder extends RecyclerView.ViewHolder{

        // declaracion de los elementos que ya están en el xml
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

    //2. crea la vista (infla el layout del item)
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_main, parent, false);
        return new ViewHolder(view);
    }

    //3. enlaza datos con la vista (bind)
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        Producto p = data.get(position);
        holder.imgProducto.setImageResource(p.imagen);
        holder.txtNombre.setText(p.nombre);
        holder.txtPrecio.setText(String.valueOf(p.precio));

        holder.btnEliminar.setOnClickListener(v -> {

            int posicionElemento = holder.getAdapterPosition();

            if(posicionElemento == RecyclerView.NO_POSITION) return;

            data.remove(posicionElemento);

            notifyItemRemoved(posicionElemento);

            // para reajustar las posiciones de los elementos
            notifyItemRangeChanged(posicionElemento, data.size() - posicionElemento);
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}
