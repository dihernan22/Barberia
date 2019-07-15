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
import com.example.barberia.Clases.Usuario;
import com.example.barberia.R;

import java.util.List;

public class UserAdapter extends ArrayAdapter {
    private Context context;
    private int resource;
    private List<Usuario> userList;

    public UserAdapter(@NonNull Context context, int resource, @NonNull List<Usuario> userList) {
        super(context, resource, userList);
        this.context = context;
        this.resource = resource;
        this.userList = userList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(this.context);
        View v =inflater.inflate(this.resource, parent, false);
        TextView tvNombre = v.findViewById(R.id.etNombreU);
        TextView tvTelefono = v.findViewById(R.id.etTelefonoU);

        tvNombre.setText(userList.get(position).getNombre() + " " + userList.get(position).getApellido());
        tvTelefono.setText(String.valueOf(userList.get(position).getTelefono()));

        return v;
    }
}
