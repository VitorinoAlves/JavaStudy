package org.example.domain.jpa;


import jakarta.persistence.*;
import org.example.dao.Persistente;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Entity
@Table(name = "TB_VENDA")
public class VendaJpa implements Persistente {

    public enum Status {
        INICIADA, CONCLUIDA, CANCELADA;

        public static Status getByName(String value) {
            for (Status status : Status.values()) {
                if (status.name().equals(value)) {
                    return status;
                }
            }
            return null;
        }
    }

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="venda_seq")
    @SequenceGenerator(name="venda_seq", sequenceName="sq_venda", initialValue = 1, allocationSize = 1)
    private Long id;

    @Column(name = "CODIGO", nullable = false, unique = true)
    private String codigo;

    @Column(name = "VALOR_TOTAL", nullable = false)
    private BigDecimal valorTotal;

    @Column(name = "DATA_VENDA", nullable = false)
    private Instant dataVenda;

    @ManyToOne
    @JoinColumn(name = "id_cliente_fk",
            foreignKey = @ForeignKey(name = "fk_venda_cliente"),
            referencedColumnName = "id", nullable = false
    )
    private ClienteJpa cliente;

    @OneToMany(mappedBy = "venda", cascade = CascadeType.ALL/*, fetch = FetchType.EAGER*/)
    private Set<ProdutoQuantidadeJpa> produtos;

    @Enumerated(EnumType.STRING)
    @Column(name = "STATUS_VENDA", nullable = false)
    private Status status;

    public VendaJpa() {
        produtos = new HashSet<>();
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Instant getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(Instant dataVenda) {
        this.dataVenda = dataVenda;
    }

    public ClienteJpa getCliente() {
        return cliente;
    }

    public void setCliente(ClienteJpa cliente) {
        this.cliente = cliente;
    }

    public Set<ProdutoQuantidadeJpa> getProdutos() {
        return produtos;
    }

    /*public void setProdutos(Set<ProdutoQuantidadeJpa> produtos) {
        this.produtos = produtos;
    }*/

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public void adicionarProduto(ProdutoJpa produto, Integer quantidade) {
        validarStatus();
        Optional<ProdutoQuantidadeJpa> op =
                produtos.stream().filter(filter -> filter.getProduto().getCodigo().equals(produto.getCodigo())).findAny();
        if (op.isPresent()) {
            ProdutoQuantidadeJpa produtpQtd = op.get();
            produtpQtd.adicionar(quantidade);
        } else {
            // Criar fabrica para criar ProdutoQuantidade
            ProdutoQuantidadeJpa prod = new ProdutoQuantidadeJpa();
            prod.setVenda(this);
            prod.setProduto(produto);
            prod.adicionar(quantidade);
            produtos.add(prod);
        }
        recalcularValorTotalVenda();
    }

    private void validarStatus() {
        if (this.status == Status.CONCLUIDA) {
            throw new UnsupportedOperationException("IMPOSSÍVEL ALTERAR VENDA FINALIZADA");
        }
    }

    public void removerProduto(ProdutoJpa produto, Integer quantidade) {
        validarStatus();
        Optional<ProdutoQuantidadeJpa> op =
                produtos.stream().filter(filter -> filter.getProduto().getCodigo().equals(produto.getCodigo())).findAny();

        if (op.isPresent()) {
            ProdutoQuantidadeJpa produtpQtd = op.get();
            if (produtpQtd.getQuantidade()>quantidade) {
                produtpQtd.remover(quantidade);
                recalcularValorTotalVenda();
            } else {
                produtos.remove(op.get());
                recalcularValorTotalVenda();
            }

        }
    }

    public void removerTodosProdutos() {
        validarStatus();
        produtos.clear();
        valorTotal = BigDecimal.ZERO;
    }

    public Integer getQuantidadeTotalProdutos() {
        // Soma a quantidade getQuantidade() de todos os objetos ProdutoQuantidade
        int result = produtos.stream()
                .reduce(0, (partialCountResult, prod) -> partialCountResult + prod.getQuantidade(), Integer::sum);
        return result;
    }

    public void recalcularValorTotalVenda() {
        //validarStatus();
        BigDecimal valorTotal = BigDecimal.ZERO;
        for (ProdutoQuantidadeJpa prod : this.produtos) {
            valorTotal = valorTotal.add(prod.getValorTotal());
        }
        this.valorTotal = valorTotal;
    }
}
