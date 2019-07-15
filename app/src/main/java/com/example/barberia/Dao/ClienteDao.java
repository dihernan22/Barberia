package com.example.barberia.Dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.example.barberia.Clases.Cliente;

import java.util.List;

@Dao
public interface ClienteDao {
    @Insert
    void Insertar(Cliente cliente);

    @Update
    void Actualizar(Cliente cliente);

    @Query("SELECT * FROM cliente WHERE user=:username AND contrasenia=:contra")
    Cliente ObtenerCliente(String username, String contra);
}
