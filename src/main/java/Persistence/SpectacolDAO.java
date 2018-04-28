package Persistence;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.ArrayList;

public class SpectacolDAO {


    EntityManagerFactory entityManagerFactory;
    EntityManager entityManager;

    public SpectacolDAO()
    {
    }
    public ArrayList<Spectacol> findAll()
    {
        entityManagerFactory = Persistence.createEntityManagerFactory("org.hibernate.tutorial.jpa");
        entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Query query = entityManager.createQuery("select e from Spectacol e");
        ArrayList <Spectacol> list = (ArrayList<Spectacol>) query.getResultList();
        entityManager.close();
        entityManagerFactory.close();
        return list;
    }

    public void insert(Spectacol spectacol)
    {
        entityManagerFactory = Persistence.createEntityManagerFactory("org.hibernate.tutorial.jpa");
        entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(spectacol);
        entityManager.getTransaction().commit();
        entityManager.close();
        entityManagerFactory.close();
    }

    public Spectacol findById(int id_spectacol)
    {
        entityManagerFactory = Persistence.createEntityManagerFactory("org.hibernate.tutorial.jpa");
        entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Spectacol spectacol = entityManager.find(Spectacol.class, id_spectacol);
        entityManager.close();
        entityManagerFactory.close();;
        return spectacol;
    }
    public void update(Spectacol spectacol)
    {
        entityManagerFactory = Persistence.createEntityManagerFactory("org.hibernate.tutorial.jpa");
        entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.merge(spectacol);
        entityManager.getTransaction().commit();
        entityManager.close();
        entityManagerFactory.close();

    }

    public void delete(int id_spectacol)
    {
        entityManagerFactory = Persistence.createEntityManagerFactory("org.hibernate.tutorial.jpa");
        entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Spectacol spectacol= entityManager.getReference(Spectacol.class, id_spectacol);
        entityManager.remove(spectacol);
        entityManager.getTransaction().commit();
        entityManager.close();
        entityManagerFactory.close();
    }
}
