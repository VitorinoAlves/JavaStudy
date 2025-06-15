package org.example.services;

import org.example.dao.IClienteDAO;
import org.example.domain.Cliente;
import org.example.exceptons.TipoChaveNaoEncontradaException;

public class ClienteService implements IClienteService{

    private IClienteDAO clienteDao;

    public ClienteService(IClienteDAO clienteDao){
        this.clienteDao = clienteDao;
    }

    @Override
    public Boolean salvar(Cliente cliente) throws TipoChaveNaoEncontradaException {
        return clienteDao.cadastrar(cliente);
    }

    @Override
    public Cliente buscarPorCpf(Long cpf) {
        return clienteDao.consultar(cpf);
    }

    @Override
    public void excluir(Long cpf) {
        clienteDao.excluir(cpf);
    }

    @Override
    public void alterar(Cliente cliente) throws TipoChaveNaoEncontradaException{
        clienteDao.alterar(cliente);
    }
}
