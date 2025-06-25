package org.example.dao;

import org.example.domain.Produto;

import java.util.List;

public interface IProdutoDAO {
    public Produto cadastrar(Produto produto);
    public void excluir(Produto produto);
    public List<Produto> buscarTodos();
}
