package com.example.barberia.Dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.example.barberia.Clases.Corte;
import com.example.barberia.Clases.Usuario;

import java.util.List;

@Dao
public interface UsuarioDao {
    @Insert
    Long Insertar(Usuario usuario);

    @Update
    void Actualizar(Usuario usuario);

    @Query("SELECT * FROM usuario")
    List<Usuario> ObtenerBarberos();
}
