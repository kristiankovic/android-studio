package com.pdm.fragments_db.adapters;

import android.content.Context;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.pdm.fragments_db.R;
import com.pdm.fragments_db.database.AppDatabase;
import com.pdm.fragments_db.entities.Estudiante;

import java.util.List;
import java.util.logging.Handler;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder> {
    private Context contexto;
    private List<Estudiante> data;
    private click_listener listener;
    private AppDatabase db;

    public CustomAdapter(Context contexto, List<Estudiante> data, click_listener listener) {
        this.contexto = contexto;
        this.data = data;
        this.listener = listener;
    }

    public interface click_listener{
        void onItemClick(Estudiante estudiante);
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
        public Button btnEliminar;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            lblNombre = itemView.findViewById(R.id.lblNombre);
            lblCarrera = itemView.findViewById(R.id.lblCarrera);
            lblCarnet = itemView.findViewById(R.id.lblCarnet);
            btnEliminar = itemView.findViewById(R.id.btnELiminar);

            btnEliminar.setOnClickListener(v -> {

                int position = getAdapterPosition();

                if(position != RecyclerView.NO_POSITION){
                    db = AppDatabase.getInstance(v.getContext());

                    AppDatabase.dataWriterExecutor.execute(() -> {

                        db.estudianteDAO().removeEstudiante(data.get(position));

                        itemView.post(() -> {
                            data.remove(position);
                            notifyItemRemoved(position);
                            notifyItemRangeChanged(position, data.size());
                            Toast.makeText(v.getContext(), "Estudiante eliminado", Toast.LENGTH_SHORT).show();
                        });

                    });

                }
            });

            itemView.setOnClickListener( v -> {
                if(listener != null && getAdapterPosition() != RecyclerView.NO_POSITION){
                    listener.onItemClick(data.get(getAdapterPosition()));
                }
            });
        }
    }
}
