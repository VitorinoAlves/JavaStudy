package org.example.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.example.domain.Acessorio;
import org.example.domain.Carro;
import org.example.domain.Marca;

import java.util.List;

public class CarroDao implements ICarroDao{
    @Override
    public Carro cadastrar(Carro carro) {
        EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("ExemploJPA");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        entityManager.persist(carro);
        entityManager.getTransaction().commit();

        entityManager.close();
        entityManagerFactory.close();


        return carro;
    }

    @Override
    public List<Carro> buscarPorNome(String nomeCarro) {
        EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("ExemploJPA");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Carro> query = builder.createQuery(Carro.class);
        Root<Carro> root = query.from(Carro.class);
        query.where(builder.like(root.get("nome"), "%" + nomeCarro + "%"));
        query.select(root);

        TypedQuery<Carro> typedQuery = entityManager.createQuery(query);
        List<Carro> listaCarro = typedQuery.getResultList();

        entityManager.close();
        entityManagerFactory.close();

        return listaCarro;
    }

    @Override
    public Carro buscarProMarca(Marca marca) {
        EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("ExemploJPA");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        StringBuilder sb = new StringBuilder();
        sb.append("SELECT c FROM Carro c ");
        sb.append("INNER JOIN Marca m on m = c.marca ");
        sb.append("WHERE m = :marca");

        entityManager.getTransaction().begin();
        TypedQuery<Carro> query = entityManager.createQuery(sb.toString(), Carro.class);
        query.setParameter("marca", marca);
        Carro carro = query.getSingleResult();

        entityManager.close();
        entityManagerFactory.close();
        return carro;
    }

    @Override
    public Carro buscarPorAcessorio(Acessorio acessorio) {
        EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("ExemploJPA");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        StringBuilder sb = new StringBuilder();
        sb.append("SELECT c FROM Carro c ");
        sb.append("JOIN c.listaAcessorios a ");
        sb.append("WHERE a = :acessorio");

        entityManager.getTransaction().begin();
        TypedQuery<Carro> query = entityManager.createQuery(sb.toString(), Carro.class);
        query.setParameter("acessorio", acessorio);
        Carro carro = query.getSingleResult();

        entityManager.close();
        entityManagerFactory.close();
        return carro;
    }

    @Override
    public void deletarCarro(Carro carro) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ExemploJPA");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        carro = entityManager.merge(carro);
        entityManager.remove(carro);
        entityManager.getTransaction().commit();

        entityManager.close();
        entityManagerFactory.close();
    }
}
