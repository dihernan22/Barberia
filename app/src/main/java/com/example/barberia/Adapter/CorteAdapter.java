package com.example.barberia.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.barberia.Clases.Corte;
import com.example.barberia.R;

import java.util.List;

public class CorteAdapter extends ArrayAdapter {
    private Context context;
    private int resource;
    private List<Corte> corteList;

    public CorteAdapter(@NonNull Context context, int resource, @NonNull List<Corte> corteList) {
        super(context, resource, corteList);
        this.context = context;
        this.resource = resource;
        this.corteList = corteList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(this.context);
        View v =inflater.inflate(this.resource, parent, false);
        TextView tvNombre = v.findViewById(R.id.etNombreC);
        TextView tvPrecio = v.findViewById(R.id.etPrecioC);

        tvNombre.setText(corteList.get(position).getNombre());
        tvPrecio.setText(String.valueOf(corteList.get(position).getPrecio()));

        return v;
    }
}
