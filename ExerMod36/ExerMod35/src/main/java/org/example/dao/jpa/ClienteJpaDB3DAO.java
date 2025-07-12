package org.example.dao.jpa;

import org.example.dao.generic.jpa.GenericJpaDB3DAO;
import org.example.domain.jpa.ClienteJpa2;

public class ClienteJpaDB3DAO extends GenericJpaDB3DAO<ClienteJpa2, Long> implements IClienteJpaDAO<ClienteJpa2> {

    public ClienteJpaDB3DAO() {
        super(ClienteJpa2.class);
    }
}
