package org.example.dao;

import org.example.domain.Acessorio;
import org.example.domain.Carro;
import org.example.domain.Marca;

import java.util.List;

public interface ICarroDao {

    Carro cadastrar (Carro carro);

    List<Carro> buscarPorNome(String nomeCarro);

    Carro buscarProMarca(Marca marca);

    Carro buscarPorAcessorio(Acessorio acessorio);

    void deletarCarro(Carro carro);
}
