package com.example.barberia.Clases;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity
public class Cliente {
    @PrimaryKey(autoGenerate = true)
    private int id_c;
    private String nombre_c;
    private String apellido_c;
    private String telefono_c;
    private String user_c;
    private String contrasenia_c;

    public Cliente(){}

    public Cliente(int id, String nombre, String apellido, String telefono, String user, String contrasenia) {
        this.id_c = id;
        this.nombre_c = nombre;
        this.apellido_c = apellido;
        this.telefono_c = telefono;
        this.user_c = user;
        this.contrasenia_c = contrasenia;
    }

    public int getId_c() {
        return id_c;
    }

    public void setId_c(int id_c) {
        this.id_c = id_c;
    }

    public String getNombre_c() {
        return nombre_c;
    }

    public void setNombre_c(String nombre_c) {
        this.nombre_c = nombre_c;
    }

    public String getApellido_c() {
        return apellido_c;
    }

    public void setApellido_c(String apellido_c) {
        this.apellido_c = apellido_c;
    }

    public String getTelefono_c() {
        return telefono_c;
    }

    public void setTelefono_c(String telefono_c) {
        this.telefono_c = telefono_c;
    }

    public String getUser_c() {
        return user_c;
    }

    public void setUser_c(String user_c) {
        this.user_c = user_c;
    }

    public String getContrasenia_c() {
        return contrasenia_c;
    }

    public void setContrasenia_c(String contrasenia_c) {
        this.contrasenia_c = contrasenia_c;
    }
}
