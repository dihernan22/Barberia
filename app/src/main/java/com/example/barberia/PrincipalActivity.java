package com.example.barberia;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.barberia.Clases.Preferences;

public class PrincipalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

//        TextView textView = findViewById(R.id.tvVer);
//        textView.setText(Preferences.ObtenerUser(this));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_loged, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.mnMore:
                Intent intent1 = new Intent(PrincipalActivity.this, RegistrarCitaActivity.class);
                startActivity(intent1);
                break;
            case R.id.mnCitas:
                Intent intent2 = new Intent(PrincipalActivity.this, ListCitasActivity.class);
                startActivity(intent2);
                break;
            case R.id.mnSalir:
                Preferences.GuardarEstado(this, false, "", 0);
                Intent intent = new Intent(PrincipalActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
