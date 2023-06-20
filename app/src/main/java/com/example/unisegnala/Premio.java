package com.example.unisegnala;

public class Premio {
    private String descrizione;
    private int punteggio;

    public Premio(String descrizione, int punteggio) {
        this.descrizione = descrizione;
        this.punteggio = punteggio;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public int getPunteggio() {
        return punteggio;
    }

    public void setPunteggio(int punteggio) {
        this.punteggio = punteggio;
    }
}
