package org.example.service;

import org.example.dao.IClienteDao;

public class ClienteService implements IClienteService{

    private IClienteDao clienteDao;

    public ClienteService(IClienteDao clienteDao){
        this.clienteDao = clienteDao;
    }

    @Override
    public String salvar() {
        clienteDao.salvar();
        return "Cliente salvo com sucesso";
    }

    @Override
    public String buscar() {
        clienteDao.buscar();
        return "Cliente buscado com sucesso";
    }

    @Override
    public String excluir() {
        clienteDao.excluir();
        return "Cliente excluido com sucesso";
    }

    @Override
    public String atualizar() {
        clienteDao.atualizar();
        return "Cliente atualizado com sucesso";
    }
}
