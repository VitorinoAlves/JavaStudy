package org.example;

import org.example.dao.IProdutoDAO;
import org.example.dao.ProdutoDAO;
import org.example.domain.Produto;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class ProdutoTest {
    private IProdutoDAO produtoDAO;

    public ProdutoTest(){
        produtoDAO = new ProdutoDAO();
    }

    @Test
    public void cadastrarProdutoTest(){
        Produto produto = new Produto();
        produto.setCodigo("A2");
        produto.setNome("Teste Produto");
        produto.setPreco(22.30);

        Produto produtoDB = produtoDAO.cadastrar(produto);

        Assert.assertNotNull(produtoDB);
        Assert.assertNotNull(produtoDB.getId());

        produtoDAO.excluir(produtoDB);
        List<Produto> list = produtoDAO.buscarTodos();
        Assert.assertTrue(list.size()==0);
    }

}
