package com.example.cadastrocarros;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.cadastrocarros.controller.CarroDao;
import com.example.cadastrocarros.model.Carro;

public class CadastroActivity extends AppCompatActivity {

    EditText etModelo;
    EditText etMarca;
    EditText etAno;
    EditText etCor;
    EditText etMotor;
    EditText etValorFipe;
    Spinner spCombustivel;
    Button btnCadastrar;
    CarroDao dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        etModelo = findViewById(R.id.etModelo);
        etMarca = findViewById(R.id.tvMarca);
        etAno = findViewById(R.id.tvAno);
        etCor = findViewById(R.id.etCor);
        etMotor = findViewById(R.id.etMotor);
        etValorFipe = findViewById(R.id.etValorFipe);
        spCombustivel = findViewById(R.id.spCombustível);
        btnCadastrar = findViewById(R.id.btnCadastrar);
        dao = new CarroDao();

        btnCadastrar.setOnClickListener(view -> {
            salvar();
        });


    }

    private void salvar() {

        if (etModelo.getText().toString().isEmpty() || etMarca.getText().toString().isEmpty() || etAno.getText().toString().isEmpty() ||
                etCor.getText().toString().isEmpty() || etMotor.getText().toString().isEmpty() || etValorFipe.getText().toString().isEmpty()) {
            Toast.makeText(this, "Preencha todos os campos", Toast.LENGTH_LONG).show();

        } else {

            Carro car = new Carro(
                    etMarca.getText().toString(),
                    etModelo.getText().toString(),
                    Integer.parseInt(etAno.getText().toString()),
                    etCor.getText().toString(),
                    etMotor.getText().toString(),
                    Float.parseFloat(etValorFipe.getText().toString()),
                    spCombustivel.getSelectedItem().toString()

        );
            dao.addCarro(car);
            Toast.makeText(this, "Carro adicionado com sucesso", Toast.LENGTH_LONG).show();
            finish();
        }
    }

}