package com.example.unisegnala;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class SegnalazioneFragment extends Fragment {

    public SegnalazioneFragment() {
        // Costruttore vuoto richiesto
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Infla il layout del fragment per la visualizzazione
        View view = inflater.inflate(R.layout.singola_segnalazione, container, false);
        Bundle bundle = getArguments();
        if (bundle != null) {
            TextView title = view.findViewById(R.id.title);
            TextView title2 = view.findViewById(R.id.title2);
            TextView description = view.findViewById(R.id.descrizione);
            title.setText(bundle.getString("titolo"));
            title2.setText(bundle.getString("titolo"));
            description.setText(bundle.getString("descrizione"));
            // Estrarre gli altri dati dal bundle se presenti
        }
        return view;
    }
}
