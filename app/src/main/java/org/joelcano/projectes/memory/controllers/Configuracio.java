package org.joelcano.projectes.memory.controllers;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import org.joelcano.projectes.memory.R;

public class Configuracio extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configuracio);
        Button btnStart = (Button) findViewById(R.id.button);
        btnStart.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        RadioButton radioButton = (RadioButton)findViewById(R.id.radioButton);
        RadioButton radioButton2 = (RadioButton)findViewById(R.id.radioButton2);
        RadioButton radioButton3 = (RadioButton)findViewById(R.id.radioButton3);

        int nivell;
        if(radioButton.isChecked()) nivell = 8;
        else if (radioButton2.isChecked()) nivell = 12;
        else nivell = 16;

        Intent intent = new Intent(this, TaulerGrid.class);
        intent.putExtra("nivell", nivell);
        startActivity(intent);
    }
}
