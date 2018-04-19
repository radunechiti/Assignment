import Persistence.Admin;
import com.mysql.cj.x.protobuf.MysqlxDatatypes;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.classloading.spi.ClassLoaderService;
import org.hibernate.cfg.Configuration;
import org.hibernate.jdbc.Work;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;



public class Main {

    private static SessionFactory factory;

    public static void main(String[] args){


        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("org.hibernate.tutorial.jpa");

        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();

        Admin admin = new Admin("Ilie","parola");

        entityManager.persist(admin);
        entityManager.getTransaction().commit();

        entityManager.close();

    }
}
