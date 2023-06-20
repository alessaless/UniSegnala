package com.example.unisegnala;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {
    private BottomNavigationView bottomNavigationView;
    private FragmentManager fragmentManager;

    private Fragment homeFragment;
    private Fragment premiFragment;
    private Fragment segnalazioniFragment;
    private Fragment profiloFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        fragmentManager = getSupportFragmentManager();

        // Crea istanze dei fragment corrispondenti
        homeFragment = new HomePage();
        premiFragment = new Premi();
        segnalazioniFragment = new Segnalazioni();
        profiloFragment = new Profilo();

        // Imposta il fragment iniziale (es. HomeFragment)
        fragmentManager.beginTransaction().replace(R.id.fragmentContainer, homeFragment).commit();

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                Fragment selectedFragment = null;

                switch (item.getItemId()) {
                    case R.id.action_home:
                        selectedFragment = homeFragment;
                        break;
                    case R.id.action_premi:
                        selectedFragment = premiFragment;
                        break;
                    case R.id.action_segnalazioni:
                        selectedFragment = segnalazioniFragment;
                        break;
                    case R.id.action_profilo:
                        selectedFragment = profiloFragment;
                        break;
                }

                if (selectedFragment != null) {
                    fragmentManager.beginTransaction().replace(R.id.fragmentContainer, selectedFragment).commit();
                }

                return true;
            }
        });
    }
}
