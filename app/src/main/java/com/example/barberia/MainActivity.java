package com.example.barberia;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteConstraintException;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.barberia.Clases.Cliente;
import com.example.barberia.Clases.Corte;
import com.example.barberia.Clases.Preferences;
import com.example.barberia.DB.DbBarberia;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (Preferences.ObtenerEstado(this) == true)
        {
            Intent intent = new Intent(MainActivity.this, PrincipalActivity.class);
            startActivity(intent);
            finish();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_login, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.mnLogin:
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                View view = getLayoutInflater().inflate(R.layout.login_dialog, null);
                final EditText etUser = view.findViewById(R.id.etUser);
                final EditText etContra = view.findViewById(R.id.etContra);

                Button btnLogin = view.findViewById(R.id.btnLogin);
                Button btnRegister = view.findViewById(R.id.btnRegistrar);

                btnLogin.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (!etUser.getText().toString().isEmpty() && !etContra.getText().toString().isEmpty())
                        {
                            Cliente cliente = DbBarberia.getAppDatabase(MainActivity.this).
                                    clienteDao().ObtenerCliente(etUser.getText().toString(), etContra.getText().toString());
                            if (cliente == null)
                            {
                                Toast.makeText(MainActivity.this, "Usuario no existe!!!", Toast.LENGTH_SHORT).show();
                            }
                            else
                            {
                                Preferences.GuardarEstado(MainActivity.this, true, cliente.getUser_c(), cliente.getId_c());
                                Intent intent = new Intent(MainActivity.this, PrincipalActivity.class);
                                startActivity(intent);
                                Toast.makeText(MainActivity.this, "Usuario logueado correctamente", Toast.LENGTH_SHORT).show();
                                finish();
                            }
                        }
                    }
                });

                btnRegister.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(MainActivity.this, RegistrarClienteActivity.class);
                        startActivity(intent);
                    }
                });
                builder.setView(view);
                AlertDialog dialog = builder.create();
                dialog.show();
                break;
            case R.id.mnCabello:
                Intent intent1 = new Intent(MainActivity.this, ListCabelloActivity.class);
                startActivity(intent1);
                break;
            case R.id.mnBarba:
                Intent intent2 = new Intent(MainActivity.this, ListBarbaActivity.class);
                startActivity(intent2);
                break;
            case R.id.mnCombo:
                Intent intent3 = new Intent(MainActivity.this, ListComboActivity.class);
                startActivity(intent3);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

}
