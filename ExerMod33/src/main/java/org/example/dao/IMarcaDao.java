package org.example.dao;

import org.example.domain.Marca;

public interface IMarcaDao {
    Marca cadastrar(Marca marca);

    void deletarMarca(Marca marca);
}
