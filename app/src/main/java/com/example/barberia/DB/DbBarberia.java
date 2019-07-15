package com.example.barberia.DB;


import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.example.barberia.Clases.Cita;
import com.example.barberia.Clases.Cliente;
import com.example.barberia.Clases.Corte;
import com.example.barberia.Clases.Usuario;
import com.example.barberia.Dao.CitaDao;
import com.example.barberia.Dao.ClienteDao;
import com.example.barberia.Dao.CorteDao;
import com.example.barberia.Dao.UsuarioDao;

@Database(version = 1, entities = {Cliente.class, Usuario.class, Corte.class, Cita.class})
public abstract class DbBarberia extends RoomDatabase {
    private static DbBarberia INSTANCE;
    public abstract ClienteDao clienteDao();
    public abstract UsuarioDao usuarioDao();
    public abstract CorteDao corteDao();
    public abstract CitaDao citaDao();

    public static DbBarberia getAppDatabase(Context context){
        if(INSTANCE == null)
            INSTANCE= Room.databaseBuilder(context.getApplicationContext(), DbBarberia.class, "db")
                    .allowMainThreadQueries()
                    .build();
        return INSTANCE;
    }
}
