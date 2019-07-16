package com.example.barberia.Clases;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity
public class Corte {
    @PrimaryKey(autoGenerate = true)
    private int id_cr;
    private String nombre_cr;
    private Double precio;
    private String tipo;
    private String imagen;

    public Corte(){}

    public Corte(int id, String nombre, Double precio, String tipo, String imagen) {
        this.id_cr = id;
        this.nombre_cr = nombre;
        this.precio = precio;
        this.tipo = tipo;
        this.imagen = imagen;
    }

    public int getId_cr() {
        return id_cr;
    }

    public void setId_cr(int id_cr) {
        this.id_cr = id_cr;
    }

    public String getNombre_cr() {
        return nombre_cr;
    }

    public void setNombre_cr(String nombre_cr) {
        this.nombre_cr = nombre_cr;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
}
