package org.example.service;

import org.example.dao.IContratoDao;

public class ContratoService implements IContratoService{
    private IContratoDao contratoDao;

    public ContratoService(IContratoDao contratoDao){
        this.contratoDao = contratoDao;
    }

    @Override
    public String salvar() {
        contratoDao.salvar();
        return "Registro salvo com sucesso";
    }

    @Override
    public String buscar() {
        contratoDao.buscar();
        return "Resultados da busca";
    }

    @Override
    public String excluir() {
        contratoDao.excluir();
        return "Registro excluido com sucesso";
    }

    @Override
    public String atualizar() {
        contratoDao.atualizar();
        return "Registro atualizado com sucesso";
    }
}
