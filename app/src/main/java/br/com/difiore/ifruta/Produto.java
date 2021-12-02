package br.com.difiore.ifruta;

import java.io.Serializable;

public class Produto implements Serializable {

    private int idProduto;
    private String codProduto;
    private String descricao;
    private Categoria categoria;
    private int quantidade;
    private float preco;

    public Produto(String codProduto, String descricao, Categoria categoria, int quantidade, float preco) {
        this.codProduto = codProduto;
        this.descricao = descricao;
        this.categoria = categoria;
        this.quantidade = quantidade;
        this.preco = preco;
    }

    public Produto() {

    }

    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    public String getCodProduto() {
        return codProduto;
    }

    public void setCodProduto(String codProduto) {
        this.codProduto = codProduto;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
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

    public String toString() {
        return "Id: " + idProduto + "\nCódigo: " + codProduto + "\nDescrição: "+ descricao +
                "\nQuantidade: " + quantidade +
                "\nPreço: " + preco;
    }
}
