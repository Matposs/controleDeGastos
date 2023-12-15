package com.matheus.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.matheus.Models.Diario;

public class DiarioDao {

    private Connection conexao;
    public DiarioDao(Connection conexao) {
        this.conexao = conexao;
    }
    public void adicionarDiario(Diario diario) throws SQLException {
        String sql = "INSERT INTO ContasDiarias (descricao, valor, data) VALUES (?, ?, ?)";

        try (PreparedStatement statement = conexao.prepareStatement(sql)) {
            statement.setString(1, diario.getDescricao());
            statement.setFloat(2, diario.getValor());
            statement.setDate(3, java.sql.Date.valueOf(diario.getData()));

            statement.executeUpdate();
        }
    }

    public List<Diario> listarDiarios() throws SQLException {
        List<Diario> diarios = new ArrayList<>();
        String sql = "SELECT * FROM ContasDiarias";

        try (PreparedStatement statement = conexao.prepareStatement(sql)) {
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    Diario diario = new Diario();
                    diario.setId(resultSet.getInt("id"));
                    diario.setDescricao(resultSet.getString("descricao"));
                    diario.setValor(resultSet.getFloat("valor"));
                    diario.setData(resultSet.getDate("data").toLocalDate());

                    diarios.add(diario);
                }
            }
        }

        return diarios;
    }

    // Método para excluir um Diario do banco de dados por ID
    public void excluirDiario(int id) throws SQLException {
        String sql = "DELETE FROM ContasDiarias WHERE id = ?";

        try (PreparedStatement statement = conexao.prepareStatement(sql)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        }
    }

    // Método para atualizar o valor de um Diario no banco de dados por ID
    public void atualizarDiario(int id, float novoValor) throws SQLException {
        String sql = "UPDATE ContasDiarias SET valor = ? WHERE id = ?";

        try (PreparedStatement statement = conexao.prepareStatement(sql)) {
            statement.setFloat(1, novoValor);
            statement.setInt(2, id);
            statement.executeUpdate();
        }
    }
}
