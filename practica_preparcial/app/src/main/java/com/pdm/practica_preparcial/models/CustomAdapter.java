package com.pdm.practica_preparcial.models;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.pdm.practica_preparcial.R;

import java.util.ArrayList;

public class CustomAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<Producto> data;
    private LayoutInflater inflater;

    public static class ViewHolder{
        TextView txtNombre, txtDetalle;
    }

    public CustomAdapter(Context context, ArrayList<Producto> data) {
        this.context = context;
        this.data = data;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder;

        if(convertView == null){

            convertView = inflater.inflate(R.layout.row_layout, parent, false);

            holder = new ViewHolder();

            holder.txtNombre = convertView.findViewById(R.id.tvNombre);
            holder.txtDetalle = convertView.findViewById(R.id.tvDetalle);

            convertView.setTag(holder);
        }

        else{
            holder = (ViewHolder) convertView.getTag();
        }

        Producto p = data.get(position);
        holder.txtNombre.setText(p.nombre);
        holder.txtDetalle.setText(String.valueOf(p.precio));

        return convertView;
    }
}
