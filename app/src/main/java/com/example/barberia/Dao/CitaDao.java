package com.example.barberia.Dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.example.barberia.Clases.Cita;
import com.example.barberia.Clases.Cliente;
import com.example.barberia.pojo.CitaConCliente;

import java.util.List;

@Dao
public interface CitaDao {
    @Insert
    void Insertar(Cita cita);

    @Delete
    void Borrar(Cita cita);

    @Update
    void Actualizar(Cita cita);

    @Query("SELECT * FROM cita WHERE id=:id")
    Cita ObtenerCita(int id);

    @Query("Select c.*, cl.*, u.*, cr.* from cita c inner join cliente cl on cl.id_c=c.id_cliente inner join usuario u on u.id_u=c.id_user inner join corte cr on cr.id_cr=c.id_corte WHERE id=:id")
    CitaConCliente obtenerConClienteId(int id);

    @Query("Select c.*, cl.*, u.*, cr.* from cita c inner join cliente cl on cl.id_c=c.id_cliente inner join usuario u on u.id_u=c.id_user inner join corte cr on cr.id_cr=c.id_corte")
    List<CitaConCliente> obtenerConCliente();
}
