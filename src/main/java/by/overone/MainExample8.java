package by.overone;

import by.overone.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class MainExample8 {
    public static void main(String[] args) {
        //delete from table with query
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();

        try {
            Session session = factory.getCurrentSession();
            session.beginTransaction();
            session.createQuery("delete Employee " +
                    "where name = 'Maxim'").executeUpdate();
            session.getTransaction().commit();
        } finally {
            factory.close();
        }
    }
}
