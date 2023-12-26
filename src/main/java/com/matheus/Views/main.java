package com.matheus.Views;

import java.sql.Connection;

import com.matheus.Controller.DiarioController;
import com.matheus.Dao.ConexaoBanco;
import com.matheus.Dao.DiarioDao;
import com.matheus.Utils.Console;

public class main {
    public static void main(String[] args) {

        ConexaoBanco conexao = ConexaoBanco.obterInstancia();
        DiarioController diarioController = new DiarioController(conexao);

        int opcao;
        do {
            exibirMenu();
            opcao = Console.readInt("Escolha uma opção: ");

            switch (opcao) {
                case 1:
                    diarioController.adicionarDados(Console.readFloat("Informe o valor gasto: "));
                    break;
                case 2:
                    diarioController.listar();
                    break;
                case 3:
                    int id = Console.readInt("Informe o ID da conta a ser excluída: ");
                    diarioController.deletar(id);
                    break;
                case 4:
                    int idEditar = Console.readInt("Informe o ID da conta a ser editada: ");
                    float novoValor = Console.readFloat("Informe o novo valor: ");
                    diarioController.editar(idEditar, novoValor);
                    break;
                case 5:
                    System.out.println("Saindo do programa.");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }

        } while (opcao != 5);
    }

    private static void exibirMenu() {
        System.out.println("===== Menu =====");
        System.out.println("1. Adicionar Conta");
        System.out.println("2. Listar Contas");
        System.out.println("3. Excluir Conta");
        System.out.println("4. Editar Conta");
        System.out.println("5. Sair");
    }
}
