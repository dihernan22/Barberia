package com.example.barberia.Dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;

import com.example.barberia.Clases.Cita;

@Dao
public interface CitaDao {
    @Insert
    void Insertar(Cita cita);
}
