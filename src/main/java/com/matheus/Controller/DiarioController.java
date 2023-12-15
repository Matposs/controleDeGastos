package com.matheus.Controller;

import java.sql.Connection;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.matheus.Dao.DiarioDao;
import com.matheus.Models.Contas;
import com.matheus.Models.Diario;
import com.matheus.Utils.Console;

public class DiarioController {

    private DiarioDao diarioDAO;
    public DiarioController(Connection conexao) {
        this.diarioDAO = new DiarioDao(conexao);
    }

    Diario conta;
    private ArrayList<Diario> diarios = new ArrayList<>();

    public static Diario create(float valor) {
        if (valor != 0) {
            System.out.println("Novo registro adicionado com sucesso!");
            return new Diario();
        } else {
            System.out.println("Valor inválido!");
            return null;
        }
    }

    public void adicionarDados(float valor) {

        conta = create(valor);
        String descricao = Console.readString("Informe a descriçao caso queira: ");
        LocalDate data = LocalDate.now();
        int dia = data.getDayOfMonth();
        int mes = data.getMonthValue();
        int ano = data.getYear();
        conta.setDia(dia);
        conta.setMes(mes);
        conta.setAno(ano);
        conta.setValor(valor);
        conta.setDescricao(descricao);
        diarios.add((Diario) conta);
    }

    public List<Diario> listar() {
        for (Diario diario : diarios) {
            System.out.println(diario);
        }
        return diarios;
    }

    public Diario Deletar(int id, LocalDate data) {
        int dia = data.getDayOfMonth();
        int mes = data.getMonthValue();
        int ano = data.getYear();
        for (Diario contaCadastrada : diarios) {
            if (contaCadastrada.getId() == (id) && contaCadastrada.getData().getDayOfMonth() == dia
                    && contaCadastrada.getData().getMonthValue() == mes && contaCadastrada.getData().getYear() == ano) {
                diarios.remove(contaCadastrada);
                return contaCadastrada;
            }
        }
        return null;
    }

    public Diario Editar(int id) {
        for (Diario contaCadastrada : diarios) {
            if (contaCadastrada.getId() == id) {
                contaCadastrada.setValor(Console.readFloat("Insira o novo valor desejado: "));
                return contaCadastrada;
            }
        }

        return null;
    }
}
