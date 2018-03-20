package com.example.kys.organizatec;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;

public class ClsLogin2 extends AppCompatActivity implements View.OnClickListener,Serializable{
    private String nom;
    private EditText nombre;
    private Button finalizar;
    private Spinner grupospinner;
    private ArrayList<String> listaGrupoFCP;
    private ArrayList<ClsInfoLogin> grupoListFCP;
    private ArrayList<String> listaGrupoTulum;
    private ArrayList<ClsInfoLogin> grupoListTulum;
    private ArrayList<String> listaGrupoTiho;
    private ArrayList<ClsInfoLogin> grupoListTiho;
    private ArrayList<String> listaGrupoChunh;
    private ArrayList<ClsInfoLogin> grupoListChunh;
    private ClsConexionDbHelper conn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lytclslogin2);

        conn = new ClsConexionDbHelper(ClsLogin2.this);

        nombre = (EditText)findViewById(R.id.editNombre);
        finalizar = (Button)findViewById(R.id.btnFinalizar);
        grupospinner = (Spinner) findViewById(R.id.spnGrupo);
        finalizar.setOnClickListener(this);

        Intent mIntent = getIntent();
        int posunidad2 = mIntent.getIntExtra("posunidad2",0);
        Toast.makeText(ClsLogin2.this,"Seleccionaste la posicion: " + posunidad2, Toast.LENGTH_LONG).show();
        //int positionunidadint = Integer.parseInt(posunidad2);

        consultarListaGrupoFCP();
        obtenerListaGrupoFCP();
        consultarListaGrupoTulum();
        obtenerListaGrupoTulum();
        consultarListaGrupoTiho();
        obtenerListaGrupoTiho();
        consultarListaGrupoChunh();
        obtenerListaGrupoChunh();

        switch (posunidad2){
            case 1:
                ArrayAdapter<CharSequence> adaptador = new ArrayAdapter(this,android.R.layout.simple_spinner_item,listaGrupoFCP);
                grupospinner.setAdapter(adaptador);
                break;
            case 2:
                ArrayAdapter<CharSequence> adaptador2 = new ArrayAdapter(this,android.R.layout.simple_spinner_item,listaGrupoTulum);
                grupospinner.setAdapter(adaptador2);
                break;
            case 3:
                ArrayAdapter<CharSequence> adaptador3 = new ArrayAdapter(this,android.R.layout.simple_spinner_item,listaGrupoTiho);
                grupospinner.setAdapter(adaptador3);
                break;
            case 4:
                ArrayAdapter<CharSequence> adaptador4 = new ArrayAdapter(this,android.R.layout.simple_spinner_item,listaGrupoChunh);
                grupospinner.setAdapter(adaptador4);
                break;

        }



        //prueba.setText("Bienvenido " + dato);

        //int position = PreferenceManager.getDefaultSharedPreferences(this).getInt("position", 0); grupospinner.setSelection(position);
        grupospinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
 /*           SQLiteDatabase db = conn.getReadableDatabase();
              String selected = parent.getItemAtPosition(0).toString();
              if (position==1){
                    Toast.makeText(ClsLogin2.this,"Seleccionaste la posicion 1", Toast.LENGTH_LONG).show();
                }*/



            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


    }


    private void consultarListaGrupoFCP() {
        SQLiteDatabase db = conn.getReadableDatabase();

        ClsInfoLogin info = null;
        grupoListFCP = new ArrayList<ClsInfoLogin>();
        Cursor cursor = db.rawQuery("select grupo.categorias\n" +
                "from unid_ac,grupo\n" +
                "where unid_ac.id_unid_ac=grupo.id_unid_ac \n" +
                "and unid_ac.id_unid_ac='1'",null);

        while(cursor.moveToNext()){
            info = new ClsInfoLogin();
            //info.setId(cursor.getInt(0));
            info.setGrupo(cursor.getString(0));

            Log.i("Grupo",info.getGrupo().toString());

            grupoListFCP.add(info);

        }

        obtenerListaGrupoFCP();

    }

    private void obtenerListaGrupoFCP() {

        listaGrupoFCP = new ArrayList<String>();
        listaGrupoFCP.add("Seleccione un grupo");

        for(int i=0; i<grupoListFCP.size();i++){

            listaGrupoFCP.add((grupoListFCP.get(i).getGrupo()));
        }
    }


    private void consultarListaGrupoTulum() {
        SQLiteDatabase db = conn.getReadableDatabase();

        ClsInfoLogin info = null;
        grupoListTulum = new ArrayList<ClsInfoLogin>();
        Cursor cursor = db.rawQuery("select grupo.categorias\n" +
                "from unid_ac,grupo\n" +
                "where unid_ac.id_unid_ac=grupo.id_unid_ac \n" +
                "and unid_ac.id_unid_ac='2'",null);

        while(cursor.moveToNext()){
            info = new ClsInfoLogin();
            //info.setId(cursor.getInt(0));
            info.setGrupo(cursor.getString(0));

            Log.i("Grupo",info.getGrupo().toString());

            grupoListTulum.add(info);

        }

        obtenerListaGrupoTulum();

    }

    private void obtenerListaGrupoTulum() {

        listaGrupoTulum = new ArrayList<String>();
        listaGrupoTulum.add("Seleccione un grupo");

        for(int i=0; i<grupoListTulum.size();i++){

            listaGrupoTulum.add((grupoListTulum.get(i).getGrupo()));
        }
    }

    private void consultarListaGrupoTiho() {
        SQLiteDatabase db = conn.getReadableDatabase();

        ClsInfoLogin info = null;
        grupoListTiho = new ArrayList<ClsInfoLogin>();
        Cursor cursor = db.rawQuery("select grupo.categorias\n" +
                "from unid_ac,grupo\n" +
                "where unid_ac.id_unid_ac=grupo.id_unid_ac \n" +
                "and unid_ac.id_unid_ac='3'",null);

        while(cursor.moveToNext()){
            info = new ClsInfoLogin();
            //info.setId(cursor.getInt(0));
            info.setGrupo(cursor.getString(0));

            Log.i("Grupo",info.getGrupo().toString());

            grupoListTiho.add(info);

        }

        obtenerListaGrupoTiho();

    }

    private void obtenerListaGrupoTiho() {

        listaGrupoTiho = new ArrayList<String>();
        listaGrupoTiho.add("Seleccione un grupo");

        for(int i=0; i<grupoListTiho.size();i++){

            listaGrupoTiho.add((grupoListTiho.get(i).getGrupo()));
        }
    }


    private void consultarListaGrupoChunh() {
        SQLiteDatabase db = conn.getReadableDatabase();

        ClsInfoLogin info = null;
        grupoListChunh = new ArrayList<ClsInfoLogin>();
        Cursor cursor = db.rawQuery("select grupo.categorias\n" +
                "from unid_ac,grupo\n" +
                "where unid_ac.id_unid_ac=grupo.id_unid_ac \n" +
                "and unid_ac.id_unid_ac='4'",null);

        while(cursor.moveToNext()){
            info = new ClsInfoLogin();
            //info.setId(cursor.getInt(0));
            info.setGrupo(cursor.getString(0));

            Log.i("Grupo",info.getGrupo().toString());

            grupoListChunh.add(info);

        }

        obtenerListaGrupoChunh();

    }

    private void obtenerListaGrupoChunh() {

        listaGrupoChunh = new ArrayList<String>();
        listaGrupoChunh.add("Seleccione un grupo");

        for(int i=0; i<grupoListChunh.size();i++){

            listaGrupoChunh.add((grupoListChunh.get(i).getGrupo()));
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.btnFinalizar:
                attemptLogin();
        }
    }

    private void attemptLogin() {

        nombre.setError(null);


        nom = nombre.getText().toString();

        boolean cancel = false;
        View focusView = null;


        if (!isNombreValid(nom)) {
            nombre.setError("Ingresa tu Nombre");
            focusView = nombre;
            cancel = true;
        }

        if (cancel)
        {
            focusView.requestFocus();

        } else
        {
            //Toast.makeText(ClsLogin2.this,"Tu nombre es: " + nom, Toast.LENGTH_LONG).show();
            Intent intent = new Intent(ClsLogin2.this, ClsHorario.class);
            intent.putExtra("nombrealumno",nom);
            //int position = grupospinner.getSelectedItemPosition();
            //PreferenceManager.getDefaultSharedPreferences(this).edit().putInt("position",position).commit();
            startActivity(intent);
        }
    }

    private boolean isNombreValid(String nombre) {

        return nombre.length()>4;
    }
}