package com.matheus.Dao;

import java.sql.Connection;

public class MensalDao {

    private Connection conexao;

    public MensalDao(Connection conexao) {
        this.conexao = conexao;
    }
}
