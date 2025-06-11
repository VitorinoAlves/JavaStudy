package org.example;

import org.example.dao.ContratoDao;
import org.example.dao.IContratoDao;
import org.example.dao.mocks.ContratoDaoMock;
import org.example.service.ContratoService;
import org.example.service.IContratoService;
import org.junit.Assert;
import org.junit.Test;

public class ContratoServiceTest {
    @Test
    public void salvarContratoTest(){
        IContratoDao dao = new ContratoDaoMock();
        IContratoService service = new ContratoService(dao);
        String retorno = service.salvar();
        Assert.assertEquals("Registro salvo com sucesso", retorno);
    }

    @Test
    public void buscarContratoTest(){
        IContratoDao dao = new ContratoDaoMock();
        IContratoService service = new ContratoService(dao);
        String retorno = service.buscar();
        Assert.assertEquals("Resultados da busca", retorno);
    }

    @Test
    public void excluirContratoTest(){
        IContratoDao dao = new ContratoDaoMock();
        IContratoService service = new ContratoService(dao);
        String retorno = service.excluir();
        Assert.assertEquals("Registro excluido com sucesso", retorno);
    }

    @Test
    public void atualizartContratoTest(){
        IContratoDao dao = new ContratoDaoMock();
        IContratoService service = new ContratoService(dao);
        String retorno = service.atualizar();
        Assert.assertEquals("Registro atualizado com sucesso", retorno);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void erroAoSalvarNoBancoDeDadosTest(){
        IContratoDao dao = new ContratoDao();
        IContratoService service = new ContratoService(dao);
        String retorno = service.salvar();
    }

    @Test(expected = UnsupportedOperationException.class)
    public void erroAoBuscarNoBancoDeDadosTest(){
        IContratoDao dao = new ContratoDao();
        IContratoService service = new ContratoService(dao);
        String retorno = service.buscar();
    }

    @Test(expected = UnsupportedOperationException.class)
    public void erroAoExcluirNoBancoDeDadosTest(){
        IContratoDao dao = new ContratoDao();
        IContratoService service = new ContratoService(dao);
        String retorno = service.excluir();
    }

    @Test(expected = UnsupportedOperationException.class)
    public void erroAoAtualizarNoBancoDeDadosTest(){
        IContratoDao dao = new ContratoDao();
        IContratoService service = new ContratoService(dao);
        String retorno = service.atualizar();
    }

}
