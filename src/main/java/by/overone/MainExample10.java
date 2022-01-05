package by.overone;

import by.overone.entity.Child;
import by.overone.entity.Section;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Set;

public class MainExample10 {
    public static void main(String[] args) {
        //take a child with his sections
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Child.class)
                .addAnnotatedClass(Section.class)
                .buildSessionFactory();

        try {
            Session session = factory.getCurrentSession();
            session.beginTransaction();
            Child child = session.get(Child.class, 1);
            System.out.println(child);
//            Set<Section> sectionSet = child.getSections();
//            for (Section sec : sectionSet) {
//                System.out.println(sec);
//            }
            session.getTransaction().commit();
        } finally {
            factory.close();
        }
    }
}
