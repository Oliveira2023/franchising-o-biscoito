package com.franchising_o_biscoito.model;

import jakarta.persistence.*;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Entity(name = "tb_loja")
public class Loja {
    @Id
    private int idLoja;
    private Boolean lojaAtiva;
    private String nomeLoja;
    private String descricaoLoja;
    private Date dataAbertura;
    private Date dataFechamento;
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Endereco endereco;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "cod_produto")
    private List<Produto> produtos;

    public int getIdLoja() {
        return idLoja;
    }

    public void setIdLoja(int idLoja) {
        this.idLoja = idLoja;
    }

    public Boolean getLojaAtiva() {
        return lojaAtiva;
    }

    public void setLojaAtiva(Boolean lojaAtiva) {
        this.lojaAtiva = lojaAtiva;
    }

    public String getNomeLoja() {
        return nomeLoja;
    }

    public void setNomeLoja(String nomeLoja) {
        this.nomeLoja = nomeLoja;
    }

    public String getDescricaoLoja() {
        return descricaoLoja;
    }

    public void setDescricaoLoja(String descricaoLoja) {
        this.descricaoLoja = descricaoLoja;
    }

    public Date getDataAbertura() {
        return dataAbertura;
    }

    public void setDataAbertura(Date dataAbertura) {
        this.dataAbertura = dataAbertura;
    }

    public Date getDataFechamento() {
        return dataFechamento;
    }

    public void setDataFechamento(Date dataFechamento) {
        this.dataFechamento = dataFechamento;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }
}
