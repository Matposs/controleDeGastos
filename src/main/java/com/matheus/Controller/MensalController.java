package com.matheus.Controller;

import java.sql.Connection;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import com.matheus.Dao.MensalDao;
import com.matheus.Models.Mensal;

public class MensalController {

    private MensalDao mensalDAO;

    public MensalController(Connection conexao) {
        this.mensalDAO = new MensalDao(conexao);
    }

    private List<Mensal> mensais = new ArrayList<>();

    public void adicionarDados(float valor, int mes, int ano) {
        Mensal mensal = new Mensal();
        mensal.setValor(valor);
        mensal.setMes(mes);
        mensal.setAno(ano);
        //mensalDAO.adicionarMensal(mensal);
        mensais.add(mensal);
    }

    public List<Mensal> listar() {
        for (Mensal mensal : mensais) {
            System.out.println(mensal);
        }
        return mensais;
    }

}
