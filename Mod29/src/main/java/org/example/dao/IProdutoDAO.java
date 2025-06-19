package org.example.dao;

import org.example.domain.Cliente;
import org.example.domain.Produto;

import java.sql.SQLException;
import java.util.List;

public interface IProdutoDAO {
    public Integer cadastrar(Produto produto) throws SQLException;

    public Produto consultar(String codigo) throws SQLException;

    Integer excluir(Produto produto) throws SQLException;

    List<Produto> consultarTodos() throws SQLException;

    Integer alterar(Produto produto) throws SQLException;
}
