package org.example.dao.jpa;

import org.example.dao.generic.jpa.GenericJpaDB2DAO;
import org.example.domain.jpa.ClienteJpa;

public class ClienteJpaDB2DAO extends GenericJpaDB2DAO<ClienteJpa, Long> implements IClienteJpaDAO<ClienteJpa> {

    public ClienteJpaDB2DAO() {
        super(ClienteJpa.class);
    }
}
