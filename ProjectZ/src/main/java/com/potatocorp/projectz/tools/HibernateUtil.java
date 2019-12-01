package com.potatocorp.projectz.tools;

<<<<<<< HEAD
import org.hibernate.SessionFactory;
=======
import com.potatocorp.projectz.entity.Client;
import com.potatocorp.projectz.entity.Course;
import com.potatocorp.projectz.entity.CourseSession;
import com.potatocorp.projectz.entity.Location;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
>>>>>>> pierre
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

    private static final SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        try {
            // Create the SessionFactory from hibernate.cfg.xml
<<<<<<< HEAD
            return new Configuration().configure().buildSessionFactory();
=======
            return new AnnotationConfiguration()
                    .addAnnotatedClass(Course.class)
                    .addAnnotatedClass(Location.class)
                    .addAnnotatedClass(Client.class)
                    .addAnnotatedClass(CourseSession.class)
                    .configure().buildSessionFactory();
>>>>>>> pierre
        } catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
