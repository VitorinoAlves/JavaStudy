package org.example.dao.mocks;

import org.example.dao.IClienteDao;

public class ClienteDaoMock implements IClienteDao {
    @Override
    public void salvar() {
        System.out.println("Sucesso ao salvar no banco");
    }

    @Override
    public void buscar() {
        System.out.println("Sucesso ao buscar no banco");
    }

    @Override
    public void excluir() {
        System.out.println("Sucesso ao excluir no banco");
    }

    @Override
    public void atualizar() {
        System.out.println("Sucesso ao atualizar no banco");
    }
}
