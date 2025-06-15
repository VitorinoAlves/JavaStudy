package org.example;

import org.example.dao.ClienteDaoMock;
import org.example.dao.IClienteDAO;
import org.example.domain.Cliente;
import org.example.exceptons.TipoChaveNaoEncontradaException;
import org.example.services.ClienteService;
import org.example.services.IClienteService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ClientServiceTest {
    private IClienteService clienteService;
    private Cliente cliente;

    public ClientServiceTest(){
        IClienteDAO dao = new ClienteDaoMock();
        clienteService = new ClienteService(dao);
    }

    @Before
    public void init() {
        cliente = new Cliente();
        cliente.setCpf(12345678910L);
        cliente.setNome("Test Nome");
        cliente.setCidade("São Paulo");
        cliente.setEnd("End");
        cliente.setEstado("SP");
        cliente.setNumero(10);
        cliente.setTelefone(11999999999L);


    }

    @Test
    public void pesquisarCliente() {
        Cliente clienteConsultado = clienteService.buscarPorCpf(cliente.getCpf());

        Assert.assertNotNull(clienteConsultado);
    }

    @Test
    public void salvarCliente() throws TipoChaveNaoEncontradaException {
        Boolean retorno = clienteService.salvar(cliente);
        Assert.assertTrue(retorno);
    }

    @Test
    public void excluirCliente(){
        clienteService.excluir(cliente.getCpf());
    }

    @Test
    public void alterarrCliente() throws TipoChaveNaoEncontradaException {
        cliente.setNome("Nome editado");
        clienteService.alterar(cliente);

        Assert.assertEquals("Nome editado", cliente.getNome());
    }
}
