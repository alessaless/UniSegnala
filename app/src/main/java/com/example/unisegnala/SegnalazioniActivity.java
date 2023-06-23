package com.example.unisegnala;

import android.app.Dialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.SwitchCompat;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ListView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class SegnalazioniActivity extends Fragment {
    Dialog dialog;
    ArrayList<Segnalazione> segnalazioni;
    AdapterSegnalazione adapter;

    public SegnalazioniActivity() {
        // Costruttore vuoto richiesto
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Infla il layout del fragment per la visualizzazione
        View view = inflater.inflate(R.layout.segnalazioni_page, container, false);
        // Personalizza la visualizzazione del fragment se necessario
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        dialog = new Dialog(getContext());
        ListView listView = view.findViewById(R.id.listaSegnalazioni);
        ArrayList<Segnalazione> segnalazioniVuote = new ArrayList<>();


        segnalazioni = new ArrayList<>();
        segnalazioni.add(new Segnalazione("Tetto caduto", "È caduto il tetto nel bagno di F al primo piano."));
        segnalazioni.add(new Segnalazione("Porta Rotta", "La porta del laboratorio Hopper è stata manomessa."));
        segnalazioni.add(new Segnalazione("Auto danneggiata", "Nel parcheggio la mia auto è stata danneggiata."));
        segnalazioni.add(new Segnalazione("Riscaldamenti spenti", "I condizionatori di aula F3 non si accendono."));

        riempiArrayList(segnalazioni,listView);

        SwitchCompat switchCompat = view.findViewById(R.id.slider);
        switchCompat.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if(isChecked){
                    svuotaArrayList(segnalazioniVuote,listView);
                } else {
                    riempiArrayList(segnalazioni,listView);
                }
            }
        });


    }

    private void riempiArrayList(ArrayList<Segnalazione> segnalazioni, ListView listView){
        adapter = new AdapterSegnalazione(getContext(), segnalazioni);
        listView.setAdapter(adapter);
    }

    private void svuotaArrayList(ArrayList<Segnalazione> segnalazioni, ListView listView){
        adapter = new AdapterSegnalazione(getContext(), segnalazioni);
        listView.setAdapter(adapter);
    }
}