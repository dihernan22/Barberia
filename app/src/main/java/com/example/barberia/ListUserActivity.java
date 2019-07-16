package com.example.barberia;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.barberia.Adapter.CorteAdapter;
import com.example.barberia.Adapter.UserAdapter;
import com.example.barberia.Clases.Corte;
import com.example.barberia.Clases.Preferences;
import com.example.barberia.Clases.Usuario;
import com.example.barberia.DB.DbBarberia;

import java.util.ArrayList;
import java.util.List;

public class ListUserActivity extends AppCompatActivity {

    private UserAdapter adapter;
    private List<Usuario> userList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_user);

        ListView lvBarberos =  findViewById(R.id.lvBarberos);

        userList.addAll(DbBarberia.getAppDatabase(this).usuarioDao().ObtenerBarberos());
        adapter = new UserAdapter(this, R.layout.item_user, userList);

        lvBarberos.setAdapter(adapter);

        lvBarberos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                if (Preferences.ObtenerEstado(ListUserActivity.this) == true)
                {
                    Intent intent = new Intent();
                    intent.putExtra("id", userList.get(position).getId_u());
                    intent.putExtra("nombre", userList.get(position).getNombre_u() + " " + userList.get(position).getApellido_u());
                    //Toast.makeText(ListBarbaActivity.this, corteList.get(position).getNombre(), Toast.LENGTH_SHORT).show();
                    setResult(RESULT_OK, intent);
                    finish();
                }
            }
        });
    }
}
