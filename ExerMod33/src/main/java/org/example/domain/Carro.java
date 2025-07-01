package org.example.domain;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "TB_CARRO")
public class Carro {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "carro_seq")
    @SequenceGenerator(name = "carro_seq", sequenceName = "sq_carro", initialValue = 1, allocationSize = 1)
    private Long id;

    @Column(name = "NOME", length = 50, nullable = false)
    private String nome;

    @Column(name = "COR", length = 20, nullable = false)
    private String cor;

    @Column(name = "ANO", nullable = false)
    private int ano;

    @ManyToOne
    @JoinColumn(name = "id_maca_fk",
            foreignKey = @ForeignKey(name = "fk,_marca_carro"),
            referencedColumnName = "id", nullable = false)
    private Marca marca;

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(name = "TB_CARRO_ACESSORIO", joinColumns = {@JoinColumn(name = "id_carro_fk")},
                inverseJoinColumns = {@JoinColumn(name = "id_acessorio_fk")})
    private List<Acessorio> listaAcessorios = new ArrayList<>();;



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

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    public List<Acessorio> getListaAcessorios() {
        return listaAcessorios;
    }

    public void setListaAcessorios(List<Acessorio> listaAcessorios) {
        this.listaAcessorios = listaAcessorios;
    }

    public void addAcessorio(Acessorio acessorio){
        this.listaAcessorios.add(acessorio);
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }
}
