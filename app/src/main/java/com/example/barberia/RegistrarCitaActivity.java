package com.example.barberia;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteConstraintException;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.example.barberia.Adapter.CorteAdapter;
import com.example.barberia.Clases.Cita;
import com.example.barberia.Clases.Cliente;
import com.example.barberia.Clases.Corte;
import com.example.barberia.Clases.Preferences;
import com.example.barberia.DB.DbBarberia;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class RegistrarCitaActivity extends AppCompatActivity implements View.OnClickListener {

    private int id_corte, id_user;

    private static final String CERO = "0";

    private static final String BARRA = "/";
    //Calendario para obtener fecha & hora
    public final Calendar c1 = Calendar.getInstance();
    //Variables para obtener la fecha
    final int mes = c1.get(Calendar.MONTH);
    final int dia = c1.get(Calendar.DAY_OF_MONTH);
    final int anio = c1.get(Calendar.YEAR);
    //Widgets
    EditText etFecha;
    ImageButton ibObtenerFecha;

    private static final String DOS_PUNTOS = ":";
    //Calendario para obtener fecha & hora
    public final Calendar c = Calendar.getInstance();
    //Variables para obtener la hora hora
    final int hora = c.get(Calendar.HOUR_OF_DAY);
    final int minuto = c.get(Calendar.MINUTE);
    //Widgets
    EditText etHora;
    ImageButton ibObtenerHora;

    ImageButton ibObtenerCorte, ibObtenerBarbero;
    TextView tvCorte;
    Spinner spTipo;
    EditText etBarbero, etCorte;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar_cita);

        //Widget EditText donde se mostrara la hora obtenida
        etHora = (EditText) findViewById(R.id.etHora);
        //Widget ImageButton del cual usaremos el evento clic para obtener la hora
        ibObtenerHora = (ImageButton) findViewById(R.id.ibHora);
        //Evento setOnClickListener - clic
        ibObtenerHora.setOnClickListener(this);

        //Widget EditText donde se mostrara la fecha obtenida
        etFecha = (EditText) findViewById(R.id.etFecha);
        //Widget ImageButton del cual usaremos el evento clic para obtener la fecha
        ibObtenerFecha = (ImageButton) findViewById(R.id.ibFecha);
        //Evento setOnClickListener - clic
        ibObtenerFecha.setOnClickListener(this);

        ibObtenerCorte = findViewById(R.id.ibCorte);
        ibObtenerCorte.setOnClickListener(this);

        ibObtenerBarbero = findViewById(R.id.ibBarbero);
        ibObtenerBarbero.setOnClickListener(this);

        tvCorte = findViewById(R.id.tvCorte);
        spTipo = findViewById(R.id.spTipo);
        etCorte = findViewById(R.id.etCorte);
        etBarbero = findViewById(R.id.etBarbero);
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
                if (etFecha.getText().toString().length()==0 || etHora.getText().toString().length()==0 || etCorte.getText().toString().length()==0 || etBarbero.getText().toString().length()==0){
                    if(etFecha.getText().toString().length()==0)
                        etFecha.setError("Campo Obligatorio");
                    if(etHora.getText().toString().length()==0)
                        etHora.setError("Campo Obligatorio");
                    if(etCorte.getText().toString().length()==0)
                        etCorte.setError("Campo Obligatorio");
                    if(etBarbero.getText().toString().length()==0)
                        etBarbero.setError("Campo Obligatorio");
                }
                else
                {
                    Cita c = new Cita();
                    c.setDia(etFecha.getText().toString());
                    c.setHora(etHora.getText().toString());
                    c.setId_cliente(Preferences.ObtenerId(this));
                    c.setId_user(id_user);
                    c.setId_corte(id_corte);

                    try{
                        DbBarberia.getAppDatabase(this).citaDao().Insertar(c);
                    }
                    catch (SQLiteConstraintException e){
                        Toast.makeText(this, "NO se puedo ingresar", Toast.LENGTH_SHORT).show();
                    }
                }
                finish();
                break;
            case R.id.mnCancel:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.ibFecha:
                obtenerFecha();
                break;
            case R.id.ibHora:
                obtenerHora();
                break;
            case R.id.ibCorte:
                if (spTipo.getSelectedItem().toString().equals("Cabello"))
                {
                    Intent intent = new Intent(RegistrarCitaActivity.this,ListCabelloActivity.class);
                    startActivityForResult(intent, 4444);
                }
                if (spTipo.getSelectedItem().toString().equals("Barba"))
                {
                    Intent intent = new Intent(RegistrarCitaActivity.this,ListBarbaActivity.class);
                    startActivityForResult(intent, 4445);
                }
                if (spTipo.getSelectedItem().toString().equals("Combo"))
                {
                    Intent intent = new Intent(RegistrarCitaActivity.this,ListComboActivity.class);
                    startActivityForResult(intent, 4446);
                }
                break;
            case R.id.ibBarbero:
                Intent intent = new Intent(RegistrarCitaActivity.this,ListUserActivity.class);
                startActivityForResult(intent, 4447);
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode==4444 || requestCode==4445 || requestCode==4446){
            if(resultCode==RESULT_OK){
                Bundle extras =data.getExtras();

                if(extras!=null)
                {
                    id_corte = extras.getInt("id");
                    etCorte.setText(extras.getString("nombre"));
                }

            }
        }

        if (requestCode==4447)
        {
            if(resultCode==RESULT_OK){
                Bundle extras =data.getExtras();

                if(extras!=null)
                {
                    id_user = extras.getInt("id");
                    etBarbero.setText(extras.getString("nombre"));
                }

            }
        }
    }

    private void obtenerHora(){
        TimePickerDialog recogerHora = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                //Formateo el hora obtenido: antepone el 0 si son menores de 10
                String horaFormateada =  (hourOfDay < 10)? String.valueOf(CERO + hourOfDay) : String.valueOf(hourOfDay);
                //Formateo el minuto obtenido: antepone el 0 si son menores de 10
                String minutoFormateado = (minute < 10)? String.valueOf(CERO + minute):String.valueOf(minute);
                //Obtengo el valor a.m. o p.m., dependiendo de la selección del usuario
                String AM_PM;
                if(hourOfDay < 12) {
                    AM_PM = "a.m.";
                } else {
                    AM_PM = "p.m.";
                }
                //Muestro la hora con el formato deseado
                etHora.setText(horaFormateada + DOS_PUNTOS + minutoFormateado + " " + AM_PM);
            }
            //Estos valores deben ir en ese orden
            //Al colocar en false se muestra en formato 12 horas y true en formato 24 horas
            //Pero el sistema devuelve la hora en formato 24 horas
        }, hora, minuto, false);

        recogerHora.show();
    }

    private void obtenerFecha(){
        DatePickerDialog recogerFecha = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                //Esta variable lo que realiza es aumentar en uno el mes ya que comienza desde 0 = enero
                final int mesActual = month + 1;
                //Formateo el día obtenido: antepone el 0 si son menores de 10
                String diaFormateado = (dayOfMonth < 10)? CERO + String.valueOf(dayOfMonth):String.valueOf(dayOfMonth);
                //Formateo el mes obtenido: antepone el 0 si son menores de 10
                String mesFormateado = (mesActual < 10)? CERO + String.valueOf(mesActual):String.valueOf(mesActual);
                //Muestro la fecha con el formato deseado
                etFecha.setText(diaFormateado + BARRA + mesFormateado + BARRA + year);


            }
            //Estos valores deben ir en ese orden, de lo contrario no mostrara la fecha actual
        },anio, mes, dia);
        //Muestro el widget
        recogerFecha.show();

    }
}
