package org.joelcano.projectes.memory.llogica;

public class Casella {
    private int valor;
    private int estat;


    public Casella(int valor, int estat) {
        this.estat = estat;
        this.valor = valor;
    }

    public int getEstat() {
        return estat;
    }

    public int getValor() {
        return valor;
    }

    public void setEstat(int estat) {
        this.estat = estat;
    }
}
