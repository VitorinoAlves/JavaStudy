package org.example.dao.jpa;

import org.example.dao.Persistente;
import org.example.dao.generic.jpa.IGenericJapDAO;
import org.example.domain.jpa.ClienteJpa;

public interface IClienteJpaDAO<T extends Persistente> extends IGenericJapDAO<T, Long> {
}
