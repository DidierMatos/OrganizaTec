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
    private ArrayList<String> listaUnidades;
    private ArrayList<ClsInfoLogin> unidadesList;
    private ArrayList<String> listaCarreras;
    private ArrayList<ClsInfoLogin> carrerasList;
    private ArrayList<String> listaSemestre;
    private ArrayList<ClsInfoLogin> semestreList;
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


        consultarListaUnidades();
        consultarListaCarreras();
        consultarListaSemestre();


        ArrayAdapter<CharSequence> adaptador = new ArrayAdapter(this,android.R.layout.simple_spinner_item,listaUnidades);
        unidadspinner.setAdapter(adaptador);


        unidadspinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //SQLiteDatabase db = conn.getReadableDatabase();
                //String selected = parent.getItemAtPosition(0).toString();
/*              if (position==1){
                    //Toast.makeText(ClsLogin1.this,"Seleccionaste la posicion 1", Toast.LENGTH_LONG).show();
                }*/
                switch(position){

                    case 1:
                        //Toast.makeText(ClsLogin1.this,"Seleccionaste la posicion 1", Toast.LENGTH_LONG).show();
                        desplegarListaCarreras();

                        carreraspinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                            @Override
                            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                                switch(position){
                                    case 1:
                                        desplegarListaSemestre();

                                        semestrespinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                            @Override
                                            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                                                switch(position) {
                                                    case 1:case 2:case 3:case 4:
                                                    Toast.makeText(ClsLogin1.this, "Seleccionaste la opcion 1,2,3 o 4", Toast.LENGTH_LONG).show();
                                                }
                                            }

                                            @Override
                                            public void onNothingSelected(AdapterView<?> parent) {

                                            }
                                        });
                                    break;
                                }

                            }

                            @Override
                            public void onNothingSelected(AdapterView<?> parent) {

                            }
                        });


                        break;
                    case 2:
                        //Toast.makeText(ClsLogin1.this,"Seleccionaste la posicion 2", Toast.LENGTH_LONG).show();
                        
                    case 3:
                        //Toast.makeText(ClsLogin1.this,"Seleccionaste la posicion 3", Toast.LENGTH_LONG).show();
                    case 4:
                        //Toast.makeText(ClsLogin1.this,"Seleccionaste la posicion 4", Toast.LENGTH_LONG).show();
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private void consultarListaUnidades() {
        SQLiteDatabase db = conn.getReadableDatabase();

        ClsInfoLogin info = null;
        unidadesList = new ArrayList<ClsInfoLogin>();
        Cursor cursor = db.rawQuery("SELECT unid_ac.Nombre_unid FROM unid_ac",null);

        while(cursor.moveToNext()){
            info = new ClsInfoLogin();
            //info.setId(cursor.getInt(0));
            info.setUnidad(cursor.getString(0));

            Log.i("Unidad",info.getUnidad().toString());

            unidadesList.add(info);

        }

        obtenerListaUnidades();

    }

    private void obtenerListaUnidades() {

        listaUnidades = new ArrayList<String>();
        listaUnidades.add("Seleccione una unidad");

        for(int i=0; i<unidadesList.size();i++){

            listaUnidades.add((unidadesList.get(i).getUnidad()));
        }
    }

    private void consultarListaCarreras() {

        SQLiteDatabase db = conn.getReadableDatabase();

        ClsInfoLogin info = null;
        carrerasList = new ArrayList<ClsInfoLogin>();
        Cursor cursor = db.rawQuery("select carreras.Nombre_carr\n" +
                "from unid_ac, carreras\n" +
                "where unid_ac.id_unid_ac = carreras.id_unid_ac\n" +
                " and unid_ac.id_unid_ac='1'",null);

        while(cursor.moveToNext()){
            info = new ClsInfoLogin();
            //info.setId(cursor.getInt(0));
            info.setCarrera(cursor.getString(0));

            Log.i("Unidad",info.getCarrera().toString());

            carrerasList.add(info);

        }

        obtenerListaCarreras();

    }

    private void obtenerListaCarreras() {

        listaCarreras = new ArrayList<String>();
        listaCarreras.add("Seleccione una carrera");

        for(int i=0; i<carrerasList.size();i++){

            listaCarreras.add((carrerasList.get(i).getCarrera()));
        }
    }

    private void desplegarListaCarreras(){

        ArrayAdapter<CharSequence> adaptador2 = new ArrayAdapter(this,android.R.layout.simple_spinner_item,listaCarreras);
        carreraspinner.setAdapter(adaptador2);

    }

    private void consultarListaSemestre() {

        SQLiteDatabase db = conn.getReadableDatabase();

        ClsInfoLogin info = null;
        semestreList = new ArrayList<ClsInfoLogin>();
        Cursor cursor = db.rawQuery("select semestre.descripcion\n" +
                "from carreras,semestre\n" +
                "where semestre.id_semestre = carreras.id_Carreras\n" +
                " and semestre.id_semestre != '1'\n" + "and semestre.id_semestre !='3'\n"
                + " and semestre.id_semestre != '5'\n" + "and semestre.id_semestre !='7'\n",null);

        while(cursor.moveToNext()){
            info = new ClsInfoLogin();
            //info.setId(cursor.getInt(0));
            info.setSemestre(cursor.getString(0));

            Log.i("Unidad",info.getSemestre().toString());

            semestreList.add(info);

        }

        obtenerListaSemestre();

    }

    private void obtenerListaSemestre() {

        listaSemestre= new ArrayList<String>();
        listaSemestre.add("Seleccione un semestre");

        for(int i=0; i<semestreList.size();i++){

            listaSemestre.add((semestreList.get(i).getSemestre()));
        }
    }

    private void desplegarListaSemestre(){

        ArrayAdapter<CharSequence> adaptador3 = new ArrayAdapter(this,android.R.layout.simple_spinner_item,listaSemestre);
        semestrespinner.setAdapter(adaptador3);

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