package com.example.barberia;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteConstraintException;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.barberia.Adapter.RvAdapter;
import com.example.barberia.DB.DbBarberia;
import com.example.barberia.pojo.CitaConCliente;
import com.example.barberia.pojo.ClienteConCita;

import java.util.ArrayList;
import java.util.List;

public class ListCitasActivity extends AppCompatActivity {

    private RvAdapter adapter;
    private List<CitaConCliente> clienteList= new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_citas);

        RecyclerView rvCitas = findViewById(R.id.rvCitas);

        clienteList.addAll(DbBarberia.getAppDatabase(this).citaDao().obtenerConCliente());

        RvAdapter.OnItemClickListener onItemClickListener = new RvAdapter.OnItemClickListener() {
            @Override
            public void OnItemClick(final int posicion, long id) {
                if(id==R.id.ibEliminar){
                    AlertDialog.Builder builder = new AlertDialog.Builder(ListCitasActivity.this);
                    builder.setTitle("Eliminando Cita");
                    builder.setMessage("Esta seguro que desea eliminar cita");
                    builder.setNegativeButton("NO", null);
                    builder.setPositiveButton("SI", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            try{
                                DbBarberia.getAppDatabase(ListCitasActivity.this).citaDao().Borrar(clienteList.get(posicion).getCita());
                                clienteList.remove(posicion);
                                adapter.notifyDataSetChanged();
                            }catch (SQLiteConstraintException e){
                                Toast.makeText(ListCitasActivity.this, "Error", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });

                    AlertDialog alert = builder.create();
                    alert.show();
                }else if(id==R.id.ibEditar){
                    Intent intent =new Intent(ListCitasActivity.this, EditarCitaActivity.class);
                    intent.putExtra("id", clienteList.get(posicion).getCita().getId());
                    intent.putExtra("id_user", clienteList.get(posicion).getUsuario().getId_u());
                    intent.putExtra("id_corte", clienteList.get(posicion).getCorte().getId_cr());
                    intent.putExtra("pos", posicion);
                    startActivityForResult(intent, 1111);
                }
            }
        };
        adapter=new RvAdapter(clienteList, onItemClickListener);
        GridLayoutManager manager = new GridLayoutManager(this,1);
        rvCitas.setLayoutManager(manager);
        rvCitas.setAdapter(adapter);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode==1111){
            if(resultCode==RESULT_OK){
                Bundle extras =data.getExtras();

                if(extras!=null){
                    clienteList.set(extras.getInt("pos"), DbBarberia.getAppDatabase(this).citaDao().obtenerConClienteId(extras.getInt("id")));
                    adapter.notifyDataSetChanged();
                }

            }
        }
    }
}
