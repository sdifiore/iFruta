package br.com.difiore.ifruta.entidades;

import java.io.Serializable;

public class ProdutoInSacola implements Serializable {

    public ProdutoInSacola(String descricao, int quantidade, float preco) {
        this.descricao = descricao;
        this.quantidade = quantidade;
        this.preco = preco;
    }

    public ProdutoInSacola() {
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    private String descricao;
    private int quantidade;
    private float preco;
}
