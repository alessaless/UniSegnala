package com.example.unisegnala;

public class Premio {
    private String descrizione;
    private String punteggio;

    public Premio(String descrizione, String punteggio) {
        this.descrizione = descrizione;
        this.punteggio = punteggio;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public String getPunteggio() {
        return punteggio;
    }

    public void setPunteggio(String punteggio) {
        this.punteggio = punteggio;
    }
}
