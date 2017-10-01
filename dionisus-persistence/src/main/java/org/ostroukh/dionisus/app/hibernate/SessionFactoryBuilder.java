package org.ostroukh.dionisus.app.hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;
import org.ostroukh.dionisus.app.infra.exeption.PersistenceException;
import org.ostroukh.dionisus.app.model.entity.establishment.ATable;
import org.ostroukh.dionisus.app.model.entity.establishment.Establishment;
import org.ostroukh.dionisus.app.model.entity.geography.Address;
import org.ostroukh.dionisus.app.model.entity.geography.City;
import org.ostroukh.dionisus.app.model.entity.geography.Coordinate;
import org.ostroukh.dionisus.app.model.entity.person.Account;

import javax.annotation.PreDestroy;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Component that is responsible for managing
 * Hibernate session factory
 */
public class SessionFactoryBuilder {
    private final SessionFactory sessionFactory;

    public SessionFactoryBuilder() {
        ServiceRegistry registry = new StandardServiceRegistryBuilder().build();

        MetadataSources sources = new MetadataSources(registry);

        sources.addAnnotatedClass(ATable.class);
        sources.addAnnotatedClass(Establishment.class);
        sources.addAnnotatedClass(Address.class);
        sources.addAnnotatedClass(City.class);
        sources.addAnnotatedClass(Coordinate.class);
        sources.addAnnotatedClass(Account.class);

        sessionFactory = sources.buildMetadata().buildSessionFactory();
    }

    private Properties loadProperties(){
        try(InputStream input = SessionFactoryBuilder.class.getClassLoader().getResourceAsStream("hibernate.properties")){
            Properties properties = new Properties();
            properties.load(input);

            return properties;
        }
        catch (IOException e){
            throw  new PersistenceException(e);
        }
    }


    public SessionFactory getSessionFactory(){
        return sessionFactory;
    }

    @PreDestroy
    public void shutdown(){
        if (sessionFactory != null){
            sessionFactory.close();
        }
    }
}
