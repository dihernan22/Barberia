package com.example.barberia.Dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.example.barberia.Clases.Corte;

import java.util.List;

@Dao
public interface CorteDao {
    @Insert
    void Insertar(Corte corte);

    @Query("SELECT * FROM corte WHERE tipo='Cabello'")
    List<Corte> ObtenerCorteCabello();

    @Query("SELECT * FROM corte WHERE tipo='Barba'")
    List<Corte> ObtenerCorteBarba();

    @Query("SELECT * FROM corte WHERE tipo='Combo'")
    List<Corte> ObtenerCombo();

    @Query("SELECT * FROM corte WHERE id_cr=:id")
    Corte ObtenerCorte(int id);
}
