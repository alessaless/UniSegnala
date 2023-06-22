package com.example.unisegnala;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class PremiActivity extends Fragment {
    Dialog dialog;

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
        ForegroundColorSpan colorSpan = new ForegroundColorSpan(Color.parseColor("#DF405C"));

        // Applicazione dello stile al numero specificando l'intervallo di caratteri
        spannableString.setSpan(colorSpan, start, end, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

        int start2 = 0;
        int end2 = message.indexOf(":") + 1;

        ForegroundColorSpan colorSpan2 = new ForegroundColorSpan(Color.BLACK);
        spannableString.setSpan(colorSpan2, start2, end2, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        spannableString.setSpan(new StyleSpan(Typeface.BOLD), start2, end2, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);


        // Impostazione del testo nel TextView
        textView.setText(spannableString);


        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        dialog = new Dialog(getContext());

        ListView listView = view.findViewById(R.id.listaPremi);

        ArrayList<Premio> premi = new ArrayList<>();

        premi.add(new Premio("5% sconto sulle fotocopie","250 punti"));
        premi.add(new Premio("Borraccia gratuita in associazione","750 punti"));

        AdapterPremio adapterPremio = new AdapterPremio(getContext(),premi);
        listView.setAdapter(adapterPremio);

        Button button = view.findViewById(R.id.buttonRiscatta);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openModal();
            }
        });

    }

    private void openModal(){
        dialog.setContentView(R.layout.modal_riscatta_premio);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        Button buttonChiudi = dialog.findViewById(R.id.buttonChiudi);
        buttonChiudi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });

        dialog.show();


    }

}