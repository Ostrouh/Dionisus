package org.ostroukh.dionisus.app.persistence.repository.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.ostroukh.dionisus.app.hibernate.SessionFactoryBuilder;
import org.ostroukh.dionisus.app.model.entity.base.AbstractEntity;
import org.ostroukh.dionisus.app.model.entity.establishment.Establishment;
import org.ostroukh.dionisus.app.model.entity.geography.City;
import org.ostroukh.dionisus.app.persistence.repository.CityRepository;

import javax.inject.Inject;
import java.util.List;
import java.util.Set;

/**
 * Created by eugene on 01.10.2017.
 */
public class HibernateCityRepository implements CityRepository{
    private final SessionFactory sessionFactory;

    @Inject
    public HibernateCityRepository(SessionFactoryBuilder builder) {
        sessionFactory = builder.getSessionFactory();
    }

    @Override
    public void save(City city) {
        try(Session session = sessionFactory.openSession()){
            city.prePersist();
            Set<Establishment> establs = city.getEstablishments();
            if(establs != null){
                establs.forEach(AbstractEntity::prePersist);
            }
            session.saveOrUpdate(city);
        }
    }

    @Override
    public City findById(int cityId) {
        try(Session session = sessionFactory.openSession()){
            return session.get(City.class, cityId);
        }
    }

    @Override
    public void delete(int cityId) {
        try (Session session = sessionFactory.openSession()){
            City city = session.get(City.class, cityId);
            if (city != null){
                session.delete(city);
            }
        }
    }

    @Override
    public List<City> findAll() {
        try (Session session = sessionFactory.openSession()){
            return session.createCriteria(City.class).list();
        }
    }
}
