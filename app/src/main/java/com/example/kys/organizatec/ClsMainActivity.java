package com.example.kys.organizatec;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ClsMainActivity extends AppCompatActivity implements View.OnClickListener{
    private Button iniciar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lytclsmainactivity);
        iniciar = (Button)findViewById(R.id.btnIniciar);
        iniciar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.btnIniciar:

                Intent intent = new Intent(ClsMainActivity.this, ClsLogin1.class);
                startActivity(intent);
        }
    }
}
