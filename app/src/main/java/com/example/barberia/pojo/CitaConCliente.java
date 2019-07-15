package com.example.barberia.pojo;

import android.arch.persistence.room.Embedded;

import com.example.barberia.Clases.Cita;
import com.example.barberia.Clases.Cliente;
import com.example.barberia.Clases.Corte;
import com.example.barberia.Clases.Usuario;

public class CitaConCliente {
    @Embedded
    Usuario usuario;

    @Embedded
    Cliente cliente;

    @Embedded
    Corte corte;

    @Embedded
    Cita cita;

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

    public Cita getCita() {
        return cita;
    }

    public void setCita(Cita cita) {
        this.cita = cita;
    }
}
