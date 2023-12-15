package com.matheus.Models;

import java.time.LocalDate;

public abstract class Contas {

    private int id;
    private float valor;
    private String descricao;
    private LocalDate data;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Descrição: " + descricao + " Valor:" + valor + " R$" + " Id: " + id;
    }

}
