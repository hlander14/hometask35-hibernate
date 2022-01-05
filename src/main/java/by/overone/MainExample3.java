package by.overone;

import by.overone.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;


public class MainExample3 {
    public static void main(String[] args) {
        //get objects from table
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();

        try {
            Session session = factory.getCurrentSession();
            session.beginTransaction();
            List<Employee> employees = session.createQuery("from Employee", Employee.class)
                    .getResultList();
            session.getTransaction().commit();
            System.out.println(employees);
        } finally {
            factory.close();
        }
    }
}
