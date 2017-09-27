package org.ostroukh.dionisus.app.persistence.repository;

import org.ostroukh.dionisus.app.model.entity.establishment.Establishment;
import org.ostroukh.dionisus.app.model.entity.geography.City;

import java.util.List;

/**
 * Defines CRUD methods to access Establishment objects in the persistent storage
 */
public interface EstablishmentRepository {

    /**
     * Saves(creates or modifies) specified establishment instance
     * @param establishment
     */
    void save(Establishment establishment);

    /**
     * Returns establishment with specified identifier. If no city exists with such identifier
     * then null is returned
     * @param id
     * @return
     */
    Establishment findById(int id);

    /**
     * Delete establishment with specified identifier
     * @param id
     */
    void delete(int id);

    /**
     * Returns all establishment for specified city
     * @param city
     * @return
     */
    List<Establishment> findByCity(City city);

    /**
     * Returns all establishment
     * @return
     */
    List<Establishment> findAll();
}
