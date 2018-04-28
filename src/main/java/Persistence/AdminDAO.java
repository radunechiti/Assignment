package Persistence;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class AdminDAO {

    EntityManagerFactory entityManagerFactory;
    EntityManager entityManager;

    public AdminDAO()
    {
        entityManagerFactory = Persistence.createEntityManagerFactory("org.hibernate.tutorial.jpa");
        entityManager = entityManagerFactory.createEntityManager();
    }
    public boolean findAdmin(Admin admin)
    {
        System.out.println("Employee username :" + admin.getUsername());
        System.out.println("Employee parola :" + admin.getParola());

        Query query = entityManager.createQuery("select e from Admin e where e.username like :username and e.parola like :parola")
                                    .setParameter("username", admin.getUsername())
                                    .setParameter("parola", admin.getParola());

        List<Admin> list = (List<Admin>) query.getResultList();

        if(list.isEmpty())
            return false;
        else
            return true;
    }
}
