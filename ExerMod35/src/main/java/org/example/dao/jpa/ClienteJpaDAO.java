package org.example.dao.jpa;

import org.example.dao.IClienteDAO;
import org.example.dao.generic.jpa.GenericJpaDAO;
import org.example.domain.jpa.ClienteJpa;

public class ClienteJpaDAO extends GenericJpaDAO<ClienteJpa, Long> implements IClienteJpaDAO {

    public ClienteJpaDAO() {
        super(ClienteJpa.class);
    }
}
