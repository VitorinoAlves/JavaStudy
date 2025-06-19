package org.example.domain;

public class Cliente {
    private Long id;
    private String nome;
    private String codigo;

    public Cliente(String nome, String codigo) {
        this.nome = nome;
        this.codigo = codigo;
    }

    public Cliente() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
}
