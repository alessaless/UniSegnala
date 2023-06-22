package com.example.unisegnala;

import android.app.AlertDialog;
import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
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
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class Profilo extends Fragment {

    Dialog dialog;
    public Profilo() {
        // Costruttore vuoto richiesto
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Infla il layout del fragment per la visualizzazione
        View view = inflater.inflate(R.layout.profilo_page, container, false);
        // Personalizza la visualizzazione del fragment se necessario

        TextView textView = view.findViewById(R.id.textview_email);

        String message = "Email: example@example.com";

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

        TextView textView1 = view.findViewById(R.id.textview_password);

        String mess = "Password: **********";

        // Creazione di una SpannableString per manipolare il testo
        SpannableString spannableString1 = new SpannableString(mess);

        // Individuazione della posizione in cui inizia e finisce il numero
        int start1 = mess.indexOf(":") + 1;
        int end1 = mess.length();

        // Creazione di un ForegroundColorSpan per impostare il colore del numero
        ForegroundColorSpan colorSpan1 = new ForegroundColorSpan(Color.RED);

        // Applicazione dello stile al numero specificando l'intervallo di caratteri
        spannableString1.setSpan(colorSpan1, start1, end1, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

        // Impostazione del testo nel TextView
        textView1.setText(spannableString1);
        return view;


    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        dialog = new Dialog(getContext());
        Button fab = view.findViewById(R.id.buttonModificaPassword);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openModal();
            }
        });
    }

    private void openModal(){
        dialog.setContentView(R.layout.modal_modifica_password);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.show();
    }
}