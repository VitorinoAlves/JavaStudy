package org.example;

import org.example.dao.IProdutoDAO;
import org.example.dao.ProdutoDAO;
import org.example.domain.Produto;
import org.junit.Assert;
import org.junit.Test;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProdutoTest {
    @Test
    public void cadastrarProdutoTest() throws SQLException {
        IProdutoDAO dao = new ProdutoDAO();
        Produto produto = new Produto("23", "Martelo");

        int qtd = dao.cadastrar(produto);
        Assert.assertEquals(qtd, 1);

        Produto produtoDB = dao.consultar(produto.getCodigo());
        Assert.assertNotNull(produtoDB);
        Assert.assertEquals(produto.getCodigo(), produtoDB.getCodigo());
        Assert.assertEquals(produto.getNome(), produtoDB.getNome());

        int qtdDeletado = dao.excluir(produtoDB);
        Assert.assertEquals(qtdDeletado, 1);

    }

    @Test
    public void buscarTodosProdutostest() throws SQLException {
        IProdutoDAO dao = new ProdutoDAO();
        List<Produto> listaProdutos = new ArrayList<>();
        int qdtCadastrado = 0;
        int qtdDeletado = 0;

        listaProdutos.add(new Produto("36", "Martelo"));
        listaProdutos.add(new Produto("25", "Machado"));

        for (Produto produto: listaProdutos){
            qdtCadastrado += dao.cadastrar(produto);
        }
        Assert.assertEquals(qdtCadastrado, listaProdutos.size());

        List<Produto> listaProdutosDB= dao.consultarTodos();
        Assert.assertNotNull(listaProdutosDB);
        Assert.assertEquals(listaProdutosDB.size(), listaProdutos.size());

        for (Produto produto: listaProdutosDB){
            qtdDeletado += dao.excluir(produto);
        }
        Assert.assertEquals(qtdDeletado, listaProdutosDB.size());

        listaProdutosDB= dao.consultarTodos();
        Assert.assertEquals(listaProdutosDB.size(), 0);

    }

    @Test
    public void alterarProdutoTest() throws SQLException {
        IProdutoDAO dao = new ProdutoDAO();
        Produto produto = new Produto("23", "Martelo");

        int qtd = dao.cadastrar(produto);
        Assert.assertEquals(qtd, 1);
        Produto produtoDB = dao.consultar(produto.getCodigo());
        Assert.assertNotNull(produtoDB);
        Assert.assertEquals(produto.getCodigo(), produtoDB.getCodigo());
        Assert.assertEquals(produto.getNome(), produtoDB.getNome());

        produtoDB.setCodigo("55");
        produtoDB.setNome("Machado");
        int qtdAlterado = dao.alterar(produtoDB);
        Assert.assertEquals(qtdAlterado, 1);

        produto = dao.consultar(produto.getCodigo());
        Assert.assertNull(produto);

        Produto produtoDBAlterado = dao.consultar(produtoDB.getCodigo());
        Assert.assertNotNull(produtoDBAlterado);
        Assert.assertEquals(produtoDBAlterado.getCodigo(), produtoDB.getCodigo());
        Assert.assertEquals(produtoDBAlterado.getNome(), produtoDB.getNome());

        int qtdDeletado = dao.excluir(produtoDBAlterado);
        Assert.assertEquals(qtdDeletado, 1);

    }

}
