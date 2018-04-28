package Persistence;

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

    public ArrayList<Bilet> findAll()
    {
        entityManagerFactory = Persistence.createEntityManagerFactory("org.hibernate.tutorial.jpa");
        entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Query query = entityManager.createQuery("select e from Bilet e");
        ArrayList <Bilet> list = (ArrayList<Bilet>) query.getResultList();
        entityManager.close();
        entityManagerFactory.close();
        return list;
    }
}
