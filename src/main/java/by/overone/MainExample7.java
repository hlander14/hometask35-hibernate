package by.overone;

import by.overone.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class MainExample7 {
    public static void main(String[] args) {
        //delete object from table
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();

        try {
            Session session = factory.getCurrentSession();
            session.beginTransaction();
            Employee employee7 = session.get(Employee.class, 4);
            System.out.println(employee7);
            session.delete(employee7);
            session.getTransaction().commit();
        } finally {
            factory.close();
        }
    }
}
