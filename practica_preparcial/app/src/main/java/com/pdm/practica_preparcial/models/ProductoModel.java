package com.pdm.practica_preparcial.models;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.pdm.practica_preparcial.R;
import java.util.ArrayList;

// al heredar de la clase es para indicar como se construye y como se llena cada fila
public class ProductoModel extends BaseAdapter {

    // declarar el contexto de la vista
    private Context context;
    private ArrayList<Producto> data;
    private LayoutInflater inflater; // toma un archivo XML estático y lo infla para convertirlo en una vista que Java pueda manipular

    // metodos obligatorios
    public ProductoModel(Context context, ArrayList<Producto> data) {
        this.context    = context;
        this.data       = data;
        this.inflater   = LayoutInflater.from(context);
    }

    public static class ViewHolder{
        TextView tvNombre, tvDetalle;
    }

    // devuelve el índice, se usa para identificar de manera unica cada elemento
    @Override
    public long getItemId(int position) {
        return position;
    }

    // le dice al listview cuantas filas debe dibujar en total, el tamaño del arraylist
    @Override
    public int getCount() {
        return data.size();
    }

    // devuelve el objeto que está en "position"
    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    // este metodo se utiliza cada vez que una fila entra en la pantalla
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
    // convertView = cuando una fila sale por arriba no se destruye, se recicla
    //               y se guarda en convertView

        ViewHolder holder;

        if(convertView == null){

            convertView = inflater.inflate(R.layout.row_layout, parent, false);

            holder = new ViewHolder();

            holder.tvNombre     = convertView.findViewById(R.id.tvNombre);
            holder.tvDetalle    = convertView.findViewById(R.id.tvDetalle);

            convertView.setTag(holder);

        }

        else{
            holder = (ViewHolder) convertView.getTag();
        }

        // obtener el objeto seleccionado
        Producto p = data.get(position);

        holder.tvNombre.setText(p.nombre);
        holder.tvDetalle.setText("$" + String.valueOf(p.precio));

        // retornar la vista
        return convertView;
    }
}
