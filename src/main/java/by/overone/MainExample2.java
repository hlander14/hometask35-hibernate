package by.overone;

import by.overone.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class MainExample2 {
    public static void main(String[] args) {
        //get object from table
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();

        try {
            Session session = factory.getCurrentSession();
            session.beginTransaction();
            Employee employee2 = session.get(Employee.class, 2);
            session.getTransaction().commit();
            System.out.println(employee2);
        } finally {
            factory.close();
        }
    }
}
