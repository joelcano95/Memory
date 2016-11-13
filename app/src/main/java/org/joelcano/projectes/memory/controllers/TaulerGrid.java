package org.joelcano.projectes.memory.controllers;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.GridView;

import org.joelcano.projectes.memory.R;
import org.joelcano.projectes.memory.llogica.Partida;

public class TaulerGrid extends AppCompatActivity {
    /** Called when the activity is first created. */
    Partida partida;
    GridView gv;
    ImageAdapter imageAdapter;
    Intent intent;
    public int nCaselles;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tauler);
        intent = getIntent();

        nCaselles = intent.getIntExtra("nivell", 0);

        gv = (GridView)findViewById(R.id.gridview);
        partida = new Partida(nCaselles);
        imageAdapter = new ImageAdapter(this, partida);
        gv.setAdapter(imageAdapter);
        GeneralListener listener = new GeneralListener(this, imageAdapter, partida, this);
        gv.setOnItemClickListener(listener);

    }

}