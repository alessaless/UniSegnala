package com.example.unisegnala;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class Segnalazioni extends Fragment {

    public Segnalazioni() {
        // Costruttore vuoto richiesto
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Infla il layout del fragment per la visualizzazione
        View view = inflater.inflate(R.layout.segnalazioni_page, container, false);
        // Personalizza la visualizzazione del fragment se necessario
        return view;
    }
}