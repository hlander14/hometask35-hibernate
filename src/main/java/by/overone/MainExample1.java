package by.overone;

import by.overone.entity.Department;
import by.overone.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class MainExample1 {
    public static void main(String[] args) {
        //add object to table
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();

        try {
            Department department = new Department("WAT", 1000, 3000);
            Employee employee = new Employee("Murat", "Amirov", 500);
            Session session = factory.getCurrentSession();
            session.beginTransaction();
            session.save(employee);
            session.getTransaction().commit();
        } finally {
            factory.close();
        }
    }
}
