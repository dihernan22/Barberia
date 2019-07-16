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

public class ListComboActivity extends AppCompatActivity {

    private CorteAdapter adapter;
    private List<Corte> corteList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_combo);

        ListView lvCombo=  findViewById(R.id.lvCombo);

        corteList.addAll(DbBarberia.getAppDatabase(this).corteDao().ObtenerCombo());
        adapter = new CorteAdapter(this, R.layout.item_corte, corteList);

        lvCombo.setAdapter(adapter);

        lvCombo.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                if (Preferences.ObtenerEstado(ListComboActivity.this) == true)
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
