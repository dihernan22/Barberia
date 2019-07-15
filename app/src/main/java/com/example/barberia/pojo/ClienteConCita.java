package com.example.barberia.pojo;

import android.arch.persistence.room.Embedded;
import android.arch.persistence.room.Relation;

import com.example.barberia.Clases.Cita;
import com.example.barberia.Clases.Cliente;
import com.example.barberia.Clases.Corte;
import com.example.barberia.Clases.Usuario;

import java.util.ArrayList;
import java.util.List;

public class ClienteConCita {
    @Embedded
    Usuario usuario;

    @Embedded
    Cliente cliente;

    @Embedded
    Corte corte;

    @Relation(entity = Cita.class, parentColumn = "id", entityColumn = "id_corte")
    List<Cita> citaList;

    public ClienteConCita() {
        usuario = new Usuario();
        cliente = new Cliente();
        corte = new Corte();
        citaList = new ArrayList<>();
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Corte getCorte() {
        return corte;
    }

    public void setCorte(Corte corte) {
        this.corte = corte;
    }

    public List<Cita> getCitaList() {
        return citaList;
    }

    public void setCitaList(List<Cita> citaList) {
        this.citaList = citaList;
    }
}
