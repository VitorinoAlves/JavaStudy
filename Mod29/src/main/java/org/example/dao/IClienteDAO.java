package org.example.dao;

import org.example.domain.Cliente;

import java.sql.SQLException;
import java.util.List;

public interface IClienteDAO {
    public Integer cadastrar(Cliente cliente) throws SQLException;

    public Cliente consultar(String codigo) throws SQLException;

    Integer excluir(Cliente cliente) throws SQLException;

    List<Cliente> consultarTodos() throws SQLException;

    Integer alterar(Cliente cliente) throws SQLException;
}
