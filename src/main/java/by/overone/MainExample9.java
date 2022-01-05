package by.overone;

import by.overone.entity.Department;
import by.overone.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class MainExample9 {
    public static void main(String[] args) {
        //add employee with department
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Department.class)
                .buildSessionFactory();

        try {
            Session session = factory.getCurrentSession();
            session.beginTransaction();

            Employee employeeAna = new Employee("Ana", "Stepnova", 495);
            Employee employeeValera= new Employee("Valeriy", "Uzlov", 781);
            Department department9 = session.get(Department.class, 2);
            department9.addEmployeeToDepartment(employeeAna);
            department9.addEmployeeToDepartment(employeeValera);

            session.getTransaction().commit();
        } finally {
            factory.close();
        }
    }
}
