package Persistence.DAO;

import Persistence.Exports.Export;
import Persistence.Model.Bilet;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.ArrayList;

public class BiletDAO {

    EntityManagerFactory entityManagerFactory;
    EntityManager entityManager;

    public void insert(Bilet bilet)
    {
        entityManagerFactory = Persistence.createEntityManagerFactory("org.hibernate.tutorial.jpa");
        entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(bilet);
        entityManager.getTransaction().commit();
        entityManager.close();
        entityManagerFactory.close();
    }

    public ArrayList<Bilet> findBySpectacol(int id_spectacol)
    {
        entityManagerFactory = Persistence.createEntityManagerFactory("org.hibernate.tutorial.jpa");
        entityManager = entityManagerFactory.createEntityManager();
        Query query = entityManager.createQuery("select e from Bilet e where e.id_spectacol like :id_spectacol")
                .setParameter("id_spectacol", id_spectacol);
        ArrayList <Bilet> list = (ArrayList<Bilet>) query.getResultList();
        entityManager.close();
        entityManagerFactory.close();
        return list;
    }
    public void export(Export export, ArrayList<Bilet> list)
    {
        export.export(list);
    }
}
