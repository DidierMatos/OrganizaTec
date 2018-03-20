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
    private ArrayList<String> listaGrupo;
    private ArrayList<ClsInfoLogin> grupoList;
    private ClsConexionDbHelper conn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lytclslogin2);

        conn = new ClsConexionDbHelper(ClsLogin2.this);

        nombre = (EditText)findViewById(R.id.editNombre);
        finalizar = (Button)findViewById(R.id.btnFinalizar);
        finalizar.setOnClickListener(this);

        consultarListaGrupo();
        obtenerListaGrupo();

        ArrayAdapter<CharSequence> adaptador = new ArrayAdapter(this,android.R.layout.simple_spinner_item,listaGrupo);
        grupospinner.setAdapter(adaptador);


        grupospinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                SQLiteDatabase db = conn.getReadableDatabase();
                String selected = parent.getItemAtPosition(0).toString();
              if (position==1){
                    Toast.makeText(ClsLogin2.this,"Seleccionaste la posicion 1", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


    }


    private void consultarListaGrupo() {
        SQLiteDatabase db = conn.getReadableDatabase();

        ClsInfoLogin info = null;
        grupoList = new ArrayList<ClsInfoLogin>();
        Cursor cursor = db.rawQuery("select grupo.categorias\n" +
                "from unid_ac,grupo\n" +
                "where unid_ac.id_unid_ac=grupo.id_unid_ac \n" +
                "and unid_ac.id_unid_ac='1'",null);

        while(cursor.moveToNext()){
            info = new ClsInfoLogin();
            //info.setId(cursor.getInt(0));
            info.setGrupo(cursor.getString(0));

            Log.i("Grupo",info.getGrupo().toString());

            grupoList.add(info);

        }

        obtenerListaGrupo();

    }

    private void obtenerListaGrupo() {

        listaGrupo = new ArrayList<String>();
        listaGrupo.add("Seleccione un grupo");

        for(int i=0; i<grupoList.size();i++){

            listaGrupo.add((grupoList.get(i).getGrupo()));
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
            //intent.putExtra("nombrealumno",nom);
            int position = grupospinner.getSelectedItemPosition();
            PreferenceManager.getDefaultSharedPreferences(this).edit().putInt("position",position).commit();
            startActivity(intent);
        }
    }

    private boolean isNombreValid(String nombre) {

        return nombre.length()>4;
    }
}