package com.example.cadastrocarros;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.cadastrocarros.controller.CarroDao;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {

    ListView lvCarrosCadastrados;
    FloatingActionButton fabCadastrar;
    CarroDao dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvCarrosCadastrados = findViewById(R.id.lvCarrosCadastrados);
        fabCadastrar = findViewById(R.id.fabCadastrar);
        dao = new CarroDao();

        fabCadastrar.setOnClickListener(view -> {
            startActivity(new Intent(this, CadastroActivity.class));
        });

        lvCarrosCadastrados.setOnItemClickListener((adapterView, view, i, l) -> {
            Intent detalhesIntent = new Intent(this, DetalhesActivity.class);
            detalhesIntent.putExtra("i", i);
            startActivity(detalhesIntent);
        });
    }

    @Override
    protected void onResume() {
        super.onResume();

        lvCarrosCadastrados.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, dao.getCarrosCadastrados()));
    }
}