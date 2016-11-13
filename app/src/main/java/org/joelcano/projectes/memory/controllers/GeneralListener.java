package org.joelcano.projectes.memory.controllers;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

import org.joelcano.projectes.memory.R;
import org.joelcano.projectes.memory.llogica.Partida;

import android.os.Handler;
public class GeneralListener implements AdapterView.OnItemClickListener{
    TaulerGrid taulerGrid;
    Partida partida;
    int primera, segona;
    ImageView imageViewPrimera;
    ImageView imageView;
    boolean enUs;
    public Context mContext;

    public GeneralListener(TaulerGrid taulerGrid, ImageAdapter imageAdapter, Partida partida, Context c) {
        this.taulerGrid = taulerGrid;
        this.partida = partida;
        mContext = c;
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {
        //si la carta esta tapada, la marquem com a descoberta i la mostrem
        if(partida.getCartas()[position].getEstat()== 0 && !(enUs)) {
            partida.getCartas()[position].setEstat(1);
            partida.setTurno(partida.getTurno() + 1);
            imageView = (ImageView) view;
            imageView.setImageResource(partida.getCartas()[position].getValor());
            if (partida.getTurno() % 2 != 0) {
                primera = position;
                imageViewPrimera = imageView;
            } else if (position != primera) {
                segona = position;
                if (partida.getCartas()[primera].getValor() != partida.getCartas()[segona].getValor()) {
                    enUs = true;
                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        public void run() {
                            imageView.setImageResource(R.drawable.dorso);
                            partida.getCartas()[primera].setEstat(0);
                            imageViewPrimera.setImageResource(R.drawable.dorso);
                            partida.getCartas()[position].setEstat(0);
                            enUs = false;
                        }
                    }, 2000);

                }
            }
        }
        if (partida.esAcabada()){
            new AlertDialog.Builder(mContext)
                    .setTitle("Partida Finalitzada. ")
                    .setMessage("Vols tornar a jugar?")
                    .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            taulerGrid.finish();
                        }
                    })
                    .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            // do nothing
                        }
                    })
                    .setIcon(android.R.drawable.ic_dialog_alert)
                    .show();
        }
    }
}
