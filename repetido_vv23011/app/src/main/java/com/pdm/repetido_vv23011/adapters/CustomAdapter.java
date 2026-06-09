package com.pdm.repetido_vv23011.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.pdm.repetido_vv23011.R;
import com.pdm.repetido_vv23011.models.Equipo;

import java.util.ArrayList;

public class CustomAdapter extends BaseAdapter {

    private Context contexto;
    private ArrayList<Equipo> data;
    private LayoutInflater inflater;

    static class ViewHolder{
        ImageView image;
        TextView txtNombre, txtTarifaDia, txtCategoria, txtCantidadDisponible;
        CheckBox cbAlquilado;
        EditText txtDiasAlquiler, txtCantidadAlquiler;
    }

    public CustomAdapter(Context contexto, ArrayList<Equipo> data) {
        this.contexto = contexto;
        this.data = data;
        this.inflater = LayoutInflater.from(contexto);
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

        if (convertView == null){
            convertView = inflater.inflate(R.layout.item_layout, parent, false);

            holder = new ViewHolder();

            holder.image = convertView.findViewById(R.id.imgProducto);
            holder.txtNombre = convertView.findViewById(R.id.txtNombre);
            holder.txtTarifaDia = convertView.findViewById(R.id.txtTarifa);
            holder.txtCategoria = convertView.findViewById(R.id.txtCategoria);
            holder.txtCantidadDisponible = convertView.findViewById(R.id.txtCantidadDisponible);
            holder.cbAlquilado = convertView.findViewById(R.id.cbAlquilado);
            holder.txtCantidadAlquiler = convertView.findViewById(R.id.txtCantidadAlquiler);
            holder.txtDiasAlquiler = convertView.findViewById(R.id.txtDiasAlquiler);
            //holder.lvAlquilados = convertView.findViewById(R.id.lvAlquilados);

            convertView.setTag(holder);

        }

        else{
            holder = (ViewHolder) convertView.getTag();
        }

        Equipo e = data.get(position);

        holder.image.setImageResource(e.imagen);
        holder.txtNombre.setText(e.nombre);
        holder.txtTarifaDia.setText("Tarifa por dia: $" + String.valueOf(e.tarifaDia));
        holder.txtCategoria.setText("Categoria: " + e.categoria);
        holder.txtCantidadDisponible.setText("Existencias: " + String.valueOf(e.cantidadDisponible));

        holder.cbAlquilado.setOnCheckedChangeListener(null);
        holder.cbAlquilado.setChecked(e.seleccionado); // estado del objeto de cada fila

        holder.cbAlquilado.setOnCheckedChangeListener((buttonView, seleccionado) ->{

            if(holder.txtDiasAlquiler.getText().toString().isEmpty() || holder.txtCantidadAlquiler.getText().toString().isEmpty()){
                holder.txtDiasAlquiler.setError("Ingrese un dato");
                holder.txtCantidadAlquiler.setError("Ingrese un dato");
                holder.cbAlquilado.setChecked(false);
                e.seleccionado = false;
            }

            else{

                int dias = Integer.parseInt(holder.txtDiasAlquiler.getText().toString().trim());
                int cantidad = Integer.parseInt(holder.txtCantidadAlquiler.getText().toString().trim());

                if(cantidad > 0 && cantidad <= e.cantidadDisponible){

                    // persistencia de datos
                    e.seleccionado = seleccionado;
                    e.diasAlquiler = dias;
                    e.cantidadAlquiler = cantidad;

                    holder.txtDiasAlquiler.setText("");
                    holder.txtCantidadAlquiler.setText("");
                    holder.cbAlquilado.setChecked(false);

                    Toast.makeText(parent.getContext(), "Item agregado", Toast.LENGTH_SHORT).show();
                }

                else {
                    holder.txtDiasAlquiler.setError("Dato no valido");
                    holder.txtCantidadAlquiler.setError("Dato no valido");
                    holder.cbAlquilado.setChecked(false);
                    e.seleccionado = false;
                }
            }

        });

        return convertView;
    }
}
