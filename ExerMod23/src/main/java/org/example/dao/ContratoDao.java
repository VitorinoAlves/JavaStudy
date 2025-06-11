package org.example.dao;

public class ContratoDao implements IContratoDao{
    @Override
    public void salvar() {
        throw new UnsupportedOperationException("Não funciona com o banco - Salvar");
    }

    @Override
    public void buscar() {
        throw new UnsupportedOperationException("Não funciona com o banco - Buscar");
    }

    @Override
    public void excluir() {
        throw new UnsupportedOperationException("Não funciona com o banco - Excluir");
    }

    @Override
    public void atualizar() {
        throw new UnsupportedOperationException("Não funciona com o banco - Atualizar");
    }
}
