package com.joao.cadastrousuario.entities;

import java.util.Objects;


public class Usuario {
    
    private Integer id;
    private String username;
    private String email;
    private String senha;
    private Pessoa pessoa;

    public Usuario(Integer id, String nome, String email, String senha, Pessoa pessoa) {
        this.id = id;
        this.username = nome;
        this.email = email;
        this.senha = senha;
        this.pessoa = pessoa;
    }

    public Usuario(String nome, String email, String senha, Pessoa pessoa) {
        this.username = nome;
        this.email = email;
        this.senha = senha;
        this.pessoa = pessoa;
    }
    
    public Usuario() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Usuario other = (Usuario) obj;
        return Objects.equals(this.id, other.id);
    }

    @Override
    public String toString() {
        return "Usuario{" + "id=" + id + ", username=" + username + ", email=" + email + ", senha=" + senha + ", pessoa=" + pessoa + '}';
    }

}
