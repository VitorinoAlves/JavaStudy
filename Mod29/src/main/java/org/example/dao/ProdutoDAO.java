package org.example.dao;

import org.example.dao.jdbc.ConnectionFactory;
import org.example.domain.Produto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProdutoDAO implements IProdutoDAO{
    @Override
    public Integer cadastrar(Produto produto) throws SQLException {
        Connection connection = null;
        PreparedStatement stm = null;

        try {
            connection = ConnectionFactory.getConnection();
            String sql = "INSERT INTO TB_PRODUTO (ID, CODIGO, NOME) VALUES (nextval('SQ_PRODUTO'),?,?)";
            stm = connection.prepareStatement(sql);
            stm.setString(1, produto.getCodigo());
            stm.setString(2, produto.getNome());
            return stm.executeUpdate();
        } catch (Exception e){
            throw e;
        } finally {
            closeConnection(connection, stm);
        }
    }

    @Override
    public Produto consultar(String codigo) throws SQLException {
        Connection connection = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        Produto produto = null;

        try {
            connection = ConnectionFactory.getConnection();
            String sql = "SELECT * FROM TB_PRODUTO WHERE CODIGO=?";
            stm = connection.prepareStatement(sql);
            stm.setString(1,codigo);
            rs = stm.executeQuery();
            if(rs.next()){
                produto = new Produto();
                produto.setId(rs.getLong("id"));
                produto.setNome(rs.getString("nome"));
                produto.setCodigo(rs.getString("codigo"));
            }

        } catch (Exception e){
            throw e;
        } finally {
            closeConnection(connection, stm);
        }
        return produto;
    }

    @Override
    public Integer excluir(Produto produto) throws SQLException {
        Connection connection = null;
        PreparedStatement stm = null;

        try {
            connection = ConnectionFactory.getConnection();
            String sql = "DELETE FROM TB_PRODUTO WHERE CODIGO=?";
            stm = connection.prepareStatement(sql);
            stm.setString(1, produto.getCodigo());
            return stm.executeUpdate();
        } catch (Exception e){
            throw e;
        } finally {
            closeConnection(connection, stm);
        }
    }

    @Override
    public List<Produto> consultarTodos() throws SQLException {
        Connection connection = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        List<Produto> listaProduto = new ArrayList<>();


        try {
            connection = ConnectionFactory.getConnection();
            String sql = "SELECT * FROM TB_PRODUTO";
            stm = connection.prepareStatement(sql);
            rs = stm.executeQuery();
            while (rs.next()){
                listaProduto.add(new Produto(
                        rs.getLong("id"),
                        rs.getString("nome"),
                        rs.getString("codigo")
                ));
            }
        } catch (Exception e){
            throw e;
        } finally {
            closeConnection(connection, stm);
        }
        return listaProduto;
    }

    @Override
    public Integer alterar(Produto produto) throws SQLException {
        Connection connection = null;
        PreparedStatement stm = null;

        try {
            connection = ConnectionFactory.getConnection();
            String sql = "UPDATE TB_PRODUTO SET CODIGO = ?, NOME = ? WHERE ID = ?";
            stm = connection.prepareStatement(sql);
            stm.setString(1, produto.getCodigo());
            stm.setString(2, produto.getNome());
            stm.setLong(3, produto.getId());
            return stm.executeUpdate();
        } catch (Exception e){
            throw e;
        } finally {
            closeConnection(connection, stm);
        }
    }

    public void closeConnection(Connection connection, PreparedStatement stm) throws SQLException {
        if(stm != null && !stm.isClosed()){
            stm.close();
        }
        if(connection != null && !connection.isClosed()){
            connection.close();
        }
    }
}
