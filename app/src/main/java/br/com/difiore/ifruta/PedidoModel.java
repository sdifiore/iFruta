package br.com.difiore.ifruta;

import java.io.Serializable;

public class PedidoModel implements Serializable {

    private int idSacola;
    private int idCliente;
    private int idProduto;

    public PedidoModel(int idSacola, int idCliente, int idProduto) {
        this.idSacola = idSacola;
        this.idCliente = idCliente;
        this.idProduto = idProduto;
    }

    public PedidoModel() {
    }

    public int getIdSacola() {
        return idSacola;
    }

    public void setIdSacola(int idSacola) {
        this.idSacola = idSacola;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

}
