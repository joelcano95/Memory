package org.joelcano.projectes.memory.llogica;

import org.joelcano.projectes.memory.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * Created by ALUMNEDAM on 28/01/2016.
 */
public class Partida {
    int nCartes;
    private Casella[]cartas;
    int turno;
    ArrayList<Integer> imatges = new ArrayList<Integer>(
            Arrays.asList(R.drawable.image_0, R.drawable.image_1, R.drawable.image_2, R.drawable.image_3,
                    R.drawable.image_4, R.drawable.image_5, R.drawable.image_6, R.drawable.image_7));


    public Partida(int nCartes) {
        this.nCartes = nCartes;
        turno = 0;
        repartirCartes();
    }

    public void repartirCartes(){
        cartas = new Casella[nCartes];
        for (int i=0; i<nCartes; i++){
            cartas[i]=new Casella(imatges.get(i/2), 0);
        }
        List <Casella> myarr = Arrays.asList(cartas);
        Collections.shuffle(myarr);
        cartas = myarr.toArray(cartas);
    }

    public boolean esAcabada(){
        for (Casella c:cartas){
            if (c.getEstat()==0)return false;
        }
        return true;
    }
    public int getnCartes() {
        return nCartes;
    }

    public Casella[] getCartas() {
        return cartas;
    }

    public void setTurno(int turno) {
        this.turno = turno;
    }

    public int getTurno() {
        return turno;
    }
}
