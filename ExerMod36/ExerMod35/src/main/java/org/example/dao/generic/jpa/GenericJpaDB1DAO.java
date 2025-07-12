package org.example.dao.generic.jpa;

import org.example.dao.Persistente;

import java.io.Serializable;

public class GenericJpaDB1DAO <T extends Persistente, E extends Serializable>
        extends GenericJpaDAO<T,E> {

    public GenericJpaDB1DAO(Class<T> persistenteClass) {
        super(persistenteClass, "Postgre1");
    }

}
