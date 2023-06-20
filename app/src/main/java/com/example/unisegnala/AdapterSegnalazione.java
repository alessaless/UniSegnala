package com.example.unisegnala;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class AdapterSegnalazione extends ArrayAdapter<Segnalazione> {
    private LayoutInflater inflater;

    public AdapterSegnalazione(Context context, ArrayList<Segnalazione> objects) {
        super(context, 0, objects);
        inflater = LayoutInflater.from(context);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.segnalazione_card, parent, false);
        }

        Segnalazione customObject = getItem(position);

        TextView textViewTitle = convertView.findViewById(R.id.NomeSegnalazione);
        TextView textViewDescription = convertView.findViewById(R.id.descrizione);

        textViewTitle.setText(customObject.getNome());
        textViewDescription.setText(customObject.getDescrizione());

        return convertView;
    }
}