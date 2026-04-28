package com.pdm.colors.adapters;

import static androidx.core.content.ContextCompat.startActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.pdm.colors.EditContact;
import com.pdm.colors.MainActivity;
import com.pdm.colors.R;
import com.pdm.colors.models.ListElement;

import java.io.Serializable;
import java.util.List;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder>{
    private Context context;
    private List<ListElement> data;
    private LayoutInflater inflater;

    public ListAdapter(Context context, List<ListElement> data) {
        this.context = context;
        this.data = data;
        this.inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public ListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListAdapter.ViewHolder holder, int position) {
        ListElement item = data.get(position);
        holder.icon.setColorFilter(Color.parseColor(item.getColor()), PorterDuff.Mode.SRC_IN);
        holder.name.setText(item.getName());
        holder.city.setText(item.getCity());
        holder.number.setText(item.getNumber());
        holder.status.setText(item.getStatus());

        if(item.getStatus().equalsIgnoreCase("Activo")){
            holder.status.setTextColor(context.getResources().getColor(R.color.green));
        }else{
            holder.status.setTextColor(context.getResources().getColor(R.color.red));
        }

        holder.itemView.setOnClickListener(view -> {

            Intent intento = new Intent(view.getContext(), EditContact.class);
            intento.putExtra("contacto", (Serializable) item);
            intento.putExtra("posicion", position);
            context.startActivity(intento);
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        ImageView icon;
        TextView name, city, number, status;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            icon = itemView.findViewById(R.id.icon);
            name = itemView.findViewById(R.id.name);
            city = itemView.findViewById(R.id.city);
            number = itemView.findViewById(R.id.number);
            status = itemView.findViewById(R.id.status);
        }

    }

    public void setItems(List<ListElement> items){
        data = items;
    }
}
