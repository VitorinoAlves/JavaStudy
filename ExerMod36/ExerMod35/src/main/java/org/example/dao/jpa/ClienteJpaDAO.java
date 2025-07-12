package org.example.dao.jpa;

import org.example.dao.IClienteDAO;
import org.example.dao.generic.jpa.GenericJpaDAO;
import org.example.dao.generic.jpa.GenericJpaDB1DAO;
import org.example.domain.jpa.ClienteJpa;

public class ClienteJpaDAO extends GenericJpaDB1DAO<ClienteJpa, Long> implements IClienteJpaDAO<ClienteJpa> {

    public ClienteJpaDAO() {
        super(ClienteJpa.class);
    }
}
