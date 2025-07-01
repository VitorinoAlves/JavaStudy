package org.example;

import org.example.dao.*;
import org.example.domain.Acessorio;
import org.example.domain.Carro;
import org.example.domain.Marca;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class CarroTest {
    private IAcessorioDao acessorioDao;
    private ICarroDao carroDao;
    private IMarcaDao marcaDao;

    public CarroTest(){
        acessorioDao = new AcessorioDao();
        carroDao = new CarroDao();
        marcaDao = new MarcaDAO();
    }

    private Marca criaMarca(){
        Marca marca = new Marca();
        marca.setNomeMarca("Test nome marca");
        marca.setNacionalidade("BR");

        return marcaDao.cadastrar(marca);
    }

    private Acessorio criaAcessorio(){
        Acessorio acessorio = new Acessorio();
        acessorio.setDescricao("Teste acessorio descricao");
        acessorio.setNome("Nome acessorio");


        return acessorio;
    }

    @Test
    public void buscarCarroPorNomeTest(){
        Marca marca = criaMarca();
        Acessorio acessorio = criaAcessorio();

        Carro carro = new Carro();
        carro.setNome("Testr Nome Carro");
        carro.setCor("Branco");
        carro.setAno(2000);
        carro.setMarca(marca);
        carro.addAcessorio(acessorio);

        carro = carroDao.cadastrar(carro);
        Assert.assertNotNull(carro);
        Assert.assertNotNull(carro.getId());

        List<Carro> carroDB = carroDao.buscarPorNome(carro.getNome());

        for (Carro carro1 : carroDB){
            Assert.assertEquals(carro1.getNome(), carro.getNome());
        }

        for (Carro carro1 : carroDB){
            carroDao.deletarCarro(carro1);
        }
    }

    @Test
    public void buscarCarroPorMarcaTest(){
        Marca marca = criaMarca();
        Acessorio acessorio = criaAcessorio();

        Carro carro = new Carro();
        carro.setNome("Testr Nome Carro");
        carro.setCor("Branco");
        carro.setAno(2000);
        carro.setMarca(marca);
        carro.addAcessorio(acessorio);

        carro = carroDao.cadastrar(carro);
        Assert.assertNotNull(carro);
        Assert.assertNotNull(carro.getId());

        Carro carroDB = carroDao.buscarProMarca(marca);

        Assert.assertNotNull(carroDB);
        Assert.assertEquals(carroDB.getMarca().getNomeMarca(), carro.getMarca().getNomeMarca());

        carroDao.deletarCarro(carroDB);
    }

    @Test
    public void buscarCarroPorAcessorioTest(){
        Marca marca = criaMarca();
        Acessorio acessorio = criaAcessorio();

        Carro carro = new Carro();
        carro.setNome("Testr Nome Carro");
        carro.setCor("Branco");
        carro.setAno(2000);
        carro.setMarca(marca);
        carro.addAcessorio(acessorio);

        carro = carroDao.cadastrar(carro);
        Assert.assertNotNull(carro);
        Assert.assertNotNull(carro.getId());

        Carro carroDB = carroDao.buscarPorAcessorio(acessorio);

        Assert.assertNotNull(carroDB);
        Assert.assertEquals(carroDB.getListaAcessorios().get(0).getNome(), carro.getListaAcessorios().get(0).getNome());

        carroDao.deletarCarro(carroDB);
    }
}
