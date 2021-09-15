package com.example.cadastrocarros;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.cadastrocarros.controller.CarroDao;
import com.example.cadastrocarros.model.Carro;

import java.text.NumberFormat;
import java.util.Locale;

public class DetalhesActivity extends AppCompatActivity {

    TextView tvModelo;
    TextView tvMarca;
    TextView tvAno;
    TextView tvCor;
    TextView tvMotor;
    TextView tvValor;
    TextView tvCombustivel;
    Button btnExcluir;

    CarroDao dao;

    Locale br;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhes);

        tvModelo = findViewById(R.id.tvModelo);
        tvMarca = findViewById(R.id.tvMarca);
        tvAno = findViewById(R.id.tvAno);
        tvCor = findViewById(R.id.tvCor);
        tvMotor = findViewById(R.id.tvMotor);
        tvValor = findViewById(R.id.tvValor);
        tvCombustivel = findViewById(R.id.tvCombustivel);
        btnExcluir = findViewById(R.id.btnExcluir);

        dao = new CarroDao();
        br = new Locale("pt","BR");

        NumberFormat valor = NumberFormat.getCurrencyInstance(br);

        Intent intent = getIntent();
        int i = intent.getIntExtra("i", -1);

        if(i == -1) {
            finish();
        }

        Carro carro = dao.getCarro(i);

        tvModelo.setText("Modelo: " + carro.getModelo());
        tvMarca.setText("Marca: " + carro.getMarca());
        tvAno.setText("Ano de fabricação: " + carro.getAno());
        tvCor.setText("Cor: " + carro.getCor());
        tvMotor.setText("Motor: " + carro.getMotor());
        tvValor.setText("Valor FIPE: " + valor.format(carro.getFipe()));
        tvCombustivel.setText("Combustível: " + carro.getCombustivel());

        btnExcluir.setOnClickListener(view -> {
            new AlertDialog.Builder(this).setTitle("Excluir carro").setMessage("Tem certeza de que deseja excluir este carro?")
                    .setPositiveButton("sim", ((dialogInterface, i1) -> {
                        dao.excluir(i);
                        Toast.makeText(this, "Carro excluído com sucesso!", Toast.LENGTH_LONG).show();
                        finish();
                    })).setNegativeButton("Não", null).show();
        });

    }
}