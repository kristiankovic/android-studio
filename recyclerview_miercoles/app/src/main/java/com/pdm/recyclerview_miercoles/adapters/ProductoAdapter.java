package com.pdm.recyclerview_miercoles.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.pdm.recyclerview_miercoles.R;
import com.pdm.recyclerview_miercoles.models.Producto;

import java.util.ArrayList;

public class ProductoAdapter extends RecyclerView.Adapter<ProductoAdapter.ProductoVH> {

    // el contexto ya lo maneja el vh
    private ArrayList<Producto> data;

    public ProductoAdapter(ArrayList<Producto> data) {
        this.data = data;
    }
    //debe heredar de recyclerview
    public static class ProductoVH extends RecyclerView.ViewHolder {

        public ImageView image;
        public TextView txtNombre, txtPrecio, txtCantidad;
        public Button btnEliminar;

        // se asocian aqui
        public ProductoVH(@NonNull View itemView) {
            super(itemView);

            image = itemView.findViewById(R.id.image);
            txtNombre = itemView.findViewById(R.id.txtNombre);
            txtPrecio = itemView.findViewById(R.id.txtPrecio);
            txtCantidad = itemView.findViewById(R.id.txtStock);
            btnEliminar = itemView.findViewById(R.id.btnEliminar);
        }
    }

    // aqui se asocia lo que hay en el layout
    @NonNull
    @Override
    public ProductoAdapter.ProductoVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_item_producto, parent, false);
        return new ProductoVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductoAdapter.ProductoVH holder, int position) {

        // se accede por medio de la posicion
        Producto p = data.get(position);

        //asignar los valores a las textviews
        holder.image.setImageResource(p.imagen);
        holder.txtNombre.setText("Nombre: " + p.nombre);
        holder.txtCantidad.setText("Stock disponible: " + String.valueOf(p.stock));
        holder.txtPrecio.setText("Precio: $" + String.valueOf(p.precio));

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

}
