package com.matheus.Controller;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import com.matheus.Dao.AnualDao;
import com.matheus.Models.Anual;

public class AnualController {

    private AnualDao anualDAO;

    public AnualController(Connection conexao) {
        this.anualDAO = new AnualDao(conexao);
    }

    private List<Anual> anuais = new ArrayList<>();

    public void adicionarDados(float valor, int ano) {
        Anual anual = new Anual();
        anual.setValor(valor);
        anual.setAno(ano);
        //anualDAO.adicionarAnual(anual);
        anuais.add(anual);
    }

    public List<Anual> listar() {
        for (Anual anual : anuais) {
            System.out.println(anual);
        }
        return anuais;
    }

}
