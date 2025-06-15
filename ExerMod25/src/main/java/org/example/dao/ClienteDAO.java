package org.example.dao;

import org.example.dao.generics.GenericDAO;
import org.example.domain.Cliente;

public class ClienteDAO extends GenericDAO<Cliente> implements IClienteDAO{

    public ClienteDAO(){
        super();
    }

    @Override
    public Class<Cliente> getTipoClasse() {
        return Cliente.class;
    }

    @Override
    public void atualiarDados(Cliente entity, Cliente entityCadastrado) {

    }
}
