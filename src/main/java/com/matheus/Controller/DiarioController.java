package com.matheus.Controller;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.matheus.Dao.ConexaoBanco;
import com.matheus.Dao.DiarioDao;
import com.matheus.Models.Contas;
import com.matheus.Models.Diario;
import com.matheus.Utils.Console;

public class DiarioController {

    private DiarioDao diarioDAO;

    public DiarioController(ConexaoBanco conexaoBanco) {
        this.diarioDAO = new DiarioDao(conexaoBanco);
    }

    Diario conta;

    public void adicionarDados(float valor) {
        LocalDate data = LocalDate.now();
        String descricao = Console.readString("Informe a descrição caso queira: ");

        Diario novoDiario = new Diario();
        novoDiario.setValor(valor);
        novoDiario.setDescricao(descricao);
        novoDiario.setData(data);

        try {
            diarioDAO.adicionarDiario(novoDiario);
            System.out.println("Novo registro adicionado com sucesso!");
        } catch (SQLException e) {
            System.out.println("Erro ao adicionar registro no banco de dados: " + e.getMessage());
        }
    }

    public List<Diario> listar() {
        try {
            List<Diario> diarios = diarioDAO.listarDiarios();
            for (Diario diario : diarios) {
                System.out.println(diario);
            }
            return diarios;
        } catch (SQLException e) {
            System.out.println("Erro ao listar registros do banco de dados: " + e.getMessage());
            return null;
        }
    }

    public void deletar(int id) {
        try {
            diarioDAO.excluirDiario(id);
            System.out.println("Registro excluído com sucesso!");
        } catch (SQLException e) {
            System.out.println("Erro ao excluir registro do banco de dados: " + e.getMessage());
        }
    }

    public void editar(int id, float novoValor) {
        try {
            diarioDAO.atualizarDiario(id, novoValor);
            System.out.println("Registro atualizado com sucesso!");
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar registro no banco de dados: " + e.getMessage());
        }
    }
}
