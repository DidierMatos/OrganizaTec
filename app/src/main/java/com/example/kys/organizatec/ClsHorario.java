package com.example.kys.organizatec;

import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
/**
 * Created by Didier on 14/03/2018.
 */

public class ClsHorario extends AppCompatActivity {

    TextView prueba;
    //ClsLogin2 nombrealumno = (ClsLogin2) getIntent().getExtras().getSerializable("nombrealumno");
    //String nombrealumno = getIntent().getStringExtra("nombrealumno");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lytclshorario);


        prueba = (TextView) findViewById(R.id.pruebaTxtVw);


        Bundle bundle = getIntent().getExtras();
        String dato = bundle.getString("nombrealumno").toString();

        prueba.setText("Bienvenido " + dato);

    }
}
