package Persistence;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class CasierDAO {

    EntityManagerFactory entityManagerFactory;
    EntityManager entityManager;

    public void insert(Casier casier)
    {
        entityManagerFactory = Persistence.createEntityManagerFactory("org.hibernate.tutorial.jpa");
        entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(casier);
        entityManager.getTransaction().commit();
        entityManager.close();
        entityManagerFactory.close();
    }

    public ArrayList<Casier> findAll()
    {
        entityManagerFactory = Persistence.createEntityManagerFactory("org.hibernate.tutorial.jpa");
        entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Query query = entityManager.createQuery("select e from Casier e");
        ArrayList <Casier> list = (ArrayList<Casier>) query.getResultList();
        entityManager.close();
        entityManagerFactory.close();
        return list;
    }
    public Casier findById(int id_casier)
    {
        entityManagerFactory = Persistence.createEntityManagerFactory("org.hibernate.tutorial.jpa");
        entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Casier casier = entityManager.find(Casier.class, id_casier);
        entityManager.close();
        entityManagerFactory.close();
        return casier;
    }
    public boolean find(Casier casier)
    {
        entityManagerFactory = Persistence.createEntityManagerFactory("org.hibernate.tutorial.jpa");
        entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Query query = entityManager.createQuery("select e from Casier e where e.username like :username and e.parola like :parola")
                .setParameter("username", casier.getUsername())
                .setParameter("parola", casier.getParola());

        List<Casier> list = (List<Casier>) query.getResultList();
        entityManager.close();
        entityManagerFactory.close();
        if(list.isEmpty())
            return false;
        else
            return true;
    }
    public void update(Casier casier)
    {
        entityManagerFactory = Persistence.createEntityManagerFactory("org.hibernate.tutorial.jpa");
        entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.merge(casier);
        entityManager.getTransaction().commit();
        entityManager.close();
        entityManagerFactory.close();

    }
    /*
    public void delete(Casier casier)
    {
        entityManagerFactory = Persistence.createEntityManagerFactory("org.hibernate.tutorial.jpa");
        entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.merge(casier);
        entityManager.getTransaction().commit();
        entityManager.close();
        entityManagerFactory.close();
    }*/

}
