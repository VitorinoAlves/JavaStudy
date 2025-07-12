package org.example.dao.generic.jpa;

import org.example.dao.Persistente;

import java.io.Serializable;

public class GenericJpaDB3DAO <T extends Persistente, E extends Serializable>
        extends GenericJpaDAO<T,E> {

    public GenericJpaDB3DAO(Class<T> persistenteClass) {
        super(persistenteClass, "Mysql1");
    }
}
