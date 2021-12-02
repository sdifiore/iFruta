package br.com.difiore.ifruta.entidades;

public class Categoria {

    private int idCategoria;
    private String descricao;

    public Categoria(String descricao) {
        this.descricao = descricao;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String toString() {
        return "Categoria: " + descricao;
    }
}
