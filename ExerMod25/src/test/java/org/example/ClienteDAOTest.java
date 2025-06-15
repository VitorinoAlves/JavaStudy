package org.example;

import org.example.dao.ClienteDAO;
import org.example.dao.ClienteDaoMock;
import org.example.dao.IClienteDAO;
import org.example.domain.Cliente;
import org.example.exceptons.TipoChaveNaoEncontradaException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ClienteDAOTest {

    private IClienteDAO clienteDAO;

    private Cliente cliente;

    public ClienteDAOTest(){
        clienteDAO = new ClienteDaoMock();
    }

    @Before
    public void init() throws TipoChaveNaoEncontradaException {
        cliente = new Cliente();
        cliente.setCpf(12345678910L);
        cliente.setNome("Test Nome");
        cliente.setCidade("São Paulo");
        cliente.setEnd("End");
        cliente.setEstado("SP");
        cliente.setNumero(10);
        cliente.setTelefone(11999999999L);

        clienteDAO.cadastrar(cliente);
    }

    @Test
    public void pesquisarCliente() {
        Cliente clienteConsultado = clienteDAO.consultar(cliente.getCpf());

        Assert.assertNotNull(clienteConsultado);
    }

    @Test
    public void salvarCliente() throws TipoChaveNaoEncontradaException {
        Boolean retorno = clienteDAO.cadastrar(cliente);
        Assert.assertTrue(retorno);
    }

    @Test
    public void excluirCliente(){
        clienteDAO.excluir(cliente.getCpf());
    }

    @Test
    public void alterarrCliente() throws TipoChaveNaoEncontradaException {
        cliente.setNome("Nome editado");
        clienteDAO.alterar(cliente);

        Assert.assertEquals("Nome editado", cliente.getNome());
    }


}
