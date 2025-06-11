package org.example;

import org.example.dao.ClienteDao;
import org.example.dao.ContratoDao;
import org.example.dao.IClienteDao;
import org.example.dao.IContratoDao;
import org.example.dao.mocks.ClienteDaoMock;
import org.example.dao.mocks.ContratoDaoMock;
import org.example.service.ClienteService;
import org.example.service.ContratoService;
import org.example.service.IClienteService;
import org.example.service.IContratoService;
import org.junit.Assert;
import org.junit.Test;

public class ClienteServiceTest {
    @Test
    public void salvarClienteTest(){
        IClienteDao dao = new ClienteDaoMock();
        IClienteService service = new ClienteService(dao);
        String retorno = service.salvar();
        Assert.assertEquals("Cliente salvo com sucesso", retorno);
    }

    @Test
    public void buscarClienteTest(){
        IClienteDao dao = new ClienteDaoMock();
        IClienteService service = new ClienteService(dao);
        String retorno = service.buscar();
        Assert.assertEquals("Cliente buscado com sucesso", retorno);
    }

    @Test
    public void excluirClienteTest(){
        IClienteDao dao = new ClienteDaoMock();
        IClienteService service = new ClienteService(dao);
        String retorno = service.excluir();
        Assert.assertEquals("Cliente excluido com sucesso", retorno);
    }

    @Test
    public void atualizartClienteTest(){
        IClienteDao dao = new ClienteDaoMock();
        IClienteService service = new ClienteService(dao);
        String retorno = service.atualizar();
        Assert.assertEquals("Cliente atualizado com sucesso", retorno);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void erroAoSalvarNoBancoDeDadosTest(){
        IClienteDao dao = new ClienteDao();
        IClienteService service = new ClienteService(dao);
        String retorno = service.salvar();
    }

    @Test(expected = UnsupportedOperationException.class)
    public void erroAoBuscarNoBancoDeDadosTest(){
        IClienteDao dao = new ClienteDao();
        IClienteService service = new ClienteService(dao);
        String retorno = service.buscar();
    }

    @Test(expected = UnsupportedOperationException.class)
    public void erroAoExcluirNoBancoDeDadosTest(){
        IClienteDao dao = new ClienteDao();
        IClienteService service = new ClienteService(dao);
        String retorno = service.excluir();
    }

    @Test(expected = UnsupportedOperationException.class)
    public void erroAoAtualizarNoBancoDeDadosTest(){
        IClienteDao dao = new ClienteDao();
        IClienteService service = new ClienteService(dao);
        String retorno = service.atualizar();
    }
}
