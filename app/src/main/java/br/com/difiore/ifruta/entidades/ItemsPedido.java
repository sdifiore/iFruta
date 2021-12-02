package br.com.difiore.ifruta.entidades;

import java.io.Serializable;

public class ItemsPedido implements Serializable {
    public ItemsPedido() {
    }

    private String name;
    private int amount;
    private float price;

    public ItemsPedido(String name, int amount, float price) {
        this.name = name;
        this.amount = amount;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
