package com.example.barberia.Clases;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;

import static android.arch.persistence.room.ForeignKey.CASCADE;
import static android.arch.persistence.room.ForeignKey.RESTRICT;

@Entity
public class Cita {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String dia;
    private String hora;
    @ForeignKey(entity = Cliente.class,
                parentColumns = "id",
                childColumns = "id_cliente",
                onDelete = CASCADE,
                onUpdate = RESTRICT)
    private int id_cliente;

    @ForeignKey(entity = Usuario.class,
                parentColumns = "id",
                childColumns = "id_user",
                onDelete = CASCADE,
                onUpdate = RESTRICT)
    private int id_user;

    @ForeignKey(entity = Corte.class,
            parentColumns = "id",
            childColumns = "id_corte",
            onDelete = CASCADE,
            onUpdate = RESTRICT)
    private int id_corte;

    public Cita() { }

    public Cita(int id, String dia, String hora, int id_cliente, int id_user, int id_corte) {
        this.id = id;
        this.dia = dia;
        this.hora = hora;
        this.id_cliente = id_cliente;
        this.id_user = id_user;
        this.id_corte = id_corte;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public int getId_corte() { return id_corte; }

    public void setId_corte(int id_corte) { this.id_corte = id_corte; }
}
