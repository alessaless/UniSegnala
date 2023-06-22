package com.example.unisegnala;

import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class PremiActivity extends Fragment {

    public PremiActivity() {
        // Costruttore vuoto richiesto
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Infla il layout del fragment per la visualizzazione
        View view = inflater.inflate(R.layout.premi_page, container, false);
        // Personalizza la visualizzazione del fragment se necessario

        TextView textView = view.findViewById(R.id.testoPunteggio);

        String message = "I tuoi punti: 500";

        // Creazione di una SpannableString per manipolare il testo
        SpannableString spannableString = new SpannableString(message);

        // Individuazione della posizione in cui inizia e finisce il numero
        int start = message.indexOf(":") + 1;
        int end = message.length();

        // Creazione di un ForegroundColorSpan per impostare il colore del numero
        ForegroundColorSpan colorSpan = new ForegroundColorSpan(Color.RED);

        // Applicazione dello stile al numero specificando l'intervallo di caratteri
        spannableString.setSpan(colorSpan, start, end, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

        // Impostazione del testo nel TextView
        textView.setText(spannableString);


        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ListView listView = view.findViewById(R.id.listaPremi);

        ArrayList<Premio> premi = new ArrayList<>();

        premi.add(new Premio("5% sconto sulle fotocopie","250"));
        premi.add(new Premio("Borraccia gratuita in associazione","750"));


        AdapterPremio adapterPremio = new AdapterPremio(getContext(),premi);
        listView.setAdapter(adapterPremio);

    }


}