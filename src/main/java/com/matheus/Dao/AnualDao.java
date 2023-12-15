package com.matheus.Dao;

import java.sql.Connection;

public class AnualDao {
        private Connection conexao;

    public AnualDao(Connection conexao) {
        this.conexao = conexao;
    }
}

