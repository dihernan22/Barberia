package com.example.barberia.Clases;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity
public class Usuario {
    @PrimaryKey(autoGenerate = true)
    private int id_u;
    private String nombre_u;
    private String apellido_u;
    private String telefono_u;
    private String cedula;
    private String user_u;
    private String contrasenia_u;

    public Usuario(){}

    public Usuario(int id, String nombre, String apellido, String telefono, String cedula, String user, String contrasenia) {
        this.id_u = id;
        this.nombre_u = nombre;
        this.apellido_u = apellido;
        this.telefono_u = telefono;
        this.cedula = cedula;
        this.user_u = user;
        this.contrasenia_u = contrasenia;
    }

    public int getId_u() {
        return id_u;
    }

    public void setId_u(int id_u) {
        this.id_u = id_u;
    }

    public String getNombre_u() {
        return nombre_u;
    }

    public void setNombre_u(String nombre_u) {
        this.nombre_u = nombre_u;
    }

    public String getApellido_u() {
        return apellido_u;
    }

    public void setApellido_u(String apellido_u) {
        this.apellido_u = apellido_u;
    }

    public String getTelefono_u() {
        return telefono_u;
    }

    public void setTelefono_u(String telefono_u) {
        this.telefono_u = telefono_u;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getUser_u() {
        return user_u;
    }

    public void setUser_u(String user_u) {
        this.user_u = user_u;
    }

    public String getContrasenia_u() {
        return contrasenia_u;
    }

    public void setContrasenia_u(String contrasenia_u) {
        this.contrasenia_u = contrasenia_u;
    }
}
