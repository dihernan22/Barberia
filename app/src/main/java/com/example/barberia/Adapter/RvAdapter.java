package com.example.barberia.Adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.barberia.R;
import com.example.barberia.pojo.CitaConCliente;

import java.util.List;

public class RvAdapter extends RecyclerView.Adapter<RvAdapter.CitaHolder> {
    List<CitaConCliente> citaList;

    private final OnItemClickListener onItemClickListener;

    public interface  OnItemClickListener{
        void OnItemClick(int posicion, long id);
    }

    public RvAdapter(List<CitaConCliente> citaList, OnItemClickListener onItemClickListener){
        this.citaList = citaList;
        this.onItemClickListener=onItemClickListener;
    }

    @NonNull
    @Override
    public CitaHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View view = inflater.inflate(R.layout.item_cita, viewGroup, false);
        CitaHolder citaHolder = new CitaHolder(view);
        return citaHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CitaHolder citaholder, int position) {
        citaholder.etNombreCliente.setText(citaList.get(position).getCliente().getNombre_c() + " " + citaList.get(position).getCliente().getApellido_c());
        citaholder.etNombreBarbero.setText(citaList.get(position).getUsuario().getNombre_u() + " " + citaList.get(position).getUsuario().getApellido_u());
        citaholder.etNombreCorte.setText(citaList.get(position).getCorte().getNombre_cr());
        citaholder.etFecha.setText(citaList.get(position).getCita().getDia());
    }

    @Override
    public int getItemCount() {
        return citaList.size();
    }


    public class CitaHolder extends RecyclerView.ViewHolder implements  View.OnClickListener{
        private TextView etNombreCliente, etNombreBarbero;
        private TextView etFecha, etNombreCorte;
        private ImageButton ibEditar;
        private ImageButton ibEliminar;

        public CitaHolder(@NonNull View itemView){
            super(itemView);

            etNombreCliente=itemView.findViewById(R.id.etNombreCliente);
            etNombreBarbero=itemView.findViewById(R.id.etNombreBarbero);
            etFecha=itemView.findViewById(R.id.etFecha);
            etNombreCorte=itemView.findViewById(R.id.etCorte);
            ibEditar=itemView.findViewById(R.id.ibEditar);
            ibEliminar=itemView.findViewById(R.id.ibEliminar);

            itemView.setOnClickListener(this);

            ibEliminar.setOnClickListener(this);
            ibEditar.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            onItemClickListener.OnItemClick(getAdapterPosition(), view.getId());
        }
    }
}
