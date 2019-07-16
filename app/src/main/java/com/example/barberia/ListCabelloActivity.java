package com.example.barberia;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.barberia.Adapter.CorteAdapter;
import com.example.barberia.Clases.Corte;
import com.example.barberia.Clases.Preferences;
import com.example.barberia.DB.DbBarberia;

import java.util.ArrayList;
import java.util.List;

public class ListCabelloActivity extends AppCompatActivity {

    //private String indice;
    private CorteAdapter adapter;
    private List<Corte> corteList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_cabello);

        ListView lvCabello =  findViewById(R.id.lvCabello);
        //Bundle extras =getIntent().getExtras();

        corteList.addAll(DbBarberia.getAppDatabase(this).corteDao().ObtenerCorteCabello());
        adapter = new CorteAdapter(this, R.layout.item_corte, corteList);

        /*if(extras!=null){
            indice=extras.getString("indice");
            prestamosList.addAll(DbPrestamos.getAppDatabase(this).prestamosDao().MostrarPojoCedula(indice));
            adapPrestamo= new AdapPrestamos(this, R.layout.item_prestamos, prestamosList);
        }else{
            prestamosList.addAll(DbPrestamos.getAppDatabase(this).prestamosDao().MostrarPojo());
            adapPrestamo = new AdapPrestamos(this, R.layout.item_prestamos, prestamosList);
        }*/

        lvCabello.setAdapter(adapter);

        lvCabello.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                if (Preferences.ObtenerEstado(ListCabelloActivity.this) == true)
                {
                    Intent intent = new Intent();
                    intent.putExtra("id", corteList.get(position).getId_cr());
                    intent.putExtra("nombre", corteList.get(position).getNombre_cr());
                    //Toast.makeText(ListBarbaActivity.this, corteList.get(position).getNombre(), Toast.LENGTH_SHORT).show();
                    setResult(RESULT_OK, intent);
                    finish();
                }
            }
        });
    }
}
