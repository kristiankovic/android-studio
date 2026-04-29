package com.pdm.fragments_db.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.pdm.fragments_db.R;
import com.pdm.fragments_db.entities.Estudiante;

import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder> {
    private Context contexto;
    private List<Estudiante> data;

    public CustomAdapter(Context contexto, List<Estudiante> data) {
        this.contexto = contexto;
        this.data = data;
    }

    @NonNull
    @Override
    public CustomAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_item_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomAdapter.ViewHolder holder, int position) {
        Estudiante e = data.get(position);

        holder.lblNombre.setText(e.nombre);
        holder.lblCarrera.setText(e.carrera);
        holder.lblCarnet.setText(e.carnet);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView lblNombre, lblCarrera, lblCarnet;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            lblNombre = itemView.findViewById(R.id.lblNombre);
            lblCarrera = itemView.findViewById(R.id.lblCarrera);
            lblCarnet = itemView.findViewById(R.id.lblCarnet);
        }
    }
}
