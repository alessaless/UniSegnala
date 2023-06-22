package com.example.unisegnala;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;

public class HomePage extends Fragment {

    Dialog dialog;
    ArrayList<Segnalazione> segnalazioni;
    AdapterSegnalazione adapter;
    public HomePage() {
        // Costruttore vuoto richiesto
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.home_page, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        dialog = new Dialog(getContext());
        ListView listView = view.findViewById(R.id.listView);


        segnalazioni = new ArrayList<>();
        segnalazioni.add(new Segnalazione("Tetto caduto", "È caduto il tetto nel bagno di F al primo piano."));
        segnalazioni.add(new Segnalazione("Porta Rotta", "La porta del laboratorio Hopper è stata manomessa."));
        segnalazioni.add(new Segnalazione("Auto danneggiata", "Nel parcheggio la mia auto è stata danneggiata."));

        adapter = new AdapterSegnalazione(getContext(), segnalazioni);
        listView.setAdapter(adapter);

        FloatingActionButton fab = view.findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openModal();
            }
        });

    }

    private void openModal(){
        dialog.setContentView(R.layout.modal_aggiungi_segnalazione);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        Button btnAggiungi = dialog.findViewById(R.id.buttonAggiungi);
        EditText titolo = dialog.findViewById(R.id.editTextTitolo);
        EditText descrizione = dialog.findViewById(R.id.editTextDescrizione);;
        btnAggiungi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(titolo.getText().length() != 0 && descrizione.getText().length() != 0){
                    segnalazioni.add(new Segnalazione(titolo.getText().toString(), descrizione.getText().toString()));
                    inviaSegnalazione(view);
                }
            }
        });
        dialog.show();
    }

    private void inviaSegnalazione(View view){
        dialog.dismiss();
        dialog.setContentView(R.layout.modal_segnalazione_aggiunta);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        Button btnChiudi = dialog.findViewById(R.id.buttonChiudi);
        btnChiudi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chiudiModal(view);
            }
        });
        dialog.show();
    }

    public void chiudiModal(View view){
        dialog.dismiss();
        adapter.notifyDataSetChanged();
    }


}