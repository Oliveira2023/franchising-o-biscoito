package com.franchising_o_biscoito.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity(name = "tb_produto")
public class Produto {
    @Id
    private Integer cod_produto;
    private int quantidade;
    private String nome;
    private String descricao;
    private double preco;

    public Integer getCod_produto() {
        return cod_produto;
    }

    public void setCod_produto(int cod_produto) {
        this.cod_produto = cod_produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }
}
