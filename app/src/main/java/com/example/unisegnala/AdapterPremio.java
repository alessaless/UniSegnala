package com.example.unisegnala;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.ArrayList;

public class AdapterPremio extends ArrayAdapter<Premio> {
    private LayoutInflater inflater;

    public AdapterPremio(Context context, ArrayList<Premio> objects) {
        super(context, 0, objects);
        inflater = LayoutInflater.from(context);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.premio_card, parent, false);
        }

        Premio customObject = getItem(position);

        TextView textViewTitle = convertView.findViewById(R.id.nomePremio);
        TextView textViewDescription = convertView.findViewById(R.id.punti);

        textViewTitle.setText(customObject.getDescrizione());
        textViewDescription.setText(customObject.getPunteggio());

        return convertView;
    }
}
