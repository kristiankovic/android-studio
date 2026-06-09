package com.pdm.parcial2_vv23011.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.pdm.parcial2_vv23011.R;
import com.pdm.parcial2_vv23011.database.AppDatabase;
import com.pdm.parcial2_vv23011.entities.Receta;

import java.util.List;

public class RecetaAdapter extends RecyclerView.Adapter<RecetaAdapter.ViewHolder> {
    private Context contexto;
    public List<Receta> data;
    public click_listener listener;
    private AppDatabase db;

    public interface click_listener{
        void onItemClick(Receta receta);
    }

    public RecetaAdapter(Context contexto, List<Receta> data, click_listener listener) {
        this.contexto = contexto;
        this.data = data;
        this.listener = listener;
    }

    @NonNull
    @Override
    public RecetaAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.receta_item_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecetaAdapter.ViewHolder holder, int position) {

        Receta r = data.get(position);

        holder.lblNombre.setText(r.nombre);
        holder.lblDescripcion.setText(r.descripcion);
        holder.lblPorciones.setText(String.valueOf(r.porciones));

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView lblNombre, lblDescripcion, lblPorciones;
        public Button btnEliminar;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            lblNombre = itemView.findViewById(R.id.lblNombre);
            lblDescripcion = itemView.findViewById(R.id.lblDescripcion);
            lblPorciones = itemView.findViewById(R.id.lblPorciones);
            btnEliminar = itemView.findViewById(R.id.btnEliminar);

            itemView.setOnClickListener(v -> {
                if(listener != null && getAdapterPosition() != RecyclerView.NO_POSITION){
                    listener.onItemClick(data.get(getAdapterPosition()));
                }
            });

            btnEliminar.setOnClickListener(v -> {
                db = AppDatabase.getInstance(v.getContext());
                int position = getAdapterPosition();

                itemView.post(() -> {
                   data.remove(position);
                   notifyItemRemoved(position);
                   notifyItemRangeChanged(position, data.size());
                });
            });
        }
    }
}
