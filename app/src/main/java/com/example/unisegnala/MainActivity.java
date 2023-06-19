package com.example.unisegnala;

import androidx.appcompat.app.AppCompatActivity;
import com.example.unisegnala.Menu;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        Button T=(Button)findViewById(R.id.buttonLogin);
        T.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(),Menu.class);
                startActivity(i);
            }
        });
    }

}