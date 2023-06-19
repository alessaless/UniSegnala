package com.example.unisegnala;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class Menu extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.action_home:
                        // Aggiungi il codice per gestire il click sulla voce "Home"
                        // ad esempio: startActivity(new Intent(MainActivity.this, HomeActivity.class));
                        return true;
                    case R.id.action_premi:
                        // Aggiungi il codice per gestire il click sulla voce "Premi"
                        return true;
                    case R.id.action_segnalazioni:
                        // Aggiungi il codice per gestire il click sulla voce "Segnalazioni"
                        return true;
                    case R.id.action_profilo:
                        // Aggiungi il codice per gestire il click sulla voce "Profilo"
                        return true;
                }
                return false;
            }
        });
    }
}






