package br.com.difiore.ifruta;

import java.io.Serializable;

public class Cliente implements Serializable {
    private int idCliente;
    private String nome;
    private String cpf;
    private String telefone;
    private String endereco;
    private String login;
    private String senha;
    private int state = 0;

    public Cliente(String nome, String cpf, String telefone, String endereco, String login, String senha,int state) {
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.endereco = endereco;
        this.login = login;
        this.senha = senha;
        this.state = state;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }


    public Cliente() {
    }

     public void setIdCliente(int id) {
        this.idCliente = idCliente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String toString() {
        return "Id: " + idCliente + ":\nNome: " + nome + " \nCpf: " + cpf + " \nTelefone: " + telefone +
                " \nEndereco: " + endereco;
    }
}
