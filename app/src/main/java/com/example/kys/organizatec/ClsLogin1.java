package com.example.kys.organizatec;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class ClsLogin1 extends AppCompatActivity implements View.OnClickListener{

    private Button continuar;
    private Spinner unidadspinner, carreraspinner, semestrespinner;
    private ArrayList<String> listaPersonas;
    private ArrayList<ClsInfoLogin> personasList;
    private ClsConexionDbHelper conn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lytclslogin1);

        conn = new ClsConexionDbHelper(ClsLogin1.this);
        SQLiteDatabase database = conn.getReadableDatabase();

        unidadspinner = (Spinner) findViewById(R.id.spnUnidad);
        carreraspinner = (Spinner) findViewById(R.id.spnCarrera);
        semestrespinner = (Spinner) findViewById(R.id.spnSemestre);

        continuar = (Button) findViewById(R.id.continuar);
        continuar.setOnClickListener(this);


        consultarListaPersona();


        ArrayAdapter<CharSequence> adaptador = new ArrayAdapter(this,android.R.layout.simple_spinner_item,listaPersonas);
        unidadspinner.setAdapter(adaptador);

        unidadspinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                SQLiteDatabase db = conn.getReadableDatabase();
                //String selected = parent.getItemAtPosition(0).toString();

                if (position==1){
                    //Toast.makeText(ClsLogin1.this,"Seleccionaste la posicion 1", Toast.LENGTH_LONG).show();

                }

                switch(position){
                    case 1:
                        Toast.makeText(ClsLogin1.this,"Seleccionaste la posicion 1", Toast.LENGTH_LONG).show();
                        break;
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private void consultarListaPersona() {
        SQLiteDatabase db = conn.getReadableDatabase();

        ClsInfoLogin info = null;
        personasList = new ArrayList<ClsInfoLogin>();
        Cursor cursor = db.rawQuery("SELECT unid_ac.Nombre_unid FROM unid_ac",null);

        while(cursor.moveToNext()){
            info = new ClsInfoLogin();
            //info.setId(cursor.getInt(0));
            info.setUnidad(cursor.getString(0));

            Log.i("Unidad",info.getUnidad().toString());

            personasList.add(info);

        }

        obtenerLista();

    }

    private void obtenerLista() {

        listaPersonas = new ArrayList<String>();
        listaPersonas.add("Seleccione una unidad");

        for(int i=0; i<personasList.size();i++){

            listaPersonas.add((personasList.get(i).getUnidad()));
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.continuar:
                Intent intent = new Intent(ClsLogin1.this, ClsHorario.class);
                startActivity(intent);
        }

    }


}