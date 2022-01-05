package by.overone;

import by.overone.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class MainExample5 {
    public static void main(String[] args) {
        //update object to table
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();

        try {
            Session session = factory.getCurrentSession();
            session.beginTransaction();
            Employee employee5 = session.get(Employee.class, 2);
            System.out.println(employee5);
            employee5.setSalary(2200);
            System.out.println(employee5);
            session.getTransaction().commit();
        } finally {
            factory.close();
        }
    }
}
