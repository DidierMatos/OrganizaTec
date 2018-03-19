package com.example.kys.organizatec;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class Unidades extends AppCompatActivity implements View.OnClickListener{

    private Button continuar;
    private Spinner unidadspinner, carreraspinner, semestrespinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unidades2);

        continuar = (Button)findViewById(R.id.continuar);

        continuar.setOnClickListener(this);

        unidadspinner = (Spinner) findViewById(R.id.spinner1);
        final String []unidad = {"Seleccione su Unidad", "Felipe Carrillo Puerto", "Tihosuco", "Chunhuhub"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,unidad);
        unidadspinner.setAdapter(adapter);

        carreraspinner = (Spinner) findViewById(R.id.spinner2);
        final String []carrera = {"Seleccione su Carrera", "Ing. En Sistemas Computacionales", "Ing. En Gestión Empresarial", "Ing. Industrial", "Ing. En Industrias Alimentarias", "Ing. en Administración"};
        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,carrera);
        carreraspinner.setAdapter(adapter2);

        semestrespinner = (Spinner) findViewById(R.id.spinner3);
        final String []semestre = {"Seleccione su Semestre", "II", "IV", "VI", "VIII", "X"};
        ArrayAdapter<String> adapter3 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,semestre);
        semestrespinner.setAdapter(adapter3);


        final Spinner cmbunidad, cmbcarrera, cmbsemestre;

        cmbunidad = (Spinner) findViewById(R.id.spinner1);
        adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        cmbunidad.setAdapter(adapter);

        cmbcarrera = (Spinner) findViewById(R.id.spinner2);
        adapter2.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        cmbcarrera.setAdapter(adapter2);

        cmbsemestre = (Spinner) findViewById(R.id.spinner3);
        adapter3.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        cmbsemestre.setAdapter(adapter3);

        cmbunidad.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override

            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                //Aqui se realizarian las acciones con la base de datos
                String select = cmbunidad.getSelectedItem().toString();
                if (select.equals("Felipe Carrillo Puerto")){

                }

                String select2 = cmbunidad.getSelectedItem().toString();
                if (select2.equals("Tihosuco")){


                }

                String select3 = cmbunidad.getSelectedItem().toString();
                if (select3.equals("Chunhuhub")){


                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        cmbcarrera.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override

            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                //Aqui se realizarian las acciones con la base de datos
                String select = cmbcarrera.getSelectedItem().toString();
                if (select.equals("Ing. En Sistemas Computacionales")){

                }

                //Aqui se realizarian las acciones con la base de datos
                String select2 = cmbcarrera.getSelectedItem().toString();
                if (select2.equals("Ing. En Gestión Empresarial")){

                }

                //Aqui se realizarian las acciones con la base de datos
                String select3 = cmbcarrera.getSelectedItem().toString();
                if (select3.equals("Ing. Industrial")){

                }

                String select4 = cmbcarrera.getSelectedItem().toString();
                if (select4.equals("Ing. En Industrias Alimentarias")){

                }

                String select5 = cmbcarrera.getSelectedItem().toString();
                if (select5.equals("Ing. en Administración")){

                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        cmbsemestre.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override

            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {


                String select = cmbsemestre.getSelectedItem().toString();
                if (select.equals("II")){

                }

                String select2 = cmbsemestre.getSelectedItem().toString();
                if (select2.equals("IV")){

                }

                String select3 = cmbsemestre.getSelectedItem().toString();
                if (select3.equals("VI")){

                }

                String select4 = cmbsemestre.getSelectedItem().toString();
                if (select4.equals("VIII")){

                }

                String select5 = cmbsemestre.getSelectedItem().toString();
                if (select5.equals("X")){

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
            case R.id.continuar:
                Intent intent = new Intent(Unidades.this, Formulario.class);
                startActivity(intent);
        }

    }

}