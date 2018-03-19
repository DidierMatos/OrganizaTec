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
    private ArrayList<String> listaCarrerasFCP;
    private ArrayList<ClsInfoLogin> carrerasListFCP;
    private ArrayList<String> listaCarrerasTulum;
    private ArrayList<ClsInfoLogin> carrerasListTulum;
    private ArrayList<String> listaCarrerasTiho;
    private ArrayList<ClsInfoLogin> carrerasListTiho;
    private ArrayList<String> listaCarrerasChunh;
    private ArrayList<ClsInfoLogin> carrerasListChunh;
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
        consultarListaCarrerasFCP();
        consultarListaCarrerasTulum();
        consultarListaCarrerasTiho();
        consultarListaCarrerasChunh();
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
                        desplegarListaCarrerasFCP();

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
                        desplegarListaCarrerasTulum();

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
                    case 3:
                        //Toast.makeText(ClsLogin1.this,"Seleccionaste la posicion 3", Toast.LENGTH_LONG).show();
                        desplegarListaCarrerasTiho();

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
                    case 4:
                        //Toast.makeText(ClsLogin1.this,"Seleccionaste la posicion 4", Toast.LENGTH_LONG).show();
                        desplegarListaCarrerasChunh();

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

    //#########################FELIPE CARRILLO PUERTO#####################//

    private void consultarListaCarrerasFCP() {

        SQLiteDatabase db = conn.getReadableDatabase();

        ClsInfoLogin info = null;
        carrerasListFCP = new ArrayList<ClsInfoLogin>();
        Cursor cursor = db.rawQuery("select carreras.Nombre_carr\n" +
                "from unid_ac, carreras\n" +
                "where unid_ac.id_unid_ac = carreras.id_unid_ac\n" +
                " and unid_ac.id_unid_ac='1'",null);

        while(cursor.moveToNext()){
            info = new ClsInfoLogin();
            //info.setId(cursor.getInt(0));
            info.setCarrera(cursor.getString(0));

            Log.i("Carrera",info.getCarrera().toString());

            carrerasListFCP.add(info);

        }

        obtenerListaCarrerasFCP();

    }

    private void obtenerListaCarrerasFCP() {

        listaCarrerasFCP = new ArrayList<String>();
        listaCarrerasFCP.add("Seleccione una carrera");

        for(int i=0; i<carrerasListFCP.size();i++){

            listaCarrerasFCP.add((carrerasListFCP.get(i).getCarrera()));
        }
    }

    private void desplegarListaCarrerasFCP(){

        ArrayAdapter<CharSequence> adaptador = new ArrayAdapter(this,android.R.layout.simple_spinner_item,listaCarrerasFCP);
        carreraspinner.setAdapter(adaptador);

    }
    //#########################FIN FELIPE CARRILLO PUERTO#####################//


    //#########################TULUM#####################//
    private void consultarListaCarrerasTulum() {

        SQLiteDatabase db = conn.getReadableDatabase();

        ClsInfoLogin info = null;
        carrerasListTulum = new ArrayList<ClsInfoLogin>();
        Cursor cursor = db.rawQuery("select carreras.Nombre_carr\n" +
                "from unid_ac, carreras\n" +
                "where unid_ac.id_unid_ac = carreras.id_unid_ac\n" +
                " and unid_ac.id_unid_ac='2'",null);

        while(cursor.moveToNext()){
            info = new ClsInfoLogin();
            //info.setId(cursor.getInt(0));
            info.setCarrera(cursor.getString(0));

            Log.i("Carrera",info.getCarrera().toString());

            carrerasListTulum.add(info);

        }

        obtenerListaCarrerasTulum();

    }

    private void obtenerListaCarrerasTulum() {

        listaCarrerasTulum = new ArrayList<String>();
        listaCarrerasTulum.add("Seleccione una carrera");

        for(int i=0; i<carrerasListTulum.size();i++){

            listaCarrerasTulum.add((carrerasListTulum.get(i).getCarrera()));
        }
    }

    private void desplegarListaCarrerasTulum(){

        ArrayAdapter<CharSequence> adaptador = new ArrayAdapter(this,android.R.layout.simple_spinner_item,listaCarrerasTulum);
        carreraspinner.setAdapter(adaptador);

    }
    //#########################FIN TULUM#####################//


    //#########################TIHOSUCO#####################//
    private void consultarListaCarrerasTiho() {

        SQLiteDatabase db = conn.getReadableDatabase();

        ClsInfoLogin info = null;
        carrerasListTiho = new ArrayList<ClsInfoLogin>();
        Cursor cursor = db.rawQuery("select carreras.Nombre_carr\n" +
                "from unid_ac, carreras\n" +
                "where unid_ac.id_unid_ac = carreras.id_unid_ac\n" +
                " and unid_ac.id_unid_ac='3'",null);

        while(cursor.moveToNext()){
            info = new ClsInfoLogin();
            //info.setId(cursor.getInt(0));
            info.setCarrera(cursor.getString(0));

            Log.i("Carrera",info.getCarrera().toString());

            carrerasListTiho.add(info);

        }

        obtenerListaCarrerasTiho();

    }

    private void obtenerListaCarrerasTiho() {

        listaCarrerasTiho = new ArrayList<String>();
        listaCarrerasTiho.add("Seleccione una carrera");

        for(int i=0; i<carrerasListTiho.size();i++){

            listaCarrerasTiho.add((carrerasListTiho.get(i).getCarrera()));
        }
    }

    private void desplegarListaCarrerasTiho(){

        ArrayAdapter<CharSequence> adaptador = new ArrayAdapter(this,android.R.layout.simple_spinner_item,listaCarrerasTiho);
        carreraspinner.setAdapter(adaptador);

    }
    //#########################FIN TIHOSUCO#####################//

    //#########################CHUNHUHUB#####################//
    private void consultarListaCarrerasChunh() {

        SQLiteDatabase db = conn.getReadableDatabase();

        ClsInfoLogin info = null;
        carrerasListChunh = new ArrayList<ClsInfoLogin>();
        Cursor cursor = db.rawQuery("select carreras.Nombre_carr\n" +
                "from unid_ac, carreras\n" +
                "where unid_ac.id_unid_ac = carreras.id_unid_ac\n" +
                " and unid_ac.id_unid_ac='4'",null);

        while(cursor.moveToNext()){
            info = new ClsInfoLogin();
            //info.setId(cursor.getInt(0));
            info.setCarrera(cursor.getString(0));

            Log.i("Carrera",info.getCarrera().toString());

            carrerasListChunh.add(info);

        }

        obtenerListaCarrerasChunh();

    }

    private void obtenerListaCarrerasChunh() {

        listaCarrerasChunh = new ArrayList<String>();
        listaCarrerasChunh.add("Seleccione una carrera");

        for(int i=0; i<carrerasListChunh.size();i++){

            listaCarrerasChunh.add((carrerasListChunh.get(i).getCarrera()));
        }
    }

    private void desplegarListaCarrerasChunh(){

        ArrayAdapter<CharSequence> adaptador = new ArrayAdapter(this,android.R.layout.simple_spinner_item,listaCarrerasChunh);
        carreraspinner.setAdapter(adaptador);

    }
    //#########################FIN CHUNHUHUB#####################//


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

            Log.i("Semestre",info.getSemestre().toString());

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