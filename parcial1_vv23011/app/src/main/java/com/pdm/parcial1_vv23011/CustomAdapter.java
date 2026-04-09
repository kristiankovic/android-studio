package com.pdm.parcial1_vv23011;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.pdm.parcial1_vv23011.models.Producto;

import java.util.ArrayList;

public class CustomAdapter extends BaseAdapter {

    private Context contexto;
    private ArrayList<Producto> data;
    private LayoutInflater inflater;

    // constructor
    public CustomAdapter(Context contexto, ArrayList<Producto> data) {
        this.contexto = contexto;
        this.data = data;
        this.inflater = LayoutInflater.from(contexto);
    }

    // metodo de vista
    public static class ViewHolder{
        TextView txtNombre, txtPrecio, txtCategoria, txtCantidadComprada;
        ImageView imgProducto;
        Button btnAgregar, btnQuitar;
        CheckBox cbCompra;
    }

    // metodos obligatorios
    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder;

        // inflar el layout
        if(convertView == null){

            convertView = inflater.inflate(R.layout.item_layout, parent, false);

            holder = new ViewHolder();

            holder.imgProducto  = convertView.findViewById(R.id.imgProducto);
            holder.txtNombre    = convertView.findViewById(R.id.txtNombre);
            holder.txtPrecio    = convertView.findViewById(R.id.txtPrecio);
            holder.txtCategoria = convertView.findViewById(R.id.txtCategoria);
            holder.txtCantidadComprada = convertView.findViewById(R.id.txtCantidadComprada);
            holder.btnAgregar   = convertView.findViewById(R.id.btnAgregar);
            holder.btnQuitar    = convertView.findViewById(R.id.btnQuitar);
            holder.cbCompra   = convertView.findViewById(R.id.cbCompra);

            convertView.setTag(holder);
        }

        // si ya esta inflado solo obtenerlo
        else{
            holder = (ViewHolder) convertView.getTag();
        }

        Producto p = data.get(position);

        holder.imgProducto.setImageResource(p.imagen);
        holder.txtNombre.setText(p.nombre);
        holder.txtPrecio.setText("Precio: $" + String.format(String.valueOf(p.precio)));
        holder.txtCategoria.setText("Categoria: " + p.categoria);

        // mostrar la cantidad comprada de este producto
        holder.txtCantidadComprada.setText(String.valueOf(p.cantidadComprada));

        // acumular la cantidad deseada a comprar
        holder.btnAgregar.setOnClickListener(v -> {
            p.cantidadComprada++;
            holder.txtCantidadComprada.setText(String.valueOf(p.cantidadComprada));
        });

        // decrementar la cantidad a comprar
        holder.btnQuitar.setOnClickListener(v -> {
            try {
                if(p.cantidadComprada > 0){
                    p.cantidadComprada--;
                    holder.txtCantidadComprada.setText(String.valueOf(p.cantidadComprada));
                }
            }catch (NumberFormatException e){
                throw new RuntimeException(e);
            }
        });

        // identificar que productos estan seleccionados

        // limpiar las selecciones anteriores
        holder.cbCompra.setOnCheckedChangeListener(null);
        holder.cbCompra.setChecked(p.comprado);

        /* -> isChecked: es el valor capturado en tiempo real
          -> buttonView: es la referencia al checkbox fisico que fue tocado, de cada fila */
        holder.cbCompra.setOnCheckedChangeListener(((buttonView, isChecked) -> {
            p.comprado = isChecked;
        }));

        return convertView;
    }
}
