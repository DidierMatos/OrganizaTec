package com.example.kys.organizatec;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class ClsLogin2 extends AppCompatActivity implements View.OnClickListener{
    private String nom;
    private EditText nombre;
    private Button finalizar;
    private Spinner grupospinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lytclslogin2);

        nombre = (EditText)findViewById(R.id.editNombre);
        finalizar = (Button)findViewById(R.id.btnFinalizar);

        finalizar.setOnClickListener(this);

        grupospinner = (Spinner) findViewById(R.id.spnGrupo);
        final String []grupo = {"Seleccione su Grupo","A", "B", "C", "D"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,grupo);
        grupospinner.setAdapter(adapter);

        final Spinner cmbgrupo;

        cmbgrupo = (Spinner) findViewById(R.id.spnGrupo);
        adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        cmbgrupo.setAdapter(adapter);

        cmbgrupo.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override

            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {


                String select = cmbgrupo.getSelectedItem().toString();
                if (select.equals("A")){

                }

                String select2 = cmbgrupo.getSelectedItem().toString();
                if (select2.equals("B")){

                }
                String select3 = cmbgrupo.getSelectedItem().toString();
                if (select3.equals("C")){

                }
                String select4 = cmbgrupo.getSelectedItem().toString();
                if (select4.equals("D")){

                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


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
            Intent intent = new Intent(ClsLogin2.this, ClsMainActivity.class);
            startActivity(intent);
        }
    }

    private boolean isNombreValid(String nombre) {

        return nombre.length()>4;
    }
}