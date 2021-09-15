package com.example.cadastrocarros.controller;

import com.example.cadastrocarros.model.Carro;

import java.util.ArrayList;
import java.util.List;

public class CarroDao {

    private static List<Carro> carrosCadastrados = new ArrayList<>();

    public void addCarro(Carro carro){
        carrosCadastrados.add(carro);
    }

    public void excluir(int position){
        carrosCadastrados.remove(position);
    }

    public Carro getCarro(int position){
        return carrosCadastrados.get(position);
    }

    public static List<Carro> getCarrosCadastrados() {
        return carrosCadastrados;
    }
}
