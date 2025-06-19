package org.example;

import org.example.dao.ClienteDAO;
import org.example.dao.IClienteDAO;
import org.example.domain.Cliente;
import org.junit.Assert;
import org.junit.Test;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClienteTest {

    @Test
    public void cadastrarTest() throws SQLException {
        IClienteDAO dao = new ClienteDAO();
        Cliente cliente = new Cliente();
        cliente.setCodigo("02");
        cliente.setNome("Teste Nome01");

        Integer qtd = dao.cadastrar(cliente);

        Assert.assertTrue(qtd == 1);

        Cliente clienteBD = dao.consultar(cliente.getCodigo());
        Assert.assertNotNull(clienteBD);
        Assert.assertNotNull(clienteBD.getId());
        Assert.assertEquals(cliente.getCodigo(), clienteBD.getCodigo());
        Assert.assertEquals(cliente.getNome(), clienteBD.getNome());

        Integer qtdDel = dao.excluir(cliente);
        Assert.assertTrue(qtdDel == 1);
    }

    @Test
    public void buscarTodosTest() throws SQLException {
        IClienteDAO dao = new ClienteDAO();
        List<Cliente> listaClientes = new ArrayList<>();
        int cadastroQtd = 0;
        int deletadoQtd = 0;


        listaClientes.add(new Cliente("02", "Nome Teste 02"));
        listaClientes.add(new Cliente("03", "Nome Teste 03"));

        for (Cliente cli: listaClientes){
            cadastroQtd += dao.cadastrar(cli);
        }
        Assert.assertEquals(cadastroQtd, listaClientes.size());

        List<Cliente> listaClienteDB = dao.consultarTodos();
        Assert.assertNotNull(listaClienteDB);
        Assert.assertTrue(listaClienteDB.size() == 2);

        for (Cliente cli: listaClienteDB){
            deletadoQtd += dao.excluir(cli);
        }
        Assert.assertEquals(deletadoQtd, listaClienteDB.size());

        listaClienteDB = dao.consultarTodos();
        Assert.assertEquals(listaClienteDB.size(), 0);

    }

    @Test
    public void alterarTest() throws SQLException {
        IClienteDAO dao = new ClienteDAO();
        Cliente cliente = new Cliente();
        cliente.setCodigo("02");
        cliente.setNome("Teste Nome01");

        Integer qtd = dao.cadastrar(cliente);
        Assert.assertTrue(qtd == 1);
        Cliente clienteBD = dao.consultar(cliente.getCodigo());
        Assert.assertEquals(cliente.getNome(), clienteBD.getNome());
        Assert.assertEquals(cliente.getCodigo(), clienteBD.getCodigo());

        clienteBD.setNome("Nome Editado");
        clienteBD.setCodigo("35");
        Integer qtdAlterado = dao.alterar(clienteBD);
        Assert.assertTrue(qtdAlterado == 1);

        Cliente clienteBDAlterado = dao.consultar(clienteBD.getCodigo());
        Assert.assertEquals(clienteBDAlterado.getNome(), clienteBD.getNome());
        Assert.assertEquals(clienteBDAlterado.getCodigo(), clienteBD.getCodigo());

        List<Cliente> list = dao.consultarTodos();
        for (Cliente cli : list) {
            dao.excluir(cli);
        }
    }
}
