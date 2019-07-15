package com.example.barberia;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.barberia.Adapter.CorteAdapter;
import com.example.barberia.Clases.Corte;
import com.example.barberia.Clases.Preferences;
import com.example.barberia.DB.DbBarberia;

import java.util.ArrayList;
import java.util.List;

public class ListBarbaActivity extends AppCompatActivity {

    private CorteAdapter adapter;
    private List<Corte> corteList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_barba);

        ListView lvBarba =  findViewById(R.id.lvBarba);

        corteList.addAll(DbBarberia.getAppDatabase(this).corteDao().ObtenerCorteBarba());
        adapter = new CorteAdapter(this, R.layout.item_corte, corteList);

        lvBarba.setAdapter(adapter);

        lvBarba.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                if (Preferences.ObtenerEstado(ListBarbaActivity.this) == true)
                {
                    Intent intent = new Intent();
                    intent.putExtra("id", corteList.get(position).getId());
                    intent.putExtra("nombre", corteList.get(position).getNombre());
                    //Toast.makeText(ListBarbaActivity.this, corteList.get(position).getNombre(), Toast.LENGTH_SHORT).show();
                    setResult(RESULT_OK, intent);
                    finish();
                }
            }
        });
    }
}
