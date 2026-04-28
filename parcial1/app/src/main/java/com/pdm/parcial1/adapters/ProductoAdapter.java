package com.pdm.parcial1.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.pdm.parcial1.R;
import com.pdm.parcial1.models.Producto;

import java.util.ArrayList;

public class ProductoAdapter extends RecyclerView.Adapter<ProductoAdapter.ViewHolder> {

    private ArrayList<Producto> data;

    public ProductoAdapter(ArrayList<Producto> data) {
        this.data = data;
    }

    @NonNull
    @Override
    public ProductoAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        // crear la vista
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductoAdapter.ViewHolder holder, int position) {

        Producto p = data.get(position);

        holder.imgProducto.setImageResource(p.imagen);
        holder.nombreProducto.setText(p.nombre);
        holder.cantidadProducto.setText("Disponibilidad: " + String.valueOf(p.stock));
        holder.precioProducto.setText("Precio: $" + String.valueOf(p.precio));

        holder.itemView.setOnClickListener(v -> {
            Toast.makeText(v.getContext(), "Seleccionaste: " + p.nombre, Toast.LENGTH_SHORT).show();
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imgProducto;
        TextView nombreProducto, cantidadProducto, precioProducto;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imgProducto = itemView.findViewById(R.id.imgProducto);
            nombreProducto = itemView.findViewById(R.id.txtNombre);
            cantidadProducto = itemView.findViewById(R.id.txtCantidad);
            precioProducto = itemView.findViewById(R.id.txtPrecio);
        }
    }
}
