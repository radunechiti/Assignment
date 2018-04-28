import Controller.Criptare;
import Persistence.Admin;
import Persistence.Bilet;
import Controller.MainController;
import View.AdminView;
import View.CasierView;
import View.LoginView;
import com.mysql.cj.x.protobuf.MysqlxDatatypes;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.classloading.spi.ClassLoaderService;
import org.hibernate.cfg.Configuration;
import org.hibernate.jdbc.Work;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Iterator;
import java.util.List;


public class Main {

    private static SessionFactory factory;

    public static void main(String[] args){


        LoginView loginView = new LoginView();
        AdminView adminView = new AdminView();
        CasierView casierView = new CasierView();
        MainController mainController = new MainController(loginView, adminView, casierView);
        Criptare criptare = new Criptare();
        System.out.println(criptare.securePassword("admin"));





     /*
        try{
            factory =  new Configuration().configure().buildSessionFactory();
        }catch(Throwable ex){
            System.err.println("Ceva pute si nu se conecteaza "+ ex);
            throw new ExceptionInInitializerError(ex);
        }

        Main main = new Main();

        Integer admin1 = main.addAdmin("eu", "parola");

        //main.showAdmins();

        System.out.println("ce pula mea se intampla");

    }

    public Integer addAdmin(String username, String parola) {
        Session session = factory.openSession();
        Transaction tx = null;
        Integer adminID = null;

        try{
            tx = session.beginTransaction();
            Admin admin = new Admin(username, parola);
            adminID = (Integer) session.save(admin);
            tx.commit();
        }catch(HibernateException e){
            if (tx!=null)
                tx.rollback();
            e.printStackTrace();

        }finally {
            session.close();
        }
        return adminID;

    }

    public void showAdmins()
    {
        Session session = factory.openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            List lista = session.createQuery("from admin").list();
            for(Iterator iterator = lista.iterator(); iterator.hasNext();)
            {
                Admin admin = (Admin) iterator.next();
                System.out.println("id"+ admin.getIdAdmin());
                System.out.println("id"+ admin.getUsername());
                System.out.println("id"+ admin.getParola());
            }
            tx.commit();
        }catch (HibernateException e){
            if(tx!=null)
                tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }*/
    }

}
