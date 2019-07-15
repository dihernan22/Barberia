package com.example.barberia;

import android.database.sqlite.SQLiteConstraintException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import com.example.barberia.Clases.Cliente;
import com.example.barberia.DB.DbBarberia;

public class RegistrarClienteActivity extends AppCompatActivity {

    EditText etNombre, etApellido, etTelefono;
    EditText etUsuario, etContra;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar_cliente);

        etNombre = findViewById(R.id.etNombreC);
        etApellido = findViewById(R.id.etApellido);
        etTelefono = findViewById(R.id.etTelefono);
        etUsuario = findViewById(R.id.etUsuario);
        etContra = findViewById(R.id.etContrasenia);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_add_cancel, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.mnAdd:
                if (etNombre.getText().toString().length()==0 || etApellido.getText().toString().length()==0
                        || etTelefono.getText().toString().length()==0 || etUsuario.getText().toString().length()==0
                || etContra.getText().toString().length()==0){
                    if(etNombre.getText().toString().length()==0)
                        etNombre.setError("Campo Obligatorio");
                    if(etApellido.getText().toString().length()==0)
                        etApellido.setError("Campo Obligatorio");
                    if(etTelefono.getText().toString().length()==0)
                        etTelefono.setError("Campo Obligatorio");
                    if(etUsuario.getText().toString().length()==0)
                        etUsuario.setError("Campo Obligatorio");
                    if(etContra.getText().toString().length()==0)
                        etContra.setError("Campo Obligatorio");
                }else{
                    Cliente nuevo = new Cliente();
                    nuevo.setNombre(etNombre.getText().toString());
                    nuevo.setApellido(etApellido.getText().toString());
                    nuevo.setTelefono(etTelefono.getText().toString());
                    nuevo.setUser(etUsuario.getText().toString());
                    nuevo.setContrasenia(etContra.getText().toString());

                    try{
                        DbBarberia.getAppDatabase(this).clienteDao().Insertar(nuevo);
                        Toast.makeText(this, "Se registro correctamente", Toast.LENGTH_SHORT).show();
                    }
                    catch (SQLiteConstraintException e){
                        Toast.makeText(this, "No se pudo registrar", Toast.LENGTH_SHORT).show();
                    }
                    /*Intent intent = new Intent();
                    if(indice.isEmpty()){
                        Cliente nuevo = new Cliente();
                        nuevo.setNombre(txtNombre.getText().toString());
                        nuevo.setApelldio(txtApellido.getText().toString());
                        nuevo.setSexo(spSexo.getSelectedItem().toString());
                        nuevo.setNumero(txtTelefono.getText().toString());
                        nuevo.setCedula(txtCedula.getText().toString());
                        nuevo.setDireccion(txtDireccion.getText().toString());
                        nuevo.setOcupacion(txtOcupacion.getText().toString());
                        intent.putExtra("nombre", txtNombre.getText().toString());

                        try{
                            DbPrestamos.getAppDatabase(this).clienteDao().Insertar(nuevo);
                        }
                        catch (SQLiteConstraintException e){
                            Toast.makeText(this, "NO se puedo ingresar", Toast.LENGTH_SHORT).show();
                        }
                    }else{
                        actualizar.setNombre(txtNombre.getText().toString());
                        actualizar.setApelldio(txtApellido.getText().toString());
                        actualizar.setSexo(spSexo.getSelectedItem().toString());
                        actualizar.setNumero(txtTelefono.getText().toString());
                        actualizar.setDireccion(txtDireccion.getText().toString());
                        actualizar.setOcupacion(txtOcupacion.getText().toString());
                        tvCedula.setEnabled(false);
                        try{
                            DbPrestamos.getAppDatabase(this).clienteDao().Actualizar(actualizar);
                            intent.putExtra("cedula",tvCedula.getText().toString());
                            intent.putExtra("lugar",lugar);
                        }
                        catch (SQLiteConstraintException e){
                            Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show();
                        }

                    }

                    setResult(RESULT_OK, intent);*/
                    finish();
                }
                break;
            case R.id.mnCancel:
                finish();
                //onBackPressed();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
