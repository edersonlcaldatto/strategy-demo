package com.br.strategydemo.strategy.juros.domain;

public abstract class Banco {
    String nome;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
